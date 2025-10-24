package solutions.lab3;

public abstract class Player {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private boolean isAlive;
    private int x;
    private int y;
    private int damage;
    private int defence;
    public Race race;

    public Player(String name, Race race) {
        this.name = name;
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
        this.isAlive = true;
        this.x = 0;
        this.y = 0;
        this.damage = 10;
        this.defence = 5;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public Race getRace() {
        return race;
    }

    public void increaseHealth(int value) {
        currentHealth = Math.min(currentHealth + value + race.getHealBonus(), maxHealth);
        System.out.println(name + " вылечен на " + value + ". Текущий уровень здоровья: " + currentHealth);
    }

    public void decreaseHealth(int value) {
        currentHealth = currentHealth - value;
        if (currentHealth <= 0) {
            currentHealth = 0;
            isAlive = false;
            System.out.println(name + " погиб.");
        } else {
            System.out.println(name + " получил " + (value) + " урона. Текущее здоровье: " + currentHealth);
        }
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
        System.out.println(name + " moved to (" + x + " , " + y + ")");
    }

    @Override
    public String toString() {
        return "Player{" +
               "name = '" + getName() + '\'' +
               ", currentHealth = " + getCurrentHealth() +
               ", isAlive = " + isAlive() +
               ", x = " + getX() +
               ", y = " + getY() +
               ", damage = " + getDamage() +
               ", defence = " + getDefence() +
               ", race = " + getRace() +
               '}';
    }
}
