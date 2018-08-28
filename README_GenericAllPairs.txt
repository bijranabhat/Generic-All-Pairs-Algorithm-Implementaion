McKenzie Allaben and Bijay Ranabhat
README FILE 
Algorithmic Graph Theory

Generic All Pairs Algorihtm 

PROGRAM INPUT: 
*****************************************************************
This program is ideally run in the open source program, Eclipse-Java version.

The program reads in a txt file containing the graph network via the Graph.java class. The first line of the txt file specifies the number of vertices in the network and the adjacency matrix of the network is listed below. 

Note: In order to account for paths with a length of zero, 999 was used as a placeholder in the adjacency matrix to indicate that there was no path between two vertices. 

The network is read in as a two-dimensional array. 

In order to change the input of the program, the code "Network1.txt" in the Algorithm.java class, must be changed to the title of your txt file before running the program: 

public static void main(String[] args) throws IOException 
    {
    	//creates a graph object G using adjacency matrix that was 	read into the program 
    	
	Graph G = new Graph("Network1.txt");
    	G.printMatrix(); //prints adj. matrix
    	
	// calls algorithm on graph G, with the source vertex 	starting at index 0
    	
	algorithm(G,0); //index of source vertex is zero 
    } 
*****************************************************************



Reading the console output: 
*****************************************************************
The two initialized distance matrices are printed. "Infinity" is a place holder for the value of infinity.

Each iteration is printed with the current state of the distance matrix that is updated as the algorithm continues to traverse through the rows of the distance matrix. Each iteration represents the matrix after one column in the specified row goes through the algorithm. 

The source vertex is labeled as vertex 0. The other vertices in the given networks are then labeled as 1, 2, 3, 4, etc. 

In the distance matrix, Infinity represents the value of infinity. 

The last iteration completed, shows the optimum distance matrix for the network, unless a negative cycle was detected.
*****************************************************************


Negative Cycles: 
*****************************************************************
This Generic All Pairs program does not terminate when faced with a negative cycle. However, a condition check was placed in the code to check if any diagonal values in the distance matrix were negative, in which case the program is then terminated and the algorithm stops. A demonstration of this can be seen when Network3.txt is run through the program.    
*****************************************************************









