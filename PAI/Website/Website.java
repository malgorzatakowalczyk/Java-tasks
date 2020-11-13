import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class Website {

    String website;
    URLConnection connect;
    String text;

    public Website(String website) throws IOException {
        this.website = website;
        URL url = new URL(website);
        connect = url.openConnection();
        readTextFromWebsite();
    }

    private void readTextFromWebsite() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        Vector<String> textLines = new Vector<String>();
        String contentLine;
        while ((contentLine = input.readLine()) != null) {
            textLines.add(contentLine);
        }
        input.close();
        StringBuilder sb = new StringBuilder();
        for (String s : textLines) {
            sb.append(s);
        }
        text = sb.toString();
    }

    public void find(String pattern) {
        Pattern linkPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = linkPattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String match = text.substring(start, end);
            System.out.println(match);
        }
    }

    public void saveConnectionParametsToFile(String fileName) throws IOException {
        PrintWriter write = new PrintWriter(fileName);
        InetAddress ipAddress = InetAddress.getByName(new URL(website).getHost());
        write.println("Ip address: " + ipAddress.getHostAddress());
        write.println("Connect timeout: " + connect.getConnectTimeout());
        write.println("Content Type: " + connect.getContentType());
        write.println("Date: " + connect.getDate());
        write.println("Content encoding: " + connect.getContentEncoding());
        write.println("Content length: " + connect.getContentLength() + "\n");
        write.println(text.substring(text.indexOf("<head>") + 6, text.indexOf("</head>")));
        write.close();
    }

}
