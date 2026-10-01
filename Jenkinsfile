pipeline {
    agent any

    environment {
        KAFKA_BIN = '/opt/kafka/bin'
        BOOTSTRAP = '172.31.5.230:9092'
        TOPIC     = 'ci-events'
    }

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

    post {
        always {
            script {
                def event = """{"job":"${env.JOB_NAME}","build":${env.BUILD_NUMBER},"status":"${currentBuild.currentResult}"}"""
                sh "echo '${event}' | KAFKA_HEAP_OPTS='-Xmx128m' ${KAFKA_BIN}/kafka-console-producer.sh --topic ${TOPIC} --bootstrap-server ${BOOTSTRAP}"
            }
        }
    }
}
