/* McKenzie Allaben and Bijay Ranabhat
 * Algorithmic Graph Theory 
 * Shortest path algorithms programming assignment
 */
import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;	

public class Algorithm
{
	//public static final int INFINITY = 999;
	public static void algorithm(Graph G, int source) throws IOException //int source = index of source vertex
    {                  					
    	int numVertices; 
    	double [][] dist;
    	double infin = Double.POSITIVE_INFINITY;
    	    	
        numVertices = G.numberOfVertices(); // gets number of vertices of graph 
        
        dist = new double[numVertices][numVertices];    //initialize 2d array for distance 
        
        int adjMatrix[][] = G.getAdj_Matrix(); //gets adjacency matrix of Cij values
        int iteration = 1;
        
    	System.out.println("Generic All Pairs Label Correcting Algorithm");
    	System.out.println("\n");
    	
		System.out.println("Initialized Table--Part 1");
        System.out.println("----------------------------------");
    	
    	for(int i = 0; i < numVertices; i++)
    	{
    		for(int j = 0; j < numVertices; j++)
    		{
    			if(i == j)
    			{
    				dist[i][j] = 0;	
    			}
    			else
    			{	
    				//dist[i][j] = 999;
    				dist[i][j] = infin;
    			}
    			System.out.print(dist[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	System.out.println("\n");
    	System.out.println("Initialized Table--Part 2");
        System.out.println("----------------------------------");
    	
    	for(int i = 0; i < numVertices; i++)
    	{
    		for(int j = 0; j < numVertices; j++)
    		{
    			if(i == j)
    			{
    				dist[i][j] = 0;	
    			}
    			else if(adjMatrix[i][j] != 999)
    			{
    				dist[i][j] = adjMatrix[i][j];
    			}
    			else
    			{	
    				dist[i][j] = infin;
    			}
    			System.out.print(dist[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	System.out.println("\n");
    	
    	
    	//actually start GAL Alg 
    	outerloop:    	
    	for(int m = 0; m < numVertices; m++)
    	{
    		for(int n = 0; n < numVertices; n++)
    		{
    			if(m == n && dist[m][n] < 0) // if diagonal value is found to be negative, then we have a neg. cycle and algorithm is stopped 
    			{
    				System.out.println("A negative cycle was detected. The algorithm has stopped.");
    				break outerloop;
    			}
    			else
    			{
    				for(int i = 0; i < numVertices; i++)
    		    	{
    					//System.out.println("I =" + i);
    		    		for(int j = 0; j < numVertices; j++)
    		    		{
    		    			//System.out.println("J =" + j);
    		    			for(int k = 0; k < numVertices; k++)
    		    			{
    		    				//System.out.println("K =" + k);
    		    				
    		    				if(dist[i][j] > dist[i][k] + dist[k][j]) 
    		    				{
    		    					//System.out.println("dist["+i+"]["+j+"] = dist["+i+"]["+k+"] + dist["+k+"]["+j+"]");
    		    					
    		    					dist[i][j] = dist[i][k] + dist[k][j];
    		    					
    		    					//System.out.println("dist[i][j] =" + dist[i][j]);
    		    				} 
    		    			}//end k 
    		    			//System.out.println("\n");
    		    		}//end j
    		    	}//end i
    				System.out.println("Iteration:" + iteration);
    				
    	            System.out.println("----------------------------------");
    	            for(int i = 0; i < numVertices; i++)
    	        	{
    	        		for(int j = 0; j < numVertices; j++)
    	        		{
    	        			System.out.print(" " + dist[i][j] + " " +" ");
    	        		}
    	        		System.out.println();
    	        	}
    	            iteration++;
    	            System.out.println("\n");
    			}//end else
    		}
    		
    		System.out.println("NEW ROW VALUE");
    	}
    	
    	System.out.println("\n");
    	System.out.println("The last iteration is the optimum solution, unless a negative cycle was detected.");
    }
    	
    public static void main(String[] args) throws IOException //main execution method/runs the entire program
    {
    	//creates a graph object G using adjacency matrix that was read into the program 
    	Graph G = new Graph("Network1.txt");
    	G.printMatrix(); //prints adj. matrix
    	// calls algorithm on graph G, with the source vertex starting at index 0
    	algorithm(G,0); //index of source vertex is zero 
    } 
}
