import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static ArrayList<Tegevus> toDoList = new ArrayList<>();

    private void lisaToDoListi(ArrayList<Tegevus> toDoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta uus tegevus: ");
        String tegevus = scanner.nextLine();
        System.out.println("Sisestasid: " + tegevus);
        Tegevus lisada = new Tegevus(tegevus, false);
        toDoList.add(lisada);
    }

    private void kustutaTegevus(ArrayList<Tegevus> toDoList) {
        int i = 0;
        for (Tegevus tegevus : toDoList) {
            System.out.println(i+1 + ". sissekanne on " + tegevus);
            i++;
        }
        System.out.println("Sisesta täisarvuna, mitmenda tegevuse kustutada tahad.");
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();
        int number = Integer.valueOf(sisend);
        System.out.println("Soovid kustutada tegevuse: " + toDoList.get(number-1));
        System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
        Scanner scanner1 = new Scanner(System.in);
        String sisend1 = scanner1.nextLine();
        if (sisend1 == "")
            toDoList.remove(number-1);
    }

    private void kuvaList(ArrayList<Tegevus> toDoList) {
        for (Tegevus tegevus : toDoList) {
            System.out.println(tegevus);
        }
    }

    private void tegevusTehtuks(ArrayList<Tegevus> toDoList) {
        int i = 0;
        for (Tegevus tegevus : toDoList) {
            System.out.println(i + ". sissekanne on " + tegevus);
            i++;
        }
        System.out.println("Sisesta täisarvuna, mitmenda tegevuse tehtuks muuta tahad.");
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();
        int number = Integer.valueOf(sisend);
        System.out.println("Soovid tehtuks muuta tegevuse: " + toDoList.get(number-1));
        System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
        Scanner scanner1 = new Scanner(System.in);
        String sisend1 = scanner1.nextLine();
        if (sisend1 == "")
            toDoList.get(number-1).setTehtud(true);
    }

    /*
    private void suvalineTegevus(ArrayList<Tegevus> toDoList) {
        return;
    }
    */
    public void sisendiAnalüüs(String sisend) {
        switch (sisend) {
            case "1":
                lisaToDoListi(toDoList);
                break;
            case "2":
                kustutaTegevus(toDoList);
                break;
            case "3":
                kuvaList(toDoList);
                break;
            case "4":
                tegevusTehtuks(toDoList);
                break;
            case "5":
                //suvalineTegevus(toDoList);
                break;
        }
    }

}
