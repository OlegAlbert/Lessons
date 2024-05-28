package Animals;

public class Dog extends Animal {

    public static int numberOfDogs = 0;
    public Dog(String name) {
        super(name);
        numberOfDogs++;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500 && distance > 0) {
            super.run(distance);
        } else {
            System.out.println(this.name + " не может пробежать дистанцию в " + distance +" метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10 && distance > 0) {
            super.swim(distance);
        } else {
            System.out.println(this.name + " не может проплыть такую дистанцию.");
        }
    }
}
