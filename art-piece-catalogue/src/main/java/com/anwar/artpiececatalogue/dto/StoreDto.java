package com.anwar.artpiececatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {
    private Integer id;
    private String name;
    private String email;

    private String country;
    private String storeDescription;
}