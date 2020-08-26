## SpringRestCRUDExample
REST CRUD operations from MongoDB Database (Spring Boot application)

This is a sample application  that demonstarte CRUD(Create, Read, Update and Delete ) operations of Book object into MangoDB database.
## How to run this on your local.
### Prerequisite: 
  You should have MangoDB running on yout localhost at port 27017. 
* Clone this repository on your local machine and import it in STS.
* Run as Spring boot application , server well start at deafult port 8080.

*Server port, MongoDB host, port, database configuration can be updated in application.properties.
Sample Rest URL for local testing:

HTTP Method: POST http : //localhost:8080/rest/book/add   
Input:
{
	"id":1,
	"name":"Math Workbook",
	"author": "Spectrum",
	"price": 10.79
}

HTTP Method: PUT http : //localhost:8080/rest/book/update
Input: {
	"id":1,
	"name":"Math Workbook",
	"author": "Spectrum",
	"price": 10.79
}

HTTP Method: GET http: //localhost:8080/rest/rest/book/1

HTTP Method: GET http: //localhost:8080/rest/book/all

HTTP Method: DELETE http: //localhost:8080/rest/book/delete/1
