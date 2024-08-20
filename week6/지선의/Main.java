import java.util.Scanner;

class Basket {
    private int[] baskets;

    public Basket(int n) {
        baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }
    }

    public void reverse(int start, int end) {
        while (start < end) {
            int temp = baskets[start];
            baskets[start] = baskets[end];
            baskets[end] = temp;
            start++;
            end--;
        }
    }

    public void printBaskets() {
        for (int basket : baskets) {
            System.out.print(basket + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 바구니의 개수
        int m = scanner.nextInt(); // 역순으로 바꿀 횟수

        Basket basket = new Basket(n);

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            basket.reverse(start, end);
        }

        basket.printBaskets();
        scanner.close();
    }
}
