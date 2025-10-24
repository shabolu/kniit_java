package solutions.lab3;

public class Race {
    private int defenceBonus;
    private int attackBonus;
    private int healBonus;
    private int spellBonus;
    private int attackRangeBonus;

    public Race(int defenceBonus, int attackBonus, int healBonus, int spellBonus, int attackRangeBonus) {
        this.defenceBonus = defenceBonus;
        this.attackBonus = attackBonus;
        this.healBonus = healBonus;
        this.spellBonus = spellBonus;
        this.attackRangeBonus = attackRangeBonus;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getHealBonus() {
        return healBonus;
    }

    public int getSpellBonus() {
        return spellBonus;
    }

    public int getAttackRangeBonus() {
        return attackRangeBonus;
    }

    @Override
    public String toString() {
        return "(" +
               "defenceBonus = " + getDefenceBonus() + ", " +
               "attackBonus = " + getAttackBonus() + ", " +
               "healBonus = " + getHealBonus() + ", " +
               "spellbonus = " + getHealBonus() + ", " +
               "attackRangeBonus = " + getAttackRangeBonus() +
               ")";
    }
}
