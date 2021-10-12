package mailshamail.ru;

import Form.Form;
import Settings.Settings;
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

    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = new Settings(this, "setting");

        ip = findViewById(R.id.ip);
        port = findViewById(R.id.port);
        time = findViewById(R.id.time);
        next = findViewById(R.id.button);

        if(!settings.equal("ip", ""))
        {
            startActivity(new Intent(getBaseContext(), Form.class));
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ip.getText().toString().equals("") || port.getText().toString().equals("") || time.getText().toString().equals(""))
                {msg();}

                settings.putValue("ip", ip.getText().toString());
                settings.putValue("port", Integer.valueOf(String.valueOf(port.getText())));
                settings.putValue("time", Integer.valueOf(String.valueOf(time.getText())));

                startActivity(new Intent(getBaseContext(), Form.class));
            }
        });
    }

    private void msg(){
        Toast.makeText(this, "Есть не заполненые поля", Toast.LENGTH_LONG).show();
    }
}