def buildApp() {
    echo 'build the application...'
}

def testApp() {
    dir('app') {
        echo 'testing the application...'
        sh 'npm install'
        sh 'npm test'
    }
}

def deployApp() {
    echo 'build the application...'
    echo "deploying version ${params.VERSION}"
}
return this