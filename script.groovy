def buildJar() {
    echo 'build the application...'
}
def testApp() {
    dir('app') {
        echo 'testing the application...'
        sh 'npm install'
        sh 'npm test'
    }
}
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh "docker build -t ndubuisip/demo-app:${IMAGE_NAME} ."
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh "docker push ndubuisip/demo-app:${IMAGE_NAME}"
    }
}
def deployApp(version) {
    echo 'starting deployment...'
    echo "deploying version ${version}"
}
return this