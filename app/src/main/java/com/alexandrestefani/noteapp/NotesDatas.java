package com.alexandrestefani.noteapp;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesDatas {

    private Context context;
    private SharedPreferences preferences;
    private final String NAME_FILE = "notes.preferences";
    private final String NAME_KEY = "name";
    private SharedPreferences.Editor editor;

    public NotesDatas(Context c){
        this.context = c;
        preferences = context.getSharedPreferences(NAME_FILE,0);
        editor = preferences.edit();
    }

    public void saveNotes(String notes){
        editor.putString(NAME_KEY,notes);
        editor.commit();
    }

    public String getNotes(){

        return preferences.getString(NAME_KEY,"");

    }
}
