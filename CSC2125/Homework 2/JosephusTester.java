/* These are the imports if you use JUnit4 */
import static org.junit.Assert.*;
import org.junit.*;

// JUNit 5 imports
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;

// ArrayList and LinkedList
import java.util.ArrayList;

public class JosephusTester {

     @Test
     public void test_0_4() {
         Integer[] answer_0_4 = { 1,2,3,4 };

         ArrayList<Integer> actual = Josephus.solve(0,4);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_4)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_4() {
         Integer[] answer_1_4 = { 2,4,3,1 };

         ArrayList<Integer> actual = Josephus.solve(1,4);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_4)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_4() {
         Integer[] answer_2_4 = { 3,2,4,1 };

         ArrayList<Integer> actual = Josephus.solve(2,4);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_4)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_0_5() {
         Integer[] answer_0_5 = { 1,2,3,4,5 };

         ArrayList<Integer> actual = Josephus.solve(0,5);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_5)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_5() {
         Integer[] answer_1_5 = { 2,4,1,5,3 };

         ArrayList<Integer> actual = Josephus.solve(1,5);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_5)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_5() {
         Integer[] answer_2_5 = { 3,1,5,2,4 };

         ArrayList<Integer> actual = Josephus.solve(2,5);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_5)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_0_6() {
         Integer[] answer_0_6 = { 1,2,3,4,5,6 };

         ArrayList<Integer> actual = Josephus.solve(0,6);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_6)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_6() {
         Integer[] answer_1_6 = { 2,4,6,3,1,5 };

         ArrayList<Integer> actual = Josephus.solve(1,6);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_6)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_6() {
         Integer[] answer_2_6 = { 3,6,4,2,5,1 };

         ArrayList<Integer> actual = Josephus.solve(2,6);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_6)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_0_7() {
         Integer[] answer_0_7 = { 1,2,3,4,5,6,7 };

         ArrayList<Integer> actual = Josephus.solve(0,7);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_7)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_7() {
         Integer[] answer_1_7 = { 2,4,6,1,5,3,7 };

         ArrayList<Integer> actual = Josephus.solve(1,7);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_7)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_7() {
         Integer[] answer_2_7 = { 3,6,2,7,5,1,4 };

         ArrayList<Integer> actual = Josephus.solve(2,7);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_7)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_0_8() {
         Integer[] answer_0_8 = { 1,2,3,4,5,6,7,8 };

         ArrayList<Integer> actual = Josephus.solve(0,8);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_8)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_8() {
         Integer[] answer_1_8 = { 2,4,6,8,3,7,5,1 };

         ArrayList<Integer> actual = Josephus.solve(1,8);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_8)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_8() {
         Integer[] answer_2_8 = { 3,6,1,5,2,8,4,7 };

         ArrayList<Integer> actual = Josephus.solve(2,8);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_8)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_0_9() {
         Integer[] answer_0_9 = { 1,2,3,4,5,6,7,8,9 };

         ArrayList<Integer> actual = Josephus.solve(0,9);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_0_9)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_1_9() {
         Integer[] answer_1_9 = { 2,4,6,8,1,5,9,7,3 };

         ArrayList<Integer> actual = Josephus.solve(1,9);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_1_9)
              expected.add(i);
         assertEquals(actual, expected);
     }

     @Test
     public void test_2_9() {
         Integer[] answer_2_9 = { 3,6,9,4,8,5,2,7,1 };

         ArrayList<Integer> actual = Josephus.solve(2,9);
         ArrayList<Integer> expected = new ArrayList<Integer>();
         for (Integer i : answer_2_9)
              expected.add(i);
         assertEquals(actual, expected);
     }
}
