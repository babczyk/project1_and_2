
import java.util.*;

public class Main {
    private static HashMap<Integer, Product> productsMap;

    private static  HashMap<Integer, Property> propertyMap;
    public static void main(String[] args) throws PriceException {
        //products-->
        // Initialize products
        //productsMap = DataManager.mockProducts();

        // Start order process
        //startOrder();

        //propertys-->
        // Initialize products
        propertyMap = PropertyDataManager.mockProperty();

        // Start order process
        startProperty();
    }

    public static void startOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Buyer buyer = new Buyer(name);

        while (true) {
            System.out.println("Which product would you like to purchase?");
            for (Map.Entry<Integer, Product> entry : productsMap.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }

            int productId = scanner.nextInt();
            if (productsMap.containsKey(productId)) {
                buyer.addProduct(productsMap.get(productId));
            } else {
                System.out.println("Invalid product ID.");
            }

            System.out.print("Would you like to continue shopping? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) break;
        }

        System.out.print("Enter coupon code (or press Enter to skip): ");
        scanner.nextLine(); // Clear buffer
        String coupon = scanner.nextLine();
        if (coupon.equals("HOLIDAY30")) {
            buyer.applyCoupon();
        }

        buyer.printReceipt();
        scanner.close();
    }

    public static void startProperty() throws PriceException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1 > Search Properties by Price");
            System.out.println("2 > Financial Report");
            System.out.println("3 > Commercial Property Yield");
            System.out.println("4 > Properties by City");
            System.out.println("5 > Number of Cities");
            System.out.println("-1 > Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("enter a price");
                    int price = scanner.nextInt();
                    propertiesList(price);
                    break;
                case 2:
                    financialReport();
                    break;
                case 3:
                    CommercialYield();
                    break;
                case 4:
                    System.out.println("enter a city");
                    String searchString =  scanner.nextLine();
                    PropertiesByCity(searchString);
                    break;
                case 5:
                    NumberOfCities();
                    break;
                case -1:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        scanner.close();
    }
    public static void financialReport(){
        for (Map.Entry<Integer, Property> entry : propertyMap.entrySet()){
            System.out.print("Tax for: "+ entry.getKey() + " is: ");
            entry.getValue().taxIt();
        }
    }

    public static void PropertiesByCity(String searchString){
        for (Map.Entry<Integer, Property> entry : propertyMap.entrySet()) {
            if (entry.getValue().getAddress().toLowerCase().contains(searchString.toLowerCase())) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    public static void CommercialYield(){
        double sum = 0;
        for (Map.Entry<Integer, Property> entry : propertyMap.entrySet()){
            if(entry instanceof Commercial){
                sum += ((Commercial) entry).getYield();
            }
        }
        System.out.println("Total Yield: " + sum);
    }
    public static void propertiesList(int price) throws PriceException{
        if(price < 0){
            throw new PriceException("The price cannot be 0 or below");
        }
        else{
            for (Map.Entry<Integer, Property> entry : propertyMap.entrySet()){
                if(entry.getValue().getPrice() == price){
                    System.out.println(entry.getValue());
                }
            }
        }

    }

    public static void NumberOfCities() {
        Set<String> cities = new HashSet<>();

        for (Property p : propertyMap.values()) {
            String address = p.getAddress();
            String city = extractCityFromAddress(address);
            cities.add(city);
        }

        System.out.println("Number of unique cities: " + cities.size());

        System.out.println("Cities: " + cities);
    }


    private static String extractCityFromAddress(String address) {
        String[] parts = address.split(",");
        return parts[0].trim();
    }

}


// Portable Interface
interface Portable {
    void weight();
}

