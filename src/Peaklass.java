import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        System.out.println("randomToDo");
        System.out.println("uus tegevus: -<sinu tegevus>");
        System.out.println("välju tegevuste lisamisest: vajuta ENTER");
        System.out.println("kuva to-do list: 1");
        System.out.println("märgi tegevus tehtuks: +<sinu tegevus>");
        System.out.println("kustuta tegevus: !<sinu tegevus>");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta uus tegevus: ");
        String sisend = scanner.nextLine();
        System.out.println("Sisestasid: " + sisend);
    }
}
