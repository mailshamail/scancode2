package mailshamail.ru;

import Form.Form;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ip, port, time;
    Button next;

    SharedPreferences settings;
    private final String Prefences = "setting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = findViewById(R.id.ip);
        port = findViewById(R.id.port);
        time = findViewById(R.id.time);
        next = findViewById(R.id.button);

        settings = getSharedPreferences(Prefences, Context.MODE_PRIVATE);

        if(!settings.getString("ip","").equals(""))
        {
            startActivity(new Intent(getBaseContext(), Form.class));
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ip.getText().toString().equals("") || port.getText().toString().equals("") || time.getText().toString().equals(""))
                { msg(); }

                final SharedPreferences.Editor editor = settings.edit();

                editor.putString("ip", ip.getText().toString());
                editor.putInt("port", 20);
                editor.putInt("time",20);
                editor.apply();

                startActivity(new Intent(getBaseContext(), Form.class));
            }

        });
    }

    private void msg(){
        Toast.makeText(this, "Есть не заполненые поля", Toast.LENGTH_LONG).show();
    }
}