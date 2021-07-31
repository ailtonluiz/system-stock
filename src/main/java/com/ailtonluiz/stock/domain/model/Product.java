package com.ailtonluiz.stock.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.EAN;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @EAN(message = "Bar code is invalid", type = EAN.Type.EAN13)
    @NotBlank(message = "Enter the barcode")
    private String barCode;

    @NotBlank(message = "Enter the name")
    private String nameProduct;

    private String reference;

    private BigDecimal priceSale;

    private BigDecimal pricePurchase;

    private Integer quantityStock = 0;

    @NotNull(message = "Enter the minimum quantity of stock")
    private Integer quantityStockMinimum = 0;

    private Integer quantityStockPending = 0;

    private Integer quantityBox = 1;


    @NotNull(message = "Enter the product group")
    @ManyToOne
    private ProductsGroup productsGroup;

    @NotNull(message = "Enter the brand")
    @ManyToOne
    private Brand brand;

    @NotNull(message = "Enter the unity")
    @ManyToOne
    private Unity unity;

    private boolean active = true;

    private String photo;

    private String contentType;


    @Transient
    private boolean newPhoto;


    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        nameProduct = nameProduct.toUpperCase();
        reference = reference.toUpperCase();

    }

    public String getPhotoOrMock() {
        return !StringUtils.isEmpty(photo) ? photo : "login.png";
    }

    public boolean isPhoto() {
        return !StringUtils.isEmpty(this.photo);
    }

    public boolean isNew() {
        return id == null;
    }

    public boolean isNewPhoto() {
        return newPhoto;
    }
}
