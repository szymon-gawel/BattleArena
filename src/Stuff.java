public class Stuff {
    private String name;
    private double weight;

    public Stuff(String name) {
        this.name = name;
        this.weight = (int)((Math.random() * 5) + 5);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Stuff " +
                "name = " + name +
                ", weight = " + weight;
    }
}
