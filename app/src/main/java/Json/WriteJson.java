package Json;

import android.content.Context;
import android.util.JsonWriter;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import Form.Form;

public class WriteJson {

    /*public String result = "[{\"forms\":" +
            "\"formID\"" +
            "{" + "\"query\":" +"{" + "\"serial\"" + "\"fields\":" + "[]" +
            "}" + "}" +"}" +
            "]";*/

    public WriteJson() {}

    public static void wr(Writer writer, int formID, String serial, String fields, Context context) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.beginObject();

        jsonWriter.name("Form").beginArray();
        for(int i=0; i<formID; i++){
            jsonWriter.value(String.valueOf(formID));
        }
        jsonWriter.endArray();
        jsonWriter.name("query").value(serial);

    }
}
