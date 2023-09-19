package au.com.keithdavidson.springwebdisandpit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebDiSandpitApplication {
  private static final Logger log = LoggerFactory.getLogger(SpringWebDiSandpitApplication.class);

  /**
   * To test:
   * Run the application.
   * Open a web browser to http://localhost:8080/ It will display an error page.
   * Refresh the page to load it again.
   * Output will be similar to this below. Note the hashcode for each singleton
   * bean doesn't change, but the bean scoped to Request does change.
   *
   * MyServiceBean hashcode=1669591464
   * MyScopedServiceBean hashcode=1082962598
   * MyRepository myRepository=98435727
   * MyComponent myComponent=772769801
   * MyServiceBean hashcode=1669591464
   * MyScopedServiceBean hashcode=1032438158
   * MyRepository myRepository=98435727
   */
  public static void main(String[] args) {
    System.out.println("Running app started.");
    SpringApplication.run(SpringWebDiSandpitApplication.class, args);
    System.out.println("Running app done.");
  }
}
