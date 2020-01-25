package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertOP extends AppCompatActivity {

    DBH myDB;
    Button btnAdd, btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_op);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DBH(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertOP.this, OnePieceList.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(InsertOP.this, "Il campo non può essere vuoto", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData (String newEntry){

        boolean insertData = myDB.addData(newEntry);

        if(insertData == true){
            Toast.makeText(InsertOP.this, "Il fumetto è stato aggiunto correttamente!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(InsertOP.this, "Errore durante l'inserimento del fumetto!", Toast.LENGTH_LONG).show();
        }

    }
}
