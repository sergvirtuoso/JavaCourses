package pattern;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args){
        StrategyClient c2 = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        c2.setStrategy(new BubbleSort());
        c2.executeStrategy(arr0);

        int[] arr1 = {11, 18, 22, 31, 48};
        c2.setStrategy(new InsertingSort());
        c2.executeStrategy(arr1);
    }
}

// Context
class StrategyClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

interface Sorting {
    void sort(int[]arr);
}

// Bubble sorting strategy
class BubbleSort implements Sorting{
    public void sort(int[] arr) {
        System.out.println("Bubble Sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for(int barier = arr.length-1;barier>=0;barier--) {
            for(int i = 0;i<barier;i++) {
                if (arr[i]>arr[i+1]) {
                    int tmp = arr[1];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
            }
        }
    }
        System.out.println("After:\t"+ Arrays.toString(arr));
    }
}
class InsertingSort implements Sorting {
    public void sort (int[] arr) {
        System.out.println("Insert sorting");
        System.out.println("Before:\t"+Arrays.toString(arr));
        for(int barier = 1; barier < arr.length; barier++) {
            int index=barier;
            while (index-1>=0 && arr[index]<arr[index-1]){
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                index--;
            }
        }
    }
}