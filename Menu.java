import java.util.ArrayList;

class Menu {
    private ArrayList<Collection> menu;
    
    Menu() {
        this.menu = new ArrayList<Collection>();
    }
    
    ArrayList<Collection> getMenu() {
        return this.menu;
    }
    
    void setMenu(ArrayList<Collection> menu) {
        this.menu = menu;
    }
    
    void addCollection(Collection collection) {
        this.menu.add(collection);
    }
    
    void addItem(int collectionIndex, Item item) {
        this.menu.get(collectionIndex).addItemToCollection(item);
    }
    
    public String toString() {
        String menuString = "";
        
        if (this.menu.size() > 0) {
            for (int i = 0; i < this.menu.size(); i++) {
                if (i > 0) {
                    menuString += "\n";
                }
                Collection collection = this.menu.get(i);
                menuString += String.format("%-30s", " ").replaceAll(" ", "*").concat("\n");
                menuString += String.format("%-5d%s", i, (collection.getTitle() + "\n"));
                menuString += String.format("%-30s", " ").replaceAll(" ", "*").concat("\n");
                menuString += String.format("%-5s%-20s%s", "#", "Title", "Price\n");
                menuString += String.format("%-30s", " ").replaceAll(" ", "-").concat("\n");
                for (int j = 0; j < collection.getSize(); j++) {
                    Item item = collection.getItem(j);
                    menuString += String.format("%-5d%-20s%.2f\n", j, item.getTitle(), item.getPrice());
                }
            }
        }
        
        return menuString;
    }
}