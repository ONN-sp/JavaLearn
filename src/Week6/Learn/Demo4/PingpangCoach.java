package Week6.Learn.Demo4;

public class PingpangCoach extends  Coach implements English {
    public PingpangCoach() {

    }
    public PingpangCoach(String name, int age) {
        super(name, age);
    }
    @Override
    public void teach() {
        System.out.println("乒乓教练在教打乒乓球");
    }
    @Override
    public void SpeakEnglish() {
        System.out.println("乒乓教练在说英语");
    }
}
