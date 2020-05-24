package Other;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

    private List<Tegevus> toDoList = new ArrayList<>();
    private static ToDoList tegevused = null;

    public ToDoList() {
    }

    public static ToDoList getInstance() { // nii pääseme toDoListile erinevatest controlleritest ligi
        if (tegevused == null)
            tegevused = new ToDoList();
        return tegevused;
    }

    //lisame failis olevad tegevused to-do-listi või loome uue faili
    public void failistToDoListi() throws IOException {
        File fail = new File("randomToDo.txt");
        if (fail.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fail)))) {
                String rida = br.readLine();
                while (rida != null) {
                    String[] jupid = rida.split(" ");
                    Tegevus uus = new Tegevus();
                    if (jupid[1].equals("true")) {
                        uus = new Tegevus(jupid[0], true);
                    } else if (jupid[1].equals("false")) {
                        uus = new Tegevus(jupid[0], false);
                    }
                    if (uus.getKirjeldus() != null)
                        tegevused.lisaToDoListi(uus);
                    rida = br.readLine();
                }
            }
        } else {
            return;
        }
    }

    public List<Tegevus> getToDoList() {
        return toDoList;
    }

    public void kuvaSissekanded(List<Tegevus> toDoList) {
        int i = 0;
        System.out.println("-----------------------------");
        for (Tegevus tegevus : toDoList) {
            System.out.println(i+1 + ". sissekanne on " + tegevus);
            i++;
        }
        System.out.println("-----------------------------");
    }

    public int tegevusiListis(List<Tegevus> toDoList) {
        return toDoList.size();
    }

    public int tegevusiListis() {
        return getToDoList().size();
    }

    public void lisaToDoListi(List<Tegevus> toDoList) {
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
    }

    public void lisaToDoListi(Tegevus tegevus) {
        toDoList.add(tegevus);
    }

    public void kustutaTegevus(List<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sul ei ole tegevusi, mida kustutada.");
        } else {
            kuvaSissekanded(toDoList);
            System.out.println("Sisesta täisarvuna, mitmenda tegevuse kustutada tahad. Väljumiseks vajuta ENTER.");
            Scanner scanner = new Scanner(System.in);
            String sisend = scanner.nextLine();
            if (sisend.equals(""))
                return;
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
            }
        }
    }

    public void kuvaList(List<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
        } else {
            System.out.println("-----------------------------");

            for (Tegevus tegevus : toDoList) {
                System.out.println(tegevus);
            }
            System.out.println("-----------------------------");
        }
    }

    public void tegevusTehtuks(List<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
        } else {
            kuvaSissekanded(toDoList);
            System.out.println("Sisesta täisarvuna, mitmenda tegevuse tehtuks muuta tahad.");
            Scanner scanner = new Scanner(System.in);
            String sisend = scanner.nextLine();
            int number = Integer.valueOf(sisend);
            Tegevus tegevus = toDoList.get(number-1);
            System.out.println("Soovid tehtuks muuta tegevuse: " + tegevus);
            System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
            Scanner scanner1 = new Scanner(System.in);
            String sisend1 = scanner1.nextLine();
            if (sisend1.equals("")) {
                if (!tegevus.isTehtud()) {
                    System.out.println("Hea töö!");
                    tegevus.setTehtud(true);
                } else {
                    System.out.println("See tegevus on juba tehtud. Kas soovid märkida selle tegemata tegevuseks?");
                    System.out.println("Kui jah, vajuta ENTER, kui ei, sisesta 'lõpeta'.");
                    Scanner scanner2 = new Scanner(System.in);
                    String sisend2 = scanner2.nextLine();
                    if (sisend2.equals("")) {
                        System.out.println("Other.Tegevus " + tegevus + " on muudetud tegemata tegevuseks.");
                        tegevus.setTehtud(false);
                    } else if (sisend2.equals("lõpeta")) {
                        return;
                    }
                    return;
                }

            } else if (sisend1.equals("lõpeta")) {
                return;
            }
        }
    }

    public void suvalineTegevus(List<Tegevus> toDoList) {
        int tegevusi = tegevusiListis(toDoList);
        if (tegevusi == 0) {
            System.out.println("Sisesta enne listi mõned tegevused.");
        } else {
            ArrayList<Tegevus> tegemata = new ArrayList<>();
            for (Tegevus tegevus : toDoList) {
                if (!tegevus.isTehtud()) {
                    tegemata.add(tegevus);
                }
            }
            if (tegemata.size() == 0) {
                System.out.println("Sul on kõik tehtud! Puhka või lisa uus tegevus.");
            } else {
                Tegevus suvaline = tegemata.get((int) (Math.random()*tegevusi));
                System.out.print("Järgmisena tee: ");
                System.out.println(suvaline.getKirjeldus());
            }
        }
    }

    public void muudaTegevuseNime(List<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sisesta enne listi mõned tegevused.");
        } else {
            kuvaSissekanded(toDoList);
            System.out.println("Sisesta täisarvuna, mitmenda tegevuse nime muuta tahad.");
            Scanner scanner = new Scanner(System.in);
            String sisend = scanner.nextLine();
            int number = Integer.valueOf(sisend);
            System.out.println("Soovid nime muuta tegevusel: " + toDoList.get(number-1));
            System.out.println("Vajuta ENTER, kui see on õige kirje, ja kirjuta 'lõpeta', kui soovid tegevust lõpetada.");
            Scanner scanner1 = new Scanner(System.in);
            String sisend1 = scanner1.nextLine();
            if (sisend1.equals("")) {
                System.out.println("Sisesta tegevuse uus nimi: ");
                Scanner scanner2 = new Scanner(System.in);
                String sisend2 = scanner2.nextLine();
                toDoList.get(number-1).setKirjeldus(sisend2);
            } else if (sisend1.equals("lõpeta")) {
                return;
            }
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
            case "6":
                muudaTegevuseNime(toDoList);
                break;
        }
    }
}
