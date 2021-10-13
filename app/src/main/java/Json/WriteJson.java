package Json;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import Form.Form;
import models.Values;

public class WriteJson {

    public WriteJson() {}

    public static void write(Form form) throws JSONException {
        Values values = new Values();
        JSONObject obj = new JSONObject();

        obj.put("form", values.getFormID());
        obj.put("query", values.getSerial());

        JSONArray field = new JSONArray();
        for(int i = 0; i<8; i++) {
            field.put(Arrays.toString(new String[]{form.getField()[i]}));
            obj.put("fields", field);
        }

        System.out.print(String.valueOf(obj));
    }
}
