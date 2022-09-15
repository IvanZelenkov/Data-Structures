/**
 * @author Ivan Zelenkov
 * Homework 4
 * Rehashing requires recomputing the hash function for all items in the hash table. Since computing the hash
 * function is expensive, suppose objects provide a hash member function of their own, and each object stores
 * the result in an additional data member the first time the hash function is computed for it. I show how such a
 * scheme would apply for the HW4.Employee class below, and explain under what circumstances the remembered
 * hash value remains valid in each HW4.Employee.
 */
public class Employee {
    private String name;
    private double salary;
    private int seniority;

    /* The "hashcode" field is used to store the hash code of the Employee instance when the hash function
       is calculated for it for the first time or if the internal member "name" has changed. The remembered
       hash value remains valid in each Employee unless the "name" of the employee has been changed
       or it is a newly created Employee object.*/
    private int hashCode;

    /**
     * Creates an employee who has a name, salary, and seniority.
     * @param name employee name.
     * @param salary employee salary.
     * @param seniority employee seniority.
     */
    public Employee(String name, double salary, int seniority) {
        /* When an Employee object is created, three characteristics are assigned to it: name, salary, and seniority.
           In addition to them, the created employee will have its own hash code value, which will be calculated in
           the recalculateHashCode() method. */
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
        /* hashCode() method returns a hash code for the name of the Employee.
           Then set the returned value in the "hashCode" variable. */
        this.hashCode = name.hashCode();
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
}