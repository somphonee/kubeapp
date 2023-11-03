app=kubeapp
tag=1.7
mvn clean package -DskipTests

#eval $(minikube -p minikube docker-env)
eval $(minikube docker-env)
docker build -t ${app}:${tag} .