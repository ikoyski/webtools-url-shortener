pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('Dockerhub-Credentials')
        K8S_HOST_IP = credentials('K8s-Host-IP')
            
        DOCKERHUB_IMAGE = 'ikoyski/webtools-url-shortener:latest'        
        DEPLOYMENT_FILENAME = 'Deploy-webtools-url-shortener.yaml'
    }
    stages {
        stage('Git Stuff') {
            steps {
                script {
                	checkout scmGit(
                		branches: [[name: '*/master']], 
                		extensions: [], 
                		userRemoteConfigs: [[url: 'https://github.com/ikoyski/webtools-url-shortener.git']]
                	)
                }
            }
        }
        stage('Maven Stuff') {
            steps {
                script {
                	sh 'mvn clean install'
                }
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
        		script {
        			sshagent(['K8s-Host-User-With-Key']) {
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