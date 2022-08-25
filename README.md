# SpringBoot-K8s-CRUD-MySQL
Deploy application to  kubernetes cluster using command line

- mvn clean package
- Install Minikube
- Install Kubectl
- Install DockerDesktop


### Commands :
- minikube start
- minikube status
- kubectl cluster-info


### To read docker images from local / hub repository use this command in the windows 
    minikube docker-env

### Copy the output of above command run again,it will be like this
    @FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env --shell cmd') DO @%i


### Make docker image of the application
    docker build -t crud-k8s:2.0 . 

### To see docker image which you built above
    docker images

### Create config-map using command prompt
    kubectl apply -f mysql-configMap.yaml

### get config-map info using command prompt
    kubectl get configmap

### Create secrets using command prompt
    kubectl apply -f mysql-secrets.yaml

### get secrets info using command prompt
    kubectl get secrets

### Create db using command prompt
	kubectl apply -f db-deployment.yaml

### Check deployment which you created and ready state
	kubectl get deployment 

### see Pod & logs :
    kubectl get pods

### Copy the pod name from above and replace in the below command and see pod is running
    kubectl logs {pod-name}

### MySQL SSH 
    kubectl exec -it {pod-name} /bin/bash
    mysql -u root -p
    enter password : root
    show databases;
    You will see the database with the name of order_management


### Create application using command prompt
	kubectl apply -f app-deployment.yaml
    kubectl get deployment

### Expose service of application to see the port
	kubectl get service
    or
    kubectl get svc
    
    To see the logs of spring boot with 3 pods
    kubectl logs {pod-name}

### Port forward in the windows machine for the pod to call rest api from postman/curl etc
    kubectl port-forward {pod-name} 5000:8080
    
### Curl Request

    curl --location --request POST 'localhost:5000/orders' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name":"pizza",
        "qty":2,
        "price": 1000
    }'

### Minikube IP
    minikube ip

### Check health
    minikube dashboard
      
    copy the url and see in the dashboard pods , replica set , jobs etc  to see the health and delete pod etc.

### Delete Service and deployment to clean up space


