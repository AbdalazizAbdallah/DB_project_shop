package model;

import java.util.ArrayList;

public class Department {

    private String departmentID;
    private String departmentName;
    private String description;
    private ArrayList<Product> listProduct;

    public Department(String departmentName, String description) {
        this.departmentName = departmentName;
        this.description = description;
        this.listProduct = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return departmentName;
    }

}
