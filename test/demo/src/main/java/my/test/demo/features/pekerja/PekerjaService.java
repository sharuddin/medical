package my.test.demo.features.pekerja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PekerjaService
 */

 @Service
public class PekerjaService {
    @Autowired
    private PekerjaRepository pekerjaRepository;

    public PekerjaService(PekerjaRepository pekerjaRepository) {
	}

	public List<Pekerja> getPekerjaList() {
        return pekerjaRepository.findAll();
    }

    public List<Pekerja> findByJawatan(String jawatan){
        return null;
    }

    public void simpanPekerja(Pekerja p2){
        
    }

	public List<Pekerja> dtPekerja(PekerjaTableInput dti) {
		return null;
	}
}