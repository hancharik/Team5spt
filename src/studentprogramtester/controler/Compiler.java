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


import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;
import studentprogramtester.controler.BatchTester;
import studentprogramtester.controler.SingleTester;
import studentprogramtester.controler.DataObject;

public class Compiler
{
  private int number;
  private String name;
  private String handle;
  private String path;
  private String classPath;
  private String sourcePath;
  private String studentPath;
  private String outputFileName;
  private int success;
  private String srcAbsPathName;
  private DataObject d;
  /*
  public Compiler(int numbr, String nme, String hndl, String pth, String clsPath, String srcPath, String stdPath, String outFileName)
  {
    number = numbr;
    name = nme;
    handle = hndl;
    path = pth;
    classPath = clsPath;
    sourcePath = srcPath;
    studentPath = stdPath;
    outputFileName = outFileName;
    success = 1;  // Outcome of compilation, success = 0
  }
  */
    public Compiler(DataObject data){
    d = data;
    number = data.numbr;
    name = data.nme;
    handle = data.hndl;
    path = data.pth;
    classPath = data.clsPath;
    sourcePath = data.srcPath;
    studentPath = data.stdPath;
    outputFileName = data.outFileName;
    success = data.success;  // Outcome of compilation, success = 0
    System.out.println("COMPILER CONSTRUCTOR:\n" + data.showDataObject());
  }
    
    
    
  
  
  public int compileJava(DataObject data)
  {
    try
    {
//    create new bin directory
      boolean createBin = new File(classPath).mkdir();

//    create new javac ProcessBuilder        
//      ProcessBuilder pb =
//      new ProcessBuilder("javac", "-d", classPath, "./" + studentPath + "/*.java");

      ProcessBuilder pbDir = new ProcessBuilder("dir");
//    Determine current working directory
	  File srcAbsPath = new File(sourcePath);
	  srcAbsPathName = srcAbsPath.getAbsolutePath();
	  System.out.println("Compiler.java line 69 source path: " + sourcePath); 
	  System.out.println("Compiler.java line 69 source absolute path: " + srcAbsPathName);

	  
      File cwd = pbDir.directory();
//    debug code - to confirm correct directory       
//    TestTools.dir(cwd);
//    NB - ProcessBuilder default is to return a null  
//    pointer for the abstract path to indicate that it 
//    is using System.Properties "user.dir", i.e., the 
//    current system working directory; hence the
//    critical need to handle a NullPointerException.
//    Also returns a null pointer if the directory
//    doesn't exist.

      
      // all this is doing is changing the dir, can we approach this in a different way using a value in our Data Object? -mh
      File nwd = TestTools.cd(cwd, studentPath);
      
      System.out.println("(Compiler.java line 88)new working directory: " + nwd.toString()); 
      String studentPathName = nwd.getAbsolutePath();
	  File nwdPath = new File(studentPath);
   System.out.println("(Compiler.java line 91)new working directory path: " + studentPathName); 
//    debug code to test new working directory
//    TestTools.dir(nwd);

	  FileFilter filter = new FileFilter() {

          
        };
	  String[] javaFileList = nwdPath.list(filter); 
//    set up output file      
      File outputFile = new File(outputFileName);
//    System.out.println(outputFileName);
      outputFile.delete();
	 int tNumber = 0; 
	  for(int k = 0; k < javaFileList.length; k++)
	  {
	    try
		{
		  if(filter.accept(nwdPath, javaFileList[k]) == true)
		  { 
	        System.out.println("COMPILER.JAVA (line 111)  Compiling: " + javaFileList[k]);

                data.testFileNames.add(" "+ javaFileList[k]);
            
                
           // String compilePath =  "C:\\java\\src\\program-test-242-1\\src\\src-output\\mudgettdr";   
          
           
                
                ProcessBuilder pb =
                new ProcessBuilder("javac ", "-d", classPath, "" + studentPath + "\\" + javaFileList[k]);
                
                System.out.println("compiler.java line 135  javac ,"+ "-d,"+ classPath+ "," + studentPath + "\\" + javaFileList[k].toString());  
                
	   //new ProcessBuilder(compilePath);
           
           
           // System.out.println(pb.environment().toString());  <-- THIS IS VERY INTERESTING 
           
           
//          Create environment map and set environmental variables         
            Map<String, String> env = pb.environment();       
            env.clear();
            env.put("PATH", path);
            env.put("CLASSPATH", classPath);
//          env.put("SOURCEPATH", sourcePath);
//          env.remove("OTHERVAR");

            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(outputFile));

//          start javac process        
            Process p = pb.start();
        
//          need other processes to wait for compilation to finish
//          basically joins the thread to the javac process to force sequential
//          execution - need to be careful - if any process hangs, whole run hangs
            success = p.waitFor();  // Returns the exit value of the process. By convention, 0 indicates normal termination. http://docs.oracle.com/javase/6/docs/api/java/lang/Process.html#waitFor%28%29

            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == outputFile;
            assert p.getInputStream().read() == -1;
            System.out.println("COMPILER.JAVA (line 138)  end of loop, success = " + success);
           
            
           // data.success = success;
            data.testFileResults.add(success);
            
            
		  } // end if statement 
		} catch(Exception e)
          {
            System.out.println(" Compiler.java FOR LOOP Compile Exception: " + javaFileList[k] +" (" + success + "  success)");
            data.success = success;
          }
          
            
      }      
	} catch(Exception e)
      {
        System.out.println("Compile Exception, PROBABLY DUE TO FILE PATH");
        System.out.println("source absolute path: " + srcAbsPathName);
      }
    
    return success;
     
    
    
    
    
  }  //end compile java
  
  
} // end 