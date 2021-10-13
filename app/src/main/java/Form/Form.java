package Form;


import Json.WriteJson;
import Settings.Settings;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import mailshamail.ru.R;
import models.Values;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.net.Socket;

public class Form extends AppCompatActivity {

    private Values values;

    public String[] fieldString = new String[8];

    private EditText[] field = new EditText[8];
    public EditText serial;

    private AlertDialog dialog;
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ConstraintLayout layout = findViewById(R.id.layout);

        settings = new Settings(this, "setting");
        values = new Values();

        getParam();

        EditText form = findViewById(R.id.editTextForm);
        form.setText(String.valueOf(values.getFormID()));

        serial = findViewById(R.id.editTextSerial);
        if (!serial.getText().toString().equals("")){
            values.setSerial(Integer.parseInt(serial.getText().toString()));
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

        for(int i = 0; i < 8; i++) {
            field[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i3, int i1, int i2) {

                   Thread thread = new Thread() {
                         public void run() {
                             try {
                                 Socket socket = new Socket(values.getIp(), values.getPort());

                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                         }
                     };
                     thread.start();

                    fillField(fieldString);
                    dialog.show();

                    try {
                        WriteJson.write(Form.this);

                       // try {
                       //     ReadJson.read(Form.this);
                       //     System.out.println("Form: " + ReadJson.form + "\n" + "Qwe: " + ReadJson.query + "\n" + "fi:" + Arrays.toString(ReadJson.Field));
                       // } catch (JSONException | IOException e) {
                       //     e.printStackTrace();
                       // }
                       // System.out.println(sw.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (getCurrentFocus() == field[6]) {

                        field[6].clearFocus();
                        field[7].requestFocus();
                        form.setText(String.valueOf(values.getNextFormID()));

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

        System.out.println("ip: " + values.getIp());
        System.out.println("port " + values.getPort());
        System.out.println("time " +  values.getTime());
    }

    private void getParam(){
        values.setIp(settings.getStringValue("ip"));
        values.setPort(settings.getIntValue("port"));
        values.setTime(settings.getIntValue("time"));
    }

    private void fillField(String[] s){
        s[7] = field[7].getText().toString();
        s[0] = field[0].getText().toString();
        s[1] = field[1].getText().toString();
        s[2] = field[2].getText().toString();
        s[3] = field[3].getText().toString();
        s[4] = field[4].getText().toString();
        s[5] = field[5].getText().toString();
        s[6] = field[6].getText().toString();
    }

    public String[] getField() {
        return fieldString;
    }

}