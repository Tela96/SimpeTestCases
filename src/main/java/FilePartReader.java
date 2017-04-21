import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilePartReader{
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) throws IllegalArgumentException
    {
        this.filePath = filePath;
        if (toLine < fromLine || fromLine < 1)
        {
            throw new IllegalArgumentException();
        }
        this.fromLine = fromLine -1;
        this.toLine = toLine -1;
    }

    private String read() throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public String readLines() throws IOException
    {
        String result = "";
        String[] splitResult = read().split("\n");
        int lineCouter = fromLine;
        while (lineCouter >= fromLine && lineCouter <= toLine)
        {
            result += splitResult[lineCouter]+"\n";
            lineCouter++;
        }
        return result.trim();

    }

    public static void main(String[] args) throws IOException
    {
        FilePartReader fpr = new FilePartReader("src/main/resources/sampletext", 1,6);
        FileWordAnalyzer anal = new FileWordAnalyzer(fpr);
        System.out.println(anal.wordsByABC());
        System.out.println(anal.wordsContainingSubString(""));
        System.out.println(fpr.readLines());
    }
}