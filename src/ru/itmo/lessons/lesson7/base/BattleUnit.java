package ru.itmo.lessons.lesson7.base;
// Unit - родительский класс
// BattleUnit - дочерний класс
// BattleUnit наследуется от класса Unit
abstract public class BattleUnit extends Unit {
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

    public void battleUnitVoid(){
        System.out.println("Метод BattleUnit");
    }
}
