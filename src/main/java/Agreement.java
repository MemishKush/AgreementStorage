import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Agreement {
    public static  final String  DATE_FORMAT =  "dd-MM-yyyy";

    private String name;
    private String signedBy;
    private List<Product> productList;



    public Agreement() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        name = "Agreement " +  sdf.format(new Date());
    }

    public Agreement(String name, String signedBy, List<Product> productList) {
        this.name = name;
        this.signedBy = signedBy;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n").append("Signed by: ").append(signedBy).append("\n")
                .append("Products: \n\t");
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }

    }

