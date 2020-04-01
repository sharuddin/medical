package my.test.demo.features.ladang;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Detail
 */

 @Entity 
 @Data 
public class Ladang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String code;
    @NotNull
    private String nama;
    @NotNull
    private String telefon;
    @NotNull
    private String kategori;
    
    
}