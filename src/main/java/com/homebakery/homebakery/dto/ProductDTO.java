package com.homebakery.homebakery.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;

    private String name;

    private Double price;

    private String description;

    private String imageName;

    private int categoryId;
}