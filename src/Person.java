public class Person {
    public String name; // имя сотудника
    public String position; // должность сотрудника
    private int age; // возраст сотрудника
    private String email; // почта сотрудника
    private String number; // телефонный номер сотрудника
    private int salary; // зарпалата сотрудника

    public Person() {
        this.name = "Name";
        this.age = 18;
        this.email = "email@mail.com";
        this.number = "899999999999";
        this.salary = 1000;
        this.position = "Employee";
    }

    public Person(String name, int age, String position, String email, String number, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
    }

    public void showPerson() {
        System.out.println("Name: " + this.name + "\nAge: " + this.age + "\nPosition: " +
                this.position + "\nemail: " + this.email + "\nNumber: " + this.number +
                "\nSalary: " + this.salary + "\n");
    }

    @Override
    public String toString() {
        return ("Name: " + this.name + "\nAge: " + this.age + "\nPosition: " +
                this.position + "\nemail: " + this.email + "\nNumber: " + this.number +
                "\nSalary: " + this.salary + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
