# Spring Web DI Sandpit

A sandpit for playing with Dependency Injection using the Spring Web framework.

I'm using Annotation Based Configuration.

### To test  
Run the application.  
Open a web browser to http://localhost:8080/ It will display an error page.  
Refresh the page to load it again.  
Note the hashcode for each singleton bean doesn't change, but the bean scoped to Request does change.  

#### Typical output
MyServiceBean hashcode=1669591464  
MyScopedServiceBean hashcode=1082962598  
MyRepository myRepository=98435727  
MyComponent myComponent=772769801  
MyServiceBean hashcode=1669591464  
MyScopedServiceBean hashcode=1032438158   
MyRepository myRepository=98435727  



