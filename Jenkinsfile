pipeline{
    
    agent any

    stages{
        stage('Checkout Source'){
            git url: 'https://github.com/ManachoM/PEP3Tingeso.git', branch: 'master'
        }
        stage('Build and Unit Tests'){
            mvn clean package
        }
        stage('Stationary Analysis'){
            scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
        }
    }
}