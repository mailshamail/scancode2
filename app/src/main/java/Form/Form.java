package Form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import mailshamail.ru.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Form extends AppCompatActivity {

    private String ip;
    final String Prefences = "setting";

    private int port, time;
    public int indextForm = 1;



    private EditText[] field = new EditText[8];
    private EditText form, serial;

    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ConstraintLayout layout = findViewById(R.id.layout);

        getParam();

        form = findViewById(R.id.editTextForm);
        form.setText(String.valueOf(indextForm));

        serial = findViewById(R.id.editTextSerial);


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