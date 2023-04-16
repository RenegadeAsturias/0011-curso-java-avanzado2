package comunicacionEnRedURL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainURLConnection {

    public static void main(String[] args) {

        try {
            URL miUrl = new URL("https://es.wikipedia.org/");
            URL javaInfoWikipedia = new URL(miUrl, "wiki/Java_(lenguaje_de_programación)");

            HttpURLConnection httpURLConnection = (HttpURLConnection) javaInfoWikipedia.openConnection();
            httpURLConnection.connect();

            httpURLConnection.getHeaderFields();
            httpURLConnection.getHeaderField(2);
            httpURLConnection.getContentEncoding();
            httpURLConnection.getContentLength();
            httpURLConnection.getDate();
            httpURLConnection.getExpiration();
            httpURLConnection.getLastModified();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
