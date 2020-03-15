package org.launchcode.pipedream.controller;

import org.launchcode.pipedream.model.Restroom;
import org.launchcode.pipedream.service.RestroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restroom")
public class RestroomController {

    private RestroomService restroomService;

    public RestroomController(RestroomService restroomService){
        this.restroomService = restroomService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Restroom add(@RequestBody Restroom restroom){
        return restroomService.add(restroom);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Restroom> getAll(){
        return restroomService.get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    ResponseEntity<Restroom> get(@PathVariable Long id){
        Optional<Restroom> restroomLocation = restroomService.get(id);
        if (restroomLocation.isPresent()) {
            return ResponseEntity.ok().body(restroomLocation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping
    ResponseEntity<Restroom> update(@RequestBody Restroom newRestroom) {
        Optional<Restroom> restroomLocation = restroomService.update(newRestroom);
        if (restroomLocation.isPresent()) {
            return ResponseEntity.ok().body(restroomLocation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        if(restroomService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}




