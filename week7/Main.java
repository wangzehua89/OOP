public class Main {
    public static void main(String[] args) {

        Appliance washer = new WashingMachine("LG");
        Appliance fridge = new Refrigerator("Panasonic");
        
        washer.displayBrand();
        washer.turnOn();
        washer.operate();
        washer.turnOff();

        System.out.println();

        fridge.displayBrand();
        fridge.turnOn();
        fridge.operate();
        fridge.turnOff();
    }
}