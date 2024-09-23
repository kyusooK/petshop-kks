# 

## Model
www.msaez.io/#/courses/cna-full/ce76b2f0-7943-11ef-a079-7fda25656cd0/dpg-dev

## Before Running Services
### Make sure there is a Kafka server running
```
cd infra
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic petshop  --from-beginning
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- petmanagement
- store


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- petmanagement
```
 http :8088/pets id="id" name="name" energy="energy" appearance="appearance" address="address" petType="petType" photo="photo" petStatus="petStatus" illnessHistories="illnessHistories" 
```
```
http :8082/pets name=야옹이 weight=5 energy=1
http :8082/pets/1/feed gram=10
http :8082/pets/1
```
- store
```
 http :8088/items id="id" price="price" customer="customer" status="status" petId="petId" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

## Test
```
http :8082/pets name=야옹이 weight=5 energy=1
http :8082/pets/1/feed gram=10
http :8082/pets/2
```