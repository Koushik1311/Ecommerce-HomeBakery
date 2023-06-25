package com.homebakery.homebakery.model;

// imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data // Data annotation for constructor, getter, setter & toSring methods
@Table(name = "categories") // Table name same as the database table name
public class Category {
    // fields for Category
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "GenerationType.IDENTITY" gives the database to auto
                                                        // increment the id field
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;
}
