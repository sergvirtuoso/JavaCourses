package pattern;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class ObserverApp {
    public static void main(String[] args){
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);

    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o: observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather changed. Temperature: " + temp + ", Presser: " + presser + ".");
    }
}

class FileObserver implements Observer{
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("Weather", "_txt");
            PrintWriter pw = new PrintWriter(String.valueOf(f));
            pw.print("Weather changed. Temperature:" + temp + ", Presser: " + presser + ".");
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
