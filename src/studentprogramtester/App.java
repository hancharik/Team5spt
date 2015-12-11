/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;


import studentprogramtester.controler.BatchTester;
import studentprogramtester.controler.SingleTester;
import studentprogramtester.controler.DataObject;
import studentprogramtester.controler.TrivialEdit;
/**
 *
 * @author marcc_000
 */
public class App {
    
    
    public static DataObject data;  //this is how i get around the config.properties
    public static RunConfiguration runCon;  
    public static DataObject[] roster;
    public static String thisIsWhereYouPutTheMainFile  = "C:\\Users\\Mark\\Desktop\\target\\";  // this is where you put the "target" file
    public static String outputFile  = "output-files";  // this is where you put the output of the test runs
    public static String testArgumentFile  = "test-arguments.txt";  // this is where you put the output of the test runs
     public static String testInputFile  = "testinput.txt";  // this is where you put the output of the test runs
   // we need to automate this process, right now the user sets the system by telling it where the home folder lives 
  // it seems like we could just test for windows, and if it is, we just add a  "C:\\"
    /* 
        public String checkForWindows(){
            String extraCharacter = "";
                if (%PATH% returns "windows_NT"){
                extraCharacter = "C:\\";
                }
            return extraCharacter;
        }
    then String thisIsWhereYouPutTheMainFile  = checkForWindows() + "Users\\Mark\\Desktop\\target\\";
    */
    
    
    
    public static void main(String[] args)
    {
        
       buildApp();
       
    } // end main
    
    
    
    
    
    
    private static void buildApp(){
        
        makeClass();  // generate an array of data objects based on the # of students
         
       
         
        StudentProgramTester SPT = new StudentProgramTester();      // instantiate a new student program tester, it takes care of everything from there 
        
       
        
        
    } // end build app

    
    
    public static void makeClass() {
        
           data = new DataObject();  // we will prob have to take this out, i'm using this as my config.properties file
             
           
            int classSize = 7; // we need to get the # of students from the class file here
           
           roster = new DataObject[classSize];
           
           for (int i = 0; i < classSize; i++){
             roster[i] = new DataObject(); 
             roster[i].classArrayNumber = i;  // i need this is a handle for the action listener for the student button array in RunConfiguration.java
           }
           
           
           
           
           
           
    } // end make class
    
    
    
    
    
    
    
}  // end
