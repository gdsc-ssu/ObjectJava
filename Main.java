import java.util.Scanner;


class Basket{
    private int[] baskets;


    public Basket(int n) {
        baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }
    }

    public void reverseRange(int start, int end) {
        int temp;
        start--;
        end--;
        while (start < end) {
            temp = baskets[start];
            baskets[start] = baskets[end];
            baskets[end] = temp;
            start++;
            end--;
        }
    }


    public void printBaskets() {
        for (int i = 0; i < baskets.length; i++) {
            System.out.print(baskets[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = sc.nextInt();


        Basket basket = new Basket(n);

        for (int i = 0; i < count; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            basket.reverseRange(start, end);
        }


        basket.printBaskets();


        sc.close();
    }
}
