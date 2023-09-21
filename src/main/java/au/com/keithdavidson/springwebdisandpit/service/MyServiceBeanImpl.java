package au.com.keithdavidson.springwebdisandpit.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceBeanImpl implements MyServiceBean {
  private String name = "MyServiceBeanImpl";

  public MyServiceBeanImpl(){
    System.out.println("MyServiceBeanImpl() constructor called.");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
