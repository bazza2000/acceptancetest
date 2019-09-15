pipeline {
  agent any
  stages {
    stage('Build') {
      agent {
        docker {
          image 'markhobson/maven-chrome'
          args '-v /root/.m2:/root/.m2 -v /root/artifacts:/artifacts'
        }

      }
      steps {
        sh 'mvn -B clean test sonar:sonar -Dsonar.host.url=http://sonarqube:9000'
      }
      post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
      }
    }
  }
}
