import java.util.ArrayList;

class Order {
    private int subTotal;
    private ArrayList<Items> items;
    
    Order() {
        this.subTotal = 0;
        this.items = new ArrayList<Items>();
    }
    
    int getSubTotal() {
        return this.subTotal;
    }
    
    ArrayList<Items> getItems() {
        return this.items;
    }
    
    void setSubTotal(int subtotal) {
        this.subTotal = subtotal;
    }
    
    void getItems(ArrayList<Items> items) {
        this.items = items;
    }
    
    Item addItem(Item item) {
        this.items.add(item);
    }
    
    void removeItem(int index) {
        this.items.remove(index);
    }
    
    public String toString() {
        // 
    }
}