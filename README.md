# kubernetes tutorial

[![Actions Status](https://github.com/avijitmondal/kubernetes-tutorial/workflows/kubernetes/badge.svg)](https://github.com/avijitmondal/kubernetes-tutorial/actions)

### steps to run application as a standalone java application with h2 database

app-details is smallest app to use different resource types of kubernetes
[App-Details](repo/blob/master/app-details/README.md)


```shell
mvn clean package
java -jar target\spring-k8s.jar
```

this java application contains two endpoints

`http://localhost:8080/hello` and `http://localhost:8080/details`

`http://localhost:8080/hello`
will return `Hello World!` unless any query param specified

if `tutorial` database `user` table contains below data

| id        | name           | passport_number  |
| --------- |:------------- :| --------------- :|
| 10001     | ranga          | e1234567         |
| 10002     | avijit         | e1234568         |


if called with `"avijit"` as a value for `'name'` query param
`http://localhost:8080/hello?name=avijit`

will respond `User{id=10002, name='avijit', passportNumber='a1234568'}`

if called with `"10001"` as a value for `'name'` query param
`http://localhost:8080/hello?id=10001`

will respond `User{id=10001, name='ranga', passportNumber='e1234567'}`

and another endpoint is `http://localhost:8080/details`

will respond the details of server ip, port and hostname

`Your current IP address: 1.2.3.4 , Port: 8080 , Hostname: abcdefgh`

### steps to run this application as a standalone docker container

```shell
docker build . -t spring-k8s:1.0 -f Dockerfile
docker run -p 8080:8080 spring-k8s:1.0 spring-k8s
```

open `http://localhost:8080/details`

### steps to deploy this application on k8s cluster with embeded h2 database 

```shell
docker build . -t spring-k8s:1.0 -f Dockerfile
kubectl apply -f kubernetes/spring-k8s-deploy.yml
kubectl apply -f kubernetes/spring-k8s-svc.yml
```

open `http://localhost:9376/details`

### steps to deploy this application on k8s cluster with mysql

before preceding deploy mysql and load data into it
```shell
kubectl apply -f mysql/mysql-k8s-pvc.yml
kubectl apply -f mysql/mysql-k8s-deploy.yml
kubectl apply -f mysql/mysql-k8s-svc-lb.yml
```

access mysql with user `root` and password as `password` and port `3306` create database named tutorial and load schema and data from `src\main\resources\schema.sql` and `src\main\resources\data.sql`

and delete kubernetes resource

`kubectl delete -f mysql/mysql-k8s-svc-lb.yml`

modify environment veriable `SPRING_PROFILES_ACTIVE` value from `default` to `prod` on the deployment file `spring-k8s-deploy.yml`  
```
kubectl apply -f mysql/mysql-k8s-svc.yml
kubectl apply -f kubernetes/spring-k8s-deploy.yml
kubectl apply -f kubernetes/spring-k8s-svc.yml
```

open `http://localhost:9376/details`


### some points to remember
construction of kubectl commands

`kubectl <action> <resource type> [resource name]`

### some useful kubernetes commands

describe a specific resource

`kubectl describe svc spring-k8s-svc
`

deploy pod

`kubectl apply -f spring-k8s-pod.yml
`

check created pods

`kubectl get pods
`


deploy replication controller

`kubectl apply -f spring-k8s-rc.yml
`

check created replication controller

`kubectl get replicationcontroller
`

deploy replica set

`kubectl apply -f spring-k8s-rs.yml
`

check created replica set

`kubectl get replicaset
`

deploy deployment

`kubectl apply -f spring-k8s-deploy.yml
`

check created replica set

`kubectl get deploy
`

create a new namespace

`kubectl apply -f spring-k8s-namespace.yml
`

check created namespace

`kubectl get namespaces
`


check all available resources

` kubectl get all
`

check resource of a specific namespace

`kubectl get all -n <namespace name>
`

Check the Status of Deployment

`kubectl rollout status deployment/spring-k8s-deploy
`

Updating the Deployment

`kubectl set image deployment/spring-k8s-deploy spring-k8s=spring-k8s:2.0
`

Rolling Back to Previous Deployment

`kubectl rollout undo deployment/spring-k8s-deploy –to-revision=1
`

