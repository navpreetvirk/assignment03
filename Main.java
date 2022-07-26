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

        
        
        
        paymentMethod();
       

        System.out.println("Thanks for placing an order, your shipping information will be provided shortly through email!");


    }

    private static void paymentMethod() {
        Scanner sc = new Scanner(System.in);
        Boolean paymentSelected = false;
            while (!paymentSelected) {
                
                System.out.println("\n\n");
                System.out.println("How would you like to pay?");
                System.out.println("1: Credit Card");
                System.out.println("2: Cash");
                System.out.println("3: Cheque");
                System.out.println("4: Gold Bars");
                
                int paymentType = sc.nextInt();
                
                if (paymentType >= 1 && paymentType <= 4) {
                    paymentSelected = true;
                }
            }   
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