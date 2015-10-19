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
    private JButton btnLogin;
    JTextField jtfUname;
    JPasswordField pwd;
    private JTabbedPane m_jt;
    public WelcomeTab(JTabbedPane jtp)
    {
        super(new FlowLayout());
        m_jt = jtp;
        JLabel lblUname = new JLabel("Username");
        this.add(lblUname);
        jtfUname = new JTextField();
        jtfUname.setPreferredSize(new Dimension(100,20));
        this.add(jtfUname);
        
        JLabel lblPwd = new JLabel("Password");
        this.add(lblPwd);
        pwd = new JPasswordField();
        pwd.setPreferredSize(new Dimension(100,20));
        this.add(pwd);
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(alBtnLogin);
        this.add(btnLogin);
        
    }

    ActionListener alBtnLogin = new ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
             if (e.getSource() == btnLogin)
             {
                 Boolean isOK = Utility.AuthenticateUser(jtfUname.getText(),new String(pwd.getPassword()));
                 if (isOK)
                 {
                     // enable the panels
                     m_jt.setEnabledAt(1, true);
                     m_jt.setEnabledAt(2, true);
                     m_jt.setEnabledAt(3, true);
                     m_jt.setEnabledAt(4, true);
                     
                 }
             }
        }        
    };
            
    
}
