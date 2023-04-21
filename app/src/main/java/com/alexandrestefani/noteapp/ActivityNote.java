package com.alexandrestefani.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityNote extends AppCompatActivity {
    private FloatingActionButton fab;
    private NotesDatas notesDatas;
    private EditText notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        notesDatas  = new NotesDatas( getApplicationContext());
        notes = findViewById(R.id.note_typed);




        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (notes.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Sem informações para gravar", Toast.LENGTH_LONG).show();
                }else{
                     notesDatas.saveNotes(notes.getText().toString());
                     Toast.makeText(getApplicationContext(),"Ideia salva", Toast.LENGTH_LONG).show();

                }


            }
        });

        // recuperar a anotação
       String notesSaved = notesDatas.getNotes();
             //coloca-se ! para inverter a expressão
        if( !notesSaved.equals("")){
            notes.setText(notesSaved);

        }


    }
}