// knapsack using bottom up algorithm for generationg subset 

public class project {
    public static void main(String[] args) {

        int[] p = { 42, 12, 40, 25 };
        int[] w = { 7, 3, 4, 5 };
        Knapsack kp = new Knapsack(4, 10, w, p);
        kp.Knapsack_generate();

    }
}

class Knapsack {
    int n; // Number of items
    int capacity;// Capacity of knapsack
    int[] weight;
    int[] totaleValue;
    int max = 0;

    public Knapsack(int n, int capacity, int[] weight, int[] totaleValue) {
        this.n = n;
        this.capacity = capacity;
        this.weight = weight;
        this.totaleValue = totaleValue;
    }

    public void Knapsack_generate() {
        System.out.println("the number of subsets: " + (Math.pow(2, n)));
        int max = 0;
        for (int i = 0; i < (Math.pow(2, n)); i++) {
            int z = 0, w = 0;
            System.out.print("{ ");
            // Print current subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print((j + 1) + " ");
                    z += totaleValue[j];
                    w += weight[j];
                }
            }
            System.out.print("}\t");
            if (w > capacity)
                System.out.println("infeasible");
            else
                max = Math.max(max, z);
            System.out.println("totale Value: " + z + "\t weight: " + w);
        }
        System.out.println("Total cost is :" + max);

    }

}