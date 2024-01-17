package com.anwar.artpiececatalogue.controller;

import com.anwar.artpiececatalogue.dto.ArtPieceDto;
import com.anwar.artpiececatalogue.dto.ArtPiecesCatalogueDto;
import com.anwar.artpiececatalogue.service.ArtPiecesCatalogueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artPiecesCatalogue")
@AllArgsConstructor
public class ArtPiecesCatalogueController {

    private final ArtPiecesCatalogueService artPiecesCatalogueService;

    @PostMapping("/addArtPiece")
    public ResponseEntity<ArtPieceDto> addArtPiece(@RequestBody ArtPieceDto artPieceDto){
        ArtPieceDto createdArtPiece = artPiecesCatalogueService.addArtPiece(artPieceDto);
        return new ResponseEntity<>(createdArtPiece, HttpStatus.CREATED);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<ArtPieceDto> getArtPieceById(@PathVariable Long id){
        ArtPieceDto artPiece = artPiecesCatalogueService.getArtPieceById(id);
        if(artPiece != null){
            return new ResponseEntity<>(artPiece, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/storeCatalogue/{storeId}")
    public ResponseEntity<ArtPiecesCatalogueDto> getReataurantDetailsWithCatalogue(@PathVariable Long storeId){
        ArtPiecesCatalogueDto catalogue = artPiecesCatalogueService.fetchCataloguePage(storeId);
        return new ResponseEntity<>(catalogue, HttpStatus.OK);
    }





}
