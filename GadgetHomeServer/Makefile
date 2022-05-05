test:
	mvn test

docker:
	mvn package -DskipTests
	sudo chown $(USER) /var/run/docker.sock
	docker login -u tshiamolephale -p 4Ff3ct!0n4t3
	sudo docker build -t tshiamolephale/gadgethomeserver .
	sudo docker push tshiamolephale/gadgethomeserver
	docker logout

drelease:
	sudo chown $(USER) /var/run/docker.sock
	docker login -u tshiamolephale -p 4Ff3ct!0n4t3
	sudo docker pull tshiamolephale/gadgethomeserver:latest
	sudo docker run -p "8080:8080" tshiamolephale/gadgethomeserver:latest