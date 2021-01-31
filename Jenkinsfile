pipeline{
    
    agent any

    tools{
        maven "M1"
    }

    stages{
        stage('Checkout Source'){
            git url: 'https://github.com/ManachoM/PEP3Tingeso.git', branch: 'master'
        }
        stage('Build and Unit Tests'){
            sh "mvn clean package"
        }
        stage('Stationary Analysis'){
            scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
        }
    }
}