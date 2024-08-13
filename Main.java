import java.util.Scanner;

class SwitchBoard {
    private int[] switches;

    public SwitchBoard(int n, int[] initialStates) {
        switches = new int[n + 1];
        System.arraycopy(initialStates, 0, switches, 1, n);
    }

    public void operateByMale(int number) {
        for (int i = number; i < switches.length; i += number) {
            toggleSwitch(i);
        }
    }

    public void operateByFemale(int number) {
        int left = number - 1;
        int right = number + 1;

        while (left > 0 && right < switches.length && switches[left] == switches[right]) {
            left--;
            right++;
        }

        for (int i = left + 1; i < right; i++) {
            toggleSwitch(i);
        }
    }


    private void toggleSwitch(int index) {
        switches[index] = switches[index] == 1 ? 0 : 1;
    }


    public String printRes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < switches.length; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }
}


class Student {
    private int gender;
    private int number;

    public Student(int gender, int number) {
        this.gender = gender;
        this.number = number;
    }

    public void operateSwitch(SwitchBoard switchBoard) {
        if (gender == 1) {
            switchBoard.operateByMale(number);
        } else if (gender == 2) {
            switchBoard.operateByFemale(number);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] initialStates = new int[n];
        for (int i = 0; i < n; i++) {
            initialStates[i] = sc.nextInt();
        }

        SwitchBoard switchBoard = new SwitchBoard(n, initialStates);

        int studentCount = sc.nextInt();
        Student[] students = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            int gender = sc.nextInt();
            int number = sc.nextInt();
            students[i] = new Student(gender, number);
        }

        for (Student student : students) {
            student.operateSwitch(switchBoard);
        }

        System.out.println(switchBoard.printRes());
    }
}
