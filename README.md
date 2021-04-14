# Graphs-Java

Graph implemented using Adjacency List and Adjacency Matrix


### When to use Adjacency Matrix?
The basic operations like adding an edge, removing an edge and checking whether there is an edge from vertex i to vertex j 
are extremely time efficient, constant time operations.

If the graph is dense and the number of edges is large, adjacency matrix should be the first choice. 
Even if the graph and the adjacency matrix is sparse, we can represent it using data structures for sparse matrices.

### When to use Adjacency List?
Though the basic operations like adding an edge, removing an edge and checking whether there is an edge from vertex i to vertex j 
are not as extremely time efficient, constant time operations as Adjacency Matrix my implementation using HashMap<K,<HashMap<k,V>>> acheives comparable complexity.

But if the Graph is too large and sparse and number of edges are limited, Adjacency List should be first choice instead.
