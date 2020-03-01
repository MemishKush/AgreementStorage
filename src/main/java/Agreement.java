import java.util.List;

public class Agreement {

    private String name;
    private String signedBy;
    private List<Product> productList;

    public Agreement() {
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
    Agreement agreement = new Agreement("01/03/202","Peter",getProductList());
    public String toString(Object a){
         a = agreement;


        return "name: " + agreement.getName() + "signed By: " + agreement.getSignedBy() + "Products: " + agreement.getProductList();
    }
    public void print(){



    }
}
