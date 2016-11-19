package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class AdminFrame extends javax.swing.JFrame {
    
    AdminController admin = new AdminController();
    final JPopupMenu pop = new JPopupMenu();
    final JPopupMenu adminpop = new JPopupMenu();
    String username;
    int index;
    
    private void addPopUp() {
        JMenuItem edit = new JMenuItem("Edit Name");
        JMenuItem pwdChange = new JMenuItem("Change Password");
        JMenuItem delete = new JMenuItem("Delete");
        JMenuItem refresh = new JMenuItem("Refresh");
        //Adding to popup menu
        pop.add(edit);
        pop.add(pwdChange);
        pop.add(delete);
        pop.add(refresh);

        //Events Handled Here
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + getTab() + " " + username);
                if (res == JOptionPane.YES_OPTION) {
                    admin.deleteRole(getTab(), username);
                    loadstaff();
                }
            }
        });
        edit.addActionListener((ActionEvent e) -> {
            String newUsername = JOptionPane.showInputDialog(rootPane, "Enter the new Username");
            System.out.println("Changing username from " + username + " to " + newUsername);
            admin.editRole(getTab(), username, newUsername);
            loadstaff();
        });
        pwdChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = JOptionPane.showInputDialog(rootPane, "Enter the new Password(Will Be Shown Here)");
                System.out.println("Changing password of " + username);
                admin.changePassword(getTab(), username, newPassword);
                loadstaff();
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadstaff();
            }
        });
    }
    private void initAdminPop(){
        JMenuItem logout = new JMenuItem("Logout");
        
        adminpop.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
    }
    public void close(){
        this.dispose();
        new LoginGUI().setVisible(true);
    }
    public AdminFrame() {
        initComponents();
        loadstaff();
        addPopUp();
        initAdminPop();
    }

    public AdminFrame(String adminName) {
        jLabel6.setText(adminName);
        initComponents();
        loadstaff();
        addPopUp();
    }
    
    public String getTab() {
        String actor;
        int getSelectedTab = jTabbedPane1.getSelectedIndex();
        if (getSelectedTab == 0) {
            actor = "counterperson";
        } else {
            actor = "manager";
        }
        return actor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        counterpersonJlist = new javax.swing.JList(new DefaultListModel());
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        managerJlist = new javax.swing.JList(new DefaultListModel());
        addRoleButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        counterpersonJlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                counterpersonJlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(counterpersonJlist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Counterperson", jPanel1);

        managerJlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerJlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(managerJlist);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manager", jPanel2);

        addRoleButton.setText("Add Role");
        addRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoleButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        jButton4.setText("Administrator");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(addRoleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addRoleButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void counterpersonJlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_counterpersonJlistMouseClicked
        counterpersonJlist.setSelectedIndex(counterpersonJlist.locationToIndex(evt.getPoint()));
        username = counterpersonJlist.getSelectedValue();
        index = counterpersonJlist.getSelectedIndex();

        //To Determine whether the user has right clicked or not
        if (SwingUtilities.isRightMouseButton(evt) && counterpersonJlist.locationToIndex(evt.getPoint()) == index) {
            //Make sure not empty
            if (!counterpersonJlist.isSelectionEmpty()) {
                pop.show(counterpersonJlist, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_counterpersonJlistMouseClicked

    private void managerJlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerJlistMouseClicked
        managerJlist.setSelectedIndex(managerJlist.locationToIndex(evt.getPoint()));
        username = managerJlist.getSelectedValue();
        index = managerJlist.getSelectedIndex();

        //To Determine whether the user has right clicked or not
        if (SwingUtilities.isRightMouseButton(evt) && managerJlist.locationToIndex(evt.getPoint()) == index) {
            //Make sure not empty
            if (!managerJlist.isSelectionEmpty()) {
                pop.show(managerJlist, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_managerJlistMouseClicked

    private void addRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoleButtonActionPerformed
        JPanel adPanel = new JPanel();
        adPanel.setLayout(new BoxLayout(adPanel, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel("Enter username");
        JTextField usernameField = new JTextField();
        JLabel pwdLabel = new JLabel("Enter Password");
        JPasswordField pwd = new JPasswordField();
        adPanel.add(label);
        adPanel.add(usernameField);
        adPanel.add(pwdLabel);
        adPanel.add(pwd);
        int res = JOptionPane.showConfirmDialog(null, adPanel, "New " + getTab(), JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            admin.addRole(getTab(), usernameField.getText(), new String(pwd.getPassword()));
            loadstaff();
        }
    }//GEN-LAST:event_addRoleButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        adminpop.show(this, jButton4.getX(), jButton4.getY());
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoleButton;
    private javax.swing.JList<String> counterpersonJlist;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> managerJlist;
    // End of variables declaration//GEN-END:variables
 void loadstaff() {
        //    AdminController admin = new AdminController();
        DefaultListModel listModel = (DefaultListModel) counterpersonJlist.getModel();
        listModel.removeAllElements();
        for (String ar : admin.getCounterPeople()) {
            listModel.addElement(ar);
        }
        counterpersonJlist.setModel(listModel);
        DefaultListModel listModel1 = (DefaultListModel) managerJlist.getModel();
        listModel1.removeAllElements();
        for (String ar : admin.getManagers()) {
            listModel1.addElement(ar);
        }
        managerJlist.setModel(listModel1);
    }
    
//    void addRole() {
//        AdminController adder = new AdminController();
//        
//    }
}
