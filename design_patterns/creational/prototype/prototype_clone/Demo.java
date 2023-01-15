package design_patterns.creational.prototype.prototype_clone;

import java.util.Arrays;

class Address implements Cloneable {
    String streetName;
    int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
    }

    // deep copy using clone
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
    }

    // deep copy using clone
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address) address.clone());
    }

}

public class Demo {
    public static void main(String[] args) throws Exception {
        Person john = new Person(new String[] { "John", "Smith" },
                new Address("ajamy", 124));
        Person jane = (Person) john.clone();
        jane.names[0] = "jane";
        jane.address.houseNumber = 124;
        System.out.println(john);
        System.out.println(jane);
    }
}
