import java.util.ArrayList;

class Order {
    private int subTotal;
    private ArrayList<Product> products;
    
    Order() {
        this.subTotal = 0;
        this.products = new ArrayList<Product>();
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
    
    void getProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    void addProduct(Product products) {
        this.products.add(products);
        this.subTotal += products.getPrice();
    }
    
    void removeProduct(Product products) {
        this.products.remove(products);
        this.subTotal -= products.getPrice();
    }
    
    // public String toString() {
    //     // 
    // }
}