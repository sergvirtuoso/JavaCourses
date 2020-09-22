package pattern;

public class IteratorApp {
    public static void main(String[] args){
        ConcreteAggregate c3 = new ConcreteAggregate();

        Iterator it = c3.getIterator();

        while(it.hasNext()) {
            System.out.println((String)it.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate{
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate{
    String[] tasks = {"Построить жену, вырастить пивной пивной живот"};

    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int index = 0;
        public boolean hasNext() {
            if (index< tasks.length) {
                return true;
            }
            else {
                return false;
            }
        }
    public Object next() {
            return tasks[index++];
    }
    }

}
