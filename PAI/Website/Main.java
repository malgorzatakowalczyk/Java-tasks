public class Main {

    public static void main(String[] args) {
        try {
            Website web = new Website(args[0]);
            String patternEmail="[a-zA-Z0-9._]*@[a-zA-Z]*\\.[a-zA-Z]*";
            String patternLink="((ht|f)tp(s?):|www\\.)(([\\w\\-]+\\.)([\\w\\-.~]+?)*[\\p{Alnum}.,%_=?&#\\-+()\\[\\]$~@!:/{};']*)";
            web.find(patternEmail);
            web.find(patternLink);
            String fileName="header.txt";
            web.saveConnectionParametsToFile(fileName);
        } catch (Exception e) {
            System.out.println("Unexpected error occurred");
        }
    }
}
