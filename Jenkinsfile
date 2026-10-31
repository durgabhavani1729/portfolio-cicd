pipeline {
    agent any

    stages {
        stage('GitHub Checkout') {
            steps {
                echo 'Downloading Portfolio Website from GitHub...'

                git branch: 'main',
                    url: 'https://github.com/durgabhavani1729/portfolio-cicd.git'
            }
        }

        stage('Maven Build') {
            steps {
                echo 'Building Portfolio Website using Maven...'

                bat 'mvn clean package'
            }
        }

        stage('Verify Build') {
            steps {
                echo 'Checking the generated JAR file...'

                bat 'dir target'
            }
        }
    }

    post {
        success {
            echo 'Portfolio CI/CD Pipeline Completed Successfully!'
        }

        failure {
            echo 'Portfolio CI/CD Pipeline Failed!'
        }
    }
}