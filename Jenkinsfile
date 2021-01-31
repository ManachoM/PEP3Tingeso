pipeline{
    
    agent any

    tools{
        maven "M1"
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
                scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
            }
        }
    }
}