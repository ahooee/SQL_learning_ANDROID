package ir.linuxian.sql.paygahdade;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

@Dao
public interface DAmoozanDao {

    @Query("SELECT * FROM damooz")
    List<DAmooz> getDAmoozan();

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insetDAmooz(DAmooz dAmooz);

    @RawQuery
    DAmooz getDAmooz(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery
    List<DAmooz> getDAmoozha(SupportSQLiteQuery supportSQLiteQuery);




}
