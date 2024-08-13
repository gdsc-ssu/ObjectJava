import java.util.Scanner;

//백준 10804번
class CardDeck { //카드 상태 관리하는 클래스
    private int[] cards; // 카드 상태 저장 배열

    public CardDeck() {
        cards = new int[20];
        for (int i = 0; i < 20; i++) {
            cards[i] = i + 1;
        }
    }

    public void reverseRange(int start, int end) { //주어진 범위(start부터 end까지)의 카드를 뒤집음
        // start와 end는 1-based 인덱스이므로, 0-based로 변환
        start--;
        end--;

        while (start < end) {
            int temp = cards[start];
            cards[start] = cards[end];
            cards[end] = temp;
            start++;
            end--;
        }
    }

    public void printDeck() {
        for (int card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardDeck deck = new CardDeck();

        for (int i = 0; i < 10; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            deck.reverseRange(start, end);
        }

        deck.printDeck();
        sc.close();
    }
}
