package au.com.keithdavidson.springwebdisandpit.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceBean {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
