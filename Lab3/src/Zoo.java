import java.util.Set;
import java.util.*;


class Zoo {
    private final Cage[] cages;

    public Zoo(int cageCount) {
        cages = new Cage[cageCount];
        for (int i = 0; i < cageCount; i++) {
            cages[i] = new Cage();
        }
    }

    public void addAnimal(Animal animal, int cageIndex) throws Exception {
        cages[cageIndex].add(animal);
    }

    public void walkThroughZoo() {
    for (int i = 0; i < cages.length; i++) {
        List<Animal> animals = cages[i].getAnimals();
        if (!animals.isEmpty()) {
            System.out.print("Cage " + (i + 1) + ": ");
            for (Animal animal : animals) {
                System.out.print(animal.getAnimalSound() + " (" + animal.getAnimalType() + ", " + animal.getAnimalClass() + ") ");
            }
            System.out.println();
        } else {
            System.out.println("Cage " + (i + 1) + ": empty.");
        }
    }
}

    public void displayUniqueAnimalTypes() {
    Set<String> uniqueAnimalTypes = new HashSet<>();
    for (Cage cage : cages) {
        List<Animal> animals = cage.getAnimals(); // Assuming you have a getAnimals method in Cage
        for (Animal animal : animals) {
            uniqueAnimalTypes.add(animal.getAnimalType());
        }
    }
    System.out.println("\n--- Unique Animal Types ---");
    System.out.println(uniqueAnimalTypes);
}


    public void displayPredatorAndHerbivoreCount() {
    int predatorCount = 0;
    int herbivoreCount = 0;

    for (Cage cage : cages) {
        List<Animal> animals = cage.getAnimals(); // Assuming you have a getAnimals method in Cage
        for (Animal animal : animals) {
            if ("Predator".equals(animal.getAnimalType())) {
                predatorCount++;
            } else if ("Herbivore".equals(animal.getAnimalType())) {
                herbivoreCount++;
            }
        }
    }

    System.out.println("\nPredator Count: " + predatorCount);
    System.out.println("Herbivore Count: " + herbivoreCount);
}


    public void displayUniqueAnimalsDescendingOrder() {
    List<Animal> uniqueAnimals = new ArrayList<>();

    for (Cage cage : cages) {
        List<Animal> animals = cage.getAnimals(); // Assuming you have a getAnimals method in Cage
        for (Animal animal : animals) {
            if (!uniqueAnimals.contains(animal)) {
                uniqueAnimals.add(animal);
            }
        }
    }

    uniqueAnimals.sort(Comparator.comparing(Animal::getAnimalName).reversed());

    System.out.println("\n--- Unique Animals in Descending Order ---");
    for (Animal animal : uniqueAnimals) {
        System.out.println(animal);
    }
}

}