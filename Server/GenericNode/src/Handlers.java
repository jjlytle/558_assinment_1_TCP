
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handlers {

    public void Handlers() {

    }

    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            String requestMethod = he.getRequestMethod();
            String response = "Port: " + Server.port + " Action: " + requestMethod + " ";
            if (requestMethod.equals("PUT")) {
                URI requestedUri = he.getRequestURI();
                String query = requestedUri.getRawQuery();
                String queryKey = parsePutQuery(query);
                if (queryKey != null) {
                    response += queryKey + "=" + Server.myHash.get(queryKey) + "\n";
                }
            } else if (requestMethod.equals("GET")) {
                URI requestedUri = he.getRequestURI();
                String query = requestedUri.getRawQuery();
                String queryKey = parseGetQuery(query);
                if (queryKey != null) {
                    response += queryKey + "=" + Server.myHash.get(queryKey) + "\n";
                }
            } else if (requestMethod.equals("DELETE")){
                URI requestedUri = he.getRequestURI();
                String query = requestedUri.getRawQuery();
                String queryKey = parseDelQuery(query);
                if (queryKey != null) {
                    response += queryKey + "=" + Server.myHash.get(queryKey) + "\n";
                }
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    public static class StoreHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            String requestMethod = he.getRequestMethod();
            String response = "Port: " + Server.port + " Action: " + requestMethod + " ";
            if (requestMethod.equals("GET")) {
            
            //URI requestedUri = he.getRequestURI();
            // send response

            for (String key : Server.myHash.keySet())
            {
                response += key + "=" + Server.myHash.get(key) + " \n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
            }

        }
    }
    
    
    static class ExitHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            String requestMethod = he.getRequestMethod();
            String response = "Port: " + Server.port + " Action: " + requestMethod + " ";
            if (requestMethod.equals("GET")) {
            response += " Sever stop.. ";
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
            }
            Server.httpServer.Stop();
        }
    }

    @SuppressWarnings("unchecked")
    public static String parsePutQuery(String query) throws UnsupportedEncodingException {

        String key = null;
        String value = null;
        if (query != null) {

            String param[] = query.split("[=]");

            if (param.length > 0) {
                key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
            }

            if (param.length > 1) {
                value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
            }

            if (key != null) {
                Server.myHash.put(key, value);
            }

        }
        return key;
    }
    
        @SuppressWarnings("unchecked")
    public static String parseGetQuery(String query) throws UnsupportedEncodingException {

        String key = null;
        if (query != null) 
        {
            key = URLDecoder.decode(query, System.getProperty("file.encoding"));
        }
        return key;
    }
    
    @SuppressWarnings("unchecked")
    public static String parseDelQuery(String query) throws UnsupportedEncodingException {

        String key = null;
        if (query != null) 
        {
            key = URLDecoder.decode(query, System.getProperty("file.encoding"));
        }
        Server.myHash.remove(key);
        return key;
    }

}
