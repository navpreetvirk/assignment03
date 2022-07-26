abstract class Item {
    private double price;
    private String title;
    
    Item(double price, String title) {
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