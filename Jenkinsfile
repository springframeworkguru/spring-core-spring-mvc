node{

     stage("Checkout"){
         checkout scm
     }

     stage("Build"){
       withEnv(["PATH+MAVEN=${tool 'M3'}"]){
         sh 'mvn clean install -DskipTests'
       }
     }
 }