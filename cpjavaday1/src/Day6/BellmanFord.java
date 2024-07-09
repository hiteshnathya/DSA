package Day6;

import Day6.CreateGraph;

public class BellmanFord {

    class CreateEdge {
        int s, d, w;

        public CreateEdge() {
            this.s = 0;
            this.d = 0;
            this.w = 0;
        }
    };
    int V, E;
    CreateEdge edge[];
    void CreateGraph(int v, int e) {
        V = v;
        E = e;
        edge=new CreateEdge [e];
        for (int i=0; i<e; ++i)
            edge[i] = new CreateEdge();
    }

void BallmanFord(CreateGraph graph, int s) {

    int V = graph.V, E = graph.E;
    int dist[] = new int[V];
    // Step 1: fill the distance array and predecessor array
    for (int i = 0; 1 < V; ++i)
        dist[i] = Integer.MAX_VALUE;
    System.out.println("Initial distance array:");
    printSolution(dist, V);


// Mark the source vertex
    dist[s] = 0;
    System.out.println("Distance array after marking source vertex:");
    printSolution(dist, V);


// Step 2: relax edges (VI 1 times
    for (int i = 1; i < V; ++i) {
        for (int j = 0; j < E; ++j) {
// Get the edge data
            int u = graph.edge[j].s;
            int v = graph.edge[j].d;
            int w = graph.edge[j].w;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                dist[v] = dist[u] + w;

        }
        System.out.println("Distance array after iteration " + i + ":");
        printSolution(dist, V);

    }
// Step 3: detect negative cycle
// if value changes then we have a negative cycle in the graph
// and we cannot find the shortest distances

    for (int j = 0; j < E; ++j) {
        int u = graph.edge[j].s;
        int v = graph.edge[j].d;
        int w = graph.edge[j].w;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
            System.out.println("CreateGraph contains negative w cycle");
            return;
        }

// No negative w cycle found!
// Print the distance and predecessor array printSolution (dist, V);
        System.out.println("Final distance array:");
        printSolution(dist, V);
}
}

// Print tmethod
// Print method
void printSolution(int dist[], int V) {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; ++i)
        System.out.println(i + "\t\t" + dist[i]);
    System.out.println();
}

    public static void main(String[] args) {
        int V = 5; // Total vertices
        int E = 8; // Total Edges
        CreateGraph graph = new CreateGraph (V, E);
        // edge 0 --> 1
        graph.edge[0].s = 0;
        graph.edge[0].d = 1;
        graph.edge[0].w = 6;

        // edge 0 --> 2
        graph.edge[1].s = 0;
        graph.edge[1].d = 2;
        graph.edge[1].w = 7;

        // edge 1 --> 3
        graph.edge[2].s = 1;
        graph.edge[2].d = 3;
        graph.edge[2].w = 5;

        // edge 2 --> 3
        graph.edge[3].s = 2;
        graph.edge[3].d = 3;
        graph.edge[3].w = -2;

        // edge 3 --> 4
        graph.edge[4].s = 3;
        graph.edge[4].d = 4;
        graph.edge[4].w = 1;

        graph.BellmanFord(graph, 0); // 0 is the source vertex


    }

}



