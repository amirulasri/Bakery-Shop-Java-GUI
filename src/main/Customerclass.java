package main;

public class Customerclass extends Ordersclass{
	//CUSTOMER DATA
    private String name;
    private String phoneno;
    private String address;
    private boolean regularcustomer; //FOR GET DISCOUNT IF TRUE
    
    public Customerclass(){
        orderid = null;
        name = null;
        phoneno = null;
        address = null;
        regularcustomer = false;
    }
    
    public Customerclass(String orderid, String name, String phoneno, String address, boolean regularcustomer){
        this.orderid = orderid;
        this.name = name;
        this.phoneno = phoneno;
        this.address = address;
        this.regularcustomer = regularcustomer;
    }
    
    //ACCESSOR
    public String getname(){
        return name;
    }
    
    public String getphoneno(){
        return phoneno;
    }
    
    public String getaddress(){
        return address;
    }
    
    public boolean getregularcustomer(){
        return regularcustomer;
    }
    
    public String getorderid(){
        return orderid;
    }
}
