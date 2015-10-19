/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester.controler;


import java.io.*;
import java.util.*;
import studentprogramtester.controler.TestRunner;
import studentprogramtester.controler.Compiler;
import studentprogramtester.controler.DataObject;

public class SingleTester{
    
    
     DataObject dataObject;       
            
  public SingleTester(int studentNumber){
//  initialize student and class configuration data    
   
    //dataObject = d;
    // is this correct? make the object and then copy?
   // dataObject = new DataObject();
    dataObject = studentprogramtester.App.roster[studentNumber];
    
  //   dataObject.setNumbr(0);
    int runNumber = 1; 
 //   dataObject.setNme("blank");
 ///   dataObject.setHndl("000000");
      
    String className = "242-1\\"; 
    String configFileName = studentprogramtester.App.data.pathToFile + "students.txt";
    System.out.println("configFileName: " + configFileName);
 //   dataObject.setPth("C:\\java\\jdk1.7.0_71\\bin");
    
//  set fixed paths and file names:
  //  dataObject.setSrcPath("C:\\java\\src\\program-test-242-1\\src\\src-output");
 //   dataObject.setTestDataPath("C:\\java\\src\\program-test-242-1\\src");
 //   dataObject.setArgsFileName(dataObject.getTestDataPath() +  "\\args.txt");
    //dataObject.setArgsFileName("C:/java/src/args.txt");
 //   dataObject.setTestInputFileName( "C:\\java\\src\\TestInput.txt");
/*  make sure set correctly
    System.out.println("sourcePath: " + sourcePath);
    System.out.println("testDataPath: " + testDataPath);
    System.out.println("argsFileName: " + argsFileName);
    System.out.println("testInputFileName: " + testInputFileName);
*/
    try
    {
/*    config file contains:
      - path to Java jdk (enclosed in quotes) on first line
        e.g. - "C:/Program Files/Java/jdk1.7.0_25/bin"
      - student name (lowercase lastnamefm) on second line
        e.g. - smithjq for John Q. Smith
      - random 6-digit handle on third line
        e.g. - 543890 - use the one given to you in class
*/
      File configFile = new File(configFileName);
      Scanner in = new Scanner(configFile);
      String line  = in.nextLine();
      Scanner inLine = new Scanner(line); 
      //path = inLine.next();
     // dataObject.setPth(inLine.next());
      line = in.nextLine();
      inLine = new Scanner(line);
      //studentName = inLine.next();
     // dataObject.setNme(inLine.next());
      line = in.nextLine();
      inLine = new Scanner(line);
      //studentHandle = inLine.next();      
    //  dataObject.setHndl(inLine.next());
      
//    set paths and file names:
      dataObject.setClsPath( dataObject.pathToFile + "bin\\" + className + dataObject.nme);
      dataObject.setStdPath(dataObject.getSrcPath() + "\\" + dataObject.getNme());
      dataObject.setInputFileStub(dataObject.getStdPath() + "\\input");
      dataObject.setOutFileName(dataObject.getStdPath() + "\\output-" + dataObject.getNme() + ".txt");
/*    make sure set correctly
      System.out.println("classPath: " + classPath);
      System.out.println("studentPath: " + studentPath);
      System.out.println("inputFileStub: " + inputFileStub);
      System.out.println("outputFileName: " + outputFileName);
*/
      
      System.out.println("TEAM FIVE RESULTS\nrun #: " + runNumber + " ;\n studentNumber: " + dataObject.getNumbr() + 
      ";\nName: " + dataObject.getNme() + "; \nHandle: " + dataObject.getHndl());
      System.out.println("\nUPDATED Output goes to: " + dataObject.getOutFileName() + dataObject.showDataObject());
        
//    run javac compiler - returns 0 on success
//    Compiler Constructor:
//    public Compiler(int numbr, String nme, String hndl, String pth, String clsPath, 
//    String srcPath, String stdPath, String outFileName)
      
      Compiler c = new Compiler(dataObject);
      int success = c.compileJava(dataObject);
        studentprogramtester.App.data.setSuccess(success);
//    Print whether or not compile successful
     if(dataObject.allTestsPass()) 
      {
        System.out.println("SingleTester.java line 101 COMPILE OK - Compiled Successfully");
      }
      else
      {
        System.out.println("SingleTester.java line 101 COMPILE FAIL - Compile Exception, \nsuccess = " + success);
      }
      
//    Run the test cases
//    TestRunner consructor:
//    public TestRunner(int numbr, String nme, String hndl, String pth, String clsPath, 
//    String srcPath, String stdPath, String tstDataPath, String argFileName, 
//    String tstInputFileName, String inputFileName, String outFileName)
      TestRunner r = new TestRunner(dataObject);
      r.runJava();
      runNumber++;
      System.out.println();
    } catch(IOException ioe)
    {
      System.out.println("main IOException");
    }
     System.out.println(dataObject.showDataObject());
    
     studentprogramtester.App.roster[studentNumber] = dataObject;
  }  // end constructor

   
}// end
