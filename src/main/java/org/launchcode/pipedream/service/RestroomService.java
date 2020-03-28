package org.launchcode.pipedream.service;

import org.launchcode.pipedream.model.Restroom;
import org.launchcode.pipedream.repository.RestroomRepository;
import org.springframework.stereotype.Service;


import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class RestroomService {

    private RestroomRepository restroomRepository;

    public RestroomService(RestroomRepository restroomRepository){
        this.restroomRepository = restroomRepository;
    }

    public List<Restroom> getAll() {
        return restroomRepository.findAll();
    }

    public Optional<Restroom> get(Long id){
        return restroomRepository.findById(id);
    }

    public Restroom add(Restroom restroom){
        return restroomRepository.save(restroom);
    }


    public Optional<Restroom> update (Restroom restroom) {
        if(restroomRepository.existsById(restroom.getId())){
            restroomRepository.save(restroom);
            return Optional.of(restroom);
        }
        return Optional.empty();
    }

    public boolean delete(Long id){
        if(restroomRepository.existsById(id)){
            restroomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
