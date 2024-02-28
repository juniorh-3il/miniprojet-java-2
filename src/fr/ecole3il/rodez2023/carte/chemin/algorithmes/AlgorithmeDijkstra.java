package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {

        // 1
        Map<Noeud<E>, Double> chemins = new HashMap<Noeud<E>, Double>();
        chemins.put(depart, 0d);
        for (Noeud<E> noeud : graphe.getNoeuds()) {
            if (noeud != depart) {
                chemins.put(noeud, Double.POSITIVE_INFINITY);
            }
        }

         PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<Noeud<E>>();
    }
}
