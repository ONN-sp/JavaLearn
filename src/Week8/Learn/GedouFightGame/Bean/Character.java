package Week8.Learn.GedouFightGame.Bean;

// 人物角色
public class Character {
    public String name;
    public int hp;
    public int maxHp;
    public int mp;
    public int maxMP;
    public int attack;
    public int defense;

    public Character() {

    }

    public Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = 50;
        this.maxMP = 50;
        this.attack = attack;
        this.defense = defense;
    }

    // 判断是否存活
    public boolean isAlive() {
        return hp > 0;
    }

    // 恢复血量
    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    // 受到伤害
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    // 恢复蓝量
    public void restoreMP(int amount) {
        mp += amount;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }

    // 消耗蓝量
    public boolean consumeMP(int amount) {
        if (mp >= amount) {
            mp -= amount;
            return true;
        }
        return false;
    }

    // 展示人物的属性
    public String show() {
        return name + "[当前生命："+ hp + "/" + maxHp + ". 蓝量：" + mp + "/" + maxMP + ". 攻击：" + attack + ". 防御：" + defense + "]";
    }

}
