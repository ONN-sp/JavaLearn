package Week6.Learn.Demo4;

public class PingpangPSporter extends Sporter implements English {
    public PingpangPSporter() {

    }
    public PingpangPSporter(String name, int age) {
        super(name, age);
    }
    @Override
    public void study() {
        System.out.println("乒乓球运动员正在学习打乒乓球");
    }
    @Override
    public void SpeakEnglish() {
        System.out.println("乒乓球运动员在说英语");
    }
}
