package solid.isp;

class Document {

}

interface Machine
{
    void print(Document d);
    void fax(Document d);
    void scan(Document d) throws Exception;
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fax(Document d) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void scan(Document d) {
        // TODO Auto-generated method stub
        
    }
     
}

class OldFashionedPrinter implements Machine{

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fax(Document d) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void scan(Document d) throws Exception {
        throw new Exception();      
    }

}




// Interface Segregation 
interface Printer {
    void print(Document d);
}

interface Scanner
{
    void scan(Document d);
}

// YAGNI = you ain't gonna need it
// YAGNI <3 ISP
class JustAPrinter implements Printer{

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub
        
    }

}

class PhotoCopier implements Printer, Scanner{

    @Override
    public void scan(Document d) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub
        
    }

}

interface MultiFunctionDevice extends Printer, Scanner {
    void fax(Document d);
}


class MultiFunctionMachine implements MultiFunctionDevice{
    Printer printer;
    Scanner scanner;
    
    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        // delegation to the Printer instance (Decorator pattern)
        printer.print(d);        
    }

    @Override
    public void scan(Document d) {
        // delegation to the Scanner instance (Decorator pattern)
        scanner.scan(d);
    }

    @Override
    public void fax(Document d) {
        // TODO Auto-generated method stub
        
    }
}

public class ISP {
    
}
