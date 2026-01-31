package inheritance;

/*
 This program demonstrates a simple Animal hierarchy.
 It explains inheritance using a superclass and subclasses.
 Method overriding is used to change behavior in child classes.
 Polymorphism is shown using parent class references.
*/

class BaseAnimal {
    String name;
    int age;

    BaseAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() { // generic animal sound
        System.out.println("Animal makes a sound");
    }
}

// Dog subclass with its own behavior
class DogAnimal extends BaseAnimal {

    DogAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() { // dog-specific sound
        System.out.println("Dog barks");
    }
}

// Cat subclass with its own behavior
class CatAnimal extends BaseAnimal {

    CatAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() { // cat-specific sound
        System.out.println("Cat meows");
    }
}

// Bird subclass with its own behavior
class BirdAnimal extends BaseAnimal {

    BirdAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() { // bird-specific sound
        System.out.println("Bird chirps");
    }
}

// Main class to test polymorphism
public class AnimalHierarchy {

    public static void main(String[] args) { // program execution starts here
        BaseAnimal a1 = new DogAnimal("Bruno", 3);
        BaseAnimal a2 = new CatAnimal("Kitty", 2);
        BaseAnimal a3 = new BirdAnimal("Tweety", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}

