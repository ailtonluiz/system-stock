package com.ailtonluiz.stock.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String description;

    private boolean active = true;

    public boolean isNew() {
        return id == null;
    }

    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        description = description.toUpperCase();

    }

}
