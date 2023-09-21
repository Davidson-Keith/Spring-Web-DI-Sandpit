package au.com.keithdavidson.springwebdisandpit;

import au.com.keithdavidson.springwebdisandpit.service.MyServiceBean;
import au.com.keithdavidson.springwebdisandpit.service.MyServiceBeanImpl;
import au.com.keithdavidson.springwebdisandpit.service.MyServiceBeanOtherImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The interface MyServiceBean is implemented by two classes: MyServiceBeanImpl, and MyServiceBeanOtherImpl.
 * Thus, to autowire MyServiceBean in our HomeController class, we must specify which particular implementation
 * we want to inject. This is specified in the myServiceBean method, which is annotated with the @Bean configuration
 * annotation.
 *
 * This class is annotated with @Configuration, which tells Spring that it contains Bean configurations.
 *
 * Note that the @SpringBootApplication annotation used by our SpringWebDiSandpitApplication main class, also
 * indicates that that class is a @Configuration class. Thus, our @Bean method below could instead go into
 * our @SpringBootApplication class.
 */
@Configuration
public class ServiceConfiguration {

  /**
   * Explicitly chooses which of MyServiceBeanImpl, or MyServiceBeanOtherImpl to use whenever
   * MyServiceBean myServiceBean is autowired within the application.
   *
   */
  @Bean
  public MyServiceBean myServiceBean() {
//    return new MyServiceBeanImpl();
    return new MyServiceBeanOtherImpl();
  }

  /**
   * Another implementation of MyServiceBean can also be used by creating a second method.
   */
//  @Bean
//  public MyServiceBean myServiceBeanSecondary() {
//    return new MyServiceBeanImpl();
////    return new MyServiceBeanOtherImpl();
//  }
}