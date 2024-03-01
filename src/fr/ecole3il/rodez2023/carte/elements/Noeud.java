package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.List;

public class Noeud<E> {

    private E valeur;
    private List<Noeud<E>> voisins;

    /**
     * Ce constructeur crée un nouvel objet Noeud avec la valeur spécifiée et initialise la liste de voisins.
     * @param valeur La valeur attribuée au noeud
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<Noeud<E>>();
    }

    /**
     * Ajouter un nœud voisin à la liste des voisins du nœud actuel.
     * @param voisin Voisin à ajouter
     */
    public void ajouterVoisin(Noeud<E> voisin) {
        this.voisins.add(voisin);
    }

    public E getValeur() {
        return this.valeur;
    }

    public List<Noeud<E>> getVoisins() {
        return this.voisins;
    }
}
