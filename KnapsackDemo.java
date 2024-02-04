import java.util.*;

class DataObject {
    int profit;
    int weight;
    double pw;
}

public class Main {
    DataObject d[];
    int max;
    int n, sum = 0;
    Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
        System.out.println("Enter no.of objects:");
        n = sc.nextInt();
        System.out.println("Enter size of knapsack:");
        max = sc.nextInt();
        d = new DataObject[n];
        for (int i = 0; i < n; i++) {
            d[i] = new DataObject();
            System.out.println("Enter profit:");
            d[i].profit = sc.nextInt();
            System.out.println("Enter Weight:");
            d[i].weight = sc.nextInt();
        }
    }

    public void calculate() {
        for (int i = 0; i < n; i++)
            d[i].pw = d[i].profit / (double) d[i].weight;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (d[i].pw < d[j].pw) {
                    DataObject temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        int k = 0;
        while (max > 0) {
            if (d[k].weight < max) {
                max = max - d[k].weight;
                sum = sum + d[k].profit;
            } else {
                sum = sum + (int) (max * (d[k].profit / (double) d[k].weight));
                max = 0;
            }
            k++;
        }
        System.out.println("Maximum Profit = " + sum);
    }

    public static void main(String a[]) {
        Main p = new Main();
        p.calculate();
    }
}
