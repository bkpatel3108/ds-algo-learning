Run following command to start this program
java DijkstraShortestPathAlgoTest

You can test this program in 2 ways.
1. Default input file (input.txt) 2. Input file path from Command line 
Note : 
Input format - input file must contain one arc per line, where each arc is
represented by two nodes followed by a weight (of type integer).
All three are separated by space. 
first_vertex second_vertex weight
Ex : 
A B 4
A C 2
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Default input file (input.txt)
To choose this option, enter 1. 
It will find shortest path length and shortest path between given source 
and destination.
------------------------------------------
Sample input data in input.txt file 
A B 4
A C 2 
A D 10 
C B 3 
C D 7 
B E 1 
C E 8 
C F 10 
C G 7 
D G 12 
F G 1 
F E 5 
E H 2 
F H 3 
G H 1
------------------------------------------
Output :
Note :
Input format - input file must contain one arc per line, where each arc is 
represented by two nodes followed by a weight (of type integer). 
All three are separated by space.
first_vertex second_vertex weight
Ex : 
A B 4
A C 2
Enter a number: 
1 - To use default input file (input.txt)
2 - To enter input file path from command line
1
Please enter source vertex
A
Please enter destination vertex
F
You created following Graph
Vertex A has 3 adjacent vertices: (C, 2) (D, 10) (B, 4)
Vertex B has 3 adjacent vertices: (C, 3) (E, 1) (A, 4)
Vertex C has 6 adjacent vertices: (D, 7) (F, 10) (E, 8) (B, 3) (G, 7) (A, 2)
Vertex D has 3 adjacent vertices: (C, 7) (G, 12) (A, 10)
Vertex E has 4 adjacent vertices: (C, 8) (F, 5) (B, 1) (H, 2)
Vertex F has 4 adjacent vertices: (C, 10) (E, 5) (G, 1) (H, 3)
Vertex G has 4 adjacent vertices: (C, 7) (D, 12) (F, 1) (H, 1)
Vertex H has 3 adjacent vertices: (F, 3) (E, 2) (G, 1)

DijkstraShortestPathAlgo >> Shortest Path length between A and F >> 9
DijkstraShortestPathAlgo >> Shortest Path>> 
A --> B --> E --> H --> G --> F
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

2. Manual Test
You can provide input file path using command line input. 
To choose this option, enter 2.
------------------------------------------
Output :
Note :
Input format - input file must contain one arc per line, where each arc is 
represented by two nodes followed by a weight (of type integer). 
All three are separated by space.
first_vertex second_vertex weight
Ex : 
A B 4
A C 2
Enter a number: 
1 - To use default input file (input.txt)
2 - To enter input file path from command line
2
Please enter input file path
/Users/bhaumikpatel/njit/workspaces/ds-algo-learning/Programming-Assignment-3/src/input.txt
Please enter source vertex
A
Please enter destination vertex
H
You created following Graph
Vertex A has 3 adjacent vertices: (C, 2) (D, 10) (B, 4)
Vertex B has 3 adjacent vertices: (C, 3) (E, 1) (A, 4)
Vertex C has 6 adjacent vertices: (D, 7) (F, 10) (E, 8) (B, 3) (G, 7) (A, 2)
Vertex D has 3 adjacent vertices: (C, 7) (G, 12) (A, 10)
Vertex E has 4 adjacent vertices: (C, 8) (F, 5) (B, 1) (H, 2)
Vertex F has 4 adjacent vertices: (C, 10) (E, 5) (G, 1) (H, 3)
Vertex G has 4 adjacent vertices: (C, 7) (D, 12) (F, 1) (H, 1)
Vertex H has 3 adjacent vertices: (F, 3) (E, 2) (G, 1)

DijkstraShortestPathAlgo >> Shortest Path length between A and H >> 7
DijkstraShortestPathAlgo >> Shortest Path>> 
A --> B --> E --> H
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

More Examples: Source A, Destination D

Note :
Input format - input file must contain one arc per line, where each arc is 
represented by two nodes followed by a weight (of type integer). 
All three are separated by space.
first_vertex second_vertex weight
Ex : 
A B 4
A C 2
Enter a number: 
1 - To use default input file (input.txt)
2 - To enter input file path from command line
1
Please enter source vertex
A
Please enter destination vertex
D
You created following Graph
Vertex A has 3 adjacent vertices: (C, 2) (D, 10) (B, 4)
Vertex B has 3 adjacent vertices: (C, 3) (E, 1) (A, 4)
Vertex C has 6 adjacent vertices: (D, 7) (F, 10) (E, 8) (B, 3) (G, 7) (A, 2)
Vertex D has 3 adjacent vertices: (C, 7) (G, 12) (A, 10)
Vertex E has 4 adjacent vertices: (C, 8) (F, 5) (B, 1) (H, 2)
Vertex F has 4 adjacent vertices: (C, 10) (E, 5) (G, 1) (H, 3)
Vertex G has 4 adjacent vertices: (C, 7) (D, 12) (F, 1) (H, 1)
Vertex H has 3 adjacent vertices: (F, 3) (E, 2) (G, 1)

DijkstraShortestPathAlgo >> Shortest Path length between A and D >> 9
DijkstraShortestPathAlgo >> Shortest Path>> 
A --> C --> D