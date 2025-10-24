package solutions.lab3;

public class Priest extends Player {
    private int healPower = 15;

    public Priest(String name, Race race) {
        super(name, race);
    }

    public void heal(Player target) {
        int totalHealAmount = healPower + race.getHealBonus();
        System.out.println(getName() + " лечит " + target.getName() + " на " + totalHealAmount + " единиц здоровья!");
        target.increaseHealth(totalHealAmount);
    }

    public int getHealPower() {
        return healPower;
    }

    @Override
    public String toString() {
        return "Priest{" +
                "name = '" + getName() + '\'' +
                ", currentHealth = " + getCurrentHealth() +
                ", maxHealth = " + getMaxHealth() +
                ", isAlive = " + isAlive() +
                ", x = " + getX() +
                ", y = " + getY() +
                ", damage = " + getDamage() +
                ", defence = " + getDefence() +
                ", race = " + getRace() +
                ", healPower = " + getHealPower() +
                '}';
    }
}
