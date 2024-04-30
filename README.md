# 

## Model
www.msaez.io/#/487999/storming/publicservicedesign

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic publicservicedesign
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- application
- process1
- process2
- compensation
- analysis1
- analysis2
- supporting


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- application
```
 http :8088/applications 민원번호="민원번호" 민원내용="민원내용" 진행상태="진행상태" 
```
- process1
```
 http :8088/investigations name="name" description="description" date="date" 민원번호="민원번호" 
 http :8088/processings name="name" date="date" 민원번호="민원번호" 
```
- process2
```
 http :8088/minwonType2s name="name" description="description" 
```
- compensation
```
 http :8088/rewardApplications id="id" reason="reason" 
 http :8088/compensationPayments id="id" amount="amount" 
```
- analysis1
```
 http :8088/analysis1s id="id" 
```
- analysis2
```
 http :8088/analysis2s id="id" 
```
- supporting
```
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

