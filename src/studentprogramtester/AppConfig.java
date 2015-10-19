/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;

import java.awt.GridLayout;
import javax.swing.*;


/**
 *
 * @author marcc_000
 */
public class AppConfig extends JPanel 
{
    public AppConfig()
    {
        GridLayout GL = new GridLayout(0,2);
        super.setLayout(GL);
        GL.setHgap(5);
        GL.setVgap(5);
        GL.layoutContainer(this);
        
        this.add(new JLabel("Student File Location"));

            JFileChooser Studentchooser = new JFileChooser();
            Studentchooser.setCurrentDirectory(new java.io.File("."));
            //Studentchooser.setDialogTitle("choosertitle");
            //Studentchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //Studentchooser.setAcceptAllFileFilterUsed(false);
        
        
        this.add(Studentchooser);
        
        this.add(new JLabel("JRE Run Time Location"));
        this.add(new JLabel("Directory Lookup CONTROL goes HERE"));
        
        this.add(new JLabel("Compiled File Location"));
        this.add(new JLabel("Directory Lookup CONTROL goes HERE"));
        
        this.add(new JLabel("Output Location"));
        this.add(new JLabel("Directory Lookup CONTROL goes HERE"));       
    }
}
