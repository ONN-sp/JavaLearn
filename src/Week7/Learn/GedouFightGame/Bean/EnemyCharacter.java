package Week7.Learn.GedouFightGame.Bean;

// 表示敌人游戏人物的角色
public class EnemyCharacter extends  Character {
    public String skill;// 敌方英雄技能
    public boolean defending;// 当前游戏人物是否拥有减少伤害的状态

    public EnemyCharacter() {
        super();
    }

    public EnemyCharacter(String name, int hp, int attack, int defense, String skill) {
        super(name, hp, attack, defense);
        this.skill = skill;
    }

    @Override
    public void takeDamage(int damage) {
        // 处于防御状态，受到的伤害减半
        if (defending) {
            // 减伤技能
            damage = Math.max(damage / 2, 1);
            defending = false;
        }
        super.takeDamage(damage);
    }
}
