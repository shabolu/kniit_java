package solutions.lab3;

public class WarriorGuard extends Warrior {
    private int additionalDefence = 10;

    public WarriorGuard(String name, Race race) {
        super(name, race);
    }

    @Override
    public void decreaseHealth(int value) {
        int damageTaken = value - additionalDefence;

        if (damageTaken > 0) {
            super.decreaseHealth(damageTaken);
            System.out.println(getName() + " принял на себя " + damageTaken + " урона. Текущий уровень здоровья: " + getCurrentHealth());
        } else {
            System.out.println(getName() + " заблокировал атаку!");
        }
    }

    public int getAdditionalDefence() {
        return additionalDefence;
    }

    @Override
    public String toString() {
        return "WarriorGuard{" +
                "name = '" + getName() + '\'' +
                ", currentHealth = " + getCurrentHealth() +
                ", maxHealth = " + getMaxHealth() +
                ", isAlive = " + isAlive() +
                ", x = " + getX() +
                ", y = " + getY() +
                ", damage = " + getDamage() +
                ", defence = " + getDefence() +
                ", additionalDefence = " + getAdditionalDefence() +
                ", race = " + getRace() +
                '}';
    }
}
