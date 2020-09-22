package pattern;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {
        // Фабричный метод - это медот который возвращает нам конкректный экземпляр конкректного объекта
        WatchMaker maker = getMakerbyName("Digital");
        Watch watch =  maker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerbyName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if(maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Не поддерживаемая линия часов" + maker);
    }
}

interface Watch{        // Марка часов, спеки
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomanWatch implements Watch{
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker{    // Производитель часов
    Watch createWatch();
}
class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch() {

        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker{
    public Watch createWatch() {

        return new RomanWatch();
    }
}