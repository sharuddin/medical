package my.test.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import my.test.demo.features.ladang.Ladang;
import my.test.demo.features.ladang.LadangRepository;
import my.test.demo.features.ladang.LadangService;
import my.test.demo.features.ladang.LadangTableInput;

@Slf4j
@DataJpaTest

public class LadangDataJpaTest {
    LadangService ladangService;

    @Test 
    public void should_return_result_with_input_search(@Autowired LadangRepository ladangRepository) {
        ladangService = new LadangService(ladangRepository);
        LadangTableInput lti = new LadangTableInput();
        lti.setPageNumber(1);
        lti.setPageSize(5);
        lti.setSortColumn("nama");
        lti.setSortDirection("desc");
        lti.setSearchInput("00");
        List<Ladang> li = ladangService.ltLadang(lti);
        log.info("{}", li);;  
    }
    @Test
    public void should_return_result_without_input_search(@Autowired LadangRepository ladangRepository) {
        ladangService = new LadangService(ladangRepository);
        LadangTableInput lti = new LadangTableInput();
        lti.setPageNumber(1);
        lti.setPageSize(5);
        lti.setSortColumn("nama");
        lti.setSortDirection("desc");
        lti.setSearchInput("");
        List<Ladang> li = ladangService.ltLadang(lti);
        log.info("{}", li);
}
}