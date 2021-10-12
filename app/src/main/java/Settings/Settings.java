package Settings;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {

    private String prefences = "s";

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private Context context;

    public Settings(Context context, String prefences){
        settings = context.getSharedPreferences(prefences, 0);
        this.prefences = prefences;
        this.context = context;
        this.editor = settings.edit();
    }

    public String getPrefences(){
        return prefences;
    }

    public void setPrefences(String prefences){
        this.prefences = prefences;
        if(this.context != null){
            settings = this.context.getSharedPreferences(prefences, 0);
        }
    }

    public void putValue(String key, Object value){
        if(value instanceof String) {
            editor.putString(key, String.valueOf(value));
            editor.apply();
        }else if(value instanceof Integer){
            editor.putInt(key, Integer.parseInt(String.valueOf(value)));
            editor.apply();
        }else if(value instanceof Boolean) {
            editor.putBoolean(key, Boolean.parseBoolean(String.valueOf(value)));
            editor.apply();
        }else if(value instanceof Float) {
            editor.putFloat(key, Float.parseFloat(String.valueOf(value)));
            editor.apply();
        }else if(value instanceof Long) {
            editor.putLong(key, Long.parseLong(String.valueOf(value)));
            editor.apply();
        }
    }

    public boolean equal(String key, String value){
        return settings.getString(key, value).equals("");
    }

    public String getStringValue(String key){
        return settings.getString(key, "");
    }

    public int getIntValue(String key){
        return settings.getInt(key, 0);
    }

    public boolean getBooleanValue(String key){
        return settings.getBoolean(key, true);
    }

    public float getFloatValue(String key){
        return settings.getFloat(key, 0);
    }

    public long getLongValue(String key){
        return settings.getLong(key, 0);
    }
}
