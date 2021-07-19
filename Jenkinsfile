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
                     bat "mvn sonar:sonar \
  -Dsonar.projectKey=PSBA \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=31136b0c7d8997392ebaeb5ab57042ebfafc1b39"   
                        
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
