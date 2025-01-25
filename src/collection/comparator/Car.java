package collection.comparator;

import lombok.Data;

import java.util.Arrays;
@Data
public class Car  implements  Comparable<Car>{

    private  String name;
    private String fuelType;
    private  Integer price;

    public Car(String name, String fuelType, Integer price) {
        this.name = name;
        this.fuelType = fuelType;
        this.price = price;
    }

    public static void main(String[] args) {

        Car car1 = new Car("BMW", "Petrol", 5000000);
        Car car2 = new Car("Audi", "Diesel", 6000000);
        Car car3 = new Car("Mercedes", "Petrol", 7000000);
        Car [] cars = new Car[3];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
//        Arrays.sort(cars, (c1, c2) -> c2.price - c1.price);
        System.out.println(cars[0].name);


    }

    @Override
    public int compareTo(Car o) {
        return this.price.compareTo(o.price);
    }


    //Comparable vs Comparator - when to use which
    /*

    Use `Comparable` when you want to define a natural ordering for the objects of a class. This is done by implementing the `Comparable` interface and overriding the `compareTo` method. This approach is suitable when the class has a single, natural way of ordering its instances.

Example:
```java
public class Car implements Comparable<Car> {
    private String name;
    private String fuelType;
    private Integer price;

    public Car(String name, String fuelType, Integer price) {
        this.name = name;
        this.fuelType = fuelType;
        this.price = price;
    }

    @Override
    public int compareTo(Car o) {
        return this.price.compareTo(o.price);
    }
}
```

Use `Comparator` when you want to define multiple ways of ordering objects, or when you want to define an ordering for a class that does not have a natural ordering. This is done by creating a class that implements the `Comparator` interface and overriding the `compare` method.

Example:
```java
import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getPrice().compareTo(c2.getPrice());
    }
}
```

You can then use the `Comparator` to sort a collection of `Car` objects:
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "Petrol", 5000000);
        Car car2 = new Car("Audi", "Diesel", 6000000);
        Car car3 = new Car("Mercedes", "Petrol", 7000000);
        Car[] cars = new Car[]{car1, car2, car3};

        Arrays.sort(cars, new CarPriceComparator());
        System.out.println(cars[0].getName());
    }
}
```
     */
}
