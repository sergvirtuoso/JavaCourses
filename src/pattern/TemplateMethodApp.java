package pattern;

public class TemplateMethodApp {
    public static void main(String[] args){
        C1 a1 = new A1();
        a1.templateMethod();

        System.out.println();

        C1 b1 = new A1();
        b1.templateMethod();
    }
}

abstract class C1{               // Шаблон
    void templateMethod() {
        System.out.println("1");
        differ();                 // Различающийся элемент.
        System.out.println("3");

    }
    abstract void differ();
}

class A1 extends C1{
    void differ(){
        System.out.println("2");
    }
}

class B1 extends C1{
    void differ(){
        System.out.println("4");
    }
}

