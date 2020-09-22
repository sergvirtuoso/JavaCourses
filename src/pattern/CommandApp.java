package pattern;

public class CommandApp{
    public static void main(String[] args){

        Computer1 computer1 = new Computer1();
        User u = new User(new StartCommand(computer1), new StopCommand(computer1), new ResetCommand(computer1));
        u.startPC();
        u.stopPC();
        u.resetPC();
    }

}

interface Command{
    void execute();
}
// Reciver
class Computer1 {
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}
// Commands
class StartCommand extends Computer1 {
    Computer1 computer1;
    public StartCommand(Computer1 computer1) {
        this.computer1 = computer1;}
    public void execute(){
        computer1.start();
    }
}

class StopCommand extends Computer1 {
    Computer1 computer1;
    public StopCommand(Computer1 computer1) {
        this.computer1 = computer1;}
    public void execute(){
        computer1.stop();
    }
}

class ResetCommand extends Computer1 {
    Computer1 computer1;
    public ResetCommand(Computer1 computer1) {
        this.computer1 = computer1;}
    public void execute(){
        computer1.reset();
    }
}
//Invoker
class User{
    Command start;
    Command stop;
    Command reset;
    public User(StartCommand start, StopCommand stop, ResetCommand reset) {
        this.start = (Command) start;
        this.stop = (Command) stop;
        this.reset = (Command) reset;
    }

    void startPC(){
        start.execute();

    }
    void stopPC(){
        stop.execute();
    }
    void resetPC(){
        reset.execute();
    }

}