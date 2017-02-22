package mx.com.ipn.amaac.tableroDeComunicacion.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma;


public class DBHelper  extends SQLiteOpenHelper {


    //Nombre de la base de datos
    public static final  String NAME_DATABASE="pictogramas.sqlite";
    private static final int DB_SHEME_VERSION=1;//Version de la DB por si hay una nueva version y haya que actualizar la BD

    //Nombre de la tabla pictograma
    public static final  String TABLE_PICTOGRAMA="pictograma";

    //Nombre de los campos de la tabla usuarios
    public static final  String ID="idPictograma";
    public static final  String NOMBRE="nombre";
    public static final  String CATEGORIA="categoria";
    public static final  String ID_DRAWABLE="idDrawable";
    public static final  String TIPO="tipo";

    //sentencia para crear la tabla pictograma
    public static final String CREATE_TABLE_PICTOGRAMA="CREATE TABLE "+ TABLE_PICTOGRAMA+" ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NOMBRE +" TEXT NOT NULL,"
            + CATEGORIA +" INTEGER,"
            + ID_DRAWABLE +" INTEGER,"
            + TIPO +" INTEGER);";



    //Context context Es una referencia a la Activity
    public DBHelper(Context context) {
        super(context, NAME_DATABASE, null,DB_SHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PICTOGRAMA);
    }

    //metodo usado en el caso de que haga falta actualizar la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_PICTOGRAMA);
        onCreate(db);
    }

    //==============================================================================================
    public void insertPictograma(Pictograma picto) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOMBRE, picto.getNombre());
        values.put(CATEGORIA, picto.getCategoria());
        values.put(ID_DRAWABLE,picto.getIdDrawable());
        values.put(TIPO,picto.getTipo());

        db.insert(TABLE_PICTOGRAMA, null, values);
        db.close();
    }


    public Pictograma getPictograma(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PICTOGRAMA, new String[]{ID,
                        NOMBRE, CATEGORIA,ID_DRAWABLE}, ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Pictograma pic = new Pictograma(cursor.getString(1), cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
        return pic;
    }

    public List<Pictograma> getAllPictogramas() {
        List<Pictograma> usersList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PICTOGRAMA;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Pictograma pic = new Pictograma(cursor.getString(1), cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
                usersList.add(pic);
            } while (cursor.moveToNext());
        }
        return usersList;
    }



    public int count(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCount= db.rawQuery("select count(*) from "+ TABLE_PICTOGRAMA , null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();

        return count;
    }


    public int updatePictograma(Pictograma picto) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOMBRE, picto.getNombre());
        values.put(CATEGORIA, picto.getCategoria());
        values.put(ID_DRAWABLE,picto.getIdDrawable());
        // updating record
        return db.update(TABLE_PICTOGRAMA, values, ID + " = ?",
                new String[]{String.valueOf(picto.getId())});
    }

    public void deletePictograma(Pictograma user) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_PICTOGRAMA, ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    //Para cerrar la conexión de la base de datos
    public void close(){
        this.close();
    }


}
