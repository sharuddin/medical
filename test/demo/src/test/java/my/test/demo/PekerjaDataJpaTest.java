package my.test.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import my.test.demo.features.pekerja.Pekerja;
import my.test.demo.features.pekerja.PekerjaRepository;
import my.test.demo.features.pekerja.PekerjaService;
import my.test.demo.features.pekerja.PekerjaTableInput;



@Slf4j
@DataJpaTest

public class PekerjaDataJpaTest {
    PekerjaService pekerjaService;

    @Test
    public void should_return_result_with_input_search(@Autowired PekerjaRepository pekerjaRepository) {
        pekerjaService = new PekerjaService(pekerjaRepository);
        PekerjaTableInput dti = new PekerjaTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jawatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("00");
        List<Pekerja> li = pekerjaService.dtPekerja(dti);
        log.info("{}", li);
        ;
    }

    @Test
    public void should_return_result_without_input_search(@Autowired PekerjaRepository pekerjaRepository) {
        pekerjaService = new PekerjaService(pekerjaRepository);
        PekerjaTableInput dti = new PekerjaTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jawatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("");
        List<Pekerja> li = pekerjaService.dtPekerja(dti);
        log.info("{}", li);
}
}