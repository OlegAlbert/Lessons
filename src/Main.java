import org.w3c.dom.Attr;

public class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan Ivanovich", 27, "CEO",
                "ivan@mail.ru", "89991234567", 1000);
        persArray[1] = new Person("Petrov Petr Petrovich", 25, "Engineer",
                "petr@mail.ru", "80000000000", 1500);
        persArray[2] = new Person("Sidorov Sidr Sidorovich", 20, "Employee",
                "sidr@mail.ru", "123123123123", 500);
        persArray[3] = new Person("Kirillov Kirill Kirillovich", 33, "Senior",
                "kirill@mail.ru", "000000000000", 10);
        persArray[4] = new Person("Anonim", 45, "Junior",
                "anon@mail.ru", "89999999999", 2000);
        for (int i = 0; i < persArray.length; i++) {
            //persArray[i].showPerson();
            System.out.println(persArray[i].toString());
        }



        Park park = new Park("Divo ostrov");
        park.addAttraction("LaserTag", 100, "10:00", "21:00");
        park.addAttraction("Carousel", 50, "09:00", "22:00");

        for (Park.Attraction attraction : park.getAttractions()) {
            System.out.println(attraction);
        }


    }
}