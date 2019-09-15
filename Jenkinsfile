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
      post {
        always {
          junit 'target/surefire-reports/*.xml'

        }

      }
      steps {
        sh 'mvn -B clean test'
      }
    }
  }
}