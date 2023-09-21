package au.com.keithdavidson.springwebdisandpit.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MyScopedServiceBeanImpl implements MyScopedServiceBean {
  private int empId;

  @Override
  public int getEmpId() {
    return empId;
  }

  @Override
  public void setEmpId(int empId) {
    this.empId = empId;
  }
}
