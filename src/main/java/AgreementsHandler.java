import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgreementsHandler {


    public void storeAgreement(Agreement agreement) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(agreement.getName()));
        writer.append(agreement.toString());
        writer.close();
    }
    public Agreement parseAgreement(String fileName) throws FileNotFoundException {
        Agreement agreement = new Agreement();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("Agreement")) {
                agreement.setName(line);
            } else if (line.startsWith("Signed by")) {
                agreement.setSignedBy(line.substring(11, line.length()));

            } else if (line.startsWith("Products")) {
                agreement.setProductList(new ArrayList<>());
            } else {
                Product p = parseProduct(line);
                p.setParent(agreement);
                agreement.getProductList().add(p);
            }
        }
        sc.close();
        return agreement;
    }

    private Product parseProduct(String line) {
        Product p = new Product();
        int index = line.indexOf("Child products");
        if (index == -1) {
            parseProductProperties(p, line);
        } else {
            parseProductProperties(p, line.substring(0, index));
            p.setProductList(new ArrayList<>());
            String childProductsStr = line.substring(index + 15, line.length());
            String[] childProducts = childProductsStr.split(";");
            for (String childProduct : childProducts) {
                Product child = parseProduct(childProduct);
                child.setParent(p);
                p.getProductList().add(child);
            }
        }
        return p;
    }

    private void parseProductProperties(Product p, String propertiesStr) {
        String[] pairs = propertiesStr.split(",");
        for (String pair : pairs) {
            if (pair.trim().length() == 0) {
                continue;
            }
            pair = pair.trim();
            int index = pair.indexOf(":");
            if (index == -1) {
                System.err.println("Wrong format for product properties!");
                continue;
            }
            String propertyName = pair.substring(0, index);
            String propertyValue = pair.substring(index + 1, pair.length()).trim();
            switch (propertyName) {
                case "Name": {
                    p.setName(propertyValue);
                    break;
                }
                case "Price": {
                    try {
                        p.setPrice(Double.parseDouble(propertyValue));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Wrong format for product price!");
                        continue;
                    }
                    break;
                }
            }
        }
    }
}
