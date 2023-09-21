package au.com.keithdavidson.springwebdisandpit.service;

import org.springframework.stereotype.Service;

/**
 * If the @Service is commented, then there is only a single @Service implementation of MyServiceBean, and spring uses
 * it where @Autowired is used in HomeController.
 * If @Service is uncommented, then the browser will display:
 * "There was an unexpected error (type=Internal Server Error, status=500)." when http://localhost:8080/ is loaded;
 * and Spring will throw a org.springframework.beans.factory.NoUniqueBeanDefinitionException.
 *
 */
@Service
public class MyServiceBeanOtherImpl implements MyServiceBean {

  private String prefix = "";
  private String name = "MyServiceBeanOtherImpl";

  public MyServiceBeanOtherImpl(){
    System.out.println("MyServiceBeanOtherImpl() constructor called.");
  }

  @Override
  public String getName() {
    return prefix + name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public void setPrefix(String prefix){
    this.prefix = prefix;
  }
}
