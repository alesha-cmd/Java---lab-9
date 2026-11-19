package ocp;

public class SuperVipDiscount implements Discount{
    public double calculate(double price) { return price * 0.2; }
}
