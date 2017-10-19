package lab.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleAppTest {

  protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

  private AbstractApplicationContext context;

  private UsualPerson expectedPerson;

  @Before
  public void setUp() throws Exception {
    context = new ClassPathXmlApplicationContext(
        APPLICATION_CONTEXT_XML_FILE_NAME);
    expectedPerson = getExpectedPerson();
  }

  @Test
  public void testInitPerson() {
    UsualPerson person = (UsualPerson) context.getBean("person");
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

    List<String> contacts = Arrays.asList("e-mail: obi.van@xyz.com", "skype: kenobi");

    person.setContacts(contacts);

    return person;
  }
}
