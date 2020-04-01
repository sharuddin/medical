package my.test.demo.features.jabatan;

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
public class Jabatan {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false, unique = true)
private String title;
@Column(nullable = false)
private String nama;
private String jabatan;

}