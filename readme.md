# Create Web App using Spring Boot

Created using spring.io

### Dependencies 

  - [x] Spring Web (comes with embedded Tomcat Server which runs the web app)
  - [x] Create as JAR 

### Webapp

* Create a webapp directory, add index.jsp page which has HTML content starting with below line.

```
<%@page language="java" %>
```


### Controller

* In Spring MVC, _Request goes to controller_ so simply adding `index.jsp` file in a directory will not display the JSP content on localhost://8080
* When we create a `Controller`, a simple class in our app package and add `@Controller` annotation to the Java class, Springboot automatically converts the **controller to a Servlet**
* `Controller` is responsible to call `index.jsp`
* To map the request url, use `@RequestMapping("/")` above the home method which returns the jsp page as string.

    ```
    @Controller
    public class HomeController {
    
        @RequestMapping("/")
        public String home() {
            System.out.println("home");
            return "index.jsp";
        }
    
    }
    ```

* By default, _Spring boot does not support JSP_, Tomcat only supports `Servlet` and all `JSP` content needs to be converted to `Servlet`, to achieve this we will use a helper 
**Tomcat Jasper**
* Add `Tomcat Jasper` from mvnregistry to `pom.xml` and run the app. 
* http://localhost:8080 will now show content of `index.jsp`.

### Sending data to Controller

* Add form to `index.jsp` and add `action=add` attribute, when form is submitted the form input is sent in URL as **localhost:8080/add?num1=2&num2=4**
* Spring allows us to have **multiple requests mapped to one particular controller**.  
* If we have Ecommerce website, everything related to Add/Delete/Update user can be put in 1 controller.

### Accepting data in Controller

* Dispatch a servlet is responsible to map all the requests with the methods like add/home.
* To accept data from client, include `public String add(HttpServletRequest req){}` to the method, and Spring is responsible for providing the request object
* Use `req.getParameter("num1")` to read values from Client request.
* To send computed data to `result.jsp`
* _To write java code inside JSP, write within `<%%>`_
* To pass processed data to JSP page, use `session` obj of HttpSession

    ```
        @RequestMapping("add")
        public String add(HttpServletRequest req, HttpSession session) { //new page
    
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            int result = num1 + num2;
    
            session.setAttribute("result", result);
    
            return "result.jsp";
        }
    ```
* Access session data in JSP, using `session.getAttribute("result")` with <%%>.
* Model allows us to pass data from _controller to view_.

### Setting prefix and suffix

Move `index.jsp` and `result.jsp` to a new directory `views` within webapp and set prefix and suffix in `application.properties`

    ```
    spring.mvc.view.prefix=/views/
    spring.mvc.view.suffix=.jsp
    ```