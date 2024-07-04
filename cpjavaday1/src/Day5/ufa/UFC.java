package Day5.ufa;

public class UFC {
    int V,E;
    Edge edge[];
    class Edge {
        int s,d;
    }

    public UFC(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i <e ; i++) {
            edge[i]=new Edge();
        }

    }
    public int find(int parent[] ,int i)
    {
        if (parent[i]==i)
            return i;
        return find(parent,parent[i]);
    }


    public void union (int perent[],int x, int y)
    {
        int xset=find(perent,x);
        int yset=find(perent,y);
        perent[xset]=yset;

    }

    public boolean isCyclic(UFC g){
        int perent[]=new  int[g.V];
        for (int i = 0; i < g.V; i++) {
            perent[i]=i;
        }
        for (int i = 0; i < g.E; i++)
        {
            int x=g.find(perent,edge[i].s);
            int y=g.find(perent,edge[i].d);

            if (x==y)
                return true;
            g.union(perent,x,y);
        }
        return false;

    }

    public static void main(String[] args) {
        UFC obj=new UFC(3,3);
        //edge 0 to 1
        obj.edge[0].s=0;
        obj.edge[0].d=1;
        //edge 0 to 2
        obj.edge[1].s=1;
        obj.edge[1].s=2;

        //edge 0 to 2
        obj.edge[2].s=0;
        obj.edge[2].s=2;

        if (obj.isCyclic(obj))
        System.out.println(" **yes**  Graph contain cycle ");
        else
            System.out.println(" does not contain cycle ");
    }
}
