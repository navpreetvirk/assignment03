class Main {
    public static void main (String[] args) {
        Menu ecommerceMenu = generateMenu();
        System.out.println(ecommerceMenu.toString());
    }
    
    public static Menu generateMenu() {
        Menu menu = new Menu();
        TShirts tShirts = new TShirts("T-Shirts");
        menu.addCollection(tShirts);
        TShirt mensTShirt = new TShirt(15, "Men's T-Shirt");
        TShirt womensTShirt = new TShirt(15, "Women's T-Shirt");
        menu.addItem(0, mensTShirt);
        menu.addItem(0, womensTShirt);
        
        Pants pants = new Pants("Pants");
        menu.addCollection(pants);
        Pant mensPant = new Pant(10, "Men's Pant");
        Pant womensPant = new Pant(25, "Women's Pant");
        menu.addItem(1, mensPant);
        menu.addItem(1, womensPant);
        
        return menu;
    }
}