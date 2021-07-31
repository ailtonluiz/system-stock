package com.ailtonluiz.stock.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String responsible;

    private String note;

    private boolean active = true;


    @PrePersist
        @PreUpdate
    private void prePersistUpdate() {
        name = name.toUpperCase();
        note = note.toUpperCase();
        email = email.toLowerCase();
        responsible = responsible.toUpperCase();

    }

    public boolean isNew() {
        return id == null;
    }
}