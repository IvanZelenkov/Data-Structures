/**
 * @author Ivan Zelenkov, ID: 2600950
 * Homework 2
 * @version 1.0
 */

import java.util.ArrayList;

public class Josephus {
    /**
     * Josephus problem solving method
     * @param m number of passes
     * @param n number people
     * @return ArrayList containing elements in liquidated order
     */
    public static ArrayList<Integer> solve(int m, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> order = new ArrayList<>();

        // for loop in short is O(N)
        for (int i = 1; i <= n; i++)
            arr.add(i); // fill the array with each person that represents some number

        int burned = m; // O(1)

        // remove every burned person until the array is empty
        while (!arr.isEmpty()) { // O(N)

            // remove the person holding the burning potato and then add
            // the person to the array 'order' to maintain the liquidation order.
            // removing an element from 'arr' is O(N) and adding it to 'order' is O(1)
            order.add(arr.remove(burned));

            if (arr.size() > 0) // O(1)
                // burned one will grow by m and use a modulus by the size of the array,
                // so the logic of the Josephus problem will work as expected
                burned = (burned + m) % arr.size(); // 1 + 1 + 1 + 1 = O(4)
        }
        return order; // 0
    }

    // As a result, the time complexity is
    // N + 1 + N * (N + 1 + 1 + 4) = N + 1 + N * (N + 6) = N + 1 + N^2 + 6N = N^2 + 7N + 1 = O(N^2)
}