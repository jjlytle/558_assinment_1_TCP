
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author jeffreylytle
 */
public class Handlers {

    int port;
    private final String charset;
    private final String myURL;

    Handlers(int port, String myURL) {
        this.port = port;
        this.myURL = myURL;
        charset = "UTF-8"; 
    }

    public void httpGet(String key) {

        try {
            String url = "http://" + myURL + ":" + port + "/";
            String getQuery = String.format("%s", URLEncoder.encode(key, charset));
            HttpURLConnection con = (HttpURLConnection) new URL(url + "?" + getQuery).openConnection();
            con.setRequestMethod("GET");
            System.out.println(con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void httpPut(String key, String value) {
        try {
            String putQuery = String.format("%s=%s", URLEncoder.encode(key, charset), URLEncoder.encode(value, charset));
            String url = "http://" + myURL + ":" + port + "/";
            HttpURLConnection con = (HttpURLConnection) new URL(url + "?" + putQuery).openConnection();
            con.setRequestProperty("Accept-Charset", charset);
            con.setRequestMethod("PUT");
            con.setDoInput(true);
            System.out.println(con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    public void httpDel(String key) {
        try {
            String url = "http://" + myURL + ":" + port + "/";
            String delQuery = String.format("%s", URLEncoder.encode(key, charset));
            HttpURLConnection con = (HttpURLConnection) new URL(url + "?" + delQuery).openConnection();
            con.setRequestProperty("Accept-Charset", charset);
            con.setRequestMethod("DELETE");
            System.out.println(con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            con.disconnect();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    public void httpStore() {
        try {
            String url = "http://" + myURL + ":" + port;
            HttpURLConnection con = (HttpURLConnection) new URL(url + "/store").openConnection();
            con.setRequestMethod("GET");
            System.out.println(con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void httpExit() {
        try {
            String url = "http://" + myURL + ":" + port;
            HttpURLConnection con = (HttpURLConnection) new URL(url + "/exit").openConnection();
            con.setRequestMethod("GET");
            System.out.println(con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
