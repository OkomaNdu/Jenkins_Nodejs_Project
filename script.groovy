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
        sh 'docker build -t ndubuisip/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push ndubuisip/demo-app:jma-2.0'
    }
}
def deployApp(version) {
    echo 'build the application...'
    echo "deploying version ${version}"
}
return this