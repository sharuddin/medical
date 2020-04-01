
package my.test.demo.features.pusatkesihatan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
 @Data 
public class PusatKesihatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String negeri;
    @NotNull
    private String bandar;
    @NotNull 
    private String hospital;
    @NotNull
    private String alamat;
    @NotNull
    private String telefon;
    @NotNull
    private String faksimile;
    @NotNull
    private String email;
   // @NotNull
   // private String jenis;
}