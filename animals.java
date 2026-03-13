public class animals {
    public static void main(String[] args) {

    }
}

class Animal {
    private String animalName;
    private int age;
    private String ownerName;

    public Animal(String animalName, int age, String ownerName) {
        this.animalName = animalName;
        this.age = age;
        this.ownerName = ownerName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Animal)) {
            return false;
        }
        Animal o = (Animal) other;
        return this.animalName.equals(o.animalName) && this.age == o.age && this.ownerName.equals(o.ownerName);
    }

    @Override
    public String toString() {
        return "Animal Name: " + animalName + ", Age: " + age + ", Owner Name: " + ownerName;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String animalName, int age, String ownerName, String breed) {
        super(animalName, age, ownerName);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Dog)) {
            return false;
        }
        Dog o = (Dog) other;
        return super.equals(other) && this.breed.equals(o.breed);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Dog, Breed: " + breed;
    }
}