package Animals;

public abstract class Animal {
    public static int numberOfAnimals;
    protected String name;

    public Animal(String name) {
        this.name = name;
        numberOfAnimals++;
    }

    public void run(int distance) {
        System.out.println(this.name + " пробежал " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println(this.name + " проплыл " + distance + " метров.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
