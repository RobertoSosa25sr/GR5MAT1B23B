pipeline{

    agent any

        stages{

            stage('Test'){
                steps{
                    echo "Test no disponible"
                    script {
                                        // Utiliza 'tool' para especificar la versión de Maven a utilizar
                                        def mavenHome = tool name: 'mv', type: 'maven'
                                        sh "${mavenHome}/bin/mvn clean test"
                                    }
                }
            }

            stage('Build'){
                steps{
                    echo "Build no disponible"
                }
            }

            stage('Deploy'){
                steps{
                    echo "Deploy no disponible"
                }
            }



        }

}