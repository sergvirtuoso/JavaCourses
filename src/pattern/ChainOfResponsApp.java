package pattern;

public class ChainOfResponsApp{
    public static void main(String[] args){
        Logger logger0 = new SMSLogger(level.ERROR);
        Logger logger1 = new FileLogger(level.DEBUG);
        Logger logger2 = new EmailLogger(level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);
        logger0.writeMessage("All is OK!", level.INFO);
        logger0.writeMessage("Debug is now", level.DEBUG);
        logger0.writeMessage("System error", level.ERROR);
    }
}

class level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
abstract class Logger{
    int priority;
    public Logger(int priority) { this.priority = priority; }
    Logger next;
    public void setNext(Logger next) { this.next = next; }
    public void writeMessage(String message, int level) {
        if(level<=priority){
            write(message);
        }
        if(next!=null){
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}

class SMSLogger extends Logger{
    public SMSLogger(int priority){
        super(priority);}
    public void write(String message){
        System.out.println("SMS: " + message);}
}

class FileLogger extends Logger{
    public FileLogger(int priority){
        super(priority);}
    public void write(String message){System.out.println("Installing files: " + message);}
}

class EmailLogger extends Logger{
    public EmailLogger(int priority){
        super(priority);}
    public void write(String message){System.out.println("Email message: " + message);}
}

