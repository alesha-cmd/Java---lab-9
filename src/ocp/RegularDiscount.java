package ocp;

public class RegularDiscount implements Discount{
    public double calculate(double price) {return price * 0.05;}
}
