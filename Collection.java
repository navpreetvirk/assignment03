import java.util.ArrayList;

abstract class Collection {
    private ArrayList<Product> collection;
    private String title;
    
    Collection(String title) {
        this.collection = new ArrayList<Product>();
        this.title = title;
    }
    
    ArrayList<Product> getCollection() {
        return this.collection;
    }
    
    int getSize() {
        return this.collection.size();
    }
    
    String getTitle() {
        return this.title;
    }
    
    void setCollection(ArrayList<Product> collection) {
        this.collection = collection;
    }
    
    void setTitle(String title) {
        this.title = title;
    }
    
    void addProductToCollection(Product product) {
        collection.add(product);
    }
    
    Product getProduct(int productIndex) {
        return this.collection.get(productIndex);
    }
}