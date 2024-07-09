package Day8;

public class travellingSalesMan {
    int Answer=Integer.MAX_VALUE;

   static int [][] distance =
           {
           {0,10,15,20},
           {10,0,35,25},
           {15,35,0,30},
           {20,25,30,0}
           };
    static int n=4;
    static  int CityVisit=(1<<n)-1;
    private static int TrevallingSalesman(int bitm, int current ,int a){

        if (bitm ==CityVisit){
            return  distance[current][0];
        }
        for (int i = 0; i < n; i++) {
            if ((bitm & (1<<i))==0 ){

                bitm= 1<<i;
                int distancAnswer= distance[current][i]+TrevallingSalesman(bitm,i,a);
                a=Math.min(a,distancAnswer);

            }
        }
        return a;
    }

    public static void main(String[] args) {
        int answer=Integer.MAX_VALUE;
        
    }

}
