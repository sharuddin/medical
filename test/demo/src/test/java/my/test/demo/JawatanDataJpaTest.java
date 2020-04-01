package my.test.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import my.test.demo.features.jawatan.Jawatan;
import my.test.demo.features.jawatan.JawatanRepository;
import my.test.demo.features.jawatan.JawatanService;
import my.test.demo.features.jawatan.JawatanTableInput;




@Slf4j
@DataJpaTest

public class JawatanDataJpaTest {
    JawatanService jawatanService;

    @Test
    public void should_return_result_with_input_search(@Autowired JawatanRepository jawatanRepository) {
        jawatanService = new JawatanService(jawatanRepository);
        JawatanTableInput dti = new JawatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jawatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("00");
        List<Jawatan> li = jawatanService.dtJawatan(dti);
        log.info("{}", li);
        ;
    }

    @Test
    public void should_return_result_without_input_search(@Autowired JawatanRepository jawatanRepository) {
        jawatanService = new JawatanService(jawatanRepository);
        JawatanTableInput dti = new JawatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jawatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("");
        List<Jawatan> li = jawatanService.dtJawatan(dti);
        log.info("{}", li);
}
}