# Jake_Varney_p1

## Project Description
This project created a simple web API that would connect to a SOAP service and a RESTful service. This was done in order to create a RESTful user facing service that would sell both DnD books and Dice to a prospective customer. The initial idea for this was for a customer to call in to the service and place an order by their individual ID numbers. It is very similar to a service like Seventh Avenue with a mailed out catalog. 

## Technologies Used
- Spring Tool Suite 4.14.0
- Spring Boot 2.6.7
- Java 8
- Spring Dev Tools
- PostgreSQL
- JaxWS 3.5.2
- Amazon Web Services(AWS)
- DBeaver
- Advanced Rest Client(ARC)

## Features
- Create New DnD Books
- Add your own Dice Sets
- Order any of the books/dice
- View all available items for sale

### To do List
- Implement findall() function from Book_Service into Front_Service
- Add a Queue using ActiveMQ
- Add a Topic using ActiveMQ


## Getting Started
First you will need to download the following programs to get started:
- Spring Tool Suite IDE (https://spring.io/tools)
- Advanced Rest Client or Postman (https://install.advancedrestclient.com/install) or (https://www.postman.com/)
- Git Bash (https://gitforwindows.org/)

You can then use any Database option of your preference. I used AWS for hosting the database and used PostgreSQL myself.

After this you will need to clone the git repository using git clone in git Bash.
git clone https://github.com/4-4-2022/Jake_Varney_p1.git

Following this, you just need to set the workspace in Spring Tool suite to whereve you cloned the repository to.

## Usage
Once you have downloaded the required code and programs, you will need to open the project in the Spring Tool Suite Workspace that you have designated. 

You will then need to run all of the services in this order: 
1. Dice_Service
2. Book_Service
3. Front_Service

(The main one that you **need** to run first is the Dice Service, as the Front_Service has a connection on startup that relies on that service being awake.)

Following this you will then need to open and run ARC. This software will allow you to test the endpoints of the program and make orders.

From here, everything should be done through the Front_Service web address http://localhost:8082

Then you will add a / to the end and add whatever end point you want, such as this POST request to the Book_Service:

Another example would be looking at the available dice in the following GET request:


