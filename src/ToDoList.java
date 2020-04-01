import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static ArrayList<Tegevus> toDoList = new ArrayList<>();

    private void kuvaSissekanded(ArrayList<Tegevus> toDoList) {
        int i = 0;
        for (Tegevus tegevus : toDoList) {
            System.out.println(i+1 + ". sissekanne on " + tegevus);
            i++;
        }
    }

    private int tegevusiListis(ArrayList<Tegevus> toDoList) {
        return toDoList.size();
    }

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
    }

    private void kustutaTegevus(ArrayList<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sul ei ole tegevusi, mida kustutada.");
        } else {
            kuvaSissekanded(toDoList);
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
            }
        }
    }

    private void kuvaList(ArrayList<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
        } else {
            for (Tegevus tegevus : toDoList) {
                System.out.println(tegevus);
            }
        }
    }

    private void tegevusTehtuks(ArrayList<Tegevus> toDoList) {
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
                        System.out.println("Tegevus " + tegevus + " on muudetud tegemata tegevuseks.");
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

    private void suvalineTegevus(ArrayList<Tegevus> toDoList) {
        int tegevusi = tegevusiListis(toDoList);
        if (tegevusi == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
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

    private void muudaTegevuseNime(ArrayList<Tegevus> toDoList) {
        if (tegevusiListis(toDoList) == 0) {
            System.out.println("Sisesta enne mõned tegevused listi.");
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
