package my.test.demo.features.jawatan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PekerjaService
 */

 @Service
public class JawatanService {
    @Autowired
    private JawatanRepository jawatanRepository;

    public JawatanService(JawatanRepository jawatanRepository) {
	}

	public List<Jawatan> getPekerjaList() {
        return jawatanRepository.findAll();
    }

    public List<Jawatan> findByJawatan(String jawatan){
        return null;
    }

    public void simpanJawatan(Jawatan p2){
        
    }

	public List<Jawatan> dtJawatan(JawatanTableInput dti) {
		return null;
	}

	public List<Jawatan> getJawatanList() {
		return null;
	}
}