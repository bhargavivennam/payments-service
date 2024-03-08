Step by step process to create a soap web application

First generate a project from https://start.spring.io/ by adding spring web and spring web services dependencies

Add wsdl4j dependency to pom.xml

Create xsd file to define domain object -> Contains getRequest and getResponse parameters

Add a jaxb2 maven plugin to pom.xml and configure source and output directory(optional) 

Perform mvn clean install this generates java files for request, response in the target -> jab folder for inputs defined in the xsd file

Create a Repository to define setters and getters

Create a service endpoint to manage incoming soap requests

Configure Beans, this bean names will determine the URL at which the web service and the generated WSDL file can be accessed.

Run the application and hit the endpoint http://localhost:8080/ws/custom_name.wsdl
