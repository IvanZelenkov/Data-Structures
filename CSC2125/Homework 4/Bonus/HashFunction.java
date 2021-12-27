/**
 * HashFunction class represents an implementation of universal hashing.
 */
public class HashFunction {
    private Employee employee;

    /**
     * Universal hashing.
     * @param x key.
     * @param A value should be in range [1, P-1].
     * @param B value should be in range [0, P-1].
     * @param P prime number.
     * @param M table size.
     * @return a hash code value for the internal member of the object.
     */
    public int uHash(int x, int A, int B, int P, int M) {
        return (int) ((((long) A * x) + B) % P) % M;
    }

    /**
     * Returns a hash code value for the object using universal hashing.
     * @return a hash code value for this object.
     */
    public int universalHashing() {
        int A = 3, B = 7, P = 37, M = 53;
        return uHash(employee.getName().hashCode(), A, B, P, M);
    }
}