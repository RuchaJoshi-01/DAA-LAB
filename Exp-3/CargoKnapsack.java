import java.util.*;
class Item {
    int weight, value;
    Item(int w, int v) { weight = w; value = v; }
}
public class CargoKnapsack {
    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int capacity = 50;
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        int curW = 0; double totalVal = 0;
        for (Item i : items) {
            if (curW + i.weight <= capacity) { curW += i.weight; totalVal += i.value; }
            else { int rem = capacity - curW; totalVal += i.value * ((double) rem / i.weight); break; }
        }
        System.out.println("Max Cargo Value in Truck: " + totalVal);
    }
}
