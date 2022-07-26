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

    
    public void printOrder() {
        String orderContent = "";
        orderContent += "Your Order: \n";

        for (int i = 0; i < this.products.size(); i++) {
            Product product = this.products.get(i);
            orderContent += String.format("%-5d%-20s$%.2f%s", (i + 1), product.getTitle(), product.getPrice(), "\n");
        }

        System.out.println(orderContent);
    }

    public void printTotal() {
        int total = 0;

        
        for (int i = 0; i < this.products.size(); i++) {
            Product product = this.products.get(i);
            total += product.getPrice();
        }

        System.out.println("Your Total: $" + total);
    }

    // public String toString() {
    //     // 
    // }
}
