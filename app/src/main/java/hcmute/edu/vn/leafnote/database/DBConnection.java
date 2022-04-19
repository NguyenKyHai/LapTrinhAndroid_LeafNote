package hcmute.edu.vn.leafnote.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import hcmute.edu.vn.leafnote.dao.UserDao;

public abstract class DBConnection extends RoomDatabase {
    private static final String DATABASE_NAME = "leafnote.db";
    private static DBConnection instance;
    public static synchronized DBConnection getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),DBConnection.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDao userDao();
}
