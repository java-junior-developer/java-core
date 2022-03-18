package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;

// Рыцарь
// здоровье
// очкиАтаки ++
// дополнительноеЗдоровье
public class Knight extends BattleUnit {
    private int additionalHealth = 10;
    public Knight(int healthScore, int attackScore){
        super(healthScore, attackScore);
    }

    public void knightVoid(){
        System.out.println("Метод knightVoid");
    }
}
