package com.example.katherine.sugarlab.repositories;

import com.example.katherine.sugarlab.models.Note;
import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static List<Note> listuser(String username){
        List<Note> notes = SugarRecord.find(Note.class,"username = ?",username);
        return notes;
    }

    public static void create(String username, String title, String content, Date date, Boolean favorite){
        Note notes = new Note(username,title, content, date,favorite);
        SugarRecord.save(notes);
    }

}
