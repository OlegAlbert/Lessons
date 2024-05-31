package Animals;

public class Cat extends Animal {

    public static int numberOfCats = 0;

    private boolean satiety;
    public Cat(String name) {
        super(name);
        numberOfCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200 && distance > 0) {
            super.run(distance);
        } else {
            System.out.println(this.name + " не может пробежать дистанцию в " + distance + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(this.name + " не умеет плавать.");
    }

    public void eatFromBowl (Bowl bowl, int amount) {
        if (bowl.getFood() >= amount && !this.isSatiety()) {
            bowl.setFood(bowl.getFood() - amount);
            this.satiety = true;
            System.out.println(this.name + " съел " + amount + " еды  и теперь сыт.");
            System.out.println("В миске осталось " + bowl.getFood() + " еды.");
        } else {
            if (this.isSatiety()) {
                System.out.println(this.name + " уже сыт.");
            } else {
                System.out.println(this.name + " не может съесть " + amount + " еды , т.к. ее в миске недостаточно.");
            }
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
