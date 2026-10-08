import java.util.ArrayList;
import java.util.List;

// Generic Class with Bounded Type Parameter (accepts Number and its subclasses)
class DataContainer<T extends Number> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    // Generic Method to calculate total sum of elements
    public double calculateSum() {
        double sum = 0.0;
        for (T item : items) {
            sum += item.doubleValue();
        }
        return sum;
    }

    public void displayAll() {
        System.out.println("Container Contents: " + items);
    }
}

public class GenericDemo {
    // Generic Utility Method with Wildcards
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Integer Container
        DataContainer<Integer> intContainer = new DataContainer<>();
        intContainer.add(10);
        intContainer.add(20);
        intContainer.add(30);
        intContainer.displayAll();
        System.out.println("Integer Sum: " + intContainer.calculateSum());

        // Double Container
        DataContainer<Double> doubleContainer = new DataContainer<>();
        doubleContainer.add(10.5);
        doubleContainer.add(20.3);
        doubleContainer.displayAll();
        System.out.println("Double Sum: " + doubleContainer.calculateSum());
    }
}
