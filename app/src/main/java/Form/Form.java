package Form;

import Json.ReadJson;
import Json.WriteJson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import mailshamail.ru.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;


public class Form extends AppCompatActivity {

    private String ip;
    final String Prefences = "setting";

    private int port, time;
    public int ser;
    public int formID = 1;

    public int[] indextForm = new int[formID];
    public String[] fieldString = new String[8];

    private EditText[] field = new EditText[8];
    public EditText serial;

    SharedPreferences settings;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ConstraintLayout layout = findViewById(R.id.layout);

        getParam();

        EditText form = findViewById(R.id.editTextForm);
        form.setText(String.valueOf(indextForm));

        serial = findViewById(R.id.editTextSerial);
        if (!serial.getText().toString().equals("")){
            ser = Integer.parseInt(serial.getText().toString());
        }else{
            Toast.makeText(this, "Введите серийный номер", Toast.LENGTH_LONG).show();
        }

        int index = 0;
        for(int i = 0; i < 8; i++){
            View view = layout.getChildAt(i);
            if(view  instanceof EditText){
                field[index++] = (EditText) view;
            }
        }

        dialog = new AlertDialog.Builder(this).setMessage("Подождите...").setPositiveButton("Закрыть",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                }).create();


        StringWriter sw = new StringWriter();
        for(int i = 0; i < 8; i++) {
            field[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i3, int i1, int i2) {

                    fillField(fieldString);
                   // dialog.show();

                    //try {
                    //    WriteJson.write(sw,Form.this);
                    //    try {
                    //        ReadJson.read(Form.this);
                    //        System.out.println("Form: " + ReadJson.form + "\n" + "Qwe: " + ReadJson.query + "\n" + "fi:" + String.valueOf(ReadJson.Field));
                    //    } catch (JSONException e) {
                    //        e.printStackTrace();
                    //    }
                    //    System.out.println(sw.toString());
                    //} catch (IOException e) {
                    //    e.printStackTrace();
                    //}

                    if (getCurrentFocus() == field[6]) {

                        field[6].clearFocus();
                        field[7].requestFocus();
                        formID++;
                        form.setText(String.valueOf(formID));

                        for (EditText editText : field) {
                            editText.removeTextChangedListener(this);
                            editText.setText("");
                            editText.addTextChangedListener(this);
                        }

                    }
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i3, int i1, int i2) {}
                @Override
                public void afterTextChanged(Editable editable) {}
            });
        }

        System.out.println("ip: " + ip);
        System.out.println("port " + port);
        System.out.println("time " + time);
    }

    private void getParam(){

        settings = getSharedPreferences(Prefences, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = settings.edit();
        final String ip = settings.getString("ip", "");
        final int port = settings.getInt("port", 20);
        final int time = settings.getInt("time", 20);

        this.ip = ip;
        this.port = port;
        this.time = time;
    }

    private void fillField(String[] s){
        s[7] = String.valueOf(field[7]);
        s[0] = String.valueOf(field[0]);
        s[1] = String.valueOf(field[1]);
        s[2] = String.valueOf(field[2]);
        s[3] = String.valueOf(field[3]);
        s[4] = String.valueOf(field[4]);
        s[5] = String.valueOf(field[5]);
        s[6] = String.valueOf(field[6]);
    }

    public int getSerial() {
        return ser;
    }

    public int getForm() {
        return formID;
    }

    public String[] getField() {
        return fieldString;
    }
}