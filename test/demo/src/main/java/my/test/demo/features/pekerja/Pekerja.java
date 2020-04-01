package my.test.demo.features.pekerja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



/**
 * Pekerja
 */

 @Data
 @Entity
public class Pekerja {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false, unique = true)
private String title;
@Column(nullable = false)
private String author;
private String nama;
private String nokp;
private String nopassport;
private String jawatan;
private String jabatan;
private String kelayakan;
private String maklumatkeluarga;

}