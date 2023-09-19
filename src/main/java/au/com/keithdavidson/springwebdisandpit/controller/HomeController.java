package au.com.keithdavidson.springwebdisandpit.controller;

import au.com.keithdavidson.springwebdisandpit.components.MyComponent;
import au.com.keithdavidson.springwebdisandpit.repository.MyRepository;
import au.com.keithdavidson.springwebdisandpit.service.MyScopedServiceBean;
import au.com.keithdavidson.springwebdisandpit.service.MyServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@Scope("request")
public class HomeController {
//    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private MyServiceBean myServiceBean;

    @Autowired
    private MyScopedServiceBean myScopedServiceBean;

    // doesn't work, as MyPojo isn't annotated so that it is picked up by the Context
    // Needs one of various annotations: @Component, @Service, @Repository, @Controller
//    @Autowired
//    private MyPojo myPojo;

    @Autowired
    private MyRepository myRepository;

    @Autowired
    private MyComponent myComponent;

    // Home page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("MyServiceBean hashcode=" + myServiceBean.hashCode()); // Singleton
        System.out.println("MyScopedServiceBean hashcode=" + myScopedServiceBean.hashCode()); // Request scope.
//        System.out.println("MyPojo hashcode=" + myPojo.hashCode());
        System.out.println("MyRepository myRepository=" + myRepository.hashCode()); // Singleton
        System.out.println("MyComponent myComponent=" + myComponent.hashCode()); // Singleton

        Date date = new Date();
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(
                        DateFormat.LONG,
                        DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate );

        return "Home Page";
    }
}
