package Other;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Peaklass {

    static void kuvaJuhtnöörid() {
        System.out.println("Juhtnöörid:");
        System.out.println("välju tegevuste lisamisest: vajuta ENTER");
        System.out.println("lisa tegevus: sisesta 1 ja vajuta ENTER");
        System.out.println("kustuta tegevus: sisesta 2 ja vajuta ENTER");
        System.out.println("kuva to-do list: sisesta 3 ja vajuta ENTER");
        System.out.println("märgi tegevus tehtuks/tegemata tegevuseks: sisesta 4 ja vajuta ENTER");
        System.out.println("vali suvaline tegevus, mida tegema hakata: sisesta 5 ja vajuta ENTER");
        System.out.println("tegevuse nime muutmiseks: sisesta 6 ja vajuta ENTER");
    }


    private static void kirjutaFaili() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("randomToDo.txt")))) {
            for (Tegevus t : ToDoList.getInstance().getToDoList()) {
                bw.write(t.getKirjeldus() + ";" + t.isTehtud());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println();
        System.out.println("*******************************************");
        System.out.println();
        System.out.println("RandomToDo");
        System.out.println("Programm aitab kasutajal oma to-do listi hallata ja tegevustega alustada.");
        System.out.println();
        kuvaJuhtnöörid();
        System.out.println();

        ToDoList isend = ToDoList.getInstance();
        isend.failistToDoListi();


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kui soovid juhtnööre uuesti näha, sisesta 'jah'.");
            System.out.println("Vali tegevus (väljumiseks vajuta ENTER): ");
            String sisend = scanner.nextLine();
            if (sisend.equals("")) {
                System.out.println("Programm lõpetas töö.");
                kirjutaFaili();
                break;
            } else if (sisend.equals("jah")) {
                kuvaJuhtnöörid();
            } else {
                System.out.println("Sisestasid: " + sisend);
            }
            isend.sisendiAnalüüs(sisend);
        }
    }
}
