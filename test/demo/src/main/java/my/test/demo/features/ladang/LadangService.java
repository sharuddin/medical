package my.test.demo.features.ladang;

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
 * SoilService
 */
@Service
public class LadangService {

    String[] columns = { "nama", "kategori", "telefon" };
    private final LadangRepository ladangRepository;

    public LadangService(final LadangRepository ladangRepository) {
        this.ladangRepository = ladangRepository;
    }

    public Ladang getLadangById(long id) {
        return this.ladangRepository.getOne(id);
    }

    public long getRecordCount() {
        return this.ladangRepository.count();
    }

    public List<Ladang> getAll() {
        return this.ladangRepository.findAll();
    }

    public Ladang save(final Ladang ladang) {
        return this.ladangRepository.saveAndFlush(ladang);
    }

    public void delete(final Long id) {
        this.ladangRepository.deleteById(id);
    }

    private Specification getFilterSpecification(LadangTableInput lti) {
        return new Specification() {
            private static final long serialVersionUID = -1381829247221773302L;

            @Override
            public Predicate toPredicate(final Root root, final CriteriaQuery query,
                    final CriteriaBuilder criteriaBuilder) {
                final List<Predicate> pr = new ArrayList<>();
                // if (!lti.getSearchInput().equals(""))
                for (final String column : columns) {
                    pr.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(column)),
                            contains(lti.getSearchInput().toLowerCase())));
                }
                return criteriaBuilder.or(pr.toArray(new Predicate[0]));
            }
        };
    }

    public long getRecordCount(LadangTableInput lti) {
        return lti.getSearchInput().equals("") ? this.ladangRepository.count()
                : this.ladangRepository.count(getFilterSpecification(lti));
    }

    public List<Ladang> ltLadang(LadangTableInput lti) {
        final Pageable paging = PageRequest.of(lti.getPageNumber(), lti.getPageSize(),
            lti.getSortDirection().equals("asc") ? Sort.by(lti.getSortColumn()).ascending()
                        : Sort.by(lti.getSortColumn()).descending());
        final Page<Ladang> pagedResult = lti.getSearchInput().equals("") ? ladangRepository.findAll(paging)
                : ladangRepository.findAll(getFilterSpecification(lti), paging);

		if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Ladang>();
        }
    }

    private static String contains(final String expression) {
        return MessageFormat.format("%{0}%", expression);
    }

}

