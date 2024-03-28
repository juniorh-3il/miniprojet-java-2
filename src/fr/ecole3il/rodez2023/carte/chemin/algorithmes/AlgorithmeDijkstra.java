package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Implémentation de l'interface <code>AlgorithmeChemin</code> et fournit une implémentation de l'algorithme de Dijkstra pour
 * trouver le chemin le plus court entre deux nœuds dans un graphe pondéré.
 *
 * @param <E> Type des nœuds du graphe parcouru par l'algorithme
 * @see <a href="https://fr.wikipedia.org/wiki/Algorithme_de_Dijkstra">Wikipedia : Algorithme de Dijkstra</a>
 */
public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {

        // 1
        Map<Noeud<E>, Double> chemins = new HashMap<Noeud<E>, Double>();
        Map<Noeud<E>, List<Noeud<E>>> predecesseurs = new HashMap<Noeud<E>, List<Noeud<E>>>();

        chemins.put(depart, 0d);
        for (Noeud<E> noeud : graphe.getNoeuds()) {
            if (noeud != depart) {
                chemins.put(noeud, Double.POSITIVE_INFINITY);
            }
            predecesseurs.put(noeud, noeud.getVoisins());
        }

        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<Noeud<E>>();

        return null;
    }
}
