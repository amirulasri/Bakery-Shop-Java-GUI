package main;

public class Itemsclass extends Ordersclass{
	//ITEMS DATA
    private String itemname;
    private int quantity;
    
    public Itemsclass(){
        orderid = null;
        itemname = null;
        quantity = 0;
    }
    
    public Itemsclass(String orderid, String itemname, int quantity){
        this.orderid = orderid;
        this.itemname = itemname;
        this.quantity = quantity;
    }
    
    //ACCESSOR
    public String getitemname(){
        return itemname;
    }
    
    public int getquantity(){
        return quantity;
    }
    
    public String getorderid(){
        return orderid;
    }
}
