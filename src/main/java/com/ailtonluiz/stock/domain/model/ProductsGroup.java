package com.ailtonluiz.stock.domain.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class ProductsGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "Enter the name of the product group")
    private String name;

    private boolean active = true;

    @OneToMany(mappedBy = "productsGroup")
    private List<Product> products;

    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        name = name.toUpperCase();

    }

    public boolean isNew() {
        return id == null;
    }

}
