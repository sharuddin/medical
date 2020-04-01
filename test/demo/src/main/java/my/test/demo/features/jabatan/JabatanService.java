package my.test.demo.features.jabatan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PekerjaService
 */

 @Service
public class JabatanService {
    @Autowired
    private JabatanRepository jabatanRepository;

    public JabatanService(JabatanRepository jabatanRepository) {
	}

	public List<Jabatan> getJabatanList() {
        return jabatanRepository.findAll();
    }

    public List<Jabatan> findByJabatan(String jabatan){
        return null;
    }

    public void simpanJabatan(Jabatan p2){
        
    }

	public List<Jabatan> dtJabatan(JabatanTableInput dti) {
		return null;
	}
}