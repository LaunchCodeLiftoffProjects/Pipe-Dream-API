package org.launchcode.pipedream.service;

import org.launchcode.pipedream.model.Restroom;
import org.launchcode.pipedream.repository.RestroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestroomService {

    private RestroomRepository restroomRepository;

    public RestroomService(RestroomRepository restroomRepository){
        this.restroomRepository = restroomRepository;
    }

    public Restroom add(Restroom restroom){
        return restroomRepository.save(restroom);
    }

    public List<Restroom> get() {
        return restroomRepository.findAll();
    }

    public Optional<Restroom> get(Long id){
        return restroomRepository.findById(id);
    }

    public Optional<Restroom> update (Restroom restroomLocation){
        if(restroomRepository.existsById(restroomLocation.getId())){
            restroomRepository.save(restroomLocation);
            return Optional.of(restroomLocation);
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
