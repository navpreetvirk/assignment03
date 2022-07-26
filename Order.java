import java.util.ArrayList;

class Order {
    private int subTotal;
    private ArrayList<Product> products;
    
    Order() {
        this.subTotal = 0;
        this.items = new ArrayList<Product>();
    }
    
    int getSubTotal() {
        return this.subTotal;
    }
    
    ArrayList<Product> getProducts() {
        return this.products;
    }
    
    void setSubTotal(int subtotal) {
        this.subTotal = subtotal;
    }
    
    void getProducts(ArrayList<Items> items) {
        this.items = items;
    }
    
    Item addProduct(Product product) {
        this.items.add(product);
        this.subtotal += product.getPrice();
    }
    
    void removeProduct(int index) {
        this.items.remove(index);
        this.subtotal -= product.getPrice();
    }
    
    public String toString() {
        // 
    }
}