import java.util.ArrayList;

abstract class Collection {
    private ArrayList<Item> collection;
    private String title;
    
    Collection(String title) {
        this.collection = new ArrayList<Item>();
        this.title = title;
    }
    
    ArrayList<Item> getCollection() {
        return this.collection;
    }
    
    int getSize() {
        return this.collection.size();
    }
    
    String getTitle() {
        return this.title;
    }
    
    void setCollection(ArrayList<Item> collection) {
        this.collection = collection;
    }
    
    void setTitle(String title) {
        this.title = title;
    }
    
    void addItemToCollection(Item item) {
        collection.add(item);
    }
    
    Item getItem(int itemIndex) {
        return this.collection.get(itemIndex);
    }
}