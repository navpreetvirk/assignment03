import java.util.ArrayList;

class Menu {
    private ArrayList<Collection> menu;
    
    Menu() {
        this.menu = new ArrayList<Collection>();
    }
    
    ArrayList<Collection> getMenu() {
        return this.menu;
    }
    
    public int getCollectionIndex(Collection collection) {
       return this.menu.indexOf(collection);
    }

    void setMenu(ArrayList<Collection> menu) {
        this.menu = menu;
    }
    
    void addCollection(Collection collection) {
        this.menu.add(collection);
    }
    
    void addProduct(int collectionIndex, Product product) {
        this.menu.get(collectionIndex).addProductToCollection(product);
    }


    
    public String toString() {
        String menuString = "";
        
        if (this.menu.size() > 0) {
            for (int i = 0; i < this.menu.size(); i++) {
                if (i > 0) {
                    menuString += "\n";
                }
                Collection collection = this.menu.get(i);
                menuString += String.format("%-31s", " ").replaceAll(" ", "*").concat("\n");
                menuString += String.format("%s", (collection.getTitle() + "\n"));
                menuString += String.format("%-31s", " ").replaceAll(" ", "*").concat("\n");
                menuString += String.format("%-5s%-20s%s", "##", "Title", "Price\n");
                menuString += String.format("%-31s", " ").replaceAll(" ", "-").concat("\n");
                for (int j = 0; j < collection.getSize(); j++) {
                    Product product = collection.getProduct(j);
                    menuString += String.format("%d%-4d%-20s$%.2f\n", i, j, product.getTitle(), product.getPrice());
                }
            }
        }
        
        return menuString;
    }

}