package practice.design.pattern;

public class SingletonDesignPatternExample {
    private static SingletonDesignPatternExample instance;

    private SingletonDesignPatternExample() {

    }

    public static SingletonDesignPatternExample getInstance() {
        if (instance == null) {
            instance = new SingletonDesignPatternExample();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        SingletonDesignPatternExample instance = SingletonDesignPatternExample.getInstance();
        instance.showMessage();
    }

}
