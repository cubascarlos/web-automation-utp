pipeline {
    agent any

    tools {
        maven 'maven-3.9.15'
        jdk 'jdk-21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/cubascarlos/web-automation-ct.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean verify -Dcucumber.filter.tags="@NTLC-1"'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            cucumber buildStatus: 'UNSTABLE',
                     fileIncludePattern: 'cucumber.json',
                     jsonReportDirectory: 'target/build',
                     sortingMethod: 'ALPHABETICAL',
                     trendsLimit: 20
        }
    }
}
