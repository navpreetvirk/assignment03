import java.util.Scanner;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu ecommerceMenu = generateMenu();
        Order order = new Order();
        
        Scanner s = new Scanner(System.in);
        String userInput;
        boolean homeScreen = true;
        boolean menuScreen = false;
        boolean orderSummaryScreen = false;
        boolean checkedOut = false;
        boolean isProductAdded = false;
        String addedProduct = "";
        
        while(!checkedOut) {
            if (homeScreen) {
                clearConsole();
                System.out.println(getHomeScreenMessage());
                System.out.print("Your Input: ");
                userInput = s.nextLine().toLowerCase();
                
                if (userInput.equals("c")) {
                    checkedOut = true; 
                } else if (userInput.equals("m")) {
                    homeScreen = false;
                    menuScreen = true;
                    orderSummaryScreen = false;
                } else if (userInput.equals("o")) {
                    homeScreen = false;
                    menuScreen = false;
                    orderSummaryScreen = true;
                }
            } else if (menuScreen) {
                clearConsole();
                System.out.println(ecommerceMenu.toString());
                System.out.println(getMenuScreenMessage());
                if (isProductAdded) {
                    System.out.println(addedProduct + " added to Order\n");
                    isProductAdded = false;
                }
                System.out.print("Your Input: ");
                userInput = s.nextLine().toLowerCase();
                
                if (userInput.equals("c")) {
                    checkedOut = true; 
                } else if (userInput.equals("o")) {
                    homeScreen = false;
                    menuScreen = false;
                    orderSummaryScreen = true;
                } else {
                    int collectionIndex = Character.getNumericValue(userInput.charAt(0));
                    int productIndex = Character.getNumericValue(userInput.charAt(1));
                    order.addProduct(ecommerceMenu.getProduct(collectionIndex, productIndex));
                    isProductAdded = true;
                    addedProduct = ecommerceMenu.getProduct(collectionIndex, productIndex).getTitle();
                }
            } else if (orderSummaryScreen) {
                clearConsole();
                System.out.println(order.getSummary());
                System.out.println(getOrderSummaryScreenMessage());
                System.out.print("Your Input: ");
                userInput = s.nextLine().toLowerCase();
                
                if (userInput.equals("c")) {
                    checkedOut = true; 
                } else if (userInput.equals("m")) {
                    homeScreen = false;
                    menuScreen = true;
                    orderSummaryScreen = false;
                } else if (userInput.equals("r")) {
                    order.resetOrder();
                } else {
                    int productIndex = Character.getNumericValue(userInput.charAt(0));
                    order.removeProduct(productIndex);
                }
            }
        }
        
        if (!order.isEmpty()) {
            clearConsole();
            System.out.println("How would you like to pay?");
            System.out.println("1: Credit Card");
            System.out.println("2: Paypal");
            System.out.println("3: Bitcoin");
            System.out.println("4: Gold Bars");
            System.out.print("\nYour Input: ");
            userInput = s.nextLine();
            
            clearConsole();
            System.out.println("Thanks for placing an order, your receipt will be provided shortly through email!");
            Thread.sleep(5000 + ((int) (Math.random() * 5000)));
            
            clearConsole();
            clearConsole();
            System.out.println("\n" + order.getReceipt());
        } else {
            System.out.println("Why are you checquing out an empty order? O.o");
        }
        
        s.close();;
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
    
    public static void clearConsole(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public static String getHomeScreenMessage() {
        String message = "";
        message += String.format("%27s", "").replaceAll(" ", "*").concat("\n");
        message += "Welcome to E-Commerce Store\n";
        message += String.format("%27s", "").replaceAll(" ", "*").concat("\n");
        message += String.format("%-5s%s", "C:", "Checkout\n");
        message += String.format("%-5s%s", "M:", "Menu\n");
        message += String.format("%-5s%s", "O:", "Order Summary\n");
        return message;
    }
    
    public static String getMenuScreenMessage() {
        String message = "";
        message += String.format("%-31s", " ").replaceAll(" ", "+").concat("\n");
        message += String.format("%-5s%s", "C:", "Checkout\n");
        message += String.format("%-5s%s", "O:", "Order Summary\n");
        message += "\n* Add Item Code\n";
        message += String.format("%-31s", " ").replaceAll(" ", "+").concat("\n");
        return message;
    }
    
    public static String getOrderSummaryScreenMessage() {
        String message = "";
        message += String.format("%-31s", " ").replaceAll(" ", "+").concat("\n");
        message += String.format("%-5s%s", "C:", "Checkout\n");
        message += String.format("%-5s%s", "M:", "Menu\n");
        message += String.format("%-5s%s", "R:", "Reset Order\n");
        message += "\n* Remove using Item Code\n";
        message += String.format("%-31s", " ").replaceAll(" ", "+").concat("\n");
        return message;
    }
}