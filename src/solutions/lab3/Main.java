package solutions.lab3;

public class Main {
    public static void main(String[] args) {
        Race orcRace = new Race(2, 5, 0, 0, 1);
        Race elfRace = new Race(1, 2, 3, 4, 2);
        Race humanRace = new Race(1, 3, 2, 2, 3);

        WarriorGuard warrior = new WarriorGuard("Орк", orcRace);
        Mage mage = new Mage("Мальчик Который Выжил", humanRace);
        Priest priest = new Priest("Михалыч", elfRace);

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);

        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
    }
}
