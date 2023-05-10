def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docke-id', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t jollyomere/demo:app-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push jollyomere/demo:app-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this

