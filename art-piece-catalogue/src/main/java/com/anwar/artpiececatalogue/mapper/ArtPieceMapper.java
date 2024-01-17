package com.anwar.artpiececatalogue.mapper;

import com.anwar.artpiececatalogue.dto.ArtPieceDto;
import com.anwar.artpiececatalogue.entity.ArtPiece;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtPieceMapper {

    ArtPieceMapper INSTANCE = Mappers.getMapper(ArtPieceMapper.class);
    ArtPiece mapArtPieceDtoToArtPiece(ArtPieceDto artPieceDto);
    ArtPieceDto mapArtPieceToArtPieceDto(ArtPiece artPiece);

}
