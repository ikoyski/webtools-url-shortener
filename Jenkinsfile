pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('Dockerhub-Credentials')
        HOST_CREDENTIALS = credentials('Host-Credentials')
    }
    stages {
        stage('Checkout from Git') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ikoyski/webtools-url-shortener.git']])
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ikoyski/webtools-url-shortener:latest .'
                }
            }
        }
        stage('Login to Docker Hub') {
            steps {
                script {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
            }
        }
        stage('Push Image to Docker Hub') {
            steps {
                script {
                    sh 'docker push ikoyski/webtools-url-shortener:latest'
                }
            }
        }
        stage('Deploy to K8s') {
        	steps {
        		script {	        		
	        		sh 'echo $HOST_CREDENTIALS_PSW | scp -o StrictHostKeyChecking=no Deploy.yaml $HOST_CREDENTIALS_USR@192.168.0.136:/home/ikoyski'
	        		try {
	        			sh 'echo $HOST_CREDENTIALS_PSW | ssh $HOST_CREDENTIALS_USR@192.168.0.136 kubectl apply -f .'
	        		} catch(error) {
	        			sh 'echo $HOST_CREDENTIALS_PSW | ssh $HOST_CREDENTIALS_USR@192.168.0.136 kubectl create -f .'
	        		}		        	
		        }
        	}
        }
    }
}