package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La classe Graphe représente un graphe (duh!) composé de noeuds et d'arrêtes.
 * Elle fournit des méthodes pour manipuler cex deux composantes.
 * @param <E> Classe de la valeur des noeuds composants le graphe.
 */
public class Graphe<E> {

    /**
     * Liste des noeuds du graphe.
     */
    private final List<Noeud<E>> noeuds;

    /**
     * Matrice d'adjacence du graphe.
     * @see <a href="https://fr.wikipedia.org/wiki/Matrice_d%27adjacence">Wikipedia : Matrice d'adjacence</a>
     */
    private final Map<Integer, Map<Integer, Double>> aretes;


    public Graphe() {
        this.noeuds = new ArrayList<Noeud<E>>();
        this.aretes = new HashMap<Integer, Map<Integer, Double>>();
    }

    /**
     * Ajoute un nœud au graphe si le nœud n'existe pas déjà dans le graphe.
     * @param noeud Nœud à ajouter
     */
    public void ajouterNoeud(Noeud<E> noeud) {
        if (!this.noeuds.contains(noeud)) {
            this.noeuds.add(noeud);
        }
    }

    /**
     * Ajoute une arête pondérée entre deux nœuds du graphe.
     * Elle prend en paramètre le nœud de départ, le nœud d'arrivée et le coût de l'arête.
     * Si les nœuds de départ et d'arrivée n'existent pas encore dans le graphe,
     * ils sont ajoutés en utilisant la méthode <code>ajouterNoeud()</code>.
     * @param depart Nœud de départ de l'arête
     * @param arrivee Nœud d'arrivée de l'arête
     * @param cout Coût associé à l'arête
     */
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

    /**
     *  Renvoie le coût de l'arête entre deux nœuds spécifiés.
     * @param depart Nœud de départ de l'arête dont on cherche le coût
     * @param arrivee Nœud de départ de l'arête dont on cherche le coût
     * @return Coût de l'arête
     * @throws Exception Le nœud de départ ou d'arrivée spécifié n'existe pas dans le graphe
     */
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

    /**
     * Renvoie une liste contenant tous les voisins d'un nœud spécifié.
     * Si le nœud n'existe pas dans le graphe, elle renvoie une liste vide.
     * @param noeud Nœud pour lequel on cherche les voisins
     * @return Les voisins du nœud spécifié en paramètre
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        List<Noeud<E>> voisins = new ArrayList<Noeud<E>>();
        if (this.noeuds.contains(noeud)) {
            for (Noeud<E> eventuelVoisin : this.noeuds) {
                try {
                    if (this.getCoutArete(noeud, eventuelVoisin) != null) {
                        voisins.add(eventuelVoisin);
                    }
                } catch (Exception e) {
                    //TODO
                }
            }
        }
        return voisins;
    }
}
