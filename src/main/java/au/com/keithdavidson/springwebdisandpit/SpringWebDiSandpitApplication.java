package au.com.keithdavidson.springwebdisandpit;

import au.com.keithdavidson.springwebdisandpit.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * A Sandpit for testing out how Spring Applications work, particularly with respect to IoC/DI and annotations.
 *
 * Using @Autowired Spring can inject a dependency automatically, skipping all the usual boilerplate code that would
 * have been used otherwise.
 *
 * HomeController has a bunch of such dependencies injected. The dependency classes themselves are annotated by
 * one of: @Component, @Service, @Repository, or @Controller. Note that the last three are all also @Component
 * subtypes.
 *
 * A Component is a self configuring Bean.
 *
 * It has a default scope of Singleton, but can have various others. All our components/beans are singleton except
 * MyScopedServiceBean, which is scoped to WebApplicationContext.SCOPE_REQUEST, which means a new object is
 * instantiated for each Http Request.
 *
 * The MyRepository singleton is injected in the HomeController simply with:
 *     @Autowired
 *     private MyRepository myRepository;
 *
 * We don't have to implicitly instantiate this object/bean, as Spring can detect that there is only one possible
 * class to use (e.g. MyRepository has no subclasses which myRepository could have been instantiated as) which is
 * in the context to be picked up by Spring's AutoConfiguration and ComponentScan (which occurs due to
 * SpringWebDiSandpitApplication being annotated with @SpringBootApplication).
 *
 * The MyServiceBean singleton is more complex, because there are two possible classes which implement MyServiceBean:
 * MyServiceBeanImpl, and MyServiceBeanOtherImpl. Thus we have to tell Spring which one we want to use. We have done
 * this via the ServiceConfiguration class, which is annotated with @Configuration.
 *
 * To test:
 * Run the application.
 * Open a web browser to http://localhost:8080/ It will display the home page.
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
 * MyComponent myComponent=772769801
 */
@SpringBootApplication // same as using all three of: @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringWebDiSandpitApplication {
  private static final Logger log = LoggerFactory.getLogger(SpringWebDiSandpitApplication.class);

  // Moved to ServiceConfiguration
//  @Bean
//  public MyServiceBean myServiceBean() {
////    return new MyServiceBeanImpl();
//    return new MyServiceBeanOtherImpl();
//  }

  /**
   */
  public static void main(String[] args) {
    System.out.println("Running app started.");
    SpringApplication.run(SpringWebDiSandpitApplication.class, args);
    System.out.println("Running app done.");
  }
}
