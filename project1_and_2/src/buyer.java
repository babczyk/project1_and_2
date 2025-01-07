import java.util.*;

class Buyer {
    private String name;
    private List<Product> products;

    public Buyer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void applyCoupon() {
        Set<String> discountedProducts = new HashSet<>();
        for (Product product : products) {
            if (!discountedProducts.contains(product.getName())) {
                product.setPrice((int) (product.getPrice() * 0.7));
                discountedProducts.add(product.getName());
            }
        }
    }

    public void printReceipt() {
        System.out.println("Receipt for: " + name);
        int total = 0;
        int VAT = 0;
        for (Product product : products) {
            System.out.println(product);
            product.warranty();
            if (product instanceof Portable) {
                ((Portable) product).weight();
            }
            total += product.getPrice();
            VAT += product.calculateVAT();
        }

        System.out.println("Total: " + total + "$" + "VAT: " + VAT);
    }
}