package parts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import parts.model.Part;
import parts.utils.Filters;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class PartsDAOImp implements PartsDAO {

    private final int partsPerPage;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public PartsDAOImp(int partsPerPage) {
        this.partsPerPage = partsPerPage;
    }

    private StringBuilder getFilterBuilder(Filters filter, String search){

        StringBuilder filterString = new StringBuilder();

        if (!search.isEmpty()){
            filterString.append(" where name like '%");
            filterString.append(search);
            filterString.append("%'");
        }
        if (filter == Filters.OPTIONAL || filter == Filters.REQUIRED){
            if (!search.isEmpty()) {
                filterString.append(" and required = ?1");
            }
            else {
                filterString.append(" where required = ?1");
            }
        }

        return filterString;

    }

    public List<Part> getAllPartsFromIndex(Filters filter, String search, int page) {

        StringBuilder queryString = new StringBuilder();

        queryString.append("from Part");
        queryString.append(getFilterBuilder(filter, search).toString());
        queryString.append(" ORDER by id");

        TypedQuery<Part> query = entityManager.createQuery(queryString.toString(), Part.class);

        if (filter == Filters.OPTIONAL || filter == Filters.REQUIRED){
            query.setParameter(1, filter == Filters.REQUIRED);
        }

        return query.setFirstResult((page-1)*partsPerPage).setMaxResults(partsPerPage).getResultList();
    }

    @Override
    public long getRowCount(Filters filter, String search) {

        StringBuilder queryString = new StringBuilder();

        queryString.append("Select Count(id) from Part");
        queryString.append(getFilterBuilder(filter, search).toString());
        queryString.append(" ORDER by id");

        TypedQuery<Long> query = entityManager.createQuery(queryString.toString(), Long.class);

        if (filter == Filters.OPTIONAL || filter == Filters.REQUIRED){
            query.setParameter(1, filter == Filters.REQUIRED);
        }

        return query.getSingleResult();
    }

    @Override
    public int getComplectCount() {
        List<Long> list = entityManager.createQuery("Select sum(pt.countInt) from Part as pt where pt.required = 1 group by pt.type",Long.class).getResultList();
        return (int)(long)Collections.min(list);
    }

    @Override
    public void addPart(Part part) {
        entityManager.persist(part);
    }

    @Override
    public void upDatePart(Part part) {
        entityManager.merge(part);
    }

    @Override
    public void deletePart(long id) {
        Part part = getPart(id);
        entityManager.remove(part);
    }

    @Override
    public Part getPart(long id) {
        TypedQuery<Part> query = entityManager.createQuery("from Part where id = ?1", Part.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

}
