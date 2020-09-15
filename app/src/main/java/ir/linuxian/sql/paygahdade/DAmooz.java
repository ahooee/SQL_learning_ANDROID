package ir.linuxian.sql.paygahdade;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "damooz")
public class DAmooz {

    @PrimaryKey
    int uid;

    @ColumnInfo(name = "Naam")
    String firstName;

    @ColumnInfo(name = "Naam_Kh")
    String lastName;

    @ColumnInfo(name = "Paye")
    int paye;

    @ColumnInfo(name = "Moaddel")
    float moaddel;


    public DAmooz(int uid, String firstName, String lastName, int paye, float moaddel) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.paye = paye;
        this.moaddel = moaddel;
    }


    public int getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPaye() {
        return paye;
    }

    public float getMoaddel() {
        return moaddel;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPaye(int paye) {
        this.paye = paye;
    }

    public void setMoaddel(float moaddel) {
        this.moaddel = moaddel;
    }
}
