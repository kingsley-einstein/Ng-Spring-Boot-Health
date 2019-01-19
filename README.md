A Health management app built using Angular 7 and Spring Boot 


----------------------------------------------------------------------------

* Clone and download project
* CD into Health-App-Server directory and run "mvn clean install". It is necessary to have Maven to run this command successfully.
* CD into Health-App-Client directory and run "npm install" to install node dependencies.
* To run Spring Boot App, CD into the server directory and run "java -jar Health-App-1.0-SNAPSHOT.jar". This would start the embedded database server and also run the main server. By default this uses the port number "8080" but this can be changed in the application.yml file or application.properties file depending on which you use.
* To run the Angular live server, CD into the client directory and run "npm start" or "ng serve -o"