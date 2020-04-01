package my.test.demo.features.pekerja;

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
 @RequestMapping("/api/pekerja")
public class PekerjaController {

    @Autowired
    private PekerjaService pekerjaService;

    @GetMapping("/")
    void memo(){

    }

    @GetMapping("/semua")
        List<Pekerja> getPekerja(){
           return pekerjaService.getPekerjaList();
        }


@GetMapping("/cariByJawatan/{jawatan}")
List<Pekerja> cariByJawatan(@PathVariable String jawatan) {
   return pekerjaService.findByJawatan(jawatan);
   
}
    
}