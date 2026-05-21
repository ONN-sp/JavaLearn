package Week7.Learn.GedouFightGame.Ui;

import Week7.Learn.GedouFightGame.Bean.EnemyCharacter;
import Week7.Learn.GedouFightGame.Bean.HeroCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FightingGame {
    // 敌人嘲讽话语
    private static final String[] TAUNTS = {
        "哈哈，就这点实力吗？",
        "太弱了，回去再练练吧！",
        "这就是你的全部本事？真让人失望！",
        "我还没认真呢，你就倒下了！",
        "弱者，永远无法战胜强者！",
        "你的战斗技巧还有待提高啊！",
        "这种程度也想挑战我？可笑！",
        "看来你还需要更多训练！"
    };
    // 启动游戏
    public void gameStart(String username) {
        // 显示游戏标题
        System.out.println("╔═════════════════════════════╗");
        System.out.println("    🎮 " + username + " 欢迎来到文字格斗游戏 🎮   ");
        System.out.println("╚═════════════════════════════╝");
        // 创建玩家角色（名字+属性分配）
        HeroCharacter player = createPlayerCharacter(username);
        // 显示创建角色的信息和技能列表
        System.out.println("角色创建成功！");
        System.out.println("\uD83C\uDF1F 初始属性为：" + player.show());
        System.out.println("\uD83C\uDF1F 拥有的技能：" + player.showSkillList());
        // 创建敌人角色
        ArrayList<EnemyCharacter> enemyLists = new ArrayList<>();
        enemyLists.add(new EnemyCharacter("初级战士", 80, 15, 10, "猛击"));
        enemyLists.add(new EnemyCharacter("敏捷刺客", 60, 20, 5, "快速攻击"));
        enemyLists.add(new EnemyCharacter("重装坦克", 120, 10, 20, "防御姿态"));
        enemyLists.add(new EnemyCharacter("神秘法师", 70, 25, 8, "火球术"));
        // 准备战斗
        int count = 1;// 战斗轮数
        int wins = 0;// 玩家胜场数
        // 重置敌人属性（越来越难打）
        // 我是依次跟多个敌人进行战斗，直到我方的生命值为0，游戏才会结束
        while (player.isAlive()) {
            if(count > 1) {
                for(int i=0;i<enemyLists.size();++i) {
                    EnemyCharacter enemy = enemyLists.get(i);
                    enemy.maxHp = enemy.maxHp+10;
                    enemy.hp = enemy.maxHp;
                    enemy.attack = enemy.attack+3;
                    enemy.defense = enemy.defense+2;
                    enemy.defending = false;
                }
            }
            // 随机选择敌人
            Random random = new Random();
            int index = random.nextInt(enemyLists.size());
            EnemyCharacter enemy = enemyLists.get(index);
            System.out.println(enemy.show());
            System.out.println("⚔\uFE0F 第" + count + "场战斗开始！对手：" + enemyLists.get(index).name);
            // 跟当前的敌人是第几回合
            int round = 1;
            while(player.isAlive()) {
                // 显示双方的状态
                System.out.println("---------------------------------------");
                System.out.println("⚔\uFE0F 第" + round + "回合开始！" );
                // 打印双方血条和蓝条
                System.out.println(getHealthBar(player.name, player.hp, player.maxHp));
                System.out.println(getMPBar(player.name, player.mp, player.maxMP));
                System.out.println(getHealthBar(enemy.name, enemy.hp, enemy.maxHp));
                // 玩家回合：选择行动（普通攻击、防御、生命汲取）
                playerTurn(player, enemy);
                // 判断当前敌人是否被击败
                if(!enemy.isAlive()) {
                    System.out.println("\uD83C\uDF89 你击败了" + enemy.name + "！");
                    wins++;
                    // 打败敌人，恢复最大蓝量的30%
                    int restoreMP = (int)(player.maxMP * 0.3);
                    player.restoreMP(restoreMP);
                    System.out.println("\uD83D\uDC99 恢复了" + restoreMP + "点蓝量！");
                    break;
                }
                // 敌人回合：选择行动（ 50%的几率普通攻击 / 50%的几率技能攻击 / 不同的敌人采取不同的技能进行攻击）
                enemyTurn(player, enemy);
                // 判断玩家是否被击败
                if(!player.isAlive()) {
                    System.out.println("你被"+ enemy.name + "击败了！");
                    // 敌人嘲讽
                    String taunt = TAUNTS[random.nextInt(TAUNTS.length)];
                    System.out.println(enemy.name + "嘲讽道：" + taunt);
                    break;
                }
                // 如果玩家没有被击败，继续下一轮战斗
                round++;
            }
            // 跟一个敌人的战斗结束后，玩家胜利，继续下一场战斗，玩家失败，游戏结束
            // 玩家胜利，恢复玩家属性（生命值、攻击值、防御值）和敌人属性
            if(player.isAlive()) {
                // 计算玩家恢复的血量（20-40）
               int healHP = random.nextInt(21)+20;
                // 玩家恢复血量
                player.heal(healHP);
                System.out.println("\uD83D\uDC9A 战斗结束！你恢复了" + healHP + "点生命值！");
                System.out.println("\uD83C\uDFC6 当前胜场：" + wins);
                System.out.println("═══════════════════════════════════════");
                // 胜三场提升属性
            }
            if(player.isAlive() && wins > 0 && wins%3 == 0) {
                System.out.println("共享！你获得了属性提升！");
                // 玩家提升属性
                player.maxHp += 30;
                player.attack += 5;
                player.defense += 3;
                System.out.println("属性提升后，当前属性：" + player.show());
            }
            // 询问玩家是否继续
            if(player.isAlive()) {
                System.out.println("是否继续下一场战斗？(y/n):");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if(choice.equalsIgnoreCase("y")) {
                    // 战斗继续
                    count++;
                    continue;
                }
                else if(choice.equalsIgnoreCase("n"))
                    break;// 玩家选择不继续，游戏结束
                else {// 玩家输入错误，重新输入
                    while(true) {
                        System.out.println("请输入y或n");
                        choice = scanner.next();
                        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))
                            break;
                    }
                }

            }
        }
        // 游戏的最终结算
        System.out.println("═══════════════════════════════════════");
        System.out.println("游戏结束！");
        System.out.println("总胜场：" + wins);
        System.out.println("感谢参与文字版格斗游戏！");
        System.exit(0);// 游戏结束，退出程序
    }

    // 敌人回合
    private void enemyTurn(HeroCharacter player, EnemyCharacter enemy) {
        System.out.println("====" + enemy.name + "的回合====！");
        // 计算当前是普通攻击50%，还是技能攻击50%
        String action = "普通攻击";// 敌人默认普通攻击
        Random random = new Random();
        int num = random.nextInt(10);// 0-4(普通攻击) 5-9(技能攻击)
        if(num>=5)
            action = enemy.skill;
        switch(action) {
            case "普通攻击":
                System.out.println("敌人采取了普通攻击");
                int damage1 = calculateDamage(enemy.attack, player.defense);
                System.out.println("⚔\uFE0F" + enemy.name + "对你使用了普通攻击，造成了"+ damage1 + "点伤害!");
                // 我方扣血
                player.takeDamage(damage1);
                break;
            case "猛击":
                System.out.println("当前的战士采取了猛击");
                int damage2 = calculateDamage((int)(enemy.attack*1.5), player.defense);
                System.out.println("⚔\uFE0F" + enemy.name + "对你使用了猛击，造成了"+ damage2 + "点伤害!");
                // 我方扣血
                player.takeDamage(damage2);
                break;
            case "快速攻击":
                System.out.println("当前的刺客采取了快速攻击");
                int damage3 = 0;
                for(int i=0;i<2;++i){
                    int temp = calculateDamage(enemy.attack/2, player.defense);
                    damage3 += temp;
                }
                System.out.println("⚔\uFE0F" + enemy.name + "对你使用了快速攻击，造成了"+ damage3 + "点伤害!");
                // 我方扣血
                player.takeDamage(damage3);
                break;
            case "防御姿态":
                System.out.println("当前的坦克采取了防御姿态 buff");
                enemy.defending = true;
                System.out.println("⚔\uFE0F" + enemy.name + "摆出了防御姿态!");
                break;
            case "火球术":
                System.out.println("当前的法师采取了火球术");
                int damage4 = calculateDamage((int)(enemy.attack*1.8), player.defense);
                System.out.println("⚔\uFE0F" + enemy.name + "对你使用了火球术，造成了"+ damage4 + "点伤害!");
                // 我方扣血
                player.takeDamage(damage4);
                break;

        }

    }

    // 定义一个方法打印敌我双方的血条
    public String getHealthBar(String name, int hp, int maxHp) {
        int barLength = 20;
        int filled = (int)((hp*1.0/maxHp)*barLength);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("：[");
        for(int i=0;i<barLength;++i) {
            if(i < filled) {
                sb.append("█");
            } else {
                sb.append(" ");
            }
        }
        sb.append("]").append(hp).append("/").append(maxHp).append(" HP");
        return sb.toString();
    }

    // 定义一个方法打印蓝条
    public String getMPBar(String name, int mp, int maxMP) {
        int barLength = 20;
        int filled = (int)((mp*1.0/maxMP)*barLength);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("：[");
        for(int i=0;i<barLength;++i) {
            if(i < filled) {
                sb.append("▓");
            } else {
                sb.append(" ");
            }
        }
        sb.append("]").append(mp).append("/").append(maxMP).append(" MP");
        return sb.toString();
    }

    public HeroCharacter createPlayerCharacter(String  username) {
        // 创建玩家角色（名字+属性分配）
        System.out.println("创建您的角色：");
        System.out.println("请输入您的角色名称：" + username);
        // 属性分配
        int points = 20;
        System.out.println("请分配属性点（共20点）");
        System.out.println("1. 生命值（每点+10HP）");
        System.out.println("2. 攻击力（每点+2ATK）");
        System.out.println("3. 防御力（每点+10DEF）");
        Scanner sc = new Scanner(System.in);
        // 定义数组把要提示的语句存起来
        String[] attributes = new String[]{"生命值", "攻击力", "防御力"};
        // 定义数组记录三个属性分配的属性点
        int[] values = new int[3];
        for(int i = 0; i < 3; ++i) {
            System.out.println("分配点数到" + attributes[i] + "（剩余点数：" + points + "）");
            values[i] = sc.nextInt();
            if(values[i] < 0) {
                System.out.println("无效输入！默认分配0点");
                values[i] = 0;
            }
            if (values[i] > points) {
                System.out.println("属性点不足！剩余属性点全部分配到：" + attributes[i]);
                values[i] = points;
            }
            points -= values[i];
        }
        // 创建玩家角色的对象
        HeroCharacter player = new HeroCharacter(
                username,
                100 + 10 * values[0],// 生命值
                10 + 2 * values[1],// 攻击力
                0 + values[2] * 1// 防御力
        );
        // 添加玩家的技能
        player.skillList.add("普通攻击");
        player.skillList.add("强力一击");
        player.skillList.add("生命汲取");
        return player;

    }

    // 玩家回合
    public void playerTurn(HeroCharacter player, EnemyCharacter enemy) {
        System.out.println("====你的回合====");
        System.out.println("1. 普通攻击");
        System.out.println("2. 强力一击（消耗10蓝）");
        System.out.println("3. 生命汲取（消耗10蓝）");
        System.out.println("选择行动（1-3）：");
        Scanner sc = new Scanner(System.in);
        String choose = sc.next();
        switch (choose) {
            default:
                System.out.println("没有这个操作，默认使用普通攻击");
            case "1" : {
                int damage1 = calculateDamage(player.attack, enemy.defense);
                System.out.println("⚔\uFE0F 你对"+ enemy.name + "使用了普通攻击，造成了"+ damage1 + "点伤害");
                // 扣血操作
                enemy.takeDamage(damage1);
                break;
            }
            case "2" : {
                if(!player.consumeMP(10)) {
                    System.out.println("蓝量不足，无法使用强力一击");
                    break;
                }
                // 计算我方技能给对方造成了多少点伤害
                int damage2 = calculateDamage((int)(player.attack*1.8), enemy.defense);
                // 提示我给对方造成了多少点伤害
                System.out.println("\uD83D\uDCA5 消耗10蓝，你对"+ enemy.name + "使用了强力一击，造成了"+ damage2 + "点伤害");
                // 扣血操作
                enemy.takeDamage(damage2);
                break;
            }
            case "3" : {
                if(!player.consumeMP(10)) {
                    System.out.println("蓝量不足，无法使用生命汲取");
                    break;
                }
                Random random = new Random();
                // 恢复0-20点
                int healHp = random.nextInt(21);
                player.heal(healHp);
                // 提示我给对方造成了多少点伤害
                System.out.println("\uD83D\uDCA5 消耗10蓝，你使用了生命汲取，恢复了"+ healHp + "点生命值");
                break;
            }
        }
    }

    // 用来计算双方战斗的时候，造成的伤害
    // 普通攻击的调用方式：calculateDamage(player.attack, enemy.defense);
    // 技能攻击的调用方式：calculateDamage(player.attack * 2, enemy.defense);
    public int calculateDamage(int attack, int defense) {
        int damage = attack - defense;
        if(damage < 1)
            damage = 1;
        return damage;
    }
}


