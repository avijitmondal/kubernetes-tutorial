# kubernetes tutorial

steps to deploy this application on k8s cluster

```
docker build . -t spring-k8s:1.0
kubectl apply -f spring-k8s-deploy.yml
kubectl apply -f spring-k8s-svc.yml
```

open 
http://localhost:9376/details

to run spring-k8s docker image as a standalone docker container user

`docker run -p 8080:8080 spring-k8s:1.0 spring-k8s
`

### some points to remember
construction of kubectl commands

`kubectl <action> <resource type> [resource name]`

### some useful kubernetes commands

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

to know more visit https://avijitmondal.github.io
