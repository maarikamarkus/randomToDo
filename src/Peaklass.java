import java.util.ArrayList;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("*******************************************");
        System.out.println();
        System.out.println("RandomToDo");
        System.out.println("Programm aitab kasutajal oma to-do listi hallata ja tegevustega alustada.");
        System.out.println();
        System.out.println("Juhtnöörid:");
        System.out.println("välju tegevuste lisamisest: vajuta ENTER");
        System.out.println("lisa tegevus: sisesta 1 ja vajuta ENTER");
        System.out.println("kustuta tegevus: sisesta 2 ja vajuta ENTER");
        System.out.println("kuva to-do list: sisesta 3 ja vajuta ENTER");
        System.out.println("märgi tegevus tehtuks: sisesta 4 ja vajuta ENTER");
        System.out.println("vali suvaline tegevus, mida tegema hakata: sisesta 5 ja vajuta ENTER");
        System.out.println();

        ToDoList isend = new ToDoList();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vali tegevus: ");
            String sisend = scanner.nextLine();
            if (sisend.equals("")) {
                System.out.println("Programm lõpetas töö");
                //return;
                break;
            } else {
                System.out.println("Sisestasid: " + sisend);
            }

            isend.sisendiAnalüüs(sisend);
        }

    }
}
