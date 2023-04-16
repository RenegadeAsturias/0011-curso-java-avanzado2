package comunicacionEnRedURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainURL {

    public static void main(String[] args) {

        try {
            URL miUrl = new URL("https://es.wikipedia.org/");
            URL javaInfoWikipedia = new URL(miUrl, "wiki/Java_(lenguaje_de_programación)");

            URL miUrl2 = new URL("https", "es.wikipedia.org", 80, "wiki/Java_(lenguaje_de_programación)");

            miUrl.getProtocol(); miUrl.getAuthority(); miUrl.getHost(); miUrl.getPort();
            miUrl.getPath(); miUrl.getQuery(); miUrl.getFile(); miUrl.getRef();

            // BufferedReader in = new BufferedReader(new InputStreamReader(miUrl.openStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(javaInfoWikipedia.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
