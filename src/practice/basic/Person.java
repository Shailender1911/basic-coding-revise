package practice.basic;

// Class definition for Person
public class Person {
    // Private fields to store the name and age of a person
    private String name;
    private int age;

    // Constructor to initialize the Person object with a name and age
    public Person(String name, int age) {
        this.name = name; // Assign the provided name to the name field
        this.age = age;   // Assign the provided age to the age field
    }

    // Override the equals method to compare two Person objects for equality
    @Override
    public boolean equals(Object obj) {
        // Check if the current object and the passed object are the same instance
        if (this == obj) return true;

        // Check if the passed object is null or not of the same class
        if (obj == null || getClass() != obj.getClass()) return false;

        // Cast the passed object to a Person type
        Person person = (Person) obj;

        // Compare the age and name fields for equality
        return age == person.age && name.equals(person.name);
    }

    // Override the hashCode method to generate a hash code for the Person object
    @Override
    public int hashCode() {
        // Generate a hash code using the name and age fields
        return 31 * name.hashCode() + age;
    }

    // Main method to test the Person class
    public static void main(String[] args) {
        // Create two Person objects with the same name and age
        Person p1 = new Person("Shailender", 30);
        Person p2 = new Person("Shailender", 30);

        // Check if the two Person objects are equal
        System.out.println(p1.equals(p2)); // true, because name and age are the same

        // Check if the hash codes of the two Person objects are equal
        System.out.println(p1.hashCode() == p2.hashCode()); // true, because the hash codes are based on name and age
    }
}