import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akos on 2017.04.20..
 */
public class FileWordAnalyzer
{
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader)
    {
        this.reader = reader;
    }
    public List<String> wordsByABC() throws IOException
    {
        String[] splitLines = reader.readLines().split("\n");
        Arrays.sort(splitLines);

        return Arrays.asList(splitLines);
    }
    public ArrayList wordsContainingSubString(String subString) throws IOException
    {
        if (subString.equals("")) return null;
        ArrayList<String> result = new ArrayList<String>();
        for (String word: reader.readLines().split("\n"))
        {
            if (word.contains(subString))
            {
                result.add(word);
            }
        }

        return result;
    }
}
