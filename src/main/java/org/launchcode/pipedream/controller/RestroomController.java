package org.launchcode.pipedream.controller;

import org.launchcode.pipedream.model.Restroom;
import org.launchcode.pipedream.service.RestroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins={"http://localhost:3000"})
@RestController
@RequestMapping("/restroom")
public class RestroomController {

    private RestroomService restroomService;

    public RestroomController(RestroomService restroomService){
        this.restroomService = restroomService;
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Restroom add(@RequestBody Restroom restroom){
        return restroomService.add(restroom);
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Restroom> getAll(){
        return restroomService.getAll();
    }

    @CrossOrigin(origins={"http://localhost:3000"})
    @GetMapping("/{id}")
    ResponseEntity<Restroom> get(@PathVariable Long id){
        Optional<Restroom> restroom = restroomService.get(id);
        if (restroom.isPresent()) {
            return ResponseEntity.ok().body(restroom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restroom/{restroomId}")
    List<Restroom> getByRestroomId(@PathVariable Long restroomId) {

        return null;
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PutMapping("/{id}")
    ResponseEntity<Restroom> update(@PathVariable Long id, @RequestBody Restroom newRestroom) {
        Optional<Restroom> restroom = restroomService.update(newRestroom);
        if (restroom.isPresent()) {
            return ResponseEntity.ok().body(restroom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        if(restroomService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}




