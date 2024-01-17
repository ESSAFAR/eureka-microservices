package com.anwar.artpiececatalogue.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtPieceDto {

    private Long id;
    private String itemName;
    private String itemDescription;
    private String movement;
    private String theme;
    private Integer year;
    private String artist;
    private Long price;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
