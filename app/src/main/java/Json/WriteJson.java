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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import Form.Form;

public class WriteJson {

    public static JsonWriter jsonWriter;

    public WriteJson() {}

    public static void write(Writer writer, Form form) throws IOException {
        jsonWriter = new JsonWriter(writer);
        jsonWriter.beginObject();

        jsonWriter.name("form").value(form.getForm());
        jsonWriter.name("query").value(form.getSerial());

        jsonWriter.name("fields").beginArray();
        for(String s : form.getField()) {
            jsonWriter.value(s);
        }
        jsonWriter.endArray();
    }

    public static JsonWriter getJsonWriter(){
        return jsonWriter;
    }
}
