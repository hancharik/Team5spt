package studentprogramtester;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class StudentConfigTab extends JPanel {

    JPanel StudentPanel;
    JTextArea taStud;

    
     String whereIsTheFolder = studentprogramtester.App.data.pathToFile;
    
    
    
    
    public StudentConfigTab() {
        //super();
        BorderLayout BL = new BorderLayout();
        //BL.layoutContainer(this);
        this.setLayout(BL);
        StudentPanel = studentPanel();
        this.add(StudentPanel, BorderLayout.WEST);
        this.add(configureTopButtons(), BorderLayout.NORTH);

        JButton btnSaveConfig = new JButton("Save");
        btnSaveConfig.addActionListener(alSave);

        this.add(btnSaveConfig, BorderLayout.SOUTH);
        this.add(StudentEdits(), BorderLayout.EAST);
    }

    private JPanel StudentEdits() {
        JPanel se = new JPanel(new BorderLayout());
        taStud = new JTextArea(Utility.getContentsOfFile(getStudentFile()));
        se.add(taStud, BorderLayout.CENTER);
        JButton btnSaveStudentEdit = new JButton("Save Edits");
        btnSaveStudentEdit.addActionListener(alSaveStudentEdit);
        se.add(btnSaveStudentEdit, BorderLayout.SOUTH);
        return se;
    }

    private JPanel configureTopButtons() {
        JPanel configBtns = new JPanel();
        configBtns.setLayout(new GridLayout(0, 2));

        JButton btnSelectAll = new JButton("Select All Students");
        btnSelectAll.addActionListener(alSelectAll);
        configBtns.add(btnSelectAll);

        JButton btnSelectNone = new JButton("Clear Selection");
        btnSelectNone.addActionListener(alSelectNone);
        configBtns.add(btnSelectNone);

        return configBtns;
    }

    private JPanel studentPanel() {
        JPanel jp = new JPanel();
        BoxLayout bx = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(bx);

        String file = getStudentFile();
        // get the current configuration
        List<String> studList = getStudents();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String ls = System.getProperty("line.separator");
            String line = "";
            try {
                while ((line = reader.readLine()) != null) {
                    
                    if (line.trim().length() > 2) {
                        String[] sArr = line.split("\t");
                        JCheckBox jcb = new JCheckBox(line);

                        jcb.setSelected(studList.contains(sArr[0]));

                        jp.add(jcb);
                    }
                }
            } catch (IOException IOE) {
            }
        } catch (FileNotFoundException fnfex) {
        }
        return jp;
    }

    ActionListener alSelectAll = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component c : StudentPanel.getComponents()) {
                if (c instanceof JCheckBox) {
                    // seriously WTF java, why can't I do this in one line
                    JCheckBox j = (JCheckBox) c;
                    if (!j.isSelected()) {
                        j.doClick();
                    }
                }
            }
        }
    };

    ActionListener alSelectNone = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component c : StudentPanel.getComponents()) {
                if (c instanceof JCheckBox) {
                    // seriously WTF java, why can't I do this in one line
                    JCheckBox j = (JCheckBox) c;
                    if (j.isSelected()) {
                        j.doClick();
                    }
                }
            }
        }
    };

    ActionListener alSave = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            for (Component c : StudentPanel.getComponents()) {
                if (c instanceof JCheckBox) {
                    JCheckBox j = (JCheckBox) c;
                    if (j.isSelected()) {
                        sb.append(j.getText());
                    }
                }
            }
            // now save it all
            Utility.writeFile(Utility.getConfigItem("ConfigureBatch", whereIsTheFolder + "configbatch.txt"), sb.toString());
            JOptionPane.showMessageDialog(StudentPanel, "Successfully Saved Student Configuration");
        }
    };

    // get a list of the previously selected students and use to mark them checked later
    private List<String> getStudents() {
        List<String> studentList = new ArrayList<String>();
        String file = Utility.getConfigItem("ConfigureBatch", whereIsTheFolder + "configbatch.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String ls = System.getProperty("line.separator");
            String line = "";
            try {
                while ((line = reader.readLine()) != null) {
                    String[] StudentARR = line.split("\t");
                    studentList.add(StudentARR[0]);
                }
            } catch (IOException IOE) {
            }
        } catch (FileNotFoundException fnfex) {
        }

        return studentList;
    }

    ActionListener alSaveStudentEdit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Utility.writeFile(getStudentFile(), taStud.getText());
            JOptionPane.showMessageDialog(StudentPanel, "Successfully Saved Student Edits");
        }
    };

    private String getStudentFile() {
        return Utility.getConfigItem("StudentFilePath", whereIsTheFolder + "students.txt");
        
    }
}
