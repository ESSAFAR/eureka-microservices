package com.anwar.artpiececatalogue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtPiece {

    @Id
    @GeneratedValue
    private Long id;
    private String itemName;
    private String itemDescription;
    private String movement;
    private String theme;
    private Integer year;
    private String artist;
    private Long storeId;
    private Long price;
    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

}
