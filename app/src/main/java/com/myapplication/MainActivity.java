package com.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   // private Button Btn1,Btn2,Btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*
        Btn1 = findViewById(R.id.btn1AlertDialog);
        Btn2 = findViewById(R.id.btn2ConformDialog);
        Btn3 = findViewById(R.id.btn3PromptDialog); */

    }

    public void ClickAnyButton(View view){
        switch (view.getId()){
            case R.id.btn1AlertDialog:
            alertdialog();
            break;

            case  R.id.btn2ConformDialog:
            conformdialog();
            break;

            case R.id.btn3PromptDialog:
            promptdialog();
            break;
        }
    }

    // Alert Dialogbox

    public void alertdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is the Alert Demo !");
        builder.setMessage("This is the Alertdialog box Message");
        builder.setCancelable(true);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               // Toast.makeText(getApplicationContext(), "Neutral button clicked", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Natural Button Clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        builder.show();
    }

    // Conform Dialogbox

    public void conformdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is the conform Demo");
        builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all record", Toast.LENGTH_SHORT).show();
            }
        });
       builder.show();
    }

    public void promptdialog(){

        final EditText edtText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is the promptdialog demo !");
        builder.setMessage("What is your name ?");
        builder.setCancelable(false);
        builder.setView(edtText);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Hello !" +" " + edtText.getText()+"! how are you ?", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();


    }

}