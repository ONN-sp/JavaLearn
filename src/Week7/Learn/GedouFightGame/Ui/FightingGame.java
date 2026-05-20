package Week7.Learn.GedouFightGame.Ui;

import Week7.Learn.GedouFightGame.Bean.EnemyCharacter;
import Week7.Learn.GedouFightGame.Bean.HeroCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FightingGame {
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
                System.out.println("⚔\uFE0F 第" + count + "回合开始！" );
                // 打印双方血条
                System.out.println(getHealthBar(player.name, player.hp, player.maxHp));
                System.out.println(getHealthBar(enemy.name, enemy.hp, enemy.maxHp));
//                System.exit(0);
            }


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
}
