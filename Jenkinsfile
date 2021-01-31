pipeline{
    
    agent any

    tools{
        maven "M1"
        dockerTool "Docker"
    }

    stages{
        stage('Checkout Source'){
            steps{
                git url: 'https://github.com/ManachoM/PEP3Tingeso.git', branch: 'master'
            }
        }
        stage('Build and Unit Tests'){
            steps{
                sh "mvn clean package"
            }
        }
        stage('Stationary Analysis'){
            steps{
                sh "mvn spotbugs:spotbugs"
            
            }
        }
        stage('Build Image'){
            steps{
                sh "cd target"
                sh "java -Djarmode=layertools -jar WebApp-0.0.1-SNAPSHOT.jar list"
                sh "java -Djarmode=layertools -jar WebApp-0.0.1-SNAPSHOT.jar extract"
                sh "cd .."
                script {
                    myapp = docker.build("manachom/pep3tingeso:${env.BUILD_ID}")
                }
            }
        }
        stage('Push image') {
            steps {
                
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                            myapp.push("latest")
                            myapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
        stage('Deploy'){
            steps{
                script {
                        kubernetesDeploy(configs: "hola-mundo-2.yml", kubeconfigId: "kubeconfig")
                    }
            }
        }
    }
}