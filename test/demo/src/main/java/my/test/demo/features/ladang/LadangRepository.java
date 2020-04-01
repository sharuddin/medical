package my.test.demo.features.ladang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * DetailRepository
 */
public interface LadangRepository extends JpaRepository<Ladang, Long>, JpaSpecificationExecutor<Ladang> {
    
}