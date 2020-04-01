package my.test.demo.features.pusatkesihatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * HospitalRepository
 */
public interface PusatKesihatanRepository extends JpaRepository<PusatKesihatan, Long>, JpaSpecificationExecutor<PusatKesihatan> {

    
}