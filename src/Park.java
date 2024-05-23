import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

public class Park {

    private String name; // название парка аттракционов
    private ArrayList<Attraction> attractions; // массив со всеми аттракционами в парке

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }


    // метод для добавления нового аттракциона в парк
    public void addAttraction(String type, int cost, String openTime, String closeTime) {
        this.attractions.add(new Attraction(type, cost, openTime, closeTime));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    // внутренний класс для описания аттракциона
    public class Attraction {
        private final String type; // информация об аттракионе
        private int cost; // цена аттракциона
        private String openTime; // время начала работы аттракциона
        private String closeTime; // время закрытия аттракциона

        public Attraction(String type, int cost, String openTime, String closeTime) {
            this.type = type;
            this.cost = cost;
            this.openTime = openTime;
            this.closeTime = closeTime;
        }

        public String getType() {
            return type;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(String closeTime) {
            this.closeTime = closeTime;
        }

        @Override
        public String toString() {
            return ("Attraction: " + type + "\nCost: " + cost + "\nOpen: "
                    + openTime + "\nClose: " + closeTime + "\n");
        }
    }

}
