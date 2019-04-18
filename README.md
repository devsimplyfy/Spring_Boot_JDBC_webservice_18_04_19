# Spring_Boot_JDBC_webservice_18_04_19
Product _att Table
input: http://localhost:8080/shopnow/product_att/


Offer Table
http://localhost:8080/shopnow/offer/


Customer_address Table
http://localhost:8080/shopnow/customer_add/110


for deleting entry from address table
method:DELETE  in ARC http://localhost:8080/shopnow/customer_add/110

for inserting and updating data in ARC use POST method and data send in json formate

for UPDATE  
method=PUT http://localhost:8080/shopnow/customer_add/75
{
"id":"75",
"customerId":"111",
"type_billing_shipping":"case",
"firstName":"Rinlki",
"lastName":"jayswal",
"address1":"Dakor",
"address2":"Dakor",
"address3":"Dakor",
"city":"Dakor",
"state":"Gujarat",
"country":"India",
"phoneNumber":"2222222222",
"isPrimary":"0",
"createdDatetime":"2019-04-25T00:00:00.000Z"
}


for inserting

  POST http://localhost:8080/shopnow/customer_add/
{

"customerId":"110",
"type_billing_shipping":"case",
"firstName":"priyanka",
"lastName":"jayswal",
"address1":"Dakor",
"address2":"Dakor",
"address3":"Dakor",
"city":"Dakor",
"state":"Gujarat",
"country":"India",
"phoneNumber":"2222222222",
"isPrimary":"0",
"createdDatetime":"2019-04-25T00:00:00.000Z"
}



TABLE-Product and PRODUCT_IMAGE TABLE
input    http://localhost:8080/shopnow/product/


TABLE-CATEGORY AND PRODUCTS
AIM--FETCH CATEGORY ID FROM PRODUCT TABLE AND CHAILD CATEGORY AND ITS PARENT CATEGORY FROM CATEGORY TABLE
INPUT---http://localhost:8080/shopnow/Category/2

TABLES-PRODUCT,PRODUCT_IMAGE,CATEGORY

AIM-FIND ID,NAME,DESCRIPTION,REGULAR_PRICE,SALE_PRICE STOCK IMAGE FROM PRODUCT TABLE
     CATEGORY_NAME,PARENT_CATEGORY FROM CATEGORY TABLE
		IMAGE_EXTR FROM PRODUCT_IMAGE TABLE
    
 INPUT- http://localhost:8080/shopnow/productAll/


