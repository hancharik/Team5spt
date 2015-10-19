/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester.controler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.JButton;

public class DemoBatchTester
{
    int studentArrayNumber;
    DataObject dataObject; 
public  DemoBatchTester()
  {
      
    String className = "242-1\\"; 
    String configFileName = "C:\\java\\src\\program-test-242-1\\configBatch.txt";
          //dataObject = new DataObject();
    //dataObject = studentprogramtester.App.roster[0];
    //setObjectVariables(dataObject);
    
    
  
      int runNumber = 0;
      
     for (int i = 0; i < 7; i++){
      
          
         dataObject = studentprogramtester.App.roster[runNumber];
            dataObject.setObjectVariables(); // should this method be in data object?
          
          
       
        
          dataObject.numbr = runNumber;
          dataObject.nme = "Student " + runNumber;
          dataObject.hndl = "" + runNumber + "" + runNumber + "" + runNumber + "" + runNumber + "" + runNumber + "" + runNumber + "" + runNumber;
        

//      set paths and file names:
        dataObject.setClsPath("\\java\\bin\\" + className + dataObject.nme);
        dataObject.setStdPath(dataObject.srcPath + "\\" + dataObject.nme);
        dataObject.setInputFileStub(dataObject.stdPath + "\\input");
       dataObject.setOutFileName(dataObject.stdPath + "\\output-" + dataObject.nme + ".txt");
/*      make sure set correctly
        System.out.println("classPath: " + classPath);
        System.out.println("studentPath: " + studentPath);
        System.out.println("inputFileStub: " + inputFileStub);
        System.out.println("outputFileName: " + outputFileName);
*/
      
        System.out.println("UPDATED BATCH TESTER\nrun #: " + runNumber + " ;\n studentNumber: " + dataObject.numbr + 
        ";\nName: " + dataObject.nme + "; \nHandle: " + dataObject.hndl);
        System.out.println("UBT Output goes to: " + dataObject.outFileName + dataObject.showDataObject() + "\nEND UPDATED BATCH TESTER\n\n");

        
       
        
  
//      Print whether or not compile successful 
        // need to add tests and ints to arraylists in dataobject
          
        
        
        
        
        enterTestData();
        
        
        
        
        
        
        
        
        
        
        
        
      
        if(dataObject.allTestsPass())   
 
            
        {
         
          studentprogramtester.App.runCon.studentButtonArray[studentArrayNumber].setBackground(Color.green);  // need to fix for student
            studentprogramtester.App.runCon.studentButtonArray[studentArrayNumber].repaint();
       
        }
        else
        {
        
          studentprogramtester.App.runCon.studentButtonArray[studentArrayNumber].setBackground(Color.red);
           studentprogramtester.App.runCon.studentButtonArray[studentArrayNumber].repaint();
       
        }
      
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
//      Run the test cases
//      TestRunner consructor:
//      public TestRunner(int numbr, String nme, String hndl, String pth, String clsPath, 
//      String srcPath, String stdPath, String tstDataPath, String argFileName, 
//      String tstInputFileName, String inputFileStub, String outFileName)
        TestRunner r = new TestRunner(dataObject);
        r.runJava();
        runNumber++;
        System.out.println();
      }
   
    
     studentprogramtester.App.roster[studentArrayNumber] = dataObject;
    
    
  } // end constructor



 // this is where you can load test data for the demo batchrunner
public void enterTestData(){
     
     
     // enter the Strings of the test names 
       // for(int i = 0; i < numberOfTests; i++){
              dataObject.testFileNames.add("HelloWorld.java"); 
              dataObject.testFileNames.add("TicTacToe.java");
              dataObject.testFileNames.add("ArraySearch.java");
         //   } 
     
     
              
              
       //enter integer values for pass/ fail, with a given fail percentage       
     for(int i = 0; i < dataObject.numberOfTests; i++){
          int chanceToPass = (int) (Math.random() * 100) + 1;
                if(chanceToPass > 20){  // 20% chance to fail
              dataObject.testFileResults.add(0); // enter pass number
                }else{
               dataObject.testFileResults.add(1); // enter fail number   
                }
              
            }
     
     
     
     
     
         
     
     
     
 }  // end enter test data








}// end
