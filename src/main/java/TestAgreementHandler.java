import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class TestAgreementHandler {
    public static Product initChildProduct(Product product, String name, Double price) {
        Product childProduct = new Product();
        childProduct.setParent(product);
        childProduct.setPrice(price);
        childProduct.setName(name);
        return childProduct;
    }

    public static List<Product> initAgreementProducts(Agreement agreement) {
        List<Product> products = new ArrayList<Product>();

        Product pc = new Product();
        pc.setName("HP");
        pc.setPrice(2000.00);
        pc.setParent(agreement);
        products.add(pc);
        List<Product> pcChildProducts = new ArrayList<>();
        pcChildProducts.add(initChildProduct(pc, "CD-RW", 20.00));
        pcChildProducts.add(initChildProduct(pc, "Ram - 1024", 100.00));
        pc.setProductList(pcChildProducts);

        Product printer = new Product();
        printer.setName("Siemens");
        printer.setPrice(400.50);
        printer.setParent(agreement);
        products.add(printer);

        return products;
    }

    private static Agreement initAgreement(String signedBy) {
        Agreement a = new Agreement();
        a.setSignedBy(signedBy);
        a.setProductList(initAgreementProducts(a));
        return a;
    }

    private static void testStoreAgreement(AgreementsHandler ah, Agreement a) {
        try {
            ah.storeAgreement(a);
        } catch (IOException e) {
            System.err.println("TestAgreementHandler.testStoreAgreement: Could not store agreement to file!");
            e.printStackTrace();
        }
    }

    private static void testParseAgreement(AgreementsHandler ah, String fileName) {
        try {
            Agreement a = ah.parseAgreement(fileName);
            System.out.println(a);
        } catch (FileNotFoundException e) {
            System.err.println("TestAgreementHandler.testParseAgreement: Could not find agreement file!");
            e.printStackTrace();
        }
    }

    private static String getCurrentDateAgreementFile() {
        SimpleDateFormat sdf = new SimpleDateFormat(Agreement.DATE_FORMAT);
        return "Agreement " + sdf.format(new Date());
    }

    public static void main(String[] args) {
        AgreementsHandler ah = new AgreementsHandler();
        testStoreAgreement(ah, initAgreement("Peter"));
        testParseAgreement(ah, getCurrentDateAgreementFile());
    }
}
