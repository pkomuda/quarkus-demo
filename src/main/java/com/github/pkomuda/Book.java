package com.github.pkomuda;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Book extends PanacheEntity {

    @EqualsAndHashCode.Include
    private String isbn;

    private String title;

    private String author;
}
