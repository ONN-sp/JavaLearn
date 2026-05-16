package Week6.Learn.Demo3;

public class Demo3 {
    static void main() {
        Animal animal = new Animal(8, "黄色");
        animal.eat("水果");
        Animal dog = new Dog(10, "黑色");
        dog.eat("骨头");
        Dog dog1 = (Dog)dog;
        dog1.lookHome();
        Animal cat = new Cat(5, "白色");
        cat.eat("鱼");
        Cat cat1 = (Cat)cat;
        cat1.catchMouse();
        Person person = new Person(dog, "狗粮");
        person.keepPet(dog);
        person.keepPet(cat);
    }
}
