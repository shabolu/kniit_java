package solutions.lab3;

public class Mage extends Player {
    private int spellPower = 20;

    public Mage(String name, Race race) {
        super(name, race);
    }

    public void castSpell(Player target) {
        int totalSpellPower = spellPower + getRace().getSpellBonus() - target.getDefence() - target.getRace().getDefenceBonus();
        System.out.println(getName() + " накладывает заклятье на " + target.getName() + " и снимает ему " + totalSpellPower + " единиц здоровья!");
        target.decreaseHealth(totalSpellPower);
    }

    public int getSpellPower() {
        return spellPower;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name = '" + getName() + '\'' +
                ", currentHealth = " + getCurrentHealth() +
                ", maxHealth = " + getMaxHealth() +
                ", isAlive = " + isAlive() +
                ", x = " + getX() +
                ", y = " + getY() +
                ", damage = " + getDamage() +
                ", defence = " + getDefence() +
                ", race = " + getRace() +
                ", spellPower = " + getSpellPower() +
                '}';
    }
}
