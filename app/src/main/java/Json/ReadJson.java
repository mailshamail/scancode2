package Json;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Form.Form;
import mailshamail.ru.R;

public class ReadJson{

    public static int form;
    public static String query;
    public static String[] Field;

    public ReadJson(){}

    public static void read(Context context) throws IOException, JSONException {
        JSONObject jo = new JSONObject(readText(context, R.raw.answers));

        form = jo.getInt("form");
        query = jo.getString("query");

        JSONArray fields = jo.getJSONArray("fields");

         Field = new String[fields.length()];
         for(int i=0;i < fields.length();i++) {
             Field[i] = fields.getString(i);
        }
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String text;
        while((text = br.readLine())!=null) {
            sb.append(text);
            sb.append("\n");
        }
        return sb.toString();
    }
}
