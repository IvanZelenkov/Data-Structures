import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.ArrayList;

public class HeapSortTest {
    private final HeapSort heapSort = new HeapSort();

    @Test
    public void test01() {
        try (FileWriter writer = new FileWriter(heapSort.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("Java\njava\nPython\nC\npHp\nKotlin\nRuby");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> expected = new ArrayList<>();
        expected.add("C");
        expected.add("java");
        expected.add("Java");
        expected.add("Kotlin");
        expected.add("pHp");
        expected.add("Python");
        expected.add("Ruby");

        assertEquals(expected, heapSort.runner());
    }

    @Test
    public void test02() {
        try (FileWriter writer = new FileWriter(heapSort.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("Z\nc\nB\na\nH\no\nR\ny");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("B");
        expected.add("c");
        expected.add("H");
        expected.add("o");
        expected.add("R");
        expected.add("y");
        expected.add("Z");

        assertEquals(expected, heapSort.runner());
    }
}
