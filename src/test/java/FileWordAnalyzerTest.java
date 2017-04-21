import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FileWordAnalyzerTest
{

    private List<String> expectedlist;
    private FileWordAnalyzer fwa = new FileWordAnalyzer(new FilePartReader("src/test/resources/testtext", 1,6));

    private void createExpetedOrderedResults()
    {
        String[] results = new String[6];
        results[0] = "alma";
        results[1] = "ba rack";
        results[2] = "cek la";
        results[3] = "dio";
        results[4] = "fuge";
        results[5] = "kolbasz";
        expectedlist = Arrays.asList(results);
    }

    @Test
    public void testSortedArray() throws Exception
    {
        createExpetedOrderedResults();
        List<String> results = fwa.wordsByABC();
        assertEquals(expectedlist, results);
    }

    @Test
    public void testSubStringForSpaces() throws Exception
    {
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("ba rack", "cek la"));
        assertEquals(expected, fwa.wordsContainingSubString(" "));
    }

    @Test
    public void testSubStringForEmptyString() throws Exception
    {
        assertEquals(null, fwa.wordsContainingSubString(""));
    }
}
