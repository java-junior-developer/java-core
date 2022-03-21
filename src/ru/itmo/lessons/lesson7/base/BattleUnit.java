package ru.itmo.lessons.lesson7.base;
// Unit - родительский класс
// BattleUnit - дочерний класс
// BattleUnit наследуется от класса Unit

import ru.itmo.lessons.lesson7.Infantry;
import ru.itmo.lessons.lesson7.Knight;
// new BattleUnit
abstract public class BattleUnit extends Unit implements AttackAble{
    protected int attackScore;
    public BattleUnit(int healthScore, int attackScore){
        super(healthScore); /* вызов конструктора родителя */
        if (attackScore < 1) {
            throw new IllegalArgumentException("Атака дб положительной");
        }
        this.attackScore = attackScore;
    }
    public int getAttackScore(){
        return attackScore;
    }

    // переопределять final метод нельзя
    public final void battleUnitVoid(){
        System.out.println("Метод BattleUnit");
    }

    public boolean runFromField(){
        if (!isAlive()) {
            System.out.println("Юнит не может сбежать");
            return false;
        }
        healthScore -= 1;
        if (!isAlive()) {
            System.out.println("Юнит не смог сбежать");
            return false;
        }
        return true;
    }
    // фабричные методы
    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        int randomIndex = (int) (Math.random() * types.length);
        switch (types[randomIndex]) {
            case "knight":
                unit = new Knight(30, 18);
                break;
            case "infantry":
                unit = new Infantry(35, 20);
                break;
        }
        return unit;
    }

    public static BattleUnit[] getBattleUnits(int count) {
        BattleUnit[] units = new BattleUnit[count];
        for (int i = 0; i < units.length; i++) {
            // в статических методах можно обратиться
            // только к статическим методам или свойствам
            units[i] = getBattleUnit();
        }
        return units;
    }
}

