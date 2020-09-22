package pattern;

public class StateApp {
    public static void main(String[] args){
 //       Station st100 = new Pro100Radio();
 //       Radio radio = new Radio();
 //       radio.setStation(st100);

 //       for(int i=0; i<10; i++) {
 //           radio.play();
 //           radio.nextStation();
        Human1 h = new Human1();
        h.setState(new Work());
        for(int i=0; i<10; i++) {
            h.doSomething();
        }
    }
}
// Context
class Human1{
    private Activity state;
    public void setState(Activity s) {this.state = s;}

    public void doSomething() {
        state.doSomething(this);
    }
}

// State
interface Activity {
    void doSomething(Human1 context);
}

class Work implements Activity{
    public void doSomething(Human1 context){
        System.out.println("Working!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity{
    private int count = 0;
    public void doSomething(Human1 context) {
        if(count<3) {
            System.out.println("DayOff");
            count++;
        }
        else{
            context.setState(new Work());
        }
    }
}

// State
interface Station{
    void play();
}

class RadioRocks implements Station {
    public void play() {System.out.println("Radio Rocks");}
}
class Pro100Radio implements Station {
    public void play() {System.out.println("Pro100 Radio");}
}
class KyivFM implements Station {
    public void play() {System.out.println("KyivFM");}
}

// Context
class Radio{
    Station station;
    void setStation(Station St){station = St;}
    void nextStation(){
        if(station instanceof Pro100Radio){
            setStation(new RadioRocks());
        }
        else if (station instanceof RadioRocks){
            setStation(new KyivFM());
        }
        else if (station instanceof KyivFM){
            setStation(new Pro100Radio());
        }
    }
    void play(){
        station.play();
    }

}