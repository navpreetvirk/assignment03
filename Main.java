import java.util.Date;
import java.util.Scanner;
import java.util.TimerTask;

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
        printReceipt();

    }
    
    
    private static void printReceipt() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\n\n");
                System.out.println("Tracking number: CGK002986959");
                System.out.println("Your Order Will be Delivered in 3 - 4 Days");
                 System.out.println("Thank you for your business!");
            }
        };

        java.util.Timer timer = new java.util.Timer("Timer");
        
        long delay = 10000L;
        timer.schedule(task, delay);
        
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
            System.out.println("Thanks for placing an order, your shipping information will be provided shortly through email!");
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