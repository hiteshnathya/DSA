package Day5.ufa;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    public static void main(String[] args) {
        int[][] edges = new int[5][3];
//        edges[0][0] = 0;
//        edges[0][1] = 1;
//        edges[0][2] = 10;
//        edges[1][0] = 1;
//        edges[1][1] = 2;
//        edges[1][2] = 9;
//        edges[2][0] = 2;
//        edges[2][1] = 4;
//        edges[2][2] = 2;
//        edges[3][0] = 4;
//        edges[3][1] = 3;
//        edges[3][2] = 5;
//        edges[4][0] = 3;
//        edges[4][1] = 2;
//        edges[4][2] = 3;

        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 2;
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[1][2] = 3;
        edges[2][0] = 1;
        edges[2][1] = 2;
        edges[2][2] = 1;
        edges[3][0] = 0;
        edges[3][1] = 3;
        edges[3][2] = 4;

        int ans = KruskalAlgo(5, edges);
        System.out.println("The min cost is " + ans);
    }

    static int[] parent;
    static int[] rank;

    public static class Pair implements Comparable<Pair> {
        public int vertex1;
        public int vertex2;
        public int weight;

        public Pair(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return vertex1 == pair.vertex1 &&
                    vertex2 == pair.vertex2 &&
                    weight == pair.weight;
        }
    }

    public static int KruskalAlgo(int n, int[][] edge) {
        System.out.print("Minimum Spanning Tree is :-");
        System.out.println();
        System.out.println("V1" + " V2" + " Wt");

        Pair[] edges = new Pair[edge.length];
        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edge[i][0];
            int vertex2 = edge[i][1];
            int weight = edge[i][2];
            edges[i] = new Pair(vertex1, vertex2, weight);
        }

        int ans = 0;
        Arrays.sort(edges, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edges[i].vertex1;
            int vertex2 = edges[i].vertex2;
            int weight = edges[i].weight;

            boolean flag = union(vertex1, vertex2);
            if (flag == false) {
                System.out.println(vertex1 + " " + vertex2 + " " + weight);
                ans += weight;
            }
        }

        return ans;
    }

    public static int find(int component) {
        if (parent[component] == component) {
            return component;
        }
        int temp = find(parent[component]);
        parent[component] = temp;
        return temp;
    }

    public static boolean union(int vertex1, int vertex2) {
        int parentOfVertex1 = find(vertex1);
        int parentOfVertex2 = find(vertex2);

        if (parentOfVertex1 == parentOfVertex2) {
            return true;
        }

        if (rank[parentOfVertex1] > rank[parentOfVertex2]) {
            parent[parentOfVertex2] = parentOfVertex1;
        } else if (rank[parentOfVertex1] < rank[parentOfVertex2]) {
            parent[parentOfVertex1] = parentOfVertex2;
        } else {
            parent[parentOfVertex2] = parentOfVertex1;
            rank[parentOfVertex1]++;
        }

        return false;
}
}