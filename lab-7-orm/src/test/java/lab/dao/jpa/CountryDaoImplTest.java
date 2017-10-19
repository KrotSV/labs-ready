package lab.dao.jpa;

import static org.junit.Assert.assertEquals;

import java.util.List;
import lab.dao.CountryDao;
import lab.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CountryDaoImplTest {

  private Country exampleCountry = new Country("Australia", "AU");

  @Autowired
  private CountryDao countryDao;

  @Before
  public void setUp() throws Exception {
    countryDao.save(exampleCountry);
  }

  @Test
  public void testSaveCountry() {
    List<Country> countryList = countryDao.getAllCountries();
    assertEquals(1, countryList.size());
    assertEquals(exampleCountry, countryList.get(0));
  }

  @Test
  public void testGetAllCountries() {
    countryDao.save(new Country("Canada", "CA"));

    List<Country> countryList = countryDao.getAllCountries();
    assertEquals(2, countryList.size());
  }

  @Test
  public void testGetCountryByName() {
    Country country = countryDao.getCountryByName("Australia");
    assertEquals(exampleCountry, country);
  }

}
