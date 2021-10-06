package Json;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import mailshamail.ru.R;

public class ReadJson{

    public ReadJson(){}

    public void read(Context context) throws IOException {

    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String text = null;
        while((text = br.readLine())!=null) {
            sb.append(text);
            sb.append("\n");
        }
        return sb.toString();
    }
}
