import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.*;

/**
 * Created by akos on 2017.04.20..
 */
public class FilePartReaderTest
{
    private String wholeFileContent = "testing\n" +
            "testing2\n" +
            "testing3\n" +
            "testing4\n" +
            "testing5\n" +
            "someothertext";
    private String partialFileContent = "testing4\n" +
            "testing5\n" +
            "someothertext";

    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalArgumentException() throws Exception
    {
        FilePartReader filePartReader = new FilePartReader("src/main/resources/sampletext", 2,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalArgumentException2() throws Exception
    {
        FilePartReader filePartReader = new FilePartReader("src/main/resources/sampletext", 0,4);
    }

    @Test(expected = NoSuchFileException.class)
    public void testFileNotFound() throws Exception
    {
        FilePartReader filePartReader = new FilePartReader("nonexistant", 1, 2);
        filePartReader.readLines();
    }

    @Test
    public void testWholeFileContent() throws Exception
    {
        FilePartReader filePartReader = new FilePartReader("src/main/resources/sampletext", 1,6);
        assertEquals(wholeFileContent, filePartReader.readLines());
    }

    @Test
    public void testPartialFileContent() throws Exception
    {
        FilePartReader filePartReader = new FilePartReader("src/main/resources/sampletext", 4,6);
        assertEquals(partialFileContent, filePartReader.readLines());
    }

}