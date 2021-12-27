import java.io.*;
import java.util.*;
import java.net.URL;

/**
 * @author Ivan Zelenkov
 * HW5 - Heapsort, Bonus 2
 * @param <T> generic type.
 */
public class RadixSort<T> {

    public static void main(String[] args) {
        /* Example of running the runner from static main method without HeapSortTest */
        RadixSort rs = new RadixSort();

        try (FileWriter writer = new FileWriter(rs.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("aaa\nccc\nzzz\nyyy\nrrr\neee\nppp\nooo");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> arrayList = rs.runner();

        StringBuilder sb = new StringBuilder();
        for (String o : arrayList)
            sb.append(o).append("\n");

        System.out.println(sb);
    }

    /**
     * Method reads strings (one per line) in a file and sorts them, using a Comparator class that ignores cases.
     */
    public ArrayList<String> runner() {
        RadixSort<T> rs = new RadixSort<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> sortedArray = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rs.getFile().getPath()))) {
            String line = reader.readLine(); /* read first line of the file and check if it is null */
            while (line != null) { /* read from file until null */
                arrayList.add(line); /* add them to the array list */
                line = reader.readLine(); /* read next line and again check the condition in while-loop, if the string is null */
            }
            sortedArray = radixSort(arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AssertionError e) {
            System.out.print("Strings in an array have different lengths");
        }

        return sortedArray;
    }

    /**
     * Method loads resources from the classpath.
     * @return loaded resources from the classpath.
     */
    private URL getFile() {
        return getClass().getResource("file.txt");
    }

    /**
     * Radix Sorting algorithm to sort ArrayList of Strings or Integers
     * @param array ArrayList of objects.
     * @return ArrayList of sorted objects.
     */
    public <T extends Object> ArrayList<T> radixSort(ArrayList<T> array) throws AssertionError {
        if (array.get(0).getClass().equals(String.class)) { /* if an array's type is String, then the condition is true */
            ArrayList<String> arrayOfStrings = (ArrayList<String>) array;

            for (int i = 1; i < array.size(); i++) {
                if (arrayOfStrings.get(i - 1).length() != arrayOfStrings.get(i).length()) {
                    throw new AssertionError("Error: Strings in an array have different lengths.");
                }
            }

            /* assume that all characters are ASCII, residing in the first 256 positions of the Unicode character set */
            final int BUCKETS = 256;

            int N = arrayOfStrings.size();
            ArrayList<String> buffer = new ArrayList<>(N);

            ArrayList<String> in = arrayOfStrings;
            ArrayList<String> out = buffer;

            /* fill the out array with nulls till N-th position*/
            for (int i = 0; out.size() != N; i++) {
                out.add(null);
            }

            int stringLength = arrayOfStrings.get(0).length();

            // counting sort for each character in the string
            for (int position = stringLength - 1; position >= 0; position--) {
                int[] count = new int[BUCKETS + 1];

                /* count frequencies */
                for (int i = 0; i < N; i++)
                    count[in.get(i).charAt(position) + 1]++;

                /* compute cumulates */
                for (int b = 1; b <= BUCKETS; b++)
                    count[b] += count[b - 1];

                /* move records */
                for (int i = 0; i < N; i++) {
                    out.set(count[in.get(i).charAt(position)]++, in.get(i));
                }

                ArrayList<String> tmp = in;
                in = out;
                out = tmp;
            }

            // if odd number of passes, in is buffer, out is arr; so copy back
            if (stringLength % 2 == 1)
                for (int i = 0; i < arrayOfStrings.size(); i++)
                    out.set(i, in.get(i));
        }
        return array;
    }
}