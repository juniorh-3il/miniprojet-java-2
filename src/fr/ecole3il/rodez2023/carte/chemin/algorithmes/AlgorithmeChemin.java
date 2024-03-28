package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.List;

/**
 * Définit un contrat pour les classes qui implémentent des algorithmes de recherche de chemin dans un graphe.
 *
 * @param <E>
 */
public interface AlgorithmeChemin<E> {
    /**
     * Trouve un chemin entre un nœud de départ et un nœud d'arrivée dans un graphe donné.
     *
     * @param graphe  Graphe dans lequel le chemin optimal sera cherché
     * @param depart  Nœud de départ du chemin optimal cherché
     * @param arrivee Nœud d'arrivée du chemin optimal cherché
     * @return Chemin le plus court entre le nœud de départ et nœud d'arrivée
     */
    List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}
