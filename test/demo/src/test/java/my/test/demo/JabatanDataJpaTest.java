package my.test.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import my.test.demo.features.jabatan.Jabatan;
import my.test.demo.features.jabatan.JabatanRepository;
import my.test.demo.features.jabatan.JabatanService;
import my.test.demo.features.jabatan.JabatanTableInput;





@Slf4j
@DataJpaTest

public class JabatanDataJpaTest {
    JabatanService jabatanService;

    @Test
    public void should_return_result_with_input_search(@Autowired JabatanRepository jabatanRepository) {
        jabatanService = new JabatanService(jabatanRepository);
        JabatanTableInput dti = new JabatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jabatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("00");
        List<Jabatan> li = jabatanService.dtJabatan(dti);
        log.info("{}", li);
        ;
    }

    @Test
    public void should_return_result_without_input_search(@Autowired JabatanRepository jabatanRepository) {
        jabatanService = new JabatanService(jabatanRepository);
        JabatanTableInput dti = new JabatanTableInput();
        dti.setPageNumber(1);
        dti.setPageSize(5);
        dti.setSortColumn("jabatan");
        dti.setSortDirection("desc");
        dti.setSearchInput("");
        List<Jabatan> li = jabatanService.dtJabatan(dti);
        log.info("{}", li);
}
}