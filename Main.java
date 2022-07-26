class Main {
    public static void main (String[] args) {
        Menu ecommerceMenu = generateMenu();
        System.out.println(ecommerceMenu.toString());
    }
    
    public static Menu generateMenu() {
        Menu menu = new Menu();
        TShirts tShirts = new TShirts("T-Shirts");
        menu.addCollection(tShirts);
        int shirtsIndex = menu.getCollectionIndex(tShirts);
        TShirt mensTShirt = new TShirt(15, "Men's T-Shirt");
        TShirt womensTShirt = new TShirt(15, "Women's T-Shirt");
        menu.addItem(shirtsIndex, mensTShirt);
        menu.addItem(shirtsIndex, womensTShirt);
        
        Pants pants = new Pants("Pants");
        menu.addCollection(pants);
        int pantsIndex = menu.getCollectionIndex(pants);
        Pant mensPant = new Pant(10, "Men's Pant");
        Pant womensPant = new Pant(25, "Women's Pant");
        menu.addItem(pantsIndex, mensPant);
        menu.addItem(pantsIndex, womensPant);
        
        return menu;
    }
}