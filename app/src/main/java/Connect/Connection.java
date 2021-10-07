package Connect;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import Json.ReadJson;
import Json.WriteJson;
import mailshamail.ru.R;

public class Connection {

    public String host;
    public int time;


    HttpURLConnection connection;

    boolean isConnection = false;

    public Connection(Context context, String host, int time){
        this.host = host;
        this.time = time;
    }

    public void OpenConnection() throws IOException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    URL url = new URL("http://"+host);
                    connection = (HttpURLConnection) url.openConnection();
                    System.out.println("HOST: " + url.getHost());
                    System.out.println("PORT: " + url.getPort());
                    System.out.println("PROT: " + url.getProtocol());
                    connection.setReadTimeout(10000);
                    connection.setConnectTimeout(15000);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-type", "application/json");
                    connection.connect();

                    //connection.setReadTimeout(time * 120);
                    isConnection = connection.getResponseCode() == HttpURLConnection.HTTP_OK;


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


    }

    public void CloseConnection() throws IOException{
        if (connection != null && connection.getResponseCode() == HttpURLConnection.HTTP_OK){
            connection.disconnect();
        }
    }

    public boolean isConnection() throws IOException {
        return isConnection;
    }
}

