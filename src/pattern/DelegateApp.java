package pattern;

class DelegateApp{
    public static void main(String[] args){
        A a = new A();
        a.f();

        Painter painter = new Painter();
        painter.setGraphics(new Square1());
        painter.draw();

        painter.setGraphics(new Triangle1());
        painter.draw();
    }
}

class A{
    void f(){
        System.out.println("f()");
    }
}

class B{
    A a = new A();
    void f(){
        a.f();
    }
}

interface Graphics{
    void draw();
}
class Triangle1 implements Graphics{
    public void draw() {
        System.out.println("Draw the Triangle");
    }
}

class Square1 implements Graphics{
    public void draw() {
        System.out.println("Draw the Square");
    }
}

class Circle1 implements Graphics{
    public void draw() {
        System.out.println("Draw the Circle");
    }
}

class Painter{  // Делегирует метод рисования
    Graphics graphics;
    void setGraphics(Graphics g) {  // <-- Мутатор: В качестве аргумента принимает экзмеляр
        graphics = g;
    }
    void draw(){
        graphics.draw();
    }
}