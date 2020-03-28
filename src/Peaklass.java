import javax.swing.*;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        System.out.println("randomToDo");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta uus tegevus: ");
        String sisend = scanner.nextLine();
        System.out.println("Sisestasid: " + sisend);
    }
}
