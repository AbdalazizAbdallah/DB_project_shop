package model;

public class Product {

    private String departmentID;

    private String IDProduct;
    private String productName;
    private double price;
    private int quanity;
    private String description;

    public Product(String productName, double price, int quanity, String description) {
        this.productName = productName;
        this.price = price;
        this.quanity = quanity;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return productName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(String IDProduct) {
        this.IDProduct = IDProduct;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        Product product = new Product(productName, price, quanity, description);
        product.setDepartmentID(getDepartmentID());
        product.setIDProduct(getIDProduct());
        
        return product;
    }

}
