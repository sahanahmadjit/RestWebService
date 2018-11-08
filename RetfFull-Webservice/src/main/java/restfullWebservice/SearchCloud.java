package restfullWebservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchCloud {
    public static String indexFileLocation = ".." + File.separator + "index";

    //Name of the index file
    public static String indexFileName = "Index.txt";
    private final long id;
    private final String content;

    public SearchCloud(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        String searchResultForClient = "";
        String query = content.toLowerCase();
        String[] subQuery = query.split(" ");



        for(String searchName: subQuery){
            File file = new File(indexFileLocation + File.separator + indexFileName);

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null) {

                    String [] spiltWords =  st.split("\\|.\\|");
                    if(spiltWords[0].equals(searchName)){
                        System.out.println("Match Find on Index File!");
                        System.out.println("Sending following result to the Web:");
                        System.out.println(st);
                        searchResultForClient = st;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return searchResultForClient;

    }
}
