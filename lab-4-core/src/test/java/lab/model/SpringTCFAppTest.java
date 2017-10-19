package lab.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@NoArgsConstructor
@Setter
@ContextConfiguration("classpath:application-context.xml")
public class SpringTCFAppTest {

  @Autowired
  private UsualPerson person;
  private UsualPerson expectedPerson;

//  @Autowired
//  SpringTCFAppTest(UsualPerson person){
//    this.person = person;
//  }
  // !В тестах должен быть один публичный конструктор!



  @Before
  public void setUp() throws Exception {
    expectedPerson = getExpectedPerson();
  }

  @Test
  public void testInitPerson() {
    assertEquals(expectedPerson, person);
    System.out.println(person);
  }

  private UsualPerson getExpectedPerson() {
    UsualPerson person = new UsualPerson();
    person.setAge(60);
    person.setHeight(1.78F);
    person.setProgrammer(false);
    person.setName("Obi Van Kenobi");

    Country country = new Country(1, "Tatuin", "TA");

    person.setCountry(country);

    List<String> contacts = new ArrayList<>();
    contacts.add("e-mail: obi.van@xyz.com");
    contacts.add("skype: kenobi");

    person.setContacts(contacts);

    return person;
  }

}
