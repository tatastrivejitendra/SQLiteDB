package com.example.sqlitedb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    EditText editRollno, editName, editMarks;
    Button btnAdd, btnDelete, btnModify, btnView, btnViewall, btnShow, btnshowinfo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editRollno = findViewById(R.id.editRollno);
        editName = findViewById(R.id.editName);
        editMarks = findViewById(R.id.editMarks);
        btnAdd = findViewById(R.id.btnadd);
        btnDelete = findViewById(R.id.btndelete);
        btnModify = findViewById(R.id.btnmodify);
        btnView = findViewById(R.id.btnview);
        btnViewall = findViewById(R.id.btnviewall);
        btnShow = findViewById(R.id.btnshow);


        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnViewall.setOnClickListener(this);
        btnShow.setOnClickListener(this);


        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.btnadd:
                if (view == btnAdd) {
                    if (editRollno.getText().toString().trim().length() == 0 ||
                            editName.getText().toString().trim().length() == 0 ||
                            editMarks.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                        shwmsg("Error", "Invalid Input");
                        return;
                    }
                    clearText();
                }
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btndelete:

                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnmodify:

                Toast.makeText(this, "Modify", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnview:
                Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnviewall:
                Toast.makeText(this, "View All", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnshow:
                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void shwmsg(String title, String msg) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.show();

    }
    public void clearText(){
        editRollno.setText("");
        editName.setText("");
        editMarks.setText("");
    }
}








