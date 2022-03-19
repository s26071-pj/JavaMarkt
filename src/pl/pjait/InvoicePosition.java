package pl.pjait;

import javax.sound.sampled.Port;

public class InvoicePosition {

    public InvoicePosition(Product product){
        this.product = product;
        this.count = 1;
    }
    public static final double TAX_5 = 0.05;
    public static final double TAX_8 = 0.08;
    public static final double TAX_23 = 0.05;

    private Product product;
    private int count;
    private double tax = TAX_23;


    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count= count;
    }
    public double getTax(){
        return tax;
    }
    public void setTax(double tax){
        this.tax =tax;
    }

    public double getNettoPrice(){
        return product.getPrice() * count;
    }

    public double getGrossPrice(){
        return getGrossPrice() * (1+ tax);
    }

    public double getTaxValue(){
        return getGrossPrice() - getNettoPrice();
    }

    public void add(InvoicePosition position) {
    }
}
