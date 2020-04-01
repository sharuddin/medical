package my.test.demo.features.pusatkesihatan;

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
 * HospitalController
 *
 */
@Slf4j
 @RestController
 @RequestMapping ("/api/v1/pusatkesihatan")
public class PusatKesihatanController {
    private PusatKesihatanService pusatkesihatanService;

    public PusatKesihatanController(PusatKesihatanService pusatkesihatanService) {
            this.pusatkesihatanService = pusatkesihatanService;
        }

        @GetMapping("/all")
        public List<PusatKesihatan> getAll() {
            return this.pusatkesihatanService.getAll();
        }

        @GetMapping("/dt")
        public HashMap<String, Object> getDT(@Valid PusatKesihatanTableInput direktoriTableInput) {
            HashMap<String, Object> map = new HashMap<>();
        map.put("count", this.pusatkesihatanService.getRecordCount(direktoriTableInput));
        map.put("results", this.pusatkesihatanService.dtPusatKesihatan(direktoriTableInput));
        log.info("{}", map);
        return map;
    }

    @GetMapping("/{id}")
    public PusatKesihatan getPusatKesihatan(@PathVariable long id) {
        return pusatkesihatanService.getPusatKesihatanById(id);
    }

    @PostMapping("")
    @Transactional
    public PusatKesihatan save(@Valid @RequestBody PusatKesihatan pusatkesihatan) {
        return pusatkesihatanService.save(pusatkesihatan);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        pusatkesihatanService.delete(id);
    }
    }