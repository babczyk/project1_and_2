class Laptop extends Computer implements Portable {
    public Laptop(String name, int price) {
        super(name, price);
    }

    @Override
    public void warranty() {
        System.out.println("Keyboard and internal components");
    }

    @Override
    public int calculateVAT() {
        return (int) (price * 0.10);
    }

    @Override
    public void weight() {
        System.out.println("2 kilograms");
    }

    @Override
    public String toString() {
        return "Laptop: " + super.toString();
    }
}
