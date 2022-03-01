package main;

public class Itemsclass extends Ordersclass{
	//ITEMS DATA
	private int itemnumber;
    private String itemname;
    private int quantity;
    
    public Itemsclass(){
        orderid = null;
        itemnumber = 0;
        itemname = null;
        quantity = 0;
    }
    
    public Itemsclass(String orderid, int itemnumber, String itemname, int quantity){
        this.orderid = orderid;
        this.itemname = itemname;
        this.quantity = quantity;
        this.itemnumber = itemnumber;
    }
    
    //ACCESSOR
    public int getitemnumber() {
    	return itemnumber;
    }
    
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
