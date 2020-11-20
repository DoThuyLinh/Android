package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"BookDatabase",null,1);
    }
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,"BookDatabase.sqlite",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Author("+
                "id_author integer primary key,"+
                "name text,"+
                "address text,"+
                "email text)");
        db.execSQL("create table Book("+
                "id_book integer primary key,"+
                " title text,"+
                " id_author integer "+
                " constraint id_author references Author(id_author)"+
                "on delete cascade on update cascade)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Author");
        db.execSQL("DROP TABLE IF EXISTS Book");
        onCreate(db);
    }
    public boolean insertAuthor(Author author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_author",author.getId_author());
        contentValues.put("name",author.getName());
        contentValues.put("address",author.getAddress());
        contentValues.put("email",author.getEmail());
        db.insert("Author",null,contentValues);
        //db.close();
        return true;
    }
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<Author>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Author",null);
        if(cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            list.add(new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public boolean deleteAuthor (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        if(db.delete("Author","id_author"+"=?", new String[]{String.valueOf(id)})>0){
            db.close();
            return true;
        }
        return false;
    }
    public boolean insertBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_book",book.getId_book());
        contentValues.put("title",book.getTitle());
        contentValues.put("id_author",book.getId_author());
//        int result = (int)db.insert("Book",null,contentValues);
//        db.close();
//        return result;
        db.insert("Book",null,contentValues);
        return true;
    }
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<Book>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Book",null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        while (cursor.isAfterLast()==false){
            list.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public boolean deleteBook (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        if(db.delete("Book","id_book"+"=?", new String[]{String.valueOf(id)})>0){
            db.close();
            return true;
        }
        return false;
    }
    public boolean updateBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",book.getTitle());
        contentValues.put("id_author",book.getId_author());
        if(db.update("Book",contentValues,"id_book"+"=?", new String[]{String.valueOf(book.getId_book())})>0){
            db.close();
            return true;
        }
        return false;
    }
    public Book searchBook(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Book book = new Book();
        Cursor cursor = db.rawQuery("select * from Book where id_book="+id+"",null);
        if(cursor!=null){
            book.setId_book(cursor.getInt(0));
            book.setTitle(cursor.getString(1));
            book.setId_author(cursor.getInt(2));
            return book;
        }
        return null;
    }

    public ArrayList<String> getBookAuthor(int id){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlstr= "select Book.id_author, title " +
                        "from Author inner join Book on " +
                        "Author.id_author = Book.id_author " +
                        "where Author.id_author=" +id;
        Cursor cursor = db.rawQuery(sqlstr,null);
        if(cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            list.add(cursor.getInt(0)+"");
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        return list;
    }
}
