# marketing
Sample microservices in Spring boot and Axon framework to implement  Command Query Responsibility Segregation (CQRS) pattern.

### Use case
Capability for customers to store their marketing preferences (post / email / sms).

### Build and run your app with Compose
From your project directory, start up your application by running docker-compose up.
```
$ docker-compose up --build
```
### Test the services
Sample http requests.

1. New customer registration with all preferences set to false by default. Expected response is customer id.
    ``` 
   POST http://localhost:8080/register
   ```
2. Update customer preferences. Replace customer_id with the response from request 1.
   ```
   POST http://localhost:8080/customer/{customer_id}/preferences
   ```
3. Query customer preferences. Replace customer_id with the response from request 1.
    ```
   GET http://localhost:8081/customer/{customer_id}/preferences
   ```
   
### Kubernetes deployment
Apply the files in the kubernetes folder of the project directory.
* 1_axonserver.yaml (provided by Axon)
    ```
    kubectl apply -f 1_axonserver.yaml
    ```
* 2_preferences_command.yml
    ```
  kubectl apply -f 2_preferences_command.yml
    ```
* 3_preferences_query.yml
    ```
  kubectl apply -f 3_preferences_query.yml
    ```