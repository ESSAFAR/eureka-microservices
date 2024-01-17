package com.anwar.artpiececatalogue.dto;

import com.anwar.artpiececatalogue.entity.ArtPiece;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtPiecesCatalogueDto {

    private List<ArtPiece> artPieces;
    private StoreDto storeDto;

}
