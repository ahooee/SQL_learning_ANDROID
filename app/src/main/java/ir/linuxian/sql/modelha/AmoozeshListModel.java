package ir.linuxian.sql.modelha;

public class AmoozeshListModel {

    public static final int SARSAFHE = 0;
    public static final int MAFAHIM = 1;
    public static final int DASTOORAT = 2;


    String naam;
    int namaye;
    int goone;



    public AmoozeshListModel(String naam, int goone , int namaye) {
        this.naam = naam;
        this.goone = goone;
        this.namaye = namaye;
    }


    public String getNaam() {
        return naam;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }


    public int getGoone() {
        return goone;
    }

    public void setGoone(int goone) {
        this.goone = goone;
    }

    public int getNamaye() {
        return namaye;
    }

    public void setNamaye(int namaye) {
        this.namaye = namaye;
    }
}
