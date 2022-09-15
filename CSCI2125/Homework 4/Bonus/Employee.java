/**
 * @author Ivan Zelenkov
 * Homework 4, Bonus
 * I implement this idea by wrapping the universal hashing function logic into a function
 * object called a HashFunction, which can be used to generate this new, stored hash of the Employee. I give the
 * Employee another instance variable which holds one of these HashFunction objects, and use that object to do
 * the work of rehashing.
 */
public class Employee {
    private String name;
    private double salary;
    private int seniority;
    private HashFunction hashFunction;

    /* The "hashcode" field is used to store the hash code of the Employee instance when the hash function
       is calculated for it for the first time or if the internal member "name" has changed. The remembered
       hash value remains valid in each Employee unless the "name" of the employee has been changed
       or it is a newly created Employee object. */
    private int hashCode;

    /**
     * Creates an employee who has a name, salary, and seniority.
     * @param name employee name.
     * @param salary employee salary.
     * @param seniority employee seniority.
     */
    public Employee(String name, double salary, int seniority) {
        /* When an Employee object is created, three characteristics are assigned to it: name, salary, and seniority.
           In addition to it, the created employee will have its own hash code value, which will be calculated in
           the recalculateHashCode() method.
         */
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
        recalculateHashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param rhs the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object rhs) {
        return rhs instanceof Employee && name.equals(((Employee) rhs).name);
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object.
     */
    public int hashCode() {
        return hashCode;
    }

    /**
     * Recalculates the hash code for the object.
     */
    public void recalculateHashCode() {
        /* universalHashing() method returns a hash code for the name of the Employee.
           Then set the returned value in the "hashCode" variable. */
        this.hashCode = hashFunction.universalHashing();
    }

    /**
     * Changes the name of the employee.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        /* recalculate hash code of the given Employee object because the name was changed */
        recalculateHashCode();
    }

    /**
     * Gets the name of the Employee.
     * @return
     */
    public String getName() {
        return name;
    }
}