package com.anwar.artpiececatalogue.service;

import com.anwar.artpiececatalogue.dto.ArtPieceDto;
import com.anwar.artpiececatalogue.dto.ArtPiecesCatalogueDto;
import com.anwar.artpiececatalogue.dto.StoreDto;
import com.anwar.artpiececatalogue.entity.ArtPiece;
import com.anwar.artpiececatalogue.mapper.ArtPieceMapper;
import com.anwar.artpiececatalogue.repository.ArtPieceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtPiecesCatalogueService {
    private final ArtPieceRepository artPieceRepository;
    private final RestTemplate restTemplate;


    public ArtPieceDto addArtPiece(ArtPieceDto artPieceDto) {
        ArtPiece savedArtPiece = artPieceRepository.save(ArtPieceMapper.INSTANCE.mapArtPieceDtoToArtPiece(artPieceDto));
        return ArtPieceMapper.INSTANCE.mapArtPieceToArtPieceDto(savedArtPiece);
    }

    public ArtPieceDto getArtPieceById(Long id) {
        if(artPieceRepository.existsById(id)){
            return ArtPieceMapper.INSTANCE.mapArtPieceToArtPieceDto(artPieceRepository.findById(id).get());
        }
        return null;
    }

    public ArtPiecesCatalogueDto fetchCataloguePage(Long storeId){
        return createCataloguePage(getArtPiecesByStore(storeId), getStoreDetailsfromStoreStoresMS(storeId));
    }

    public ArtPiecesCatalogueDto createCataloguePage(List<ArtPiece> artPieces, StoreDto store){
        ArtPiecesCatalogueDto catalogue = new ArtPiecesCatalogueDto();
        catalogue.setArtPieces(artPieces);
        catalogue.setStoreDto(store);
        return catalogue;

    }

    private List<ArtPiece> getArtPiecesByStore(Long storeId){
        return artPieceRepository.findByStoreId(storeId);
    }

    private StoreDto getStoreDetailsfromStoreStoresMS(Long storeId) {
        //We can use the local host, but in  order to go through eureka, we will use the name of the service
        return restTemplate.getForObject("http://STORES-SERVICE/store/" + storeId, StoreDto.class);
    }





}
