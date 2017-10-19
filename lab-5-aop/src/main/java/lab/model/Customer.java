package lab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer implements Person {

  private String name;
  private boolean broke;

  public Customer(String name) {
    this.name = name;
  }

  public void sayHello(Person person) {
  }
}
