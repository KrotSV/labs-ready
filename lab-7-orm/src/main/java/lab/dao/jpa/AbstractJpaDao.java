package lab.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AbstractJpaDao {

  EntityManagerFactory emf;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }
}