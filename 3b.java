class PiContainer {
    private double piValue; // Private variable

    protected void computePi() {
        this.piValue = Math.PI; // Computes and assigns value internally
    }

    public double getPiValue() { // Public getter access
        if (piValue == 0) {
            computePi();
        }
        return piValue;
    }
}

public class PiDemo {
    public static void main(String[] args) {
        PiContainer piObj = new PiContainer();
        System.out.println("Value of Pi: " + piObj.getPiValue());
    }
}
