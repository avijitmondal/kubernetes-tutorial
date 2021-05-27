### Deploy Prometheus using helm

Add stable repo update configuration    

`helm repo add stable https://charts.helm.sh/stable --force-update`

Install prometheus operator using

`helm install stable/prometheus-operator --generate-name`

update services for prometheus and grafana to LoadBalancer from ClusterIP   

```
kubectl edit svc prometheus-operator-201022-prometheus
kubectl edit svc prometheus-operator-201022-grafana
```

Default username and password for grafana is `admin` decoded password is `prom-operator`

Load demo-prometheus-dash.json to grafana to show different kubernetes cluster matrices.