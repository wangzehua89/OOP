public class Main {
    public static void main(String[] args) {

        Appliance washer = new WashingMachine("LG");
        Appliance fridge = new Refrigerator("Panasonic");
        Appliance tv = new Television("Huawei");
        Appliance microwave = new Microwave("Galanz");

        washer.displayBrand();
        washer.turnOn();
        washer.operate();
        washer.turnOff();

        System.out.println();

        fridge.displayBrand();
        fridge.turnOn();
        fridge.operate();
        fridge.turnOff();

        System.out.println();

        tv.displayBrand();
        tv.turnOn();
        tv.operate();
        tv.turnOff();

        System.out.println();

        microwave.displayBrand();
        microwave.turnOn();
        microwave.operate();
        microw
    }
}