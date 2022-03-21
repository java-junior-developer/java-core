package ru.itmo.lessons.lesson7.base;

// ru.itmo.lessons.lesson7.base.Unit
// родительский класс всех персонажей
// нельзя создать экземпляр
// может содержать абстрактные методы
abstract public class Unit {
    /* доступ к свойству из текущего класса + дочерних классов */
    protected int healthScore;
    private int maxHealthScore;
    public Unit(int healthScore){
        if (healthScore < 1) {
            throw new IllegalArgumentException("Здоровье дб положительным");
        }
        this.healthScore = healthScore;
        maxHealthScore = healthScore;
    }
    public int getHealthScore(){
        return healthScore;
    }
    // увеличить здоровье на healthScore, но не больше изначального,
    // если персонаж жив
    public void plusHealth(int healthScore){
        if (!isAlive()) return;
        this.healthScore =
                Math.min(this.healthScore + healthScore, maxHealthScore);
    }
    // уменьшить здоровье на healthScore, если персонаж жив
    public void minusHealth(int healthScore){
        if (!isAlive()) return;
        this.healthScore -= healthScore;
    }
    // метод вернет true, если здоровье больше 0,
    // false, если нет
    public boolean isAlive() {
        return healthScore > 0;
    }

    // абстрактный метод - метод без реализации (без {})
    public abstract void rest();
}
