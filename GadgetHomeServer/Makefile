
docker:
	mvn package -DskipTests
	sudo chown $(USER) /var/run/docker.sock
	docker login gitlab.wethinkco.de:5050 -u tslephal -p jzUr2y3obG3CMCthDswv
	sudo docker build -t gitlab.wethinkco.de:5050/tslephal/gadgethome .
	sudo docker push gitlab.wethinkco.de:5050/tslephal/gadgethome
	docker logout

drelease:
	sudo chown $(USER) /var/run/docker.sock
	sudo docker login gitlab.wethinkco.de:5050 -u tslephal -p jzUr2y3obG3CMCthDswv
	sudo docker pull gitlab.wethinkco.de:5050/tslephal/gadgethome:latest
	sudo docker run -p "8080:8080" gitlab.wethinkco.de:5050/tslephal/gadgethome:latest