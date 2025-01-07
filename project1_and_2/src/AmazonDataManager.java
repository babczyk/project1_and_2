import java.util.HashMap;

class DataManager {
    public static HashMap<Integer, Product> mockProducts() {
        HashMap<Integer, Product> products = new HashMap<>();
        products.put(1, new TV("Samsung 75", 5000));
        products.put(2, new TV("LG OLED", 4000));
        products.put(3, new Smartphone("Apple iPhone 16", 1000));
        products.put(4, new Smartphone("Samsung Galaxy S25", 1200));
        products.put(5, new Laptop("Dell XPS 13", 1500));
        products.put(6, new Laptop("MacBook Pro", 2000));
        products.put(7, new PC("HP Pavilion", 800));
        products.put(8, new PC("Lenovo ThinkCentre", 900));
        return products;
    }
}