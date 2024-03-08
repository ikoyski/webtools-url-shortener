pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('Dockerhub-Credentials')
        K8S_HOST_IP = credentials('K8s-Host-IP')
    }
    stages {
        stage('Git Stuff') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ikoyski/webtools-url-shortener.git']])
            }
        }
        stage('Maven Stuff') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Stuff') {
            steps {
                script {
                    sh 'docker build -t ikoyski/webtools-url-shortener:latest .'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker push ikoyski/webtools-url-shortener:latest'
                }
            }
        }        
        stage('K8s Stuff') {
        	steps {
        		sshagent(['K8s-Host-User-With-Key']) {
					sh 'scp -o StrictHostKeyChecking=no Deploy.yaml ikoyski@$K8S_HOST_IP_USR:/home/ikoyski'
					script {	        		
		        		try {
		        			sh 'ssh -o StrictHostKeyChecking=no ikoyski@$K8S_HOST_IP_USR kubectl apply -f .'
		        		} catch(error) {
		        			sh 'ssh -o StrictHostKeyChecking=no ikoyski@$K8S_HOST_IP_USR kubectl create -f .'
		        		}	        	
			        }
				}
        	}
        }
    }
}