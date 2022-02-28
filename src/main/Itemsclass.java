package main;

public class Itemsclass extends Ordersclass{
	//ITEMS DATA
    private String itemname;
    private int quantity;
    private boolean discount; //BASED ON DISCOUNT CUSTOMER
    
    public Itemsclass(){
        orderid = null;
        itemname = null;
        quantity = 0;
        discount = false;
    }
    
    public Itemsclass(String orderid, String itemname, int quantity, boolean discount){
        this.orderid = orderid;
        this.itemname = itemname;
        this.quantity = quantity;
        this.discount = discount;
    }
    
    //ACCESSOR
    public String getitemname(){
        return itemname;
    }
    
    public int getquantity(){
        return quantity;
    }
    
    public boolean getdiscount(){
        return discount;
    }
    
    public String getorderid(){
        return orderid;
    }
}
