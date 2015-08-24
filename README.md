# Spring Boot People API

This Spring Boot project uses Spring Data REST to expose methods for managing People and Families.

Objects are persisted using an in-memory database (H2) that is initialized with 3 people and 1 family.

## Person
A person can be added, delete, and updated.  If a family exists, a person can be added to a family. 

### Properties
- First name
- Last name
- Age

### Add Person

	curl -i -X POST -H "Content-Type:application/json" \
	-d 	'{"firstName":"George", "lastName":"Costanza", "birthDate":"1960-06-07" }'\
	http://localhost:8080/person
	
### Remove Person
	
	curl -i -X DELETE http://localhost:8080/person/{id}

### Update Person Birth Date

	curl -i -X PATCH -H "Content-Type:application/json" \
	-d '{"birthDate":"1960-11-11"}' \
	-http://localhost:8080/person/{id}
	
### Set Person Family

	curl -v -X PUT -H "Content-Type: text/uri-list" \
     -d "http://localhost:8080/family/{id}" \
     http://localhost:8080/person/{id}/family


## Family
A family can be added, deleted, and updated.  Removing a family does not remove the people included in that family.

### Properties
- Name

### Add family

	curl -i -X POST -H "Content-Type:application/json" -d 	'{"name":"Costanza"}' http://localhost:8080/family
	
### Remove Family

	curl -i -X DELETE http://localhost:8080/family/{id}

### Change Family Name

	curl -i X PATCH -H "Content-Type:application/json" \
	-d '{"name":"New Family Name"}' \
	-http://localhost:8080/family/{id}

