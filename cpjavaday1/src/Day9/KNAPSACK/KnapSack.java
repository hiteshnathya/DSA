package Day9.KNAPSACK;

public class KnapSack {
    public static int maximum(int a , int b ) {
        if (a>b) {
            return a;
        }
        else {
            return b;
        }
    }

    public static int knapsack(int w, int weight[], int profit[], int n) {
        if (n==0 || w==0){
            return 0;
        }
        if (weight[n-1]> w){
            return knapsack(w,weight, profit,n-1 );
        }
        else {
            return maximum((profit[n-1]+knapsack(w-weight[n-1], weight,profit,n-1 )), knapsack(w,weight, profit,n-1 ));

        }

    }
    public static void main(String[] args) {

        int weight[]={50,90,110,60,100};
        int profit[]={10,20,30,10,40};
        int n = 5;
        int w = 250;
        int total = knapsack(w,weight, profit,n );
        System.out.println("Total profit : "+ total);

    }
}
