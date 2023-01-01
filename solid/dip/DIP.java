package solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser
{
    List<Person> findAllChildrenOf(String name);
}

// low level module
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<Triplet<Person, Relationship, Person>>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<Person, Relationship, Person>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<Person, Relationship, Person>(child, Relationship.CHILD, parent));

    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
        .filter(x -> Objects.equals(x.getFirst().name, name)
                && x.getSecond() == Relationship.PARENT)
        .map(Triplet::getThird)
        .collect(Collectors.toList());
    }
}

// high-level module
class Research {

    // depends on implementation details => breaks DIP

    public Research(Relationships relationships)
    {
      // high-level: find all of john's children
      List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
      relations.stream()
        .filter(x -> x.getFirst().name.equals("John")
                && x.getSecond() == Relationship.PARENT)
        .forEach(ch -> System.out.println("John has a child called " + ch.getThird().name));
    }
  
    // depends on abstractions => satisfies DIP
    public Research(RelationshipBrowser browser)
    {
      List<Person> children = browser.findAllChildrenOf("John");
      for (Person child : children)
        System.out.println("John has a child called " + child.name);
    }
}

// Dependency Inversion
public class DIP {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Adam");
        Person child2 = new Person("Joseph");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);

    }
}
