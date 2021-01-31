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
                scanForIssues tool: spotBugs(pattern: '**/target/spotbugsXml.xml')
            }
        }
        stage('Build Image'){
            steps{
                sh "systemctl start docker"
                script {
                    myapp = docker.build("manachom/pep3tingeso:${env.BUILD_ID}")
                }
            }
        }
        stage("Push image") {
            steps {
                
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                            myapp.push("latest")
                            myapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
    }
}