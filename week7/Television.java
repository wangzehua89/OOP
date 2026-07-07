public class Television extends Appliance {

    public Television(String brand) {
        super(brand);
    }

    @Override
    public void operate() {
        System.out.println("Playing TV programs...");
    }
}