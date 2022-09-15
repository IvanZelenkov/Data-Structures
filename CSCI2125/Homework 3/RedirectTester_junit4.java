import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;

public class RedirectTester_junit4 {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
	private final BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    private final String lineseparator = System.getProperty("line.separator");

	@Before
	public void setup() {
		bst.insert(10);
		bst.insert(8);
		bst.insert(6);
		bst.insert(4);
		bst.insert(2);
		bst.insert(7);
		bst.insert(14);
		bst.insert(16);
		bst.insert(13);
		bst.insert(12);
		bst.insert(11);
		System.setOut(new PrintStream(output));
		System.setErr(new PrintStream(errorOutput));
	} // end @Before method

	@Test
	public void testFromLeftRight() {
		int k1 = 2, k2 = 14;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("2 4 6 7 8 10 11 12 13 14 ", output.toString());
	}

	@Test
	public void testFromLeftRight2() {
		int k1 = 8, k2 = 12;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("8 10 11 12 ", output.toString());
	}

	@Test
	public void testFromLeftRight3() {
		int k1 = 7, k2 = 13;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("7 8 10 11 12 13 ", output.toString());
	}

	@Test
	public void testWithNonexistentValues() {
		int k1 = -12, k2 = -13;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("", output.toString());
	}

	@Test
	public void testLeftSideValuesOnly() {
		int k1 = 2, k2 = 8;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("2 4 6 7 8 ", output.toString());
	}

	@Test
	public void testRightSideValuesOnly() {
		int k1 = 10, k2 = 14;
		bst.inclusivePrintValuesBetween(k1, k2);
		assertEquals("10 11 12 13 14 ", output.toString());
	}

	@After
	public void resetStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	} // end @After method

} // end class RedirectTester