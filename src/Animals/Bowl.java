package Animals;

public class Bowl {
    private int food;

    public Bowl(int food) {
        if (food > 0) {
            this.food = food;
        }
        else {
            food = 0;
            System.out.println("Нельзя добавить в миску отрицательное число еды.");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.food += amount;
            System.out.println("В миску добавлено " + amount + " еды. В миске осталось " + this.food + " еды.");
        } else {
            System.out.println("Нельзя добавить в миску отрицательное число еды.");
        }
    }


    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
