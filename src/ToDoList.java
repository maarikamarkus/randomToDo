import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private ArrayList<Tegevus> toDoList;

    public ToDoList(ArrayList<Tegevus> toDoList) {
        this.toDoList = toDoList;
    }

    public ArrayList<Tegevus> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<Tegevus> toDoList) {
        this.toDoList = toDoList;
    }

    public void lisaToDoListi(String sisend) {
        Tegevus uus = new Tegevus(sisend, false);
        toDoList.add(uus);
    }

    public void sisendiAnalüüs(String sisend) {
        if (sisend.equals("1")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sisesta uus tegevus: ");
            String tegevus = scanner.nextLine();
            System.out.println("Sisestasid: " + tegevus);
            lisaToDoListi(tegevus);
        } else if (sisend.equals("2")) {
            //
        } else if (sisend.equals("3")) {
            //
        } else if (sisend.equals("4")) {
            //
        }
        //if (sisend.equals("2") jne
    }

}
