package Other;

public class Tegevus {

    private String kirjeldus;
    private boolean tehtud;

    public Tegevus(String kirjeldus, boolean tehtud) {
        this.kirjeldus = kirjeldus;
        this.tehtud = tehtud;
    }

    public Tegevus() {};

    public String getKirjeldus() {
        return kirjeldus;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }

    public boolean isTehtud() {
        return tehtud;
    }

    public void setTehtud(boolean tehtud) {
        this.tehtud = tehtud;
    }

    @Override
    public String toString() {
        String tehtud;
        if (isTehtud())
            tehtud = "+";
        else
            tehtud = "-";
        return kirjeldus  + ": " + tehtud + ";";
    }

}
