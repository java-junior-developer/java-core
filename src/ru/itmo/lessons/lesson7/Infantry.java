package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.AttackAble;
import ru.itmo.lessons.lesson7.base.BattleUnit;

public final class Infantry extends BattleUnit {
    // final свойсва нельзя изменить,
    // значение можно задать только при объявлении
    // или через конструктор, но не в сеттерах и тп
    private final int additionalAttack = 5;

    public Infantry(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    public void infantryVoid(){
        System.out.println("Метод infantryVoid");
    }

    // переопределение метода родителя
    @Override
    public boolean runFromField() {
        if (super.runFromField()) {
            attackScore -= 3;
            System.out.println("После бегства атака уменьшена на 3");
            return true;
        }
        return false;
    }


    @Override
    public void rest() {
        plusHealth(1);
        System.out.println("Отдых пехотинца");
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive())enemy.minusHealth(attackScore);
        if (enemy.isAlive()) this.minusHealth(enemy.getAttackScore());
        if (this.isAlive()) enemy.minusHealth(additionalAttack);
    }
}
