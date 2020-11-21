import classes.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class JVM extends JFrame {
    JFrame mainframe = new JFrame("JVM");
    programHandler handler = programHandler.getInstance();
    private JButton btn_addproject;
    private JButton btn_addtask;
    private JButton btn_assignteams;
    private JList list_teams;
    private JLabel lbl_projecttasks;
    private JTable table_project;
    private JTextArea textArea_details;
    private JPanel mainPanel;
    private JToolBar topToolBar;
    private JLabel lbl_projecttabletitle;
    private JButton savebtn;
    private JComboBox Projectcbx;
    private JLabel ProjectSelect;


    public void initialise_GUI(){
        ArrayList<Task> tasks = handler.currentProject.getProjectTasks();
        String[] headings = {"Task Description", "Assigned to Team: ", "Starts:", "Ends:"};
        String[][] data = {
                {"Hello Task", "Team A", " 2020-12-15", "2020-12-16"}
        };


        table_project = new JTable(data,headings);
        JScrollPane sp=new JScrollPane(table_project);
        mainframe.add(sp);
    }

    //Creates the functions
    public JVM() throws IOException {

        mainframe.setContentPane(mainPanel);
        //mainframe.setSize(700, 600);
        initialise_GUI();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setVisible(true);


        btn_addproject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Project_gui Project = new Project_gui();
                Project.setContentPane(new Project_gui().projectPanel);
                Project.pack();
                Project.setVisible(true);
            }
        });

        btn_addtask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Task_gui Task = new Task_gui();
                Task.setContentPane(new Task_gui().taskPanel);
                Task.pack();
                Task.setVisible(true);
            }
        });

        btn_assignteams.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Team_gui Team = new Team_gui();
                Team.setContentPane(new Team_gui().teamPanel);
                Team.pack();
                Team.setVisible(true);
            }
        });

        list_teams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });

        table_project.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               // model.insertRow(model.getRowCount(), new Object[]{})
                //JVMTable JVMTable = new JVMTable();
                //JVMTable = (DefaultTableModel)table_project.getModel();

            }
        });

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try { handler.saveInstances();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("ERROR: Projects failed to save");
                }
            }
        });

        Projectcbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
