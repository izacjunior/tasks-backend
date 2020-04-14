pipeline{
    agent any
    stages{
        stage('Build Backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
         stage('Unit Test'){
            steps{
                bat 'mvn test'
            }
        }

        stage('Sonar Analysis'){
            enviroment{
                scannerHome = tool 'Sonar_Local_Scanner'
            }
            steps{
                withSonarQubeWnv('SONAR_LOCAL'){
                bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=bd1eeb0928d7c4860a0745618237000d0e8bfcd8 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
            }
        }
    }
}

}
