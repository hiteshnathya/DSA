package Day4.djks;

import java.util.*;

public class Graph {

    private  int V;
    private List<List<Node>> l1;

    static class Node{
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Graph(int v){
        V =v;
        l1=new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            l1.add(new ArrayList<>());

        }

    }

    public void addEdge(int s,int d,int w){
        l1.get(s).add(new Node(d,w));//for directed  graph

        l1.get(d).add(new Node(s,w));//for undirected

    }

    public void djks(int s){
        PriorityQueue<Node> pq=new PriorityQueue<>(V, Comparator.comparing(node -> node.weight));
        int distances[]=new int[V];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[s]=0;
        pq.add(new Node(s,0));

        System.out.println("Initial distances: ");
        for (int i = 0; i < V; i++) {
            System.out.print(distances[i] + " ");
        }
        System.out.println();

        while (!pq.isEmpty())
        {
            int m=pq.poll().dest;
            System.out.println("Extracted node: " + m);
            for (Node n: l1.get(m))
            {
                int v=n.dest;
                int weight=n.weight;
                if (distances[m]+weight<distances[v])
                {
                    distances[v]=distances[m]+weight;
                    pq.add(new Node(v,distances[v]));
                    System.out.println("Updated distance to node " + v + ": " + distances[v]);
                }
            }
        }
        System.out.println("Final distances: ");
        for (int i = 0; i < V; i++) {
            System.out.print(distances[i] + " ");
        }
        System.out.println();
        System.out.println(" \nShortest disstance from node "+s+" ");
        for (int i = 0; i < V; i++) {
            System.out.println(s+ "---- " + i+ " : "+ distances[i]);

        }
    }

    public static void main(String[] args) {
        Graph obj=new Graph(6);
        obj.addEdge(0,1,10);
        obj.addEdge(0,2,5);
        obj.addEdge(1,2,3);
        obj.addEdge(2,3,1);
        obj.addEdge(3,4,7);
        obj.addEdge(4,5,2);
        obj.djks(0);
    }
}