import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Handler implements URLHandler {
    ArrayList<String> s = new ArrayList<String>();

    public String handleRequest(URI url){
        if (url.getPath().equals("/")) {
            return String.format("Welcome");
        } 
        else if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                s.add(parameters[1]);
                return String.format("\"%s\" added!", parameters[1]);
            } 
        }
        else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                return findMatch(s, parameters[1]);
            }
        }  
        return "404 Not Found!";
    }

    public String findMatch(ArrayList<String> in, String match) {
        ArrayList<String> r = new ArrayList<String>();
        for (String s: in) {
            if (s.contains(match)) {
                r.add(s);
            }
        }
        return(r.toString());
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
