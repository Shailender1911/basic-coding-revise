package collection.comparator;

import java.util.Arrays;

public class ComparableExamples  implements  Comparable<Car>{

    Car car;
    public static void main(String[] args) {

        Car car1 = new Car("BMW", "Petrol", 5000000);
        Car car2 = new Car("Audi", "Diesel", 6000000);
        Car car3 = new Car("Mercedes", "Petrol", 7000000);
        Car [] cars = new Car[3];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        Arrays.sort(cars);
        System.out.println(cars[0].getName());
    }

    @Override
    public int compareTo(Car o) {
        return this.car.getPrice().compareTo(o.getPrice());
    }
}
