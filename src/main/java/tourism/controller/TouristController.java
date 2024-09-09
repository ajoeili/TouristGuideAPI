package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name, @RequestParam(required = false) String caps) {
        TouristAttraction touristAttraction = touristService.findAttractionByName(name, caps);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction updatedTouristAttraction = touristService.updateTouristAttraction(touristAttraction);
        if (updatedTouristAttraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("delete/{name}")
    public ResponseEntity<Void> deleteTouristAttraction(@PathVariable String name) {
        boolean isDeleted = touristService.deleteAttractionByName(name);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
