# Backend Java-Spring Challenge

Author: Santiago Garcia Tech<br>
Created: Feb 17, 2021 6:12 PM<br>
Done: Yes<br>
Link: https://github.com/san99tiago/LEARNING_JAVA<br>
Platform: Github<br>
Topic: Spring<br>

# Challenge Requirements

With the purpose of a Proof of Concept in a backend Java path, this challenge is a way of showing some of my abilities with Java, Spring Framework, Spring Boot, Microservices and problem solving with these learnt technologies.

## General Information

We must design a complete REST-API that a frontend system will use, but both systems must be decoupled (nothing from the frontend must be designed in this challenge). The general purpose is to design this REST-API with two databases: MySQL for the client's information and MongoDB for the client's photos (in a base-64 encoded text format).

All the information will be consumed by a frontend service via HTTP requests and should be able to add and receive information from the REST-API in a JSON-like way.

## Clients Information

The clients have important data and it must be stored in a relational database (MySQL). The name of the database must be "clients" and it should have the following fields:

- Names
- Last name
- Id Type
- Id Value
- Age
- Born City

## Client's Photos Information

Some of our clients have photos and some of them don't. For this challenge we will have a non-relational database (MongoDB) to save the client's photo in a base64 text-encoded format.

The name of the database should be "clientphotos" and the collection should be called "base64".

The important fields for the collection are:

- Id Type
- Id Value
- Photo

Id Type and Id Value are the same for the Client and for the Client's Photos, in case that the client has photos. Otherwise, the client's photo info should not be stored in the database.

## Business API Requirements

The REST-API should be able to make special types of queries to the databases and get/add the desired information of the clients and client's photo.

The basic CRUD functionalities should be implemented for the clients and the client's photo. This can be interpreted as:

- Create new clients or client's photos.
- Read existing clients and client's photos.
- Update existing clients or client's photos when a client exist.
- Delete existing clients or client's photos when it exists.

There are also some special requirements that the API must accomplish for the data of the clients and client's photos. These are:

- We should be able to check clients and client's photos based on Id Type and Id Value.
- We should be able to check clients and client's photos based on clients older than a given age (example: get all clients older than 60).

## Extra Requirements

Even if the REST-API works perfectly, there are two extra important features that must be added in order to complete the challenge:

1. It must be designed with the Test Driven Development patterns and rules, with an expected test-coverage greater than 85%, so that the future developers can have a well-designed and scalable application.
2. The REST-API must be well documented using Swagger2 or a similar tool, so that the frontend group can understand how to properly consume the API.

## Final Requirements

All the assumptions other than the given ones are valid.

We can create, design and implement any architecture based on what we consider that is the best solution.

---

### Explained by:

Santiago Garcia Arango

---
