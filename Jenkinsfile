pipeline {
    agent any

    tools {
        maven "maven"
    }
    
  // parameters {
     //   string(name: 'company', defaultValue: 'Sapient', description: 'Enter your cmopany name???')
//	booleanParam(name: 'DEBUG_BUILD', defaultValue: true, description: 'do you want to buidl with debug')
//	choice(name: 'env', choices: ['DEV', 'TEST', 'PROD'], description: 'specify you build env') 
  //  }

    stages {
                stage('Install') 
                {
                            steps {
                        


                                git branch: 'main' , url: 'https://github.com/ghaikanav/assessment-springboot.git'

                                // Run Maven on a Unix agent.
                                bat "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true"

                               
                               
                            
                            
                            }

                }
                stage('sonar')
                {
             
                    steps
                    {
                     bat "mvn sonar:sonar -Dsonar.projectKey=PSBA -Dsonar.host.url=https://tools.publicis.sapient.com/sonar -Dsonar.login=9eaeff26e31c8478bde4afc34ef3c63a7d77a2a9"   
                        
                    }
                    
                    
                }

                stage('Build') 
                {
                    steps 
                    {
                

                        // Run Maven on a Unix agent.
                        bat "docker image build -t testjenkins ."

                    }

                }

                stage('Deployement') 
                {
                    steps {
                
                        // Run Maven on a Unix agent.
                        bat "docker run --name HospitalApp -p 8081:8080  testjenkins"

                            }
                }

  

}

}
