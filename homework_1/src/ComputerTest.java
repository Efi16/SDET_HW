interface Connectable {
    void connect();
    void disconnect();
}

interface Upgradable {
    void upgrade(String newVersion);
}

abstract class Computer {
    private String brand;
    private String model;
    private static int computerCount = 0;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
        computerCount++;
    }

    public abstract void displayInfo();

    public static int getComputerCount() {
        return computerCount;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

class Desktop extends Computer implements Connectable, Upgradable {
    private int powerSupply; // Ватт
    private boolean isConnected;

    public Desktop(String brand, String model, int powerSupply) {
        super(brand, model);
        this.powerSupply = powerSupply;
        this.isConnected = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Desktop - Brand: " + getBrand() + ", Model: " + getModel() + ", Power Supply: " + powerSupply + "W");
    }

    @Override
    public void connect() {
        isConnected = true;
        System.out.println(getBrand() + " " + getModel() + " is now connected.");
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println(getBrand() + " " + getModel() + " is now disconnected.");
    }

    @Override
    public void upgrade(String newVersion) {
        System.out.println("Upgrading " + getBrand() + " " + getModel() + " to version " + newVersion);
    }
}

class Laptop extends Computer implements Connectable {
    private int batteryLife; // Время работы в часах
    private boolean isConnected;

    public Laptop(String brand, String model, int batteryLife) {
        super(brand, model);
        this.batteryLife = batteryLife;
        this.isConnected = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Laptop - Brand: " + getBrand() + ", Model: " + getModel() + ", Battery Life: " + batteryLife + " hours");
    }

    @Override
    public void connect() {
        isConnected = true;
        System.out.println(getBrand() + " " + getModel() + " is now connected.");
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println(getBrand() + " " + getModel() + " is now disconnected.");
    }
}

public class ComputerTest {
    public static void main(String[] args) {
        Desktop desktop = new Desktop("Dell", "XPS", 750);
        Laptop laptop = new Laptop("Apple", "MacBook Pro", 10);

        desktop.displayInfo();
        laptop.displayInfo();

        desktop.connect();
        laptop.connect();

        desktop.upgrade("1.1.0");

        System.out.println("Total computers created: " + Computer.getComputerCount());

        desktop.disconnect();
        laptop.disconnect();
    }
}
