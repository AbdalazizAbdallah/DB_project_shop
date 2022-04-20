/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaceListeners;

import model.Department;
import model.Product;

/**
 *
 * @author Abdalaziz Abdallah
 */
public interface InsertNewProductActionListener {
    
     boolean insertNewProductListener(Product product,String idDepartment);
   
}
