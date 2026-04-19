package Week1.Learn.Variable;

public class VariableMain {
    static void main(String[] args) {
        VariableBase hero1 = new VariableBase(220, 1012.5, 85, 1.2);
        VariableBase hero2 = new VariableBase(210, 1223.3, 80,1.3);
        // hero1对hero2进行攻击
        double damage = hero1.attack_*hero1.skill_ - hero2.defense_;
        double left_hp = hero2.hp_ - damage;
        System.out.println(damage);
        System.out.println(left_hp);
    }
}
