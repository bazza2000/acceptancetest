pipeline {
  agent any
  stages {
    stage('Build') {
      agent {
        docker {
          image 'markhobson/maven-chrome'
          args '--add-host=demo.viosystems.com:172.31.14.136 -v /root/.m2:/root/.m2 -v /root/artifacts:/artifacts  --network root_default'
        }

      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'

        }

      }
      steps {
        sh 'mvn -B clean test sonar:sonar -Dsonar.host.url=http://sonarqube:9000'
      }
    }
  }
  triggers {
    GenericTrigger(genericVariables: [
                    [key: 'ref', value: '$.ref']
                  ], causeString: 'Triggered on $ref', token: 'acceptancetest', printContributedVariables: true, printPostContent: true, silentResponse: false)
    }
}
