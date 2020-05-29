package UniqueNamesCounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KeyValuesParser {
    public static HashMap<String, HashSet<String>> names = new HashMap<String, HashSet<String>>();
    public static HashMap<String, HashSet<String>> Parse(String path) { //Parsing the nickname file to HashMap<String,HashSet<string>>
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = input.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String key = st.nextToken();
                HashSet<String> values = new HashSet<String>();
                while (st.hasMoreElements())
                    values.add(st.nextToken());
                names.put(key, values);
            }
        } catch (IOException ex) { }
        return names;
    }
}
