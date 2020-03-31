import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static ArrayList<Tegevus> toDoList = new ArrayList<>();

    private void lisaToDoListi(ArrayList<Tegevus> toDoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta uus tegevus: ");
        String tegevus = scanner.nextLine();

        while (!tegevus.equals("")) {
            System.out.println("Sisestasid: " + tegevus);
            Tegevus lisada = new Tegevus(tegevus, false);
            toDoList.add(lisada);
            System.out.println("Sisesta uus tegevus (lisamisest väljumiseks vajuta ENTER): ");
            tegevus = scanner.nextLine();
        }
        System.out.println("Lõpetasid tegevuste lisamise.");
        return;

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
        if (sisend1.equals("")) {
            System.out.println("Kustutati tegevus: " + toDoList.get(number-1).getKirjeldus());
            toDoList.remove(number-1);
        } else if (sisend1.equals("lõpeta")) {
            System.out.println("Ühtegi tegevust ei kustutatud.");
            return;
        }

    }

    private void kuvaList(ArrayList<Tegevus> toDoList) {
        for (Tegevus tegevus : toDoList) {
            System.out.println(tegevus);
        }
    }

    private void tegevusTehtuks(ArrayList<Tegevus> toDoList) {
        int i = 0;
        for (Tegevus tegevus : toDoList) {
            System.out.println(i+1 + ". sissekanne on " + tegevus);
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
        if (sisend1.equals("")) {
            System.out.println("Hea töö!");
            toDoList.get(number - 1).setTehtud(true);
        } else if (sisend1.equals("lõpeta")) {
            return;
        }
    }

    private void suvalineTegevus(ArrayList<Tegevus> toDoList) {
        int tegevusi = toDoList.size();
        if (tegevusi == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
            return;
        } else {
            Tegevus suvaline = toDoList.get((int) (Math.random()*tegevusi));
            System.out.print("Järgmisena tee: ");
            System.out.println(suvaline.getKirjeldus());
        }
    }

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
                suvalineTegevus(toDoList);
                break;
        }
    }

}
