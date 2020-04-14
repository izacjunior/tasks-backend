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
            environment{
                scannerHome = tool 'Sonar_Local_Scanner'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=bd1eeb0928d7c4860a0745618237000d0e8bfcd8 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
            }
        }
    }
        stage('Quality Gate'){
            steps{
                sleep(5)
                timeout(time: 1, unit: 'MINUTES'){
                waitForQualityGate abortPipeline: true
                }
    }
    } 
    stage('Deploy Backend'){
        steps{
            deploy adapters: [tomcat8(credentialsId: 'TomCat_login', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
        }
    }

    stage('API Test'){
        steps{
            dir('api-test') {
            git credentialsId: 'git_hub', url: 'https://github.com/izacjunior/api-Tests-WCAquino'        
            bat 'mvn test'
    }
    }
    }
    stage('Deploy Frontend'){
        steps{
        dir('frontend') {
            git credentialsId: 'git_hub', url: 'https://github.com/izacjunior/tasks-frontend'
            bat 'mvn clean package'
            deploy adapters: [tomcat8(credentialsId: 'TomCat_login', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks', war: 'target/tasks.war'
        }
    }
    }
 stage('Funcional Test'){
        steps{
            dir('funcional-test') {
            git credentialsId: 'git_hub', url: 'https://github.com/izacjunior/tasks-Funcional-WCAquino'        
            bat 'mvn test'
    }
    }
    }
    }
}