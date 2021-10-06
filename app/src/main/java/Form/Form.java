package Form;

import Json.ReadJson;
import Json.WriteJson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import mailshamail.ru.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;


public class Form extends AppCompatActivity {

    private String ip;
    final String Prefences = "setting";

    private int port, time;
    public int indextForm = 1;
    public int ser = 0;

    private EditText[] field = new EditText[8];

    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ConstraintLayout layout = findViewById(R.id.layout);

        getParam();

        EditText form = findViewById(R.id.editTextForm);
        form.setText(String.valueOf(indextForm));

        EditText serial = findViewById(R.id.editTextSerial);
        ser = Integer.parseInt(serial.getText().toString());

        int index = 0;
        for(int i = 0; i < 8; i++){
            View view = layout.getChildAt(i);
            if(view  instanceof EditText){
                field[index++] = (EditText) view;
            }
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
}