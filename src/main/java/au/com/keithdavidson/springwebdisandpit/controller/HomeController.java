package au.com.keithdavidson.springwebdisandpit.controller;

import au.com.keithdavidson.springwebdisandpit.Utils;
import au.com.keithdavidson.springwebdisandpit.components.MyComponent;
import au.com.keithdavidson.springwebdisandpit.pojos.MyPojo;
import au.com.keithdavidson.springwebdisandpit.repository.MyRepository;
import au.com.keithdavidson.springwebdisandpit.service.MyScopedServiceBean;
import au.com.keithdavidson.springwebdisandpit.service.MyServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("request")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * There are two possible instantiations of MyServiceBean: MyServiceBeanImpl, and MyServiceBeanOtherImpl. Thus,
     * this needs to be explicitly specified, and is done via our ServiceConfiguration class. This allows a single
     * point of configuration, and all usages of MyServiceBean throughout the application can be injected accordingly.
     */
    @Autowired
    private MyServiceBean myServiceBean;

    @Autowired
    private MyScopedServiceBean myScopedServiceBean;

    // @Autowired doesn't work, as MyPojo isn't annotated so that it is picked up by the Context
    // MyPojo needs one of various annotations: @Component, @Service, @Repository, @Controller.
    // We could, of course, simply instantiate it here, but then we don't have IoC and DI.
    // Uncommenting @Autowired will throw an org.springframework.beans.factory.NoSuchBeanDefinitionException
//    @Autowired
    private MyPojo myPojo;

    @Autowired
    private MyRepository myRepository;

    @Autowired
    private MyComponent myComponent;

    // Home page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> home() {
        return new ResponseEntity<>(buildResponseBody(), HttpStatus.OK);
    }

    private String buildResponseBody() {
        String[] messages = createMessages();
        log(messages);
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>Spring Web DI Sandpit - Home Page.</h1>");
        for (String message : messages){
            builder.append(message);
            builder.append("<BR>");
        }
        return builder.toString();
    }

    private String[] createMessages() {
        String serviceBeanHash = "myServiceBean hashcode = " + myServiceBean.hashCode(); // Singleton
        String scopedServiceBeanHash = "myScopedServiceBean hashcode = " + myScopedServiceBean.hashCode(); // Request scope.
//        String pojoHash = "myPojo hashcode = " + myPojo.hashCode(); // Singleton
        String repositoryHash = "myRepository hashcode = " + myRepository.hashCode(); // Singleton
        String componentHash = "myComponent hashcode = " + myComponent.hashCode(); // Singleton
        String serviceBeanImplementation = "MyServiceBean implementation = " + myServiceBean.getName();
        return new String[] {serviceBeanHash, scopedServiceBeanHash, repositoryHash, componentHash, serviceBeanImplementation};
    }

    private void log(String[] messages){
        for(String message : messages){
            Utils.println(message);
//            logger.info(message);
        }
    }
}
