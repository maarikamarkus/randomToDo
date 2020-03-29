import java.util.ArrayList;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        System.out.println("randomToDo");
        System.out.println();
        // võiksid olla tegevused, aga prg ei tööta
        System.out.println("uus tegevus: sisesta 1 ja vajuta ENTER");
        System.out.println("välju tegevuste lisamisest: vajuta ENTER");
        System.out.println("kuva to-do list: sisesta 2 ja vajuta ENTER");
        System.out.println("märgi tegevus tehtuks: sisesta 3 ja vajuta ENTER");
        System.out.println("kustuta tegevus: sisesta 4 ja vajuta ENTER");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vali tegevus: ");
        String sisend = scanner.nextLine();
        System.out.println("Sisestasid: " + sisend);

        //kahtlane, aga kuidagi peab tegema mingi algse ArrayList<Tegevus>-e, et ToDoList isendit teha saada
        Tegevus tegevus = new Tegevus(sisend, false);
        ArrayList<Tegevus> tegevused = new ArrayList<>();
        tegevused.add(tegevus);

        ToDoList toDoList = new ToDoList(tegevused);
        toDoList.lisaToDoListi(sisend);
        toDoList.sisendiAnalüüs(sisend);
    }
}
