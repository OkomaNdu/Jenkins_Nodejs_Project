
pipeline {
    agent any
    tools {
     nodejs 'node'
    }
    stages {
        stage("test") {
            steps {
                 script{
                   dir('app') {
                   echo "Testing the application..."
                   sh 'npm install'
                   sh 'npm test'
                   }
                 }
            }
        }
        stage("build") {
            steps {
               script {
                   echo "Building the application..."
               }
            }
        }
        stage("deploy") {
            steps {
                script {
                   echo "Deploying the application..."
                }
            }
        }
    }
}