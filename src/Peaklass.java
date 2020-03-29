import java.util.ArrayList;
import java.util.Scanner;

public class Peaklass {
    static void lisaToDoListi(String sisend, ArrayList<Tegevus> toDoList) {
        Tegevus uus = new Tegevus(sisend, false);
        toDoList.add(uus);
    }

    static void sisendiAnalüüs(String sisend) {
        // kutsuda välja sisendile vastav meetod

        // nt
        // if (sisend == x )
        //     lisaToDoListi(sisend);
    }

    public static void main(String[] args) {
        System.out.println("randomToDo");
        // võiksid olla tegevused, aga prg ei tööta
        System.out.println("uus tegevus: sisesta 1 ja vajuta ENTER");
        System.out.println("välju tegevuste lisamisest: vajuta ENTER");
        System.out.println("kuva to-do list: sisesta 2 ja vajuta ENTER");
        System.out.println("märgi tegevus tehtuks: sisesta 3 ja vajuta ENTER");
        System.out.println("kustuta tegevus: sisesta 4 ja vajuta ENTER");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta uus tegevus: ");
        String sisend = scanner.nextLine();
        System.out.println("Sisestasid: " + sisend);
    }
}
