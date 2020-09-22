package pattern;

class BuilderApp{
    public static void main(String[] args){
        Car car = new CarBuilder()
                    .buildMake("Mercedes")
                    .buildTransmission(Transmission.AUTO)
                    .buildmaxSpeed(250)
                    .build();
    }
}

enum Transmission{
    MANUAL, AUTO
}
class Car{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {this.make = make;}
    public void setTransmission(Transmission transmission) {this.transmission = transmission;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    public String toString() {
        return "Car [make=" + make + ", transmission = " + transmission + ", maxspeed" + maxSpeed + "]";
    }
}

class CarBuilder{     //Строитель "машины" который принимает атрибуты.
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s = 120;
    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }
    CarBuilder buildmaxSpeed(int s){
        this.s = s;
        return this;
    }
    Car build(){                 // Метод класса Car который будет возвращать построенную машину с указанным набором свойств.
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }

}