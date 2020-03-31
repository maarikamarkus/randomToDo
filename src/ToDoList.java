import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private ArrayList<Tegevus> toDoList;

    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public ArrayList<Tegevus> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<Tegevus> toDoList) {
        this.toDoList = toDoList;
    }

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
            System.out.println(i + ". sissekanne on " + tegevus);
            i++;
        }
        System.out.println("Sisesta täisarvuna, mitmenda tegevuse kustutada tahad.");
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();
        Integer number = new Integer(sisend);
        System.out.println("Soovid kustutada tegevuse: " + toDoList.get(number.intValue()-1));
        System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
        Scanner scanner1 = new Scanner(System.in);
        String sisend1 = scanner1.nextLine();
        if (sisend1 == "")
            toDoList.remove(number.intValue()-1);
        else
            return;
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
        Integer number = new Integer(sisend);
        System.out.println("Soovid tehtuks muuta tegevuse: " + toDoList.get(number.intValue()-1));
        System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
        Scanner scanner1 = new Scanner(System.in);
        String sisend1 = scanner1.nextLine();
        if (sisend1 == "")
            toDoList.get(number.intValue()-1).setTehtud(true);
        else
            return;
    }

    private void suvalineTegevus(ArrayList<Tegevus> toDoList) {
        return;
    }

    public void sisendiAnalüüs(String sisend) {
        if (sisend.equals("1")) {
            lisaToDoListi(toDoList);
        } else if (sisend.equals("2")) {
            kustutaTegevus(toDoList);
        } else if (sisend.equals("3")) {
            kuvaList(toDoList);
        } else if (sisend.equals("4")) {
            tegevusTehtuks(toDoList);
        } else if (sisend.equals("5")) {
            suvalineTegevus(toDoList);
        }
    }

}
