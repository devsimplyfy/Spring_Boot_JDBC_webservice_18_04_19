package com.Shopnow.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Shopnow.entity.shopNoweventaddress;
import com.Shopnow.entity.ProductsAllevent;
import com.Shopnow.entity.Productsevent;
import com.Shopnow.entity.shopNoweventCategory;
import com.Shopnow.entity.shopNoweventColor_main;
import com.Shopnow.entity.shopNoweventOffer;
import com.Shopnow.entity.shopNoweventProduct_att;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository("mysql")
public class MySqlshopNowDaoImpl implements shopNowDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
   

    
 // -------------------------------THIS SQLIMPLIMANTETION FOR ADDRESS TABLE-----------------------------------------------------------
    
    
    private static class addressRowMapper implements RowMapper<shopNoweventaddress> {

        @Override
        public shopNoweventaddress mapRow(ResultSet resultSet, int i) throws SQLException {
        	shopNoweventaddress emp = new shopNoweventaddress();
           
            
        	emp.setId(resultSet.getInt("id"));
        	emp.setCustomerId(resultSet.getInt("customerId"));
        	emp.setType_billing_shipping(resultSet.getString("type_billing_shipping"));
        	emp.setFirstName(resultSet.getString("firstName"));
        	emp.setLastName(resultSet.getString("lastName"));
        	emp.setAddress1(resultSet.getString("address1"));
        	emp.setAddress2(resultSet.getString("address2"));
        	emp.setAddress3(resultSet.getString("address3"));
        	emp.setCity(resultSet.getString("city"));
        	emp.setState(resultSet.getString("state"));
        	emp.setCountry(resultSet.getString("country"));
        	emp.setPhoneNumber(resultSet.getString("phoneNumber"));
        	emp.setIsPrimary(resultSet.getInt("IsPrimary"));
			emp.setCreatedDatetime(resultSet.getDate("createdDatetime"));
		
           	return emp;
            
        }
    }

    


    @Override
    public Collection<shopNoweventaddress> getAllCustomer_add() throws SQLException {
        
        final String sql = "select * from address LIMIT 10";
        List<shopNoweventaddress> empresult = jdbcTemplate.query(sql, new addressRowMapper());
        return empresult;
    }
 
    @Override
    public Collection<shopNoweventaddress> getCustomer_addById(int customerId) throws SQLException {
       
       
    	final String sql = "select * from address where customerId=?";
        List<shopNoweventaddress> empresult = jdbcTemplate.query(sql, new addressRowMapper(),customerId);
        return empresult;
    }
          
  
    @Override
    public void removeCustomer_addById(int customerId) {
      
        final String sql = "DELETE FROM address WHERE customerId = ?";
        jdbcTemplate.update(sql, customerId);
    }
    
    
    @Override
    public void updateCustomer_addById(shopNoweventaddress c1) {
      
        final String sql = "UPDATE address SET customerId=?,type_billing_shipping=?,firstName=?,lastName=?,address1=?,address2=?,address3=?,city=?,state=?,country=?,phoneNumber=?,isPrimary=?,createdDatetime=? WHERE id=?;";
        
        final int id=c1.getId();
        final int customerId = c1.getCustomerId();
        final String type_billing_shipping=c1.getType_billing_shipping();
        final String lastName=c1.getLastName();
        final String firstName=c1.getFirstName();
        final String address1=c1.getAddress1();
        final String address2=c1.getAddress2();
        final String address3=c1.getAddress3();
        final String city=c1.getCity();
        final String state=c1.getState();
        final String country=c1.getCountry();
        final String phoneNumber=c1.getPhoneNumber();
        final int isPrimary=c1.getIsPrimary();
        final Date createdDatetime=c1.getCreatedDatetime();
        
        jdbcTemplate.update(sql, new Object[]{customerId,type_billing_shipping,firstName,lastName,address1,address2,address3,city,state,country,phoneNumber,isPrimary,createdDatetime,id});
    }
 
    @Override
    public void insertCustomer_addToDb(shopNoweventaddress c1) {
        
        final String sql = "INSERT INTO address (customerId,type_billing_shipping,firstName,lastName,address1,address2,address3,city,state,country,phoneNumber,isPrimary,createdDatetime)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
        final int customerId = c1.getCustomerId();
        final String type_billing_shipping=c1.getType_billing_shipping();
        final String lastName=c1.getLastName();
        final String firstName=c1.getFirstName();
        final String address1=c1.getAddress1();
        final String address2=c1.getAddress2();
        final String address3=c1.getAddress3();
        final String city=c1.getCity();
        final String state=c1.getState();
        final String country=c1.getCountry();
        final String phoneNumber=c1.getPhoneNumber();
        final int isPrimary=c1.getIsPrimary();
        final Date createdDatetime=c1.getCreatedDatetime();
        
        
        
        jdbcTemplate.update(sql, new Object[]{customerId,type_billing_shipping,firstName,lastName,address1,address2,address3,city,state,country,phoneNumber,isPrimary,createdDatetime});

    }
    
    

    

   
    // ----------------THIS SQLIMPLIMANTETION FOR COLOR_CODE TABLE--------------------------------------------------------------------
    
    private static class Color_codeRowMapper1 implements RowMapper<shopNoweventColor_main> {

        @Override
        public shopNoweventColor_main mapRow(ResultSet resultSet1, int i) throws SQLException {
        	shopNoweventColor_main emp1 = new shopNoweventColor_main();
           
			emp1.setColor_id(resultSet1.getInt("id"));
			emp1.setColor_code(resultSet1.getString("color_code"));
			emp1.setColor_name(resultSet1.getString("color_name"));
	
           	return emp1;
           
            
       
            
        }
    }
    
    
    

    @Override
    public Collection<shopNoweventColor_main> getAllColor()throws SQLException, ClassNotFoundException {
        
    	
        final String sql = "SELECT * FROM color_code_main LIMIT 100";
         List<shopNoweventColor_main> students = jdbcTemplate.query(sql,new Color_codeRowMapper1());
        return students;
        
       
    }
    @Override
    public Collection<shopNoweventColor_main> getColorById(int id) throws SQLException, ClassNotFoundException  {
        
		 String sql="SELECT * FROM color_code_main where id=?";
		 List<shopNoweventColor_main> color_name = jdbcTemplate.query(sql, new Color_codeRowMapper1());
	        
        return color_name;
    }
    
    
  //------------------------------- THIS SQLIMPLIMANTETION FOR PRODUCT_ATTRIBUTE TABLE----------------------------------------------
    
    private static class Product_attRowMapper implements RowMapper<shopNoweventProduct_att> {

        @Override
        public shopNoweventProduct_att mapRow(ResultSet resultSet2, int i) throws SQLException {
        	shopNoweventProduct_att product_att = new shopNoweventProduct_att();
        	
        	
        	
        	product_att.setProduct_id(resultSet2.getInt("product_id"));
        	
        	String att_value=resultSet2.getString("attribute_value");
        	String[] att_value1=att_value.split(",");
        	product_att.setAtt_value(att_value1);
        	
        
            
            return product_att;
        }
    
    }

    @Override
    public Collection<shopNoweventProduct_att> getAllProduct_atts() throws SQLException {
        
        final String sql = "SELECT pa.product_id,pa.id,av.att_value,att_group_name FROM product_attributes pa \n" + 
        		"INNER JOIN attributes_value av ON av.id=pa.att_group_val_id\n" + 
        		"INNER JOIN attributes a ON a.id=pa.att_group_id LIMIT 100" ;
        
        final String sql1="SELECT pa.product_id,GROUP_CONCAT(att_group_name,' : ',av.att_value) AS attribute_value FROM product_attributes pa  \n" + 
        		" INNER JOIN attributes_value av ON av.id=pa.att_group_val_id INNER JOIN attributes a ON a.id=pa.att_group_id GROUP BY product_id limit 10";
        
        List<shopNoweventProduct_att> product_att = jdbcTemplate.query(sql1, new Product_attRowMapper());
       
        return product_att;
    }
   
    
    @Override
    public Collection<shopNoweventProduct_att> getProduct_attById(int product_id) throws SQLException {
        
    	final String sql = "SELECT pa.*,av.*,att_group_name FROM product_attributes pa \n" + 
    			"INNER JOIN attributes_value av ON av.id=pa.att_group_val_id\n" + 
    			"INNER JOIN attributes a ON a.id=pa.att_group_id\n" + 
    			"WHERE product_id=?";
    	
    	final String sql1="SELECT pa.product_id,GROUP_CONCAT(att_group_name,' : ',av.att_value) AS attribute_value FROM product_attributes pa  \n" + 
    			 " INNER JOIN attributes_value av ON av.id=pa.att_group_val_id INNER JOIN attributes a ON a.id=pa.att_group_id where product_id=?";
        
    	List<shopNoweventProduct_att> product_att = jdbcTemplate.query(sql1, new Product_attRowMapper(),product_id);
        
        return product_att;
    }
    
    
    
    
    
 //----------------------------------------- THIS SQLIMPLIMANTETION FOR OFFER TABLE--------------------------------------------------
    

    private static class OfferRowMapper implements RowMapper<shopNoweventOffer> {

        @Override
        public shopNoweventOffer mapRow(ResultSet resultSet, int i) throws SQLException {
        	
        	shopNoweventOffer shopoffer = new shopNoweventOffer();
        	
 
        	shopoffer.setProduct_id(resultSet.getInt("product_id"));
            String offer=resultSet.getString("offer_name");
            String[] offer_name=offer.split(",");
            shopoffer.setOffer_name(offer_name);
        	
        	return shopoffer;
        }
    }


    @Override
    public Collection<shopNoweventOffer> getAllOffer() throws SQLException {
        
        final String sql = "SELECT product_id,GROUP_CONCAT(offer_name) AS offer_name FROM product_offers Group by product_id";
     
        List<shopNoweventOffer> offer = jdbcTemplate.query(sql, new OfferRowMapper());
      
        return offer;
    }

    @Override
    public Collection<shopNoweventOffer> getOfferById(int product_id) throws SQLException, ClassNotFoundException  {
        
       
		final String sql="SELECT product_id,GROUP_CONCAT(offer_name) AS offer_name FROM product_offers WHERE product_id=?";	
		List<shopNoweventOffer> offer = jdbcTemplate.query(sql, new OfferRowMapper(),product_id);
	  
		return offer;
        
    }
    

    // ---------------------------------------------THIS SQLIMPLIMANTETION FOR PRODUCT_SIMPLE TABLE---------------------------------

    private static class ProductsRowMapper implements RowMapper<Productsevent> {

        @Override
        public Productsevent mapRow(ResultSet resultSet, int i) throws SQLException {
        	Productsevent pe = new Productsevent();
           
            
        	pe.setId(resultSet.getInt("id"));
        	pe.setName(resultSet.getString("name"));
        	pe.setDescription(resultSet.getString("description"));
        	pe.setRegular_price(resultSet.getFloat("regular_price"));
        	pe.setSale_price(resultSet.getFloat("sale_price"));
        	pe.setStock(resultSet.getString("stock"));
            pe.setImage(resultSet.getString("image"));
           
            
            String image_url=resultSet.getString("image1");
            String[] image_url1=image_url.split(",");
            pe.setImage_extra(image_url1);
        	
           	return pe;
            
        }
    }

    @Override
    public Collection<Productsevent> getAllProducts() throws SQLException {
        
        final String sql = "SELECT products.id,products.description,products.name,products.regular_price,products.sale_price,products.stock,products.image,\n" + 
		            "GROUP_CONCAT(product_image.image) AS image1 FROM products,product_image WHERE products.id=product_image.product_id GROUP BY products.id LIMIT 3";
        
		            List<Productsevent> pe= jdbcTemplate.query(sql, new ProductsRowMapper());
        return pe;
    }

 
    @Override
    public Collection<Productsevent> getProductsById(int id) throws SQLException {
       
       
    	
    	final String sql1="Select products.id,products.description,products.name,products.regular_price,products.sale_price,products.stock,products.image,GROUP_CONCAT(product_image.image) AS image1 FROM products,product_image WHERE products.id=product_image.product_id AND products.id=?";
        
    	List<Productsevent> pe = jdbcTemplate.query(sql1,new ProductsRowMapper(),id);
        
        
        return pe;
    }

    
    
    
    
    
 // --------------------------------THIS SQLIMPLIMANTETION FOR PRODUCT_SIMPLE TABLE---------------------------------------------------

    private static class ProductsAllRowMapper implements RowMapper<ProductsAllevent> {

        @Override
        public ProductsAllevent mapRow(ResultSet resultSet, int i) throws SQLException {
        	ProductsAllevent pe1 = new ProductsAllevent();
           
        	
        	pe1.setId(resultSet.getInt("id"));
        	pe1.setName(resultSet.getString("name"));
        	pe1.setDescription(resultSet.getString("description"));
        	pe1.setCategory_name(resultSet.getString("Category_name"));
        	pe1.setParent_category(resultSet.getString("parent_category"));
        	pe1.setRegular_price(resultSet.getFloat("regular_price"));
        	pe1.setSale_price(resultSet.getFloat("sale_price"));
        	pe1.setStock(resultSet.getString("stock"));
            pe1.setImage(resultSet.getString("image"));
          
            
            String image_url=resultSet.getString("extra_image");
            String[] image_url1=image_url.split(",");
            pe1.setImage_extra(image_url1);
        	
           	return pe1;
            
        }
    }

    @Override
    public Collection<ProductsAllevent> getAllProductsAll() throws SQLException {
        
        final String sql = "SELECT t2.id,t2.description,t2.name,t1.Category_name,t1.parent_category,t2.regular_price,t2.sale_price,t2.stock,t2.image,t2.extra_image FROM(\n" + 
        		"SELECT result.name AS Category_name,result.id,cat.parent_name AS parent_category FROM(SELECT pa.id,ca.name,ca.parent_id FROM products pa INNER JOIN categories ca ON pa.category_id=ca.id\n" + 
        		") AS result INNER JOIN (SELECT id,parent_id,NAME AS parent_name FROM categories  ) AS cat ON result.parent_id=cat.id\n" + 
        		") AS t1 INNER JOIN\n" + 
        		"(SELECT products.id,products.description,products.name,products.regular_price,products.sale_price,products.stock,products.image,GROUP_CONCAT(product_image.image) AS extra_image FROM products,product_image WHERE products.id=product_image.product_id GROUP BY products.id\n" + 
        		") t2 ON t1.id=t2.id limit 3";
        
		            List<ProductsAllevent> pe1= jdbcTemplate.query(sql, new ProductsAllRowMapper());
        return pe1;
    }

 
    @Override
    public Collection<ProductsAllevent> getProductsAllById(int id) throws SQLException {
       
       
    	final String sql1="SELECT t2.id,t2.description,t2.name,t1.Category_name,t1.parent_category,t2.regular_price,t2.sale_price,t2.stock,t2.image,t2.extra_image FROM(\n" + 
    			"SELECT result.name AS Category_name,result.id,cat.parent_name AS parent_category FROM(SELECT pa.id,ca.name,ca.parent_id FROM products pa INNER JOIN categories ca ON pa.category_id=ca.id\n" + 
    			") AS result INNER JOIN (SELECT id,parent_id,NAME AS parent_name FROM categories  ) AS cat ON result.parent_id=cat.id\n" + 
    			") AS t1 INNER JOIN\n" + 
    			"(SELECT products.id,products.description,products.name,products.regular_price,products.sale_price,products.stock,products.image,GROUP_CONCAT(product_image.image) AS extra_image FROM products,product_image WHERE products.id=product_image.product_id GROUP BY products.id\n" + 
    			") t2 ON t1.id=t2.id WHERE t1.id=?";
    	
    	List<ProductsAllevent> pe1 = jdbcTemplate.query(sql1,new ProductsAllRowMapper(),id);
        
        
        return pe1;
    }
    
    
    //----------------------------------- THIS SQLIMPLIMANTETION FOR CATEGORY TABLE-------------------------------------------------
    
    private static class CategoryRowMapper implements RowMapper<shopNoweventCategory> {

        @Override
        public shopNoweventCategory mapRow(ResultSet resultSet1, int i) throws SQLException {
        	shopNoweventCategory cat=new shopNoweventCategory();                     
           
		    cat.setId(resultSet1.getInt("id"));
		    cat.setName(resultSet1.getString("name"));
		    cat.setParent_name(resultSet1.getString("parent_name"));
		    
           	return cat;
            
        }
    }
    
    
    @Override
    public Collection<shopNoweventCategory>getAllCategory() {
        // SELECT column_name(s) FROM table_name
    	
        
        
        final String sql1="SELECT result.id,result.name,cat.parent_name FROM(SELECT pa.id,ca.name,ca.parent_id FROM products pa INNER JOIN categories ca ON pa.category_id=ca.id\n"+
        	") AS result INNER JOIN (SELECT id,parent_id,NAME AS parent_name FROM categories  ) AS cat ON result.parent_id=cat.id" ;
        
        List<shopNoweventCategory> students = jdbcTemplate.query(sql1 ,new CategoryRowMapper());
        return students;
        
       
    }
    @Override
    public Collection<shopNoweventCategory> getCategoryById(int id){
        // SELECT column_name(s) FROM table_name where column = value
		 String sql="SELECT cat.id,result.name,cat.parent_name FROM(SELECT pa.id,ca.name,ca.parent_id FROM products pa INNER JOIN categories ca ON pa.category_id=ca.id AND pa.category_id=? LIMIT 1 \n" +
		 		") AS result INNER JOIN (SELECT id,parent_id,NAME AS parent_name FROM categories  ) AS cat ON result.parent_id=cat.id";
		
		 List<shopNoweventCategory> color_name = jdbcTemplate.query(sql, new CategoryRowMapper(),id);
	        
        return color_name;
    }
    
    
    
    
    
    
  
    
    
   
}
