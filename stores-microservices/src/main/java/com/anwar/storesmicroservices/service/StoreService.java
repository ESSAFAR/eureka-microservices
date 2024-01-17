package com.anwar.storesmicroservices.service;

import com.anwar.storesmicroservices.entity.Store;
import com.anwar.storesmicroservices.repository.StoresRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StoreService {
    private final StoresRepository storesRepository;
    public List<Store> findAllRestaurants() {
        return storesRepository.findAll();
    }

    public Store addStore(Store store) {
        return storesRepository.save(store);
    }

    public Store getStoreById(Long id) {
        if(storesRepository.existsById(id)){
            return storesRepository.findById(id).get();
        }
        return null;
    }
}
