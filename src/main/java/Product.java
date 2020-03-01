import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class Product {
    private Object parent;
    private List<Product> productList;
    private String name;
    private Double price;

    public Product() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", ").append("Price: ").append(price);
        if (productList != null) {
            sb.append(", Child products: ");
            for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
                sb.append(iterator.next());
                if (iterator.hasNext()) {
                    sb.append("; ");
                }
            }
        }
        if (parent instanceof Agreement) {
            sb.append("\n");
        }
        return sb.toString();
    }
}
