import java.util.Scanner;
class Main {
    public static void main (String[] args) {
        Menu ecommerceMenu = generateMenu();
        System.out.println(ecommerceMenu.toString());


        Order order = new Order();

        // Don't have the Java knowledge to put this in separate class / interface
        Boolean orderDone = false;
        String nextItem = "";
        System.out.println("Place your next order.");
        System.out.println("For example, Type 00 for \"Butter Chicken\".");
        System.out.println("Type \"D\" To Finish");
        
        // Scanner sc = new Scanner(System.in);
        // nextItem = sc.nextLine();
        // System.out.println(nextItem);
        
        while(!orderDone) {
            Scanner sc = new Scanner(System.in);
            nextItem = sc.nextLine();
    
            if (!nextItem.equals("D")) {
                int collectionIndex = Character.getNumericValue(nextItem.charAt(0));
                int itemIndex = Character.getNumericValue(nextItem.charAt(1));
                Product itemToAdd = ecommerceMenu.getProduct(collectionIndex, itemIndex);
                order.addProduct(itemToAdd);
            }
            else {
                orderDone = true;
            }
        }
        order.printOrder();
        order.printTotal();


    }
    
    public static Menu generateMenu() {
        Menu menu = new Menu();
        TShirts tShirts = new TShirts("T-Shirts");
        menu.addCollection(tShirts);
        int shirtsIndex = menu.getCollectionIndex(tShirts);
        TShirt mensTShirt = new TShirt(15, "Men's T-Shirt");
        TShirt womensTShirt = new TShirt(15, "Women's T-Shirt");
        menu.addProduct(shirtsIndex, mensTShirt);
        menu.addProduct(shirtsIndex, womensTShirt);
        
        Pants pants = new Pants("Pants");
        menu.addCollection(pants);
        int pantsIndex = menu.getCollectionIndex(pants);
        Pant mensPant = new Pant(10, "Men's Pant");
        Pant womensPant = new Pant(25, "Women's Pant");
        menu.addProduct(pantsIndex, mensPant);
        menu.addProduct(pantsIndex, womensPant);
        
        return menu;
    }
}