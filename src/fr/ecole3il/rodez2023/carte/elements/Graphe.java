package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe<E> {

    private final List<Noeud<E>> noeuds;
    private final Map<Integer, Map<Integer, Double>> aretes;

    public Graphe() {
        this.noeuds = new ArrayList<Noeud<E>>();
        this.aretes = new HashMap<Integer, Map<Integer, Double>>();
    }

    public void ajouterNoeud(Noeud<E> noeud) {
        this.noeuds.add(noeud);
    }

    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        if (!this.noeuds.contains(depart)) {
            this.ajouterNoeud(depart);
        }
        if (!this.noeuds.contains(arrivee)) {
            this.ajouterNoeud(arrivee);
        }

        int indexNoeudDepart = this.noeuds.indexOf(depart);
        int indexNoeudArrivee = this.noeuds.indexOf(arrivee);

        this.aretes.get(indexNoeudDepart).put(indexNoeudArrivee, cout);
        this.aretes.get(indexNoeudArrivee).put(indexNoeudDepart, cout);

        depart.ajouterVoisin(arrivee);
        arrivee.ajouterVoisin(depart);
    }

    public Double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) throws Exception {
        if (!this.noeuds.contains(depart)) {
            throw new Exception("Noeud de départ absent du graphe");
        }
        if (!this.noeuds.contains(arrivee)) {
            throw new Exception("Noeud d'arrivée absent du graphe");
        }

        int indexNoeudDepart = this.noeuds.indexOf(depart);
        int indexNoeudArrivee = this.noeuds.indexOf(arrivee);

        return this.aretes.get(indexNoeudDepart).get(indexNoeudArrivee);
    }

    public List<Noeud<E>> getNoeuds() {
        return this.noeuds;
    }

    public List<Noeud<E>> getVoisins(Noeud<E> noeud) throws Exception {
        if (!this.noeuds.contains(noeud)) {
            throw new Exception("Noeud absent");
        }

        List<Noeud<E>> voisins = new ArrayList<Noeud<E>>();

        for (Noeud<E> eventuelVoisin : this.noeuds) {
            if (this.getCoutArete(noeud, eventuelVoisin) != null) {
                voisins.add(eventuelVoisin);
            }
        }

        return voisins;
    }
}
