pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    stages {
         stage('Clone repository') { 
            steps { 
                script{
                checkout scm
                }
            }
        }
        stage('Test'){
            steps {
                script{
                    sh'cd GadgetHomeServer; mvn package'
                }
            }
        }

        stage('Build') { 
            steps { 
                script{
                 app = docker.build("tshiamolephale/gadgethomeserver")
                }
            }
        }
        stage('Deploy') {
            steps {
                script{
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                    app.push("${env.BUILD_NUMBER}")
                    app.push("latest")
                    }
                }
            }
        }
    }
}
