package Day3;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    private int v;
    private LinkedList<Integer> l1[];

    public BFS(int v) {

        this.v = v;
        l1 = new LinkedList[v];
        for (int j = 0; j < v; j++)
            l1[j] = new LinkedList<>();

    }

    // create method addEdge()
    public void addEdge(int v, int w) {
        l1[v].add(w);
    }
    // bfs method

    public void bfs(int s) {
        boolean visited[] = new boolean[v];
        // create queue


        LinkedList<Integer> q = new LinkedList<Integer>();

        // mark the node as visited and enqueue

        visited[s] = true;
        q.add(s);


        while (q.size() != 0) {
            s = q.poll();
            System.out.println(s + " ");

            Iterator<Integer> itr = l1[s].listIterator();
            while (itr.hasNext()) {
                int x = itr.next();
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }

            }

        }
    }

    public static void main(String args[]) {
        BFS obj = new BFS(4);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 0);
        obj.addEdge(2, 3);
        obj.addEdge(3, 3);

        obj.bfs(2);

    }


}


