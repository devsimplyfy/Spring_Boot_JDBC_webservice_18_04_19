package com.Shopnow.controller;


import com.Shopnow.entity.shopNoweventaddress;
import com.Shopnow.entity.ProductsAllevent;
import com.Shopnow.entity.Productsevent;
import com.Shopnow.entity.shopNoweventCategory;
import com.Shopnow.entity.shopNoweventColor_main;
import com.Shopnow.entity.shopNoweventOffer;
import com.Shopnow.entity.shopNoweventProduct_att;
import com.Shopnow.service.shopNowService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/shopnow")
public class shopNowController {

    @Autowired
    private shopNowService shopnowService;
    
// THIS METHOD FOR  APPLY CRUD OPERATION ON  ADDRESS TABLE
    
    @RequestMapping(value="/customer_add/",method = RequestMethod.GET)
    public Collection<shopNoweventaddress> getAllCustomer_add() throws SQLException{
        return shopnowService.getAllCustomer_add();
    }
  
    @RequestMapping(value = "/customer_add/{customerId}", method = RequestMethod.GET)
    public Collection<shopNoweventaddress> getCustomer_addById(@PathVariable("customerId") int customerId) throws SQLException, ClassNotFoundException{
        return shopnowService.getCustomer_addById(customerId);
    }
  
    @RequestMapping(value = "/customer_add/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer_addById(@PathVariable("customerId") int customerId){
    	shopnowService.removeCustomer_addById(customerId);
    }
    
    //Update Data
    @RequestMapping(value="/customer_add/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer_addById(@RequestBody shopNoweventaddress emp){
    	shopnowService.updateCustomer_addById(emp);
    }
    
    //Insert SQL Query

    @RequestMapping(value="/customer_add/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCustomer_add(@RequestBody shopNoweventaddress  emp){
    	shopnowService.insertCustomer(emp);
    }
    
    
    
    
 // THIS METHOD FOR  APPLY CRUD OPERATION ON  PRODUCT_ATTRIBUTE TABLE  
    
    
    @RequestMapping(value = "/product_att/", method = RequestMethod.GET)
    public Collection<shopNoweventProduct_att> getAllProduct_att() throws SQLException{
        return shopnowService.getAllProduct_atts();
    }

    @RequestMapping(value = "/product_att/{Product_id}", method = RequestMethod.GET)
    public Collection<shopNoweventProduct_att> getProduct_attById(@PathVariable("Product_id") int Product_id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProduct_attById(Product_id);
    }
    
    

    
 // THIS METHOD FOR  APPLY CRUD OPERATION ON  COLOR_CODE_MAIN TABLE

    @RequestMapping(value="/color/",method = RequestMethod.GET)
    public Collection<shopNoweventColor_main> getAllColor() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllColor();
    }

    @RequestMapping(value = "/color/{color_id}", method = RequestMethod.GET)
    public Collection<shopNoweventColor_main> getStudentById(@PathVariable("color_id") int color_id) throws SQLException, ClassNotFoundException{
        return shopnowService.getColorById(color_id);
    }
    
    
    // THIS METHOD FOR  APPLY CRUD OPERATION ON  offer TABLE

    @RequestMapping( value="/offer/",method = RequestMethod.GET)
    public Collection<shopNoweventOffer> getAllOffer() throws SQLException{
        return shopnowService.getAllOffer();
    }

    @RequestMapping(value = "/offer/{id}",method = RequestMethod.GET)
    public Collection<shopNoweventOffer> getOfferById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getOfferById(id);
    }

   
  
    // THIS METHOD FOR  APPLY CRUD OPERATION ON  PRODUCTS TABLE
    
    @RequestMapping(value="/product", method = RequestMethod.GET)
    public Collection<Productsevent> getAllProducts() throws SQLException{
        return shopnowService.getAllProducts();
    }
  
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Collection<Productsevent> getProductsById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProductsById(id);
    }


  // THIS METHOD FOR  APPLY CRUD OPERATION ON  PRODUCTS_ALL TABLE
    
    @RequestMapping(value="/productAll", method = RequestMethod.GET)
    public Collection<ProductsAllevent> getAllProductsAll() throws SQLException{
        return shopnowService.getAllProductsAll();
    }
  
    @RequestMapping(value = "/productAll/{id}", method = RequestMethod.GET)
    public Collection<ProductsAllevent> getProductsAllById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProductsAllById(id);
    }
    
    
    


    //THIS METHOD FOR  APPLY CRUD OPERATION ON  Category TABLE
    
    @RequestMapping(value="/Category/",method = RequestMethod.GET)
    public Collection<shopNoweventCategory> getAllCategory() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllCategory();
    }

    @RequestMapping(value = "/Category/{id}", method = RequestMethod.GET)
    public Collection<shopNoweventCategory> getCategoryById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getCategoryById(id);
    }





}
