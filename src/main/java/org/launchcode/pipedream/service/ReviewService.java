package org.launchcode.workforce.service;

import org.launchcode.pipedream.model.Review;
import org.launchcode.pipedream.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsJobsService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> get(Long id) {
        return reviewRepository.findById(id);
    }

    ///////////////left off here!!!!!!!!!!!
    public List<ClientsJobs> getByLocation(Long id) {
        return clientsJobsRepository.findByLocationId(id);
    }

    public List<ClientsJobs> getByClient(Long id) {
        return clientsJobsRepository.findByClientId(id);
    }

    public ClientsJobs add(ClientsJobs clientsJobs) {
        return clientsJobsRepository.save(clientsJobs);
    }

    public Optional<ClientsJobs> update(ClientsJobs clientsJobs) {
        if(clientsJobsRepository.existsById(clientsJobs.getId())){
            clientsJobsRepository.save(clientsJobs);
            return Optional.of(clientsJobs);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (clientsJobsRepository.existsById(id)) {
            clientsJobsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}