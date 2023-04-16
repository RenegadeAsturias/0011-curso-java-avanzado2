package comunicacionEnRedURL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainURLConnectionOutput {

    public static void main(String[] args) {

        try {
            URL miUrl = new URL("https://es.wikipedia.org/");
            URL javaInfoWikipedia = new URL(miUrl, "wiki/Java_(lenguaje_de_programación)");

            HttpURLConnection httpURLConnection = (HttpURLConnection) javaInfoWikipedia.openConnection();

            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            byte[] data = new byte[1024];
            outputStream.write(data);
            outputStream.close();

            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
