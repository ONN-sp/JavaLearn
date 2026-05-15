package Week6.Learn;

public class Person {
    private Animal animal;
    private String food;
    public Person () {
    }
    public Person (Animal animal, String food) {
        this.animal = animal;
        this.food = food;
    }
    public void keepPet(Animal animal) {
        if(animal instanceof Dog)
            ((Dog) animal).eat(food);
        else if(animal instanceof Cat)
            ((Cat) animal).eat(food);
        else
            System.out.println("请输入正确的动物");
    }
}
