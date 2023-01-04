package design_patterns.creational.builder.faceted_builder;

class Person {
    // address
    String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person [streetAddress=" + streetAddress + ", postcode=" + postcode + ", city=" + city + ", companyName="
                + companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
    }

}

// builder facade
// expose another builders (sub builders)
class PersonBuilder {
    protected Person person = new Person();

    PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }

}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
}

public class Demo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();

        Person p = pb
                .lives()
                .at("628 abo qeer")
                .in("alexandria")
                .withPostcode("1204")
                .works()
                .at("ProCrew")
                .asA("software engineer")
                .earning(4352627)
                .build();

            System.out.println(p);
    }
}
