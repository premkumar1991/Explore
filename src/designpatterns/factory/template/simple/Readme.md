# Simple factory 
- simple factory has one interface with mandatory operation for implementation
- factory implementation class has mostly zero args constructor or you will end up with having more static method to create instance for different combination of input
- factory client is exposed to client which accepts type and return respective factory instance


# normal factory example
```
public abstract class Animal {
  public abstract String getSound();
}

public class Dog extends Animal {
  public String getSound() {
    return "Woof";
  }
}

public class Cat extends Animal {
  public String getSound() {
    return "Meow";
  }
}

public class AnimalFactory {
  public static Animal createAnimal(String type) {
    if (type.equalsIgnoreCase("dog")) {
      return new Dog();
    } else if (type.equalsIgnoreCase("cat")) {
      return new Cat();
    } else {
      throw new IllegalArgumentException("Unknown animal type");
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Animal dog = AnimalFactory.createAnimal("dog");
    System.out.println(dog.getSound()); // Output: Woof
    
    Animal cat = AnimalFactory.createAnimal("cat");
    System.out.println(cat.getSound()); // Output: Meow
  }
}

```

# abstract factory example
```
public interface Animal {
  String getSound();
}

public interface AnimalFactory {
  Animal createAnimal();
}

public class Dog implements Animal {
  public String getSound() {
    return "Woof";
  }
}

public class Cat implements Animal {
  public String getSound() {
    return "Meow";
  }
}

public class DogFactory implements AnimalFactory {
  public Animal createAnimal() {
    return new Dog();
  }
}

public class CatFactory implements AnimalFactory {
  public Animal createAnimal() {
    return new Cat();
  }
}

public class Main {
  public static void main(String[] args) {
    AnimalFactory dogFactory = new DogFactory();
    Animal dog = dogFactory.createAnimal();
    System.out.println(dog.getSound()); // Output: Woof
    
    AnimalFactory catFactory = new CatFactory();
    Animal cat = catFactory.createAnimal();
    System.out.println(cat.getSound()); // Output: Meow
  }
}

```

Note: You can still avoid the createAnimal method calling by putting inside one more class with static method exposed
Example 
``` 
class FactoryClient{
    static Animal createAnimal(AnimalFactory animalFactory){
        return animalFactory.createAnimal();
    }
}
>> pros
See how it avoids type checks compared to simple factory
Also you can pass dynamic params to the respective factory
example
 AnimalFactory dogFactory = new DogFactory(1,2);
AnimalFactory catFactory = new CatFactory(List.of(1,2));

>> cons
one more layer of abstract for every type of implementation required
additional one more layer is required if you want to provide client
```
