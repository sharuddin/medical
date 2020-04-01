package my.test.demo.features.pusatkesihatan;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * HospitalService
 */

 @Service
public class PusatKesihatanService {

    String[]columns = {"negeri","bandar","hospital","alamat", "telefon", "faksimile","email"};
    private final PusatKesihatanRepository pusatkesihatanRepository;

    public PusatKesihatanService(final PusatKesihatanRepository pusatkesihatanRepository){
        this.pusatkesihatanRepository = pusatkesihatanRepository;
}

public PusatKesihatan getPusatKesihatanById(long id) {
    return this.pusatkesihatanRepository.getOne(id);
}

public long getRecordCount() {
    return this.pusatkesihatanRepository.count();
}

public PusatKesihatan getPusatKesihatanByNegeri(long negeri) {
	return null;
}

public List<PusatKesihatan> getAll() {
    return this.pusatkesihatanRepository.findAll();
}

public PusatKesihatan save(final PusatKesihatan pusatKesihatan) {
    return this.pusatkesihatanRepository.saveAndFlush(pusatKesihatan);
}

private Specification getFilterSpecification(PusatKesihatanTableInput dti) {
    return new Specification() {
        private static final long serialVersionUID = -1381829247221773302L;
      

        @Override
        public Predicate toPredicate(final Root root, final CriteriaQuery query,
                final CriteriaBuilder criteriaBuilder) {

            final List<Predicate> pr = new ArrayList<>();
            // if (!lti.getSearchInput().equals(""))
            for (final String column : columns) {
                pr.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(column)),
                        contains(dti.getSearchInput().toLowerCase())));
            }
            return criteriaBuilder.or(pr.toArray(new Predicate[0]));
        }
    };
}

public long getRecordCount(PusatKesihatanTableInput dti) {
    return dti.getSearchInput().equals("") ? this.pusatkesihatanRepository.count()
            : this.pusatkesihatanRepository.count (getFilterSpecification(dti));
}

public List<PusatKesihatan> dtPusatKesihatan(PusatKesihatanTableInput dti) {
    final Pageable paging = PageRequest.of(dti.getPageNumber(), dti.getPageSize(),
        dti.getSortDirection().equals("asc") ? Sort.by(dti.getSortColumn()).ascending()
                    : Sort.by(dti.getSortColumn()).descending());
    final Page<PusatKesihatan> pagedResult = dti.getSearchInput().equals("") ? pusatkesihatanRepository.findAll(paging)
            : pusatkesihatanRepository.findAll(getFilterSpecification(dti), paging);

    if (pagedResult.hasContent()) {
        return pagedResult.getContent();
    } else {
        return new ArrayList<PusatKesihatan>();
    }
}

private static String contains(final String expression) {
    return MessageFormat.format("%{0}%", expression);
}



public void delete(long id) {
}





}

