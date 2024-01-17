package com.anwar.storesmicroservices.controller;

import com.anwar.storesmicroservices.entity.Store;
import com.anwar.storesmicroservices.service.StoreService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin
@Data
public class StoreController {

    private final StoreService storeService;



    @GetMapping("/all")
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> allRestaurants = storeService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Store> saveStore(@RequestBody Store store) {
        Store newStore = storeService.addStore(store);
        return new ResponseEntity<>(newStore, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        Store store = storeService.getStoreById(id);
        if(store != null){
            return new ResponseEntity<>(store, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
