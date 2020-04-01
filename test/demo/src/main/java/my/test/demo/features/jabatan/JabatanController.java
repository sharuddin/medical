package my.test.demo.features.jabatan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * PekerjaController
 */

 @RestController
 @RequestMapping("/api/jabatan")
public class JabatanController {

    @Autowired
    private JabatanService jabatanService;

    @GetMapping("/")
    void memo(){

    }

    @GetMapping("/semua")
        List<Jabatan> getJabatan() {
           return jabatanService.getJabatanList();
        }


@GetMapping("/cariByJawatan/{jabatan}")
List<Jabatan> cariByJabatan(@PathVariable String jabatan) {
   return jabatanService.findByJabatan(jabatan);
   
}
    
}