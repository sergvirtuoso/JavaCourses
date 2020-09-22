package pattern;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompositeApp{
    public static void main(String[] args){
        Shape1 square1 = new Square();
        Shape1 square2 = new Square();
        Shape1 triangle1 = new Triangle();

        Shape1 square3 = new Square();
        Shape1 circle1 = new Circle();
        Shape1 circle2 = new Circle();
        Shape1 circle3 = new Circle();

        Composite1 composit = new Composite1();
        Composite1 composit1 = new Composite1();
        Composite1 composit2 = new Composite1();

        composit1.addComponent1(square1);
        composit1.addComponent1(square2);
        composit1.addComponent1(triangle1);

        composit2.addComponent1(square3);
        composit2.addComponent1(circle1);
        composit2.addComponent1(circle2);

        composit.addComponent1(composit1);
        composit.addComponent1(composit2);

        composit.draw();
    }
}
interface Shape1{
    void draw();
}

class Square implements Shape1{
    public void draw(){
        System.out.println("Квадрат");
    }
}
class Triangle implements Shape1{
    public void draw(){
        System.out.println("Треугольник");
    }
}
class Circle implements Shape1{
    public void draw(){
        System.out.println("Круг");
    }
}

class Composite1 implements Shape1{
    private List<Shape1> components = new ArrayList<>();  // Создает список с элементами интерфейса

    void addComponent1(Shape1 component){

        components.add(component);
    }
    void removeComponent(Shape1 component){

        components.remove(component);
    }
    public void draw() {
        for(Shape1 component: components){
            component.draw();
        }
    }
}