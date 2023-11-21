class Main {
    public static void main(String[] args) {
        Predator lion = new Predator("Astrid", "Lion", "Arrrr");
        Herbivore rabbit = new Herbivore("Astra", "Rabbit", "Purr purr");

        System.out.println(lion.getAnimalName() + " : type {" + lion.getAnimalType() + ")"+ " class (" + lion.getAnimalClass() + ")");
        System.out.println(rabbit.getAnimalName() + " : type {" + rabbit.getAnimalType() +")" + " class (" + rabbit.getAnimalClass() + ")");
        System.out.println("----------------------");

        Zoo zoo = new Zoo(4);
        try {
            zoo.addAnimal(lion, 0);
            zoo.addAnimal(rabbit, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        zoo.walkThroughZoo();
        zoo.displayUniqueAnimalTypes();
        zoo.displayPredatorAndHerbivoreCount();
        zoo.displayUniqueAnimalsDescendingOrder();
    }
}