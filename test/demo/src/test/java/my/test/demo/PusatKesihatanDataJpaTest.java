package my.test.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import my.test.demo.features.pusatkesihatan.PusatKesihatan;
import my.test.demo.features.pusatkesihatan.PusatKesihatanRepository;
import my.test.demo.features.pusatkesihatan.PusatKesihatanService;
import my.test.demo.features.pusatkesihatan.PusatKesihatanTableInput;


@Slf4j
@DataJpaTest

public class PusatKesihatanDataJpaTest {
    PusatKesihatanService pusatkesihatanService;

    @Test
    public void should_return_result_with_input_search(@Autowired PusatKesihatanRepository pusatkesihatanRepository) {
        pusatkesihatanService = new PusatKesihatanService(pusatkesihatanRepository);
        PusatKesihatanTableInput dti = new PusatKesihatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("negeri");
        dti.setSortDirection("desc");
        dti.setSearchInput("00");
        List<PusatKesihatan> li = pusatkesihatanService.dtPusatKesihatan(dti);
        log.info("{}", li);
        ;
    }

    @Test
    public void should_return_result_without_input_search(@Autowired PusatKesihatanRepository pusatkesihatanRepository) {
        pusatkesihatanService = new PusatKesihatanService(pusatkesihatanRepository);
        PusatKesihatanTableInput dti = new PusatKesihatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("negeri");
        dti.setSortDirection("desc");
        dti.setSearchInput("");
        List<PusatKesihatan> li = pusatkesihatanService.dtPusatKesihatan(dti);
        log.info("{}", li);
}
}