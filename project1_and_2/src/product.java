abstract class Product {
    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
    }

    public abstract void warranty();

    public int calculateVAT() {
        return (int) (price * 0.17);
    }

    @Override
    public String toString() {
        return name + " - " + price + "$";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}