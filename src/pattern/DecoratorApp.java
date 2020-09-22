package pattern;

public class DecoratorApp {

    public static void main(String[] args){
       // PrinterInterface printer = new Printer("Hello");
        PrinterInterface printer = new WorldDecorator(new ExclamationPointDecorator(new ExclamationPointDecorator1(new Printer("Hello"))));
        printer.print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;
    public Printer(String value) {this.value = value;}
    public void print() {
        System.out.print(value);
    }
}

class WorldDecorator implements PrinterInterface{
    PrinterInterface component;
    public WorldDecorator(PrinterInterface component) {this.component = component;}
    public void print() {
        component.print();
        System.out.print(" world");
    }
}

class ExclamationPointDecorator implements PrinterInterface{
    PrinterInterface component;
    public ExclamationPointDecorator(PrinterInterface component) {this.component = component;}
    public void print() {
        component.print();
        System.out.print("!");
    }

}
class ExclamationPointDecorator1 implements PrinterInterface{
    PrinterInterface component;
    public ExclamationPointDecorator1(PrinterInterface component) {this.component = component;}
    public void print() {
        component.print();
        System.out.print("!!");
    }

}