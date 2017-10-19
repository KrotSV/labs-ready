package lab.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class UsualPerson implements Person {

  private int id;
  private String name;

  private Country country;

  private int age;
  private float height;
  private boolean isProgrammer;

  private List<String> contacts;

  @Override
  public void sayHello(Person person) {

  }
}