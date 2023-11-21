import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
 
class Cage {
    private Map<String, List<Animal>> animalsByType;

    public Cage() {
        animalsByType = new HashMap<>();
    }

    public void add(Animal newAnimal) throws Exception {
        String animalType = newAnimal.getAnimalType();
        if (!animalsByType.containsKey(animalType)) {
            animalsByType.put(animalType, new ArrayList<>());
        }

        List<Animal> animalsOfType = animalsByType.get(animalType);

        for (Animal existingAnimal : animalsOfType) {
            if (!existingAnimal.getAnimalClass().equals(newAnimal.getAnimalClass())) {
                throw new Exception("Cannot add a predator to a cage with a herbivore, and vice versa.");
            }
        }

        animalsOfType.add(newAnimal);
    }

    public List<Animal> getAnimals() {
        List<Animal> allAnimals = new ArrayList<>();
        for (List<Animal> animalsOfType : animalsByType.values()) {
            allAnimals.addAll(animalsOfType);
        }
        return allAnimals;
    }

    public Map<String, List<Animal>> getAnimalsByType() {
        return animalsByType;
    }
}
