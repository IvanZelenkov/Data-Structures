import java.io.*;
import java.util.*;
import java.net.URL;

/**
 * @author Ivan Zelenkov
 * HW5 - Heapsort, Bonus 1
 * @param <T> generic type.
 */
public class HeapSort<T> {

    public static void main(String[] args) {
        /* Example of running the runner from static main method without HeapSortTest */
        HeapSort hs = new HeapSort();

        try (FileWriter writer = new FileWriter(hs.getClass().getResource("file.txt").getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("Z\nc\nB\na\nH\no\nR\ny");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> arrayList = hs.runner();

        StringBuilder sb = new StringBuilder();
        for (String o : arrayList)
            sb.append(o).append("\n");

        System.out.println(sb);
    }

    /**
     * Method reads strings (one per line) in a file and sorts them, using a Comparator class that ignores cases.
     */
    public ArrayList<String> runner() {
        HeapSort<T> hs = new HeapSort<>();
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(hs.getFile().getPath()))) {
            String line = reader.readLine(); /* read first line of the file and check if it is null */
            while (line != null) { /* read from file until null */
                arrayList.add(line); /* add them to the array list */
                line = reader.readLine(); /* read next line and again check the condition in while-loop, if the string is null */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* the method compareToIgnoreCase of the String class is used */
        Comparator<String> comparator = String::compareToIgnoreCase;

        return heapSort(arrayList, comparator);
    }

    /**
     * Method loads resources from the classpath.
     * @return loaded resources from the classpath.
     */
    private URL getFile() {
        return getClass().getResource("file.txt");
    }

    /**
     * Standard heapsort.
     * @param array ArrayList of objects.
     * @param comparator a comparator object is capable to compare two objects.
     * @return ArrayList of sorted objects.
     */
    private <T extends Object> ArrayList<T> heapSort(ArrayList<T> array, Comparator<T> comparator) {
        for (int i = array.size() / 2 - 1; i >= 0; i--) /* build heap */
            percolateDown(array, i, array.size(), comparator);
        for (int i = array.size() - 1; i > 0; i--) {
            swapReferences(array, 0, i);
            percolateDown(array, 0, i, comparator);
        }
        return array;
    }

    /**
     * Internal method of the heapsort.
     * @param array ArrayList of objects.
     * @param i the position from which to percolate down.
     * @param n the logical size of the binary heap.
     * @param comparator a comparator object is capable to compare two objects.
     */
    private <T extends Object> void percolateDown(ArrayList<T> array, int i, int n, Comparator<T> comparator) {
        int child;
        T tmp;
        for (tmp = array.get(i); leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && comparator.compare(array.get(child), array.get(child + 1)) < 0)
                child++;
            if (comparator.compare(tmp, array.get(child)) < 0)
                array.set(i, array.get(child));
            else
                break;
        }
        array.set(i, tmp);
    }

    /**
     * Internal method of the heapsort.
     * @param i the index of the item in the heap.
     * @return the index of the left child.
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Method to swap the elements in an array list.
     * @param array ArrayList of objects.
     * @param i the index of the first object.
     * @param j the index of the second object.
     */
    private <T extends Object> void swapReferences(ArrayList<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}