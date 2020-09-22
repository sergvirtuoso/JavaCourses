package pattern;

public class BridgeApp {
    public static void main(String[] args){
        Car1 c1 = new Sedan(new Kia());
        Car1 c2 = new Hatchback(new Skoda());
        c1.showDetails();
        c2.showDetails();
    }
}

abstract class Car1{
    Make make;
    public Car1(Make m){
        make = m;
    }
    abstract void showDetails();
}
class Sedan extends Car1{

    public Sedan(Make m) {
        super(m); }
    void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}
class Hatchback extends Car1{
    public Hatchback(Make m) {
        super(m); }
    void showDetails() {
        System.out.println("Hatchback");
        make.setMake();
    }

}

interface Make{
    void setMake();
}
class Skoda implements Make{
    public void setMake() {
        System.out.println("Skoda");
    }
}
class Kia implements Make{
    public void setMake() {
        System.out.println("Kia");
    }
}