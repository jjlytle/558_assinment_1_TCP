
import static java.lang.Integer.parseInt;
import java.util.HashMap;

/**
 *
 * @author jeffreylytle
 */
public class Server {
    public static int port;
    public static HashMap<String, String> myHash = new HashMap<String, String>() {};
    public static SimpleHttpServer httpServer;
    public static void main(String[] args) {
        Server.port = parseInt(args[1]);
        httpServer = new SimpleHttpServer();
	httpServer.Start(port);      
    }
    
}
