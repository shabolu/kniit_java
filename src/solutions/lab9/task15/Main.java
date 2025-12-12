package solutions.lab9.task15;

enum Season {
    WINTER("Зима", "Холодно", "Новый год"),
    SPRING("Весна", "Тепло", "Пасха"),
    SUMMER("Лето", "Жарко", "День Независимости"),
    AUTUMN("Осень", "Прохладно", "День знаний");

    private final String name;
    private final String temperature;
    private final String holiday;

    Season(String name, String temperature, String holiday) {
        this.name = name;
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Информация о временах года:");
        
        for (Season season : Season.values()) {
            System.out.println(season.getName() + ": " + season.getTemperature() + ", типичный праздник - " + season.getHoliday());
        }
    }
}