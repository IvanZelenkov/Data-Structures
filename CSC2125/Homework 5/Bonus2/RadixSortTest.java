import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.io.*;
import java.util.ArrayList;

public class RadixSortTest {
    private final RadixSort radixSort = new RadixSort();

    @Test
    public void test01() {
        try (FileWriter writer = new FileWriter(radixSort.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("aaa\nccc\nzzz\nyyy\nrrr\neee\nppp\nooo");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> expected = new ArrayList<>();
        expected.add("aaa");
        expected.add("ccc");
        expected.add("eee");
        expected.add("ooo");
        expected.add("ppp");
        expected.add("rrr");
        expected.add("yyy");
        expected.add("zzz");

        assertEquals(expected, radixSort.runner());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test(expected = AssertionError.class)
    public void testIllegalStateException() {
        try (FileWriter writer = new FileWriter(radixSort.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("a\nccc\nzzz\nyyy\nrrr\neee\nppp\nooo");

        } catch (IOException e) {
            e.printStackTrace();
        }

        exception.expect(AssertionError.class);
        radixSort.runner();
    }
}
