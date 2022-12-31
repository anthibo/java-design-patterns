package solid.srp;

public class Demo {
    public static void main(String[] args) throws Exception {
        Journal journal = new Journal();
        journal.addEntry("I started learning design patterns in java today");
        journal.addEntry("I visited my aunt");
        journal.addEntry("I played volleyball");
        System.out.println(journal.toString());

        Persistence persistence = new Persistence();
        String filename = "files/journal.txt";
        persistence.saveToFile(journal, filename, true);
    }
}
