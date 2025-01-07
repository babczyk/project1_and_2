class PC extends Computer {
    public PC(String name, int price) {
        super(name, price);
    }

    @Override
    public void warranty() {
        System.out.println("Internal components only");
    }

    @Override
    public String toString() {
        return "PC: " + super.toString();
    }
}
