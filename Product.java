abstract class Product {
    private double price;
    private String title;
    
    Product(double price, String title) {
        this.price = price;
        this.title = title;
    }
    
    double getPrice() {
        return this.price;
    }
    
    String getTitle() {
        return this.title;
    }
    
    void setPrice(double price) {
        this.price = price;
    }
    
    void setTitle(String title) {
        this.title = title;
    }
}