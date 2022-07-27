import java.util.ArrayList;

class Order {
    private double subTotal;
    private ArrayList<Product> products;
    
    Order() {
        this.subTotal = 0;
        this.products = new ArrayList<Product>();
    }
    
    double getSubTotal() {
        return this.subTotal;
    }
    
    ArrayList<Product> getProducts() {
        return this.products;
    }
    
    void addProduct(Product product) {
        this.subTotal += product.getPrice();
        this.products.add(product);
    }
    
    void removeProduct(int index) {
        this.subTotal -= this.products.get(index).getPrice();
        this.products.remove(index);
    }
    
    void resetOrder() {
        this.subTotal = 0;
        this.products = new ArrayList<Product>();
    }
    
    boolean isEmpty() {
        if (this.products.size() == 0) {
            return true;
        }
        return false;
    }

    public String getSummary() {
        String orderSummary = "";
        orderSummary += String.format("%30s", "").replaceAll(" ", "*").concat("\n");
        orderSummary += "Order Summary\n";
        orderSummary += String.format("%30s", "").replaceAll(" ", "*").concat("\n");
        
        orderSummary += String.format("%-5s%-20s%s", "#", "Title", "Price\n");
        orderSummary += String.format("%30s", "").replaceAll(" ", "-").concat("\n");
        if (this.products.size() > 0) {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                orderSummary += String.format("%-5d%-20s%.2f%s", i, product.getTitle(), product.getPrice(), "\n");
            }
            
            
            orderSummary += String.format("%30s", "").replaceAll(" ", "+").concat("\n");
            orderSummary += String.format("%5s%-20s%.2f%s", "", "Sub Total", this.subTotal, "\n");
            orderSummary += String.format("%30s", "").replaceAll(" ", "+").concat("\n");
        } else {
            orderSummary += "Empty";
        }
        
        return orderSummary;
    }
    
    public String getReceipt() {
        String receiptString = "";
        receiptString += String.format("%31s", "").replaceAll(" ", "*").concat("\n");
        receiptString += "Receipt\n";
        receiptString += String.format("%31s", "").replaceAll(" ", "*").concat("\n");
        
        receiptString += String.format("%-5s%-20s%s", "#", "Title", "Price\n");
        receiptString += String.format("%30s", "").replaceAll(" ", "-").concat("\n");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            receiptString += String.format("%-5d%-20s$%.2f%s", i, product.getTitle(), product.getPrice(), "\n");
        }
        
        
        receiptString += String.format("%31s", "").replaceAll(" ", "+").concat("\n");
        receiptString += String.format("%5s%-20s$%.2f%s", "", "Sub Total", this.subTotal, "\n");
        receiptString += String.format("%5s%-20s$%.2f%s", "", "Total Taxes", this.subTotal * .12, "\n");
        receiptString += String.format("%31s", "").replaceAll(" ", "+").concat("\n");
        receiptString += String.format("%5s%-20s$%.2f%s", "", "Total", this.subTotal * 1.12, "\n");
        receiptString += String.format("%31s", "").replaceAll(" ", "+").concat("\n");
        
        return receiptString;
    }
}
