# Miniprojet 2 - Repérage et direction sur une carte en 2D

Interface graphique exploitant l'algorithme de Dijkstra et A* afin d'obtenir le chemin le plus court entre deux points dans un graphe.

## Questions/Réponses

**Question** : Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe et les informations associées à
ces relations, comme les coûts des arêtes ?

**Réponse** : Une matrice ou un tableau bidimensionnel.

**Question :** Pourquoi pensez-vous que les classes `Noeud` et `Graphe` ont été définies avec des paramètres génériques ?

**Réponse** : Pour que `Noeud` et `Graphe` puisse respectivement contenir des valeurs de n'importe quel type et contenir des nœuds contenant n'importe
quel type.

**Question** : Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?

**Réponse** : On pense que la création d'une interface est une bonne pratique dans ce contexte car cela permet d'implémenter n'import quel algorithme
avec un contrat commun, permettant une meilleure réusabilité et testabilité.


## Retour personnel

C'est sûrement moi mais j'ai eu du mal à comprendre les étapes de l'algorithme de Dijkstra dans les consignes.