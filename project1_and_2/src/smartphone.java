class Smartphone extends Product implements Portable {
    public Smartphone(String name, int price) {
        super(name, price);
    }

    @Override
    public void warranty() {
        System.out.println("Screen and battery");
    }

    @Override
    public void weight() {
        System.out.println("200 grams");
    }

    @Override
    public String toString() {
        return "Smartphone: " + super.toString();
    }
}
