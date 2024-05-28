package Animals;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        this.food += amount;
        System.out.println("В миску добавлено " + amount + " еды. В миске осталось " + this.food + " еды.");
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
