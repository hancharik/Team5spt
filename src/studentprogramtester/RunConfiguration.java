/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;




import studentprogramtester.controler.BatchTester;
import studentprogramtester.controler.DemoBatchTester;
import studentprogramtester.controler.SingleTester;
import studentprogramtester.controler.DataObject;
import studentprogramtester.controler.SmartButton;
import studentprogramtester.controler.TrivialEdit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

import java.util.Calendar;

/**
 *
 * @author mah537
 */
public class RunConfiguration extends JPanel{
    
     int column1 = 190;
    int column2 = 10;
    int buttonOffset = 110;
    
   
   int currentSelectedStudent = 0;
    
    DataObject data; //= compilatron6000.Compilatron6000.data;  // moved to updateLabels()
    
    boolean isDemo = false;
    javax.swing.JTextArea text = new javax.swing.JTextArea();
    JTextArea displayResults;
   JFileChooser chooser;
   String choosertitle;
   String chooserDirectorySelection;
   String chooserFileSelection;
    
   
   TrivialEdit trivialEdit = new TrivialEdit();
        public JButton setPathButton = new JButton();
    public JButton setStudentPathButton = new JButton();
    
    public JButton setOutputFileNameButton = new JButton();
    public JButton setArgsFileNameButton = new JButton();
    
    
     JButton showPathsButton = new JButton();
    
      JButton showPathToFileButton = new JButton();
    
    public JButton runBatchButton = new JButton();
    public JButton runDemoBatchButton = new JButton();
    
    
    
    public JButton runSingleButton = new JButton();
     
    
    public JLabel studentNameLabel = new JLabel("student name");
    
    
    public String explanation = "<html><h2><font color='blue'>it puts the file into the blue box </font><br><font color='red'>or else it gets the hose again</font><h2></html>";
    
    public JLabel explanationLabel = new JLabel(explanation);
    public JLabel studentNumberLabel = new JLabel("student number" );
    public JLabel studentHandleLabel = new JLabel("student Handle");
    public JLabel pathLabel= new JLabel("path");
    public JLabel classPathLabel= new JLabel("class path");
    public JLabel sourcePathLabel= new JLabel("source path");
    public JLabel studentPathLabel= new JLabel("student path");
    public JLabel outputFileNameLabel = new JLabel("output file name");
    public JLabel configurationFileNameLabel = new JLabel("configuration file name" );
    public JLabel argsFileNameLabel = new JLabel("args file name");
    public JLabel successLabel = new JLabel("success number");
    public JLabel currentSelectedStudentLabel = new JLabel("current selected student: " + currentSelectedStudent);
    
    JPanel studentButtons;
    public JButton[] studentButtonArray;
    JPanel p;
    
    JPanel testButtons;
    public ArrayList <JButton> testButtonArray;
   // JPanel t;
    JButton testButton1;
    JButton testButton2;
    JButton testButton3;
    JButton testButton4;
    JButton testButton5;
    
   //public File[] resultFiles = new File[7];  // this isn't used 
    
   
   
   
   
   
   
   
    public RunConfiguration()
    {
        //fillTestClass();
       initializeComponents();
      
    }

        
     public void initializeComponents(){
         
         this.setLayout(null);
       
         //data = studentprogramtester.App.data;
        data = new DataObject();
         
         
         
        setOutputFileNameButton.setBounds(column(2), row(8), 170, 26);
        setStudentPathButton.setBounds(column(2), row(7), 170, 26);
        setArgsFileNameButton.setBounds(column(2), row(10), 170, 26);
        setPathButton.setBounds(column(2), row(4), 170, 26);
        
        
        
        showPathsButton.setBounds(column(2), row(2), 170, 26);
        showPathsButton.setVisible(false);
        
        showPathToFileButton.setBounds(column(1), row(4), 270, 26);
        //showPathToFileButton.setVisible(false);
        
        displayResults = new JTextArea();
        displayResults.setBackground(new Color(89, 185, 217));
        displayResults.setBounds(column(1), row(4), 640, 500);
        displayResults.setVisible(false);
        Font font = new Font("Verdana", Font.BOLD, 12);
        displayResults.setFont(font);
        displayResults.setForeground(Color.YELLOW);
   
        text.setBackground(Color.blue);
        text.setBounds(column(1), row(13), 560, 260);
        text.setVisible(true);
        
        
        trivialEdit.setVisible(false);
        
        
        studentNumberLabel.setBounds(column(1), row(1), 400, 26);
        studentNameLabel.setBounds(column(1), row(2), 400, 26);
        explanationLabel.setBounds(column(1), row(7), 400, 260);
        studentHandleLabel.setBounds(column(1), row(3), 400, 26);
        pathLabel.setBounds(column(1), row(4), 400, 26);
        classPathLabel.setBounds(column(1), row(5), 400, 26);
        sourcePathLabel.setBounds(column(1), row(6), 400, 26);
        studentPathLabel.setBounds(column(1), row(7), 400, 26);
        outputFileNameLabel.setBounds(column(1), row(8), 540, 26);
        configurationFileNameLabel.setBounds(column(1), row(9), 400, 26);
        argsFileNameLabel.setBounds(column(1), row(10), 400, 26);
        successLabel.setBounds(column(1), row(11), 400, 26);
        currentSelectedStudentLabel.setBounds(column(2), row(15), 400, 26);
        
        runSingleButton.setBounds(column(2), row(1), 170, 26);
        runSingleButton.setVisible(false);
        runBatchButton.setBounds(column(1) + (buttonOffset+(buttonOffset/10)), row(8), 170, 26);
        runDemoBatchButton.setBounds(column(1), row(1), 500, 285);
        
        studentButtons = createResultButtons(studentprogramtester.App.roster.length);
        studentButtons.setBounds(column(1)+ 30, row(18), 700, ((studentprogramtester.App.roster.length/7)+1)*50);
        studentButtons.setVisible(false);
        studentButtons.setBackground(new Color(89, 185, 217)); 
        
        testButtons = new JPanel(new GridLayout(5,1));//createTestResultButtons(data);
        testButtons.setBounds(column(3), row(1), 200, 260);
         testButtons.setBackground(new Color(89, 185, 217)); 
        //testButtons.setBackground(Color.red);
        testButton1 = new JButton();
        testButton2 = new JButton();
        testButton3 = new JButton();
        testButton4 = new JButton();
        testButton5 = new JButton();
        
        testButtons.add(testButton1);
        testButtons.add(testButton2);
        testButtons.add(testButton3);
        testButtons.add(testButton4);
        testButtons.add(testButton5);
        
        testButtons.setVisible(false);
        
       
        setPathButton.addActionListener(new RunConfiguration.ControlButtonListener());
        setStudentPathButton.addActionListener(new RunConfiguration.ControlButtonListener());
        runSingleButton.addActionListener(new RunConfiguration.ControlButtonListener());
        setOutputFileNameButton.addActionListener(new RunConfiguration.ControlButtonListener());
        setArgsFileNameButton.addActionListener(new RunConfiguration.ControlButtonListener());
        runBatchButton.addActionListener(new RunConfiguration.ControlButtonListener());
        runDemoBatchButton.addActionListener(new RunConfiguration.ControlButtonListener());
        showPathsButton.addActionListener(new RunConfiguration.ControlButtonListener());
        showPathToFileButton.addActionListener(new RunConfiguration.ControlButtonListener());
        setPathButton.setText("Set Path");
        setStudentPathButton.setText("Set Student Path");
        setOutputFileNameButton.setText("Set Output file Name");
        setArgsFileNameButton.setText("Set args file");
        
        showPathsButton.setText("Show Paths");
        showPathToFileButton.setText("Am I the one?");
        
        
        
        runSingleButton.setText("Run Single");
        runBatchButton.setText("Run Batch");
       // runDemoBatchButton.setText("OS X / Demo Batch");
        //ImageIcon bill = new javax.swing.ImageIcon(getClass().getResource("/images/bb.gif"));
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/package1/package2/dump.jpg")));
         ImageIcon bill = new ImageIcon("images/bb.gif");
      
        runDemoBatchButton.setIcon(bill);
       // runDemoBatchButton.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/package1/package2/dump.jpg")));
        runBatchButton.setVisible(false);  // turn this off until the user selects the directory
       // runDemoBatchButton.setVisible(false);
      
       
       // this.setBackground(new Color(R, G, B));
        this.setBackground(new Color(89, 185, 217)); 
       
        this.add(studentNameLabel);
        this.add(explanationLabel);
        this.add(studentNumberLabel);
        this.add(studentHandleLabel);
        this.add(outputFileNameLabel);
        this.add(configurationFileNameLabel);
        this.add(argsFileNameLabel);
        this.add(pathLabel);
        this.add(classPathLabel);
        this.add(sourcePathLabel);
        this.add(studentPathLabel);
        this.add(successLabel);
        //this.add(currentSelectedStudentLabel);  // i was using this to find a bug, i found the bug
        
        this.add(setPathButton);
        this.add(setStudentPathButton);
        this.add(setOutputFileNameButton);
        this.add(setArgsFileNameButton);
        this.add(showPathsButton);
       // this.add(showPathToFileButton);
        
        hideLabels();
        
        this.add(runBatchButton);
     this.add(runDemoBatchButton);
        this.add(displayResults);
        
        
        this.add(runSingleButton);
       
        this.add(studentButtons);
        this.add(testButtons);
        
        
            this.add(  text  );
        
        new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    {   
                        // this is where you put where what happens when you drop
                        text.append( files[i].getCanonicalPath() + "\n" );
                         studentprogramtester.App.thisIsWhereYouPutTheMainFile = files[i].getCanonicalPath() +  "\\"; // need to add the slash here or it breaks
                         studentprogramtester.App.runCon.runBatchButton.setVisible(true);
                         text.setVisible(false);
                         
                            ImageIcon bill = new ImageIcon("images/Butters.png");
      
        runDemoBatchButton.setIcon(bill);
          runDemoBatchButton.setBounds(column(1) + (buttonOffset+(buttonOffset/10)), row(2), 180, 180);
                         explanationLabel.setText("<html><h2><font color='blue' size='6' face='verdana'>compiling: </font><font color='red'size='4'>" + files[i].getCanonicalPath() +  "</font><h2></html>");
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
        
        
        
        
        
     }  // end initialize components
      
     
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
private int row(int r){
    int pixelNumber = ((r-1)*36)+10;
    return pixelNumber;
}   

private int column(int c){ 
    int columnPixelNumber = 0;
    
    switch(c){  // these arent in cardinal order, i've been readjusting layouts
        case 1: columnPixelNumber = 210; break;
        case 2: columnPixelNumber = 10; break;
        case 3: columnPixelNumber = 980; break;
        case 4: columnPixelNumber = 400; break;
    }
    return columnPixelNumber;
} // end column
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
     
     
     
     
  public void showChooser(){  // this is from the example marc linked to in the google drive
      
                        chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());  // this is where you apply the dataObject.setVariable();
       chooserDirectorySelection = chooser.getCurrentDirectory().toString();
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
      chooserFileSelection = chooser.getSelectedFile().toString();
      }
    else {
      System.out.println("No Selection ");
      }
  }
      
  
  
  
  
    public class ControlButtonListener implements ActionListener{ // i'm pretty sure this is from Fred's IST 311 class
        public void actionPerformed(ActionEvent evt){
          
           JButton thisButton = (JButton) evt.getSource();
           
            if (thisButton == runSingleButton) {
                hideRunButtons();
                studentprogramtester.App.roster[currentSelectedStudent].emptyTestArrayLists();
              SingleTester s = new SingleTester(currentSelectedStudent);
              updateLabels(studentprogramtester.App.roster[currentSelectedStudent]);
              createTestResultButtons();//studentButtons.setVisible(false);
              hidePaths();
              showPathsButton.setText("Show paths");
            }
            
            
            
            
            if (thisButton == runBatchButton) {
                
                // move the run batch button to it's new location
                runBatchButton.setBounds(column(4), row(1), 170, 26);
                 hideRunButtons();
                 
                long howLongDidTestTake1 = System.currentTimeMillis();
                
                
                
                
                
                
 Thread t = new Thread() {
                      @Override 
                      public void run() {
                           BatchTester b = new BatchTester(); 
                      }
                };
    t.start();      
                
                
                
                
                
                
                
             
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
             //   long howLongDidTestTake2 = System.currentTimeMillis();
            //    long totalTime = howLongDidTestTake2 - howLongDidTestTake1;
             //   int averageTimePerStudent = (int)totalTime/studentprogramtester.App.roster.length;
            //    System.out.println("\n\n\nBatchTester.java ("  + studentprogramtester.App.roster.length+ " students) " + totalTime + " milliseconds (" + averageTimePerStudent + "/student)");
               // System.out.println("BatchTester.java took " + totalTime/1000 + "." + totalTime%1000 + " seconds, which was " + averageTimePerStudent/1000 + "." + averageTimePerStudent%1000 + " per student");
                
                
                //// this is just to print out a timestamp on the test results, it's handy code to have:
              //  Calendar c = Calendar.getInstance();
                // System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
                // http://docs.oracle.com/javase/tutorial/java/data/numberformat.html
              //   System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
                
                runBatchButton.setText("Run New Batch");
                runBatchButton.setVisible(false);
               //updateLabels(studentprogramtester.App.roster[currentSelectedStudent]);
               
            }
            
            
            
            
           
            if (thisButton ==  runDemoBatchButton) {
                fillTestClass();
               // isDemo = true;
                 hideRunButtons();
                 
               DemoBatchTester b = new DemoBatchTester();  // this still needs to work for UNIX
                 // fill the class roster with students
                 
               updateLabels(studentprogramtester.App.roster[currentSelectedStudent]);
               
            }
            
            
            
            
            if (thisButton == setArgsFileNameButton) {
                showChooser();
                argsFileNameLabel.setText(chooserFileSelection);
 
            }
            
            
            
            
            
            if (thisButton == setPathButton) {
                showChooser();
                pathLabel.setText(chooserFileSelection);
              studentprogramtester.App.roster[currentSelectedStudent].setPth("\\" + chooserFileSelection + "\\" );  // this needs to handle if the user enters nothing, otherwise it sets path to empty string
            }
            
            
            
            
            
            if (thisButton == showPathsButton) {
              if(showPathsButton.getText().equals("Hide paths")){
                  hidePaths();
                showPathsButton.setText("Show paths");  
              }
                else{
                  showPaths();
                  showPathsButton.setText("Hide paths");
                }
            
              
            }
            
             if (thisButton == showPathToFileButton) {
             showChooser();
                showPathToFileButton.setText(chooserFileSelection + "\\");
              studentprogramtester.App.thisIsWhereYouPutTheMainFile = chooserFileSelection + "\\"; // need to add the slash here or it breaks
            studentprogramtester.App.makeClass();
              runBatchButton.setVisible(true);
              runDemoBatchButton.setVisible(true);
            }
            
            
        }

      
    } // end ControlButtonListener
    

    
    
    
    
      private void hideRunButtons() {
          
          runSingleButton.setVisible(false);
          
        //  runBatchButton.setVisible(false);
          runDemoBatchButton.setVisible(false);
            studentButtons.setVisible(true);
            showPathToFileButton.setVisible(false);
            explanationLabel.setVisible(false);
            
               studentNameLabel.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentHandleLabel.setVisible(false);
        
        showPathsButton.setVisible(false);
        runSingleButton.setVisible(false);
        testButtons.setVisible(false);
     runBatchButton.setVisible(false);
           displayResults.setVisible(false);
            
            
        for(int i = 0; i < studentButtonArray.length; i++){
       
        studentButtonArray[i].setBackground(Color.gray);
       
    }
            
            
            
            
            
        }  // end hide run buttons
    
      
      
      
      
      
   private void fillTestClass(){
       
       for(int i = 0; i < data.totalNumberOfStudents; i++){
          DataObject d = new DataObject();
          d.setNme("Student #" + i);
          d.setNumbr(i);
          d.setHndl("handle #" + i);
          SmartButton b = new SmartButton();
        //  d.enterTestData();
         studentprogramtester.App.roster[i] = d;
         studentprogramtester.App.runCon.studentButtonArray[i] = b;
         
       }
       
        
       
   } // end fill test class
    
    
 public void updateLabels(DataObject data){
     
 
     
    studentNameLabel.setText("student name: " + data.getNme());
    studentNumberLabel.setText("student number: " + data.getNumbr());
    studentHandleLabel.setText("student Handle: " + data.getHndl());
    pathLabel.setText("path: "+ data.getPth());
    classPathLabel.setText("class path: "+ data.getClsPath());
    sourcePathLabel.setText("source path: "+data.getSrcPath());
    studentPathLabel.setText("student path: "+ data.getStdPath());
    outputFileNameLabel.setText("output file: "+ data.getOutFileName());
    configurationFileNameLabel.setText("configuration file name: "+ data.getConfigurationFileName() );
    argsFileNameLabel.setText("args file name: "+ data.getArgsFileName());
    successLabel.setText(data.showTestArray());
    
    
    
    // this works...
    currentSelectedStudentLabel.setText("current selected student: " + currentSelectedStudent);
    // so why doesn't this work??
    displayResults.setText(Utility.getContentsOfFile(getStudentFile()));// = testResultScreen();
    //displayResults.setText("current selected student: " + currentSelectedStudent);// = testResultScreen();
   
   
//       testButton1.setText( "OOO");
   //    testButton2.setText("lll");
     //   testButton3.setText("2222222");
   
    
 }  // end update labels   
    




 private JPanel createResultButtons(int numberOfStudents){
    
     
     // testing if this works
     if(isDemo){
     //fillTestClass();
     }       
             
    p = new JPanel(); 
    int rowNumber = 7;
    int dividedBySeven = (numberOfStudents/rowNumber) + 1;
    //p.setLayout(new GridLayout((numberOfStudents/7)+1,7));
    if(numberOfStudents == 7){
       p.setLayout(new GridLayout(1,7));  
    }else{
    p.setLayout(new GridLayout(dividedBySeven ,rowNumber));
    }
    studentButtonArray = new SmartButton[numberOfStudents];
    for(int i = 0; i < studentButtonArray.length; i++){
        SmartButton b = new SmartButton();
        b.setText("student " + i);
        b.setId(i);
        b.setBackground(Color.gray);
        b.addActionListener(new RunConfiguration.StudentButtonListener());
        studentButtonArray[i] = b;
        p.add(b);
    }
     
     
     return p;
 }  // end create result buttons 
 
 
 // i just cut and pasted the control button listener and adapted it for the student button array
     public class StudentButtonListener implements ActionListener{ // i'm pretty sure this is from Fred's IST 311 class
        public void actionPerformed(ActionEvent evt){
          
            SmartButton thisButton = (SmartButton) evt.getSource();
            DataObject d = studentprogramtester.App.roster[thisButton.getId()];
            trivialEdit.dispose();
            //System.out.println("");
            currentSelectedStudent = thisButton.getId();  // need this to run SingleTester.java on the correct student!
            //System.out.println("runconfiguration.java 476     currentSelectedStudent: " + currentSelectedStudent);  
       
            updateLabels(d);
            createTestResultButtons();
            showLabels();
            hidePaths();
            showPathsButton.setText("Show paths");  
            runSingleButton.setText("Run " + thisButton.getText());
        }
    } // end studentButtonListener
 
 
 
 
 private void hideLabels(){
     
        studentNameLabel.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentHandleLabel.setVisible(false);
        outputFileNameLabel.setVisible(false);
        configurationFileNameLabel.setVisible(false);
        argsFileNameLabel.setVisible(false);
        pathLabel.setVisible(false);
        classPathLabel.setVisible(false);
        sourcePathLabel.setVisible(false);
        studentPathLabel.setVisible(false);
        successLabel.setVisible(false);
        
        
        setPathButton.setVisible(false);
        setStudentPathButton.setVisible(false);
        setOutputFileNameButton.setVisible(false);
        setArgsFileNameButton.setVisible(false);
   
     

     
 }  // end hide labels
 
 
  private void showLabels(){
     
        studentNameLabel.setVisible(true);
        studentNumberLabel.setVisible(true);
        studentHandleLabel.setVisible(true);
        
        showPathsButton.setVisible(true);
        runSingleButton.setVisible(true);
        testButtons.setVisible(true);
     runBatchButton.setVisible(true);
     repaint();
 }  // end hide labels
 
  
  
 
 private void createTestResultButtons(){
   
      
     
   DataObject data1 = studentprogramtester.App.roster[currentSelectedStudent];   
   
   testButtons.remove(testButton4);
   testButtons.remove(testButton5);
   
   int i = 0; 
        
      testButton1.setText(data1.testFileNames.get(i));
      testButton1.setBackground(setColor(data1, i));
      testButton1.addActionListener(new RunConfiguration.TestButtonListener());
      testButton1.setOpaque(true);
      i++;
      testButton2.setText(data1.testFileNames.get(i));
      testButton2.setBackground(setColor(data1, i));
      testButton2.addActionListener(new RunConfiguration.TestButtonListener());
      testButton2.setOpaque(true);
      i++;
      testButton3.setText(data1.testFileNames.get(i));
      testButton3.setBackground(setColor(data1, i));
      testButton3.addActionListener(new RunConfiguration.TestButtonListener());
      testButton3.setOpaque(true);
       if(data1.testFileNames.size()>3){       
      i++;
      testButton4.setText(data1.testFileNames.get(i));
      testButton4.setBackground(setColor(data1, i));
      testButton4.addActionListener(new RunConfiguration.TestButtonListener());
      testButton4.setOpaque(true);
      testButtons.add(testButton4);
        
       }
       if(data1.testFileNames.size()>4){ 
      i++;
      testButton5.setText(data1.testFileNames.get(i));
      testButton5.setBackground(setColor(data1, i));
      testButton5.addActionListener(new RunConfiguration.TestButtonListener());
      testButton5.setOpaque(true);
      testButtons.add(testButton5);
       }
 }  // end create result buttons  
 
 
 
 
 
 
 
private Color setColor(DataObject data, int arrayNumber){
    Color color = Color.green;
    if(data.testFileResults.get(arrayNumber)!=0){
        color = Color.red;
    }
    
    return color;
}
 







      public class TestButtonListener implements ActionListener{ // i'm pretty sure this is from Fred's IST 311 class
        public void actionPerformed(ActionEvent evt){
          
           JButton thisButton = (JButton) evt.getSource();
              // this is where we open the student's java file, which has been converted to a (.txt -?) file
           trivialEdit.dispose();
         // for some reason i'm getting a blank space at the beginning when I getText() from the button (maybe it's happening when we setText() - i looked, couldn't find the probem), havent found out why, starting the string at substring(1) fixes the problem
              if(currentSelectedStudent!=0){
                  trivialEdit = new TrivialEdit(studentprogramtester.App.roster[currentSelectedStudent].pathToFile +  studentprogramtester.App.outputFile + "\\student" + currentSelectedStudent + "\\" + thisButton.getText().substring(1));
              }
            trivialEdit.setVisible(true);
            setSize(600, 600); 
             trivialEdit.setLocation(804, 0);
            //displayResults.setVisible(false);
           // System.out.println(studentprogramtester.App.roster[currentSelectedStudent].pathToFile + "src-output\\student" + currentSelectedStudent + "\\" + thisButton.getText().substring(1));
           // thisButton.setText("show test file");
           //  thisButton.setBackground(Color.gray);
            
            
            
            
        }
    } // end testButtonListener
 
 public void showPaths(){
     
          outputFileNameLabel.setVisible(true);
        configurationFileNameLabel.setVisible(true);
        argsFileNameLabel.setVisible(true);
        pathLabel.setVisible(true);
        classPathLabel.setVisible(true);
        sourcePathLabel.setVisible(true);
        studentPathLabel.setVisible(true);
        successLabel.setVisible(true);
        
        
        setPathButton.setVisible(true);
        setStudentPathButton.setVisible(true);
        setOutputFileNameButton.setVisible(true);
        setArgsFileNameButton.setVisible(true);
       displayResults.setVisible(false);
        runSingleButton.setVisible(true);
        studentButtons.setVisible(true); // false hides the buttons
 }  // end show paths
 
 
  public void hidePaths(){
     
          outputFileNameLabel.setVisible(false);
        configurationFileNameLabel.setVisible(false);
        argsFileNameLabel.setVisible(false);
        pathLabel.setVisible(false);
        classPathLabel.setVisible(false);
        sourcePathLabel.setVisible(false);
        studentPathLabel.setVisible(false);
        successLabel.setVisible(false);
        
        
        setPathButton.setVisible(false);
        setStudentPathButton.setVisible(false);
        setOutputFileNameButton.setVisible(false);
        setArgsFileNameButton.setVisible(false);
    
           displayResults.setVisible(true);
        studentButtons.setVisible(true);
 }  // end show paths
 

  
  
  
    private String getStudentFile() {
        //return Utility.getConfigItem("StudentFilePath", whereIsTheFolder + "students.txt");
        if(currentSelectedStudent == 0){
          return Utility.getConfigItem("StudentFilePath", studentprogramtester.App.thisIsWhereYouPutTheMainFile + studentprogramtester.App.outputFile + "\\mudgettdr\\output-mudgettdr.txt");  
        }else{
        return Utility.getConfigItem("StudentFilePath", studentprogramtester.App.thisIsWhereYouPutTheMainFile + studentprogramtester.App.outputFile + "\\student" + currentSelectedStudent + "\\output-student" + currentSelectedStudent + ".txt");
        }
        }

  
      private JTextArea testResultScreen() {
         
        JTextArea trs = new JTextArea(Utility.getContentsOfFile(getStudentFile()));
       
        
        return trs;
    }
  
  
  
  
 
} // end
