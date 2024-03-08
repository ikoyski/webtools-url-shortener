pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    environment {
    	GIT_URL = 'https://github.com/ikoyski/webtools-url-shortener.git'
        DOCKERHUB_CREDENTIALS = credentials('Dockerhub-Credentials')
        DOCKERHUB_IMAGE = 'ikoyski/webtools-url-shortener:latest'
        K8S_HOST_IP = credentials('K8s-Host-IP')
        DEPLOYMENT_FILENAME = 'Deploy-webtools-url-shortener.yaml'        
    }
    stages {
        stage('Git Stuff') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: $GIT_URL]])
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
                    sh 'docker build -t $DOCKERHUB_IMAGE .'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker push $DOCKERHUB_IMAGE'
                }
            }
        }
        stage('K8s Stuff') {
        	steps {
        		sshagent(['K8s-Host-User-With-Key']) {
        			script {
						sh 'scp -o StrictHostKeyChecking=no $DEPLOYMENT_FILENAME ikoyski@$K8S_HOST_IP_USR'
						try {
		        			sh 'ssh -o StrictHostKeyChecking=no ikoyski@$K8S_HOST_IP_USR kubectl apply -f $DEPLOYMENT_FILENAME'
		        		} catch(error) {
		        			sh 'ssh -o StrictHostKeyChecking=no ikoyski@$K8S_HOST_IP_USR kubectl create -f $DEPLOYMENT_FILENAME'
		        		}
		        	}
				}
        	}
        }
    }
}