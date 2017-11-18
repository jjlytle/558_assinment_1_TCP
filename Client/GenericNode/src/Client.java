
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author jeffreylytle
 */

// example call
//java -jar GenericNode.jar tc $server $port put mD7 booLeejae8ne0lahgoos
public class Client {

    public static void main(String[] args) throws IOException {
        
        String connectionProtocol = args[0];
        String ipAddress = args[1];
        int port = parseInt(args[2]);
        String requestMethod = args[3];
        String key = null;
        String value = null;

        
        try
        {
            key = args[4];
            value = args[5];
            
        } catch (Exception e)
        {
            //System.out.println(e.toString());
        }
        Handlers myHandler = new Handlers(port, ipAddress);
        switch(requestMethod)
        {
            case "put": myHandler.httpPut(key, value);
                break;
            case "get": myHandler.httpGet(key); 
                break;
            case "del": myHandler.httpDel(key);
                break;
            case "store": myHandler.httpStore();
                break;
            case "exit": myHandler.httpExit();
                break;      
        }
        
        
        
//        Handlers myHandler = new Handlers(5001, "localhost");
//        myHandler.httpPut("Jeff", "Sarah");
//        myHandler.httpGet("Jeff");
//        Handlers myHandler2 = new Handlers(5001, "127.0.0.1");
//        myHandler2.httpPut("sr0g9u0u9", "vbkjkjrw");
//        myHandler2.httpGet("sr0g9u0u9");
//        myHandler.httpGet("Jeff");
//        myHandler.httpDel("Jeff");
//        myHandler.httpGet("Jeff");
//        myHandler2.httpPut("sr0g9u0u9", "vbkjkjrw");
//        myHandler2.httpPut("sr0gsdgsu0u9", "vbksdgjkjrw");
//        myHandler2.httpPut("sr0gfaa9u0u9", "vbkasfjkjrw");
//        myHandler2.httpPut("sr0g9uasf0u9", "vbsafkjkjrw");
//        myHandler2.httpPut("sr0g9uasf0u9", "vbkjkasfjrw");
//        myHandler2.httpStore();
//        myHandler2.httpGet("sr0g9uasf0u9");
//        myHandler2.httpExit();
    }
        
}
