import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Handler implements URLHandler {

    public String handleRequest(URI url){
        List<String> s = new ArrayList<String>();

        if (url.getPath().equals("/")) {
            for (String r: s) {
                System.out.prinln(r);
            }
        } else if (url.getPath().contains("/add") {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                s.add(parameters[1]);
                return String.format("String \"%s\" added!", parameters[1]);
            }
        }
        else {
            return "404 Not Found!"
        }
    }
}

class SearchEngine {
    public static void main(String args[]) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return; 
        }


        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}


