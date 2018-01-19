package cloud.thecode.testingmapswithapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

import java.util.ArrayList;

import cloud.thecode.testingmapswithapi.LocationPoint;

/**
 * Created by Mazen on 1/18/2018.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context) {
        super(context, "Places", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Locations (id integer primary key autoincrement, longitude text, latitude text)");
        db.rawQuery("INSERT INTO Locations(longitude, latitude) VALUES(33.3827746, 31.8473888)", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Locations");
        onCreate(db);
    }


    public void addLocation(LocationPoint l) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("longitude", l.getLongitude());
        v.put("latitude", l.getLatitude());

        db.insertWithOnConflict("Locations", null, v, 1);

    }

    public ArrayList<LocationPoint> getVisitedLocations() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Locations", null, null, null, null, null, null);
        ArrayList<LocationPoint> points = new ArrayList<LocationPoint>();
        LocationPoint locationPoint;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                locationPoint = new LocationPoint();
                locationPoint.setLongitude(cursor.getString(1));
                locationPoint.setLatitude(cursor.getString(2));
                points.add(locationPoint);
            }
        }
        cursor.close();
        db.close();
        return points;
    }



}
