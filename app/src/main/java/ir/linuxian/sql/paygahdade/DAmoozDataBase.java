package ir.linuxian.sql.paygahdade;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DAmooz.class},version = 1)
public abstract class DAmoozDataBase extends RoomDatabase {

    private static volatile DAmoozDataBase INCTANCE;

    public static DAmoozDataBase getInstance(Context context){

        if(INCTANCE == null)
            INCTANCE = Room.databaseBuilder(context, DAmoozDataBase.class, "DAMOOZ.db").build();

        return INCTANCE;

    }

    public abstract DAmoozanDao getDamoozDAO();



}
