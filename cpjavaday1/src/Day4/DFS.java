package Day4;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    private int v;
    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> l1[];
    // Constructor
    public DFS(int v)
    {
        this.v = v;
        l1 = new LinkedList[v];//value has been passes that we givin
        for (int i = 0; i < v; i++) {
            l1[i] = new LinkedList<>();
        }
    }
    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        l1[v].add(w);// Add w to v's list.

    }
    public void dfsVisited(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println("Visited " + v);
        // Mark the current node as visited and print it
        //to explore all adjecent for this perticular v1
        Iterator<Integer> itr = l1[v].listIterator();
        // Recur for all the vertices adjacent to this vertex
        while (itr.hasNext()) {
            int x = itr.next();
            if (!visited[x]) {
                dfsVisited(x, visited);
            }
        }
    }
    public void dfs(int v1)
    // The function to do DFS traversal.
    // It uses recursive dfsVisited()
    {
        boolean visited[] = new boolean[v];
        // Mark all the vertices as not visited(set as false by default in java)
        dfsVisited(v1, visited);
        // Call the recursive helper function to print dfs traversal
    }
    public static void main(String[] args) {
        DFS obj = new DFS(6);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 0);
        obj.addEdge(2, 3);
        obj.addEdge(3, 3);
        obj.dfs(2);
    }
}
