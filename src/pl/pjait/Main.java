package pl.pjait;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        InvoicePosition position = new InvoicePosition(new Product());
        position.getNettoPrice();

        System.out.println("Stawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

        Product product = new Product("12344","Cukier",350.0,0.0);
        Product product2 = new Product("232", "mleko", 10.0, 0.0);
        Product product3 = new Product("234", "kawa", 5.0, 0.0);


        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(new Product("111", "woda", 2.0, 0.0));
        productList.add(new Product("125", "piwo", 3.0, 0.0));


        Cart cart = new Cart();
        cart.setProducts(productList);

        System.out.printf(cart.toString());

        System.out.printf("\nCart after discount: \n");
        ICanCalculateSpecialOffer discount300Plus = new Discount300Plus();
        ICanCalculateSpecialOffer freeCup = new ApplyFreeCup();
        ICanCalculateSpecialOffer thirdForFree = new ApplyDiscountThirdForFree();
        cart.applyDiscount(discount300Plus);
        cart.applyDiscount(thirdForFree);
        cart.applyDiscount(freeCup);

        System.out.println(cart.toString());

        System.out.println("---------------------------");
        System.out.println("Before sorting by price:");
        System.out.println(cart.toString());

        CartService cartService = new CartService();
        cartService.sortProductsByPrice(productList);

        System.out.println("After sorting by price:");
        System.out.println(cart.toString());

        System.out.println("---------------------------");
        System.out.println("Before sorting by name:");
        System.out.println(cart.toString());

        cartService.sortProductsByName(productList);

        System.out.println("After sorting by name:");
        System.out.println(cart.toString());


        int howMany = 3;
        System.out.println(CartService.getnCheapestOne(productList, howMany));
    }
    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOSC\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK");
        System.out.println("**********************************************************************");
        for (InvoicePosition p : invoice.getPositions()){
            System.out.print("|" + p.getProduct().getName() + "|");
            System.out.print(p.getCount() + "\t\t|");
            System.out.print(p.getNettoPrice());
            System.out.print(p.getGrossPrice());
            System.out.print(p.getTax());
            System.out.print(p.getTaxValue());
            System.out.print("*************************************************************************************");
        }
    }
}
