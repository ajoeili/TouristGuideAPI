package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final ArrayList<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        fillTouristAttractions();
    }

    private void fillTouristAttractions() {
        touristAttractions.add(new TouristAttraction("The Eiffel Tower", "Big tower in Paris"));
        touristAttractions.add(new TouristAttraction("The leaning tower of Pisa", "Leaning tower in Pisa"));
        touristAttractions.add(new TouristAttraction("Statue of Liberty", "Big statue in New York City"));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction existingAttraction : touristAttractions) {
            if (existingAttraction.getName().equalsIgnoreCase(touristAttraction.getName())) {
                existingAttraction.setDescriptition(touristAttraction.getDescriptition());
                return existingAttraction;
            }
        }
        return null;
    }

    public boolean deletetAttractionByName(String name) {
        return touristAttractions.removeIf(touristAttraction -> touristAttraction.getName().equalsIgnoreCase(name));
    }
}
