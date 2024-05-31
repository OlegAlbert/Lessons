import Animals.Animal;
import Animals.Bowl;
import Animals.Cat;
import Animals.Dog;
import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Triangle;

public class Main {
    public static void main(String[] args) {

        // 1 часть задания

        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Murka");

        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog("Sharik");

        cat1.run(201);
        cat2.swim(100);

        dog1.run(501);
        dog2.swim(10);

        System.out.println("Всего котов: " + Cat.numberOfCats);
        System.out.println("Всего собак: " + Dog.numberOfDogs);
        System.out.println("Всего животных: " + Animal.numberOfAnimals);

        Bowl bowl = new Bowl(79);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Cat1");
        cats[0].eatFromBowl(bowl, 20);
        cats[1] = new Cat("Cat2");
        cats[2] = new Cat("Cat3");
        cats[3] = new Cat("Cat4");
        cats[4] = new Cat("Cat5");

        for (int i = 0; i < cats.length; i++) {
            cats[i].eatFromBowl(bowl, 20);
            /*if (bowl.getFood() < 20) {
                bowl.addFood(20);
            }*/
            if (cats[i].isSatiety()) {
                System.out.println(cats[i].getName() + " сыт.");
            } else {
                System.out.println(cats[i].getName() + " голоден.");
            }
        }


        // 2 часть задания
        Circle circle = new Circle(10);
        circle.setBorderColor("Черный");
        circle.setFillColor("Белый");

        Rectangle rectangle = new Rectangle(15, 20);
        rectangle.setBorderColor("Крсный");
        rectangle.setFillColor("Синий");

        Triangle triangle = new Triangle(5, 6, 7);
        triangle.setBorderColor("Желтый");
        triangle.setFillColor("Фиолетовый");

        System.out.println("Круг:");
        circle.printShape();

        System.out.println("Квадрат:");
        rectangle.printShape();

        System.out.println("Треугольник:");
        triangle.printShape();
    }
}