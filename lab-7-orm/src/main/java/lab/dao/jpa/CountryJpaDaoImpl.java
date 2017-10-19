package lab.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

  @Override
  public void save(Country country) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    transaction.begin();
    em.persist(country);
    transaction.commit();

    em.close();
  }

  @Override
  public List<Country> getAllCountries() {
    EntityManager em = emf.createEntityManager();

    String hql = "FROM Country";
    List<Country> countries = em.createQuery(hql, Country.class).getResultList();

    em.close();

    return countries;
  }

  @Override
  public Country getCountryByName(String name) {
    EntityManager em = emf.createEntityManager();

    String hql = String.format("from Country C where C.name = '%s'", name) ;
    Country country = em.createQuery(hql, Country.class).getSingleResult();

    em.close();

    return country;
  }
}
