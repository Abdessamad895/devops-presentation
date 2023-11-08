pipeline {
    agent any 
    
    tools{ 
        maven '<maven_name>'
    }
    
    stages{
        
        stage("Git Checkout"){
            steps{
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/dorbanianas/devops-presentation.git'
            }
        }
        
        stage("Build"){
            steps {
                bat "mvn clean package"
            }
        }
        
        stage("Sonarqube Analysis "){
            steps{
                bat """
                    mvn sonar:sonar -Dsonar.url=http://localhost:9000/ -Dsonar.login=<sonarqube_token> -Dsonar.projectName=Devops \
                    -Dsonar.java.binaries=. \
                    -Dsonar.projectKey=Devops
                """
            }
        }
        
        stage("Docker login"){
            steps {
                withCredentials([string(credentialsId: '<variable_id>', variable: '<variable_name>')]) {
                    bat "docker login -u <username_docker_account> -p ${<variable_name>}"
                }
            }
        } 
        
        stage("Docker build"){
            steps {
                 bat "docker build -t <app_name> ."
            }
        }
        
        stage("Docker push"){
            steps {
                 bat "docker push <username_docker_account>/<app_name>" 
            }
        }
        
        stage("Docker run"){
            steps {
                 bat """
                      docker stop <username_docker_account>/<app_name> 
                      docker rm <username_docker_account>/<app_name> 
                      docker run --name <app_name> -d -p 8000:8080 <username_docker_account>/<app_name> 
                    """ 
            }
        }
        
    }
}
