/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author marcc_000
 */
public class WelcomeTab extends JPanel
{
    private String instructions = "grab your ankles and kiss your ass goodbye";
    private JButton btnLogin;
    JTextField jtfUname;
    JPasswordField pwd;
    private JTabbedPane mainPane;
    public WelcomeTab(JTabbedPane tabbedPane)
    {
        super(new FlowLayout());
        mainPane = tabbedPane;
        JLabel instructionsLabel2 = new JLabel(instructions);
        this.add(instructionsLabel2);
        jtfUname = new JTextField();
        jtfUname.setPreferredSize(new Dimension(100,20));
        //this.add(jtfUname);
        
        JLabel instructionsLabel1 = new JLabel(instructions);
        this.add(instructionsLabel1);
        pwd = new JPasswordField();
        pwd.setPreferredSize(new Dimension(100,20));
        //this.add(pwd);
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(alBtnLogin);
        //this.add(btnLogin);
        
        
 
        
        
        
        
        
        
        
    }

    ActionListener alBtnLogin = new ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
             if (e.getSource() == btnLogin)
             {
                
             }
        }        
    };
            
    
}
