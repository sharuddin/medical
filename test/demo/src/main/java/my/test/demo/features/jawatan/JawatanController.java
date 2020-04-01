package my.test.demo.features.jawatan;

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
 @RequestMapping("/api/jawatan")
public class JawatanController {

    @Autowired
    private JawatanService jawatanService;

    @GetMapping("/")
    void memo(){

    }

    @GetMapping("/semua")
        List<Jawatan> getJawatan(){
           return jawatanService.getJawatanList();
        }


@GetMapping("/cariByJawatan/{jawatan}")
List<Jawatan> cariByJawatan(@PathVariable String jawatan) {
   return jawatanService.findByJawatan(jawatan);
   
}
    
}