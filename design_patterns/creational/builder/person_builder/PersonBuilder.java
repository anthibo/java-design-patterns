package design_patterns.creational.builder.person_builder;

class Person {
    String name;
    String position;

    @Override
    public String toString() {
        return "Person [name=" + name + ", position=" + position + "]";
    }

}
// recursive generics in ts, and java
// recursive fluent api
// recursive generic builder for cross inheritance builder
public class PersonBuilder <SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self(){
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    // 
    @Override
    protected EmployeeBuilder self() {
        return this;
    }
    
}

class Demo {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person ahmed = pb
                .withName("ahmed")
                .worksAt(" software engineer")
                .build();
        System.out.println(ahmed);
    }
}
