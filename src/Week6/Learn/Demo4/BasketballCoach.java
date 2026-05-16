package Week6.Learn.Demo4;

public class BasketballCoach extends Coach {
    public BasketballCoach() {

    }
    public BasketballCoach(String name, int age) {
        super(name, age);
    }
    @Override
    public void teach() {
        System.out.println("篮球教练在教打篮球");
    }
}
