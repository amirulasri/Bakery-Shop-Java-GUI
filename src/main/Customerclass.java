package main;

public class Customerclass extends Ordersclass{
	//CUSTOMER DATA
    private String name;
    private String phoneno;
    private String email;
    private boolean regularcustomer; //FOR GET DISCOUNT IF TRUE
    
    public Customerclass(){
        orderid = null;
        name = null;
        phoneno = null;
        email = null;
        regularcustomer = false;
    }
    
    public Customerclass(String orderid, String name, String phoneno, String email, boolean regularcustomer){
        this.orderid = orderid;
        this.name = name;
        this.phoneno = phoneno;
        this.email = email;
        this.regularcustomer = regularcustomer;
    }
    
    //ACCESSOR
    public String getname(){
        return name;
    }
    
    public String getphoneno(){
        return phoneno;
    }
    
    public String getemail(){
        return email;
    }
    
    public boolean getregularcustomer(){
        return regularcustomer;
    }
    
    public String getorderid(){
        return orderid;
    }
}
