# Spring Web DI Sandpit

A sandpit for playing with Dependency Injection using the Spring Web framework.

The purpose is to try out different annotations and so on to see what happens.

I'm using Annotation Based Configuration.

### Annotations Used
@SpringBootApplication  
(Equivalent to using all of: @Configuration, @EnableAutoConfiguration, and @ComponentScan)  

@Configuration    
@Bean  

@Component
@Service  
@Repository  
@Controller  
@Scope(WebApplicationContext.SCOPE_REQUEST)

### To Run  
Run the application.  
Open a web browser to http://localhost:8080/ 
It will display some basic bean hash codes and info.
It is also output to System.out. I've used this instead of the log so that it stands out better. 
Refresh the page to load it again.  
Note the hashcode for each singleton bean doesn't change, but the bean scoped to Http Request does change.  

#### Typical Output
myServiceBean hashcode = 2112406815  
myScopedServiceBean hashcode = 1328896401  
myRepository hashcode = 458162722  
myComponent hashcode = 323006048  
MyServiceBean implementation = MyServiceBeanOtherImpl  

myServiceBean hashcode = 2112406815  
myScopedServiceBean hashcode = 509793834  
myRepository hashcode = 458162722  
myComponent hashcode = 323006048  
MyServiceBean implementation = MyServiceBeanOtherImpl  




