pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "jenkin-maven"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/SPART9119/appOnboarding.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }
        stage("App Onboard Saviynt"){
            steps{
               script {
                    try {
                       sh '''
                       java -jar /var/lib/jenkins/workspace/test-java-pipeline/target/appOnboarding-0.0.1-SNAPSHOT.jar
                       echo "App deployemnt success"
                       '''
                }catch(Exception e){
                    echo e.toString()
                    echo "Error detected, but we will continue."
                }
               }
            }
        }
    }
}