pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/akkim862/simple-java-ant-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'ant clean jar'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t simple-java-ant-app:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'
            }
        }
    }
}
