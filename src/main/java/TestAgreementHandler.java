import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class TestAgreementHandler {
    public static void main(String[] args) throws IOException {
        Agreement a = new Agreement();

        a.setSignedBy("Peter");
        a.setProductList(initAgreementProducts(a));

        AgreementsHandler ah = new AgreementsHandler();
        ah.storeAgreement(a);
        //System.out.println(a);
    }
    public static List<Product> initAgreementProducts(Agreement agreement){
        List<Product> products = new ArrayList<Product>();

        Product pc = new Product();
        pc.setName("HP - Laptop");
        pc.setPrice(2000.00);
        pc.setParent(agreement);
        products.add(pc);
        List<Product> pcChildProducts = new ArrayList<>();
        pcChildProducts.add(initChildProduct(pc,"CD-RW",20.00));
        pcChildProducts.add(initChildProduct(pc,"Ram - 1024",100.00));
        pc.setProductList(pcChildProducts);

        Product printer  = new Product();
        printer.setName("Siemens - Printer");
        printer.setPrice(400.50);
        printer.setParent(agreement);
        products.add(printer);

        Product monitor = new Product();
        monitor.setName("Fujitsu - ProScreen");
        monitor.setPrice(300.00);
        monitor.setParent(agreement);
        products.add(monitor);
        List<Product> monitorChildProducts = new ArrayList<>();
        monitorChildProducts.add(initChildProduct(monitor,"Sony - Headphones",100.00));
        monitor.setProductList(monitorChildProducts);

        return products;
    }
    public static Product initChildProduct (Product product,String name,Double price){
        Product childProduct = new Product();
        childProduct.setParent(product);
        childProduct.setPrice(price);
        childProduct.setName(name);
        return childProduct;
    }
}
