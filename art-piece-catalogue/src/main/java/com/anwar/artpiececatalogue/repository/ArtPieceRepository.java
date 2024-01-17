package com.anwar.artpiececatalogue.repository;

import com.anwar.artpiececatalogue.entity.ArtPiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtPieceRepository extends JpaRepository<ArtPiece, Long> {
    List<ArtPiece> findByStoreId(Long storeId);
}
