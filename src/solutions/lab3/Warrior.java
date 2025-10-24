package solutions.lab3;

public class Warrior extends Player {
    private int attackPower = 12;
    private int attackRange = 2;

    public Warrior(String name, Race race) {
        super(name, race);
    }

    public void attack(Player target) {
        double distance = Math.sqrt(Math.pow(target.getX() - getX(), 2) + Math.pow(target.getY() - getY(), 2));

        if (distance <= attackRange + getRace().getAttackRangeBonus()) {
            int totalAttackAmount = attackPower + getRace().getAttackBonus() - target.getDefence() - target.getRace().getDefenceBonus();
            System.out.println(getName() + " атакует " + target.getName() + " и снимает ему " + totalAttackAmount + " единиц здоровья!");
            target.decreaseHealth(totalAttackAmount);
        } else {
            System.out.println(getName() + " не смог атаковать " + target.getName() + ", так как цель находится вне зоны поражения.");
        }
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name = '" + getName() + '\'' +
                ", currentHealth = " + getCurrentHealth() +
                ", maxHealth = " + getMaxHealth() +
                ", isAlive = " + isAlive() +
                ", x = " + getX() +
                ", y = " + getY() +
                ", damage = " + getDamage() +
                ", defence = " + getDefence() +
                ", race = " + getRace() +
                ", attackPower = " + getAttackPower() +
                '}';
    }
}
