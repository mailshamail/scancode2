package Json;

import android.content.Context;
import android.util.JsonWriter;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import Form.Form;

public class WriteJson {

    /*public String result = "[{\"forms\":" +
            "\"formID\"" +
            "{" + "\"query\":" +"{" + "\"serial\"" + "\"fields\":" + "[]" +
            "}" + "}" +"}" +
            "]";*/

    public WriteJson() {}

    public static void jsonObject(Writer writer, Form form) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.beginObject();

        jsonWriter.name("Form").beginArray();
        for(int i = 0; i < form.getForm(); i++) {
            jsonWriter.value(form.getForm());
        }
        jsonWriter.endArray();

        //jsonWriter.name("query").value(form.getSerial());

    }
}
