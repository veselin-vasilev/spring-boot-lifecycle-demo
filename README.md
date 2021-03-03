# Spring Boot Lifecycle Demo

This is a very simple demo app which I use to demonstrate everything that happens when you start a simple Web Spring Boot app. The idea is to implement as many hooks 
into the Spring lifecycle as possible, in order to highlight the different steps the application goes through until it's ready to accept traffic. 

The project has minimal dependencies and the DemoApplication class is the entry point. You can easily run it through your IDE or package and run with Maven. 

You will gain the most value from this project if you simply run the app in debug mode and place breakpoints at every stage of the code. Inspecting how the
ApplicationContext changes as you go along and how the different parts of the app are configured is super helpful to help demistify the internals of how Spring Boot
works. 
