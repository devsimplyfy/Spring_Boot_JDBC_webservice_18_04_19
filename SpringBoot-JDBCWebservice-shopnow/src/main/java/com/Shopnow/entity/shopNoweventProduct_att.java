package com.Shopnow.entity;

/**
 * @author Ajay 
 *
 */
public class shopNoweventProduct_att {
		// THIS GETER SETTER METHOD FOR PRODUCT_ATTRIBUTE TABLE
	
	    //private int Pro_id;
	    private int product_id;
	    private String[] att_value;
	   // private String att_group_name;
	    
	    
	    
	    
	    	public shopNoweventProduct_att() {
	        
			
	        
	    }
	    
	    
	    
		public shopNoweventProduct_att(int product_id,String[] att_value) {
	        
			
			//this.Pro_id = Pro_id;
	        this.product_id =product_id;
	       // this.att_group_name=att_group_name;
	        this.att_value=att_value;
	        
	    }

	

		public int getProduct_id() {
			return product_id;
		}

		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}

		public String[] getAtt_value() {
			return att_value;
		}

		public void setAtt_value(String[] att_value) {
			this.att_value = att_value;
		}

		
	
  
}
