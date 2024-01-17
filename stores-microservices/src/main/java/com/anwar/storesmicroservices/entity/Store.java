package com.anwar.storesmicroservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String country;
    private String storeDescription;
}
