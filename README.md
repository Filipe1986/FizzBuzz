# Fizz Buzz Bazz

Write a rest service that has 1 endpoint using Spring Boot 2.X, you can choose between java or kotlin for the programming language:

Endpoint: /fizzbuzz?entry=[int]

The output is formatted in JSON
That endpoint will apply the fizzbuzz output with the following rules:

    If the entry is a multiple of 3, the output must be "fizz"
    
    If the entry is a multiple of 5, the output must be "buzz"
    
    If the entry is a multiple of 3 and 5, the output must be "fizzbuzz"
    

Otherwise the output must be the entry
    An error is thrown if the entry is not a Int
    If there is no entry or it's empty, the output must be an array with all the answers from 1 to 100
 
I expect unittest and integration tests

Optionnal things to do:
- Write a Dockerfile and a docker-compose file to run the rest service
- Allow to pass an array of entries and give the anwser for each element of the entry in the output
- Implement another rule: 

        If the entry if multiple of 7 then output "Bazz"

        if multiple of 3 and 7 output "FizzBazz"

        if multiple of 5 and 7 output "BuzzBazz"

        if multiple of 3, 5 and 7 output "FizzBuzzBazz"


### Running local on container:

mvn clean package

cd deps
Docker-compose build
Docker-compose up