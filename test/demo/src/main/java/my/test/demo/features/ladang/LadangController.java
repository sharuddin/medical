package my.test.demo.features.ladang;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * DetailController
 */

 @Slf4j
 @RestController
 @RequestMapping ("/api/v1/ladang")
public class LadangController { 
    private LadangService ladangService;

        public LadangController(LadangService ladangService) {
            this.ladangService = ladangService;
        }

        @GetMapping("/all")
        public List<Ladang> getAll() {
            return this.ladangService.getAll();
        }

        @GetMapping("/dt")
        public HashMap<String, Object> getDT(@Valid LadangTableInput ladangTableInput) {
            HashMap<String, Object> map = new HashMap<>();
        map.put("count", this.ladangService.getRecordCount(ladangTableInput));
        map.put("results", this.ladangService.ltLadang(ladangTableInput));
        log.info("{}", map);
        return map;
    }

    @GetMapping("/{id}")
    public Ladang getLadang(@PathVariable long id) {
        return ladangService.getLadangById(id);
    }

    @PostMapping("")
    @Transactional
    public Ladang save(@Valid @RequestBody Ladang ladang) {
        return ladangService.save(ladang);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        ladangService.delete(id);
    }
    }
