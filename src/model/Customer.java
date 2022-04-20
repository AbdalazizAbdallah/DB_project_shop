package model;


import java.util.ArrayList;







public class Customer{

    
private String customerId ;
private String customerName;
private String address ;
private String userName ;
private String password ;
private ArrayList<Product> cart ;
private ArrayList<Product> myFavourite ;


public Customer(String customerId,String customerName, String address, String userName, String password) {
   this.customerId = customerId;
   this.customerName = customerName;
   this.address = address;
   this.userName = userName;
   this.password = password;
   cart = new ArrayList<>();
   myFavourite  = new ArrayList<>();
}

public Customer(String customerId,String customerName, String address, String userName) {
   this.customerId = customerId;
   this.customerName = customerName;
   this.address = address;
   this.userName = userName;
   cart = new ArrayList<>();
   myFavourite  = new ArrayList<>();
}


public String getCustomerName() {
    return customerName;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public ArrayList<Product> getMyFavourite() {
        return myFavourite;
    }

    public void setMyFavourite(ArrayList<Product> myFavourite) {
        this.myFavourite = myFavourite;
    }



}
