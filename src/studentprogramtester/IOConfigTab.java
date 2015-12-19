/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author marcc_000
 */
public class IOConfigTab extends JPanel
{
    JTextArea tbCMDLineArgs;
    JTextArea tbTestInput;
    RoundButton btnSave;
    RoundButton btnCancel;
    
    String whereIsTheFolder = studentprogramtester.App.thisIsWhereYouPutTheMainFile;
    
    
    
    public IOConfigTab()
    {
        configureLayout();
    }

    private void configureLayout()
    {
        GridLayout GL = new GridLayout(0,2);
        super.setLayout(GL);
        GL.setHgap(5);
        GL.setVgap(5);
        GL.layoutContainer(this);

        JLabel lblCmdLineArgs = new JLabel("Command Line Arguments");
        tbCMDLineArgs = new JTextArea();
        tbCMDLineArgs.setText(Utility.getContentsOfFile(Utility.getConfigItem("ArgsTextFile", whereIsTheFolder + studentprogramtester.App.testArgumentFile)));

        JLabel lblTestInput = new JLabel("System Inputs");
        tbTestInput = new JTextArea();
        tbTestInput.setText(Utility.getContentsOfFile(Utility.getConfigItem("TestInputTextFile", whereIsTheFolder + studentprogramtester.App.testInputFile)));
        
        btnSave = new RoundButton("Save");
        btnSave.addActionListener(ALSaveButton);
        
        btnCancel = new RoundButton("Cancel");

        super.add(lblCmdLineArgs);
        super.add(tbCMDLineArgs);

        super.add(lblTestInput);
        super.add(tbTestInput);
        
        super.add(btnSave);
        super.add(btnCancel);

    }
    
    
    ActionListener ALSaveButton = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            Utility.writeFile(Utility.getConfigItem("ArgsTextFile", whereIsTheFolder + studentprogramtester.App.testArgumentFile), tbCMDLineArgs.getText());
            Utility.writeFile(Utility.getConfigItem("TestInputTextFile", whereIsTheFolder + studentprogramtester.App.testInputFile), tbTestInput.getText());
        }

    };
    
            
    

}
