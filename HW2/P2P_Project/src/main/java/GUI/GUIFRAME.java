package GUI;

import NetWork.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.font.TextAttribute;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class GUIFRAME extends javax.swing.JFrame {
    GUIControler GUIC = new GUIControler();

    public GUIFRAME() {
        initComponents();
        GUIC.setDataBase(USER.getUsersFromDataBase("DataBase.txt"));
        GUIC.setTargetUsers(new ArrayList<>());
        GUIC.setDlm(new DefaultListModel());
        GUIC.setCT(new ClientThread());
        GUIC.setST(new ServerThread());
        GUIC.setTCPS(new TCP_Server());
        GUIC.setTCPC(new TCP_client());
        GUIC.getTCPS().setL(jList1);
        
        //USER.PrintUsersList(GUIC.getDataBase(), jList1);
        UnderLineLable();
        InterfaceNetowrk();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManiP = new javax.swing.JPanel();
        LoginP = new javax.swing.JPanel();
        UserNameL = new javax.swing.JLabel();
        UserNameT = new javax.swing.JTextField();
        LoginB = new javax.swing.JButton();
        LogoutB = new javax.swing.JButton();
        NewUserL = new javax.swing.JLabel();
        ChatP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        SendB = new javax.swing.JButton();
        MessageConfigrations = new javax.swing.JPanel();
        LocalIPL = new javax.swing.JLabel();
        LocalPortL = new javax.swing.JLabel();
        LocalIPT = new javax.swing.JTextField();
        LocalPortT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        UploadB = new javax.swing.JButton();
        InterfaseComBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        MessagesAreaTA = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ServerConfigreations = new javax.swing.JPanel();
        TCPServerIPL = new javax.swing.JLabel();
        TCPServerPortL = new javax.swing.JLabel();
        TCPServerIPT = new javax.swing.JTextField();
        TCPServerPortT = new javax.swing.JTextField();
        OnlineUsersL = new javax.swing.JLabel();
        OnlineUsersList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        ConnectToServerB = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Messenger V 1.0");
        setResizable(false);

        UserNameL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UserNameL.setText("Username :");

        UserNameT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        UserNameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameTActionPerformed(evt);
            }
        });

        LoginB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LoginB.setText("LOGIN");
        LoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginBMousePressed(evt);
            }
        });

        LogoutB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LogoutB.setText("LOGOUT");
        LogoutB.setEnabled(false);
        LogoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBActionPerformed(evt);
            }
        });

        NewUserL.setForeground(new java.awt.Color(255, 51, 51));
        NewUserL.setText("New User ?");
        NewUserL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NewUserLMousePressed(evt);
            }
        });

        javax.swing.GroupLayout LoginPLayout = new javax.swing.GroupLayout(LoginP);
        LoginP.setLayout(LoginPLayout);
        LoginPLayout.setHorizontalGroup(
            LoginPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(UserNameT)
                .addGap(18, 18, 18)
                .addGroup(LoginPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(NewUserL, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginPLayout.createSequentialGroup()
                        .addComponent(LoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LogoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        LoginPLayout.setVerticalGroup(
            LoginPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(LoginPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameL)
                    .addComponent(UserNameT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginB)
                    .addComponent(LogoutB))
                .addGap(3, 3, 3)
                .addComponent(NewUserL))
        );

        ChatP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setToolTipText("Enter Your Message Here");
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        SendB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SendB.setText("Send");
        SendB.setEnabled(false);
        SendB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SendBMousePressed(evt);
            }
        });

        MessageConfigrations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message Configurations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        LocalIPL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LocalIPL.setText("Local IP :");

        LocalPortL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LocalPortL.setText("Local Port # :");

        LocalIPT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        LocalPortT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel1.setText("Send Meassge to :");

        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout MessageConfigrationsLayout = new javax.swing.GroupLayout(MessageConfigrations);
        MessageConfigrations.setLayout(MessageConfigrationsLayout);
        MessageConfigrationsLayout.setHorizontalGroup(
            MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageConfigrationsLayout.createSequentialGroup()
                .addGroup(MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessageConfigrationsLayout.createSequentialGroup()
                        .addGroup(MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocalPortL)
                            .addComponent(LocalIPL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocalIPT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(LocalPortT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(MessageConfigrationsLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        MessageConfigrationsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LocalIPT, LocalPortT});

        MessageConfigrationsLayout.setVerticalGroup(
            MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageConfigrationsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalIPL)
                    .addComponent(LocalIPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MessageConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalPortL)
                    .addComponent(LocalPortT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        UploadB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UploadB.setText("Upload File /.txt");
        UploadB.setEnabled(false);
        UploadB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UploadBMousePressed(evt);
            }
        });

        InterfaseComBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        InterfaseComBox.setEnabled(false);
        InterfaseComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaseComBoxActionPerformed(evt);
            }
        });

        MessagesAreaTA.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(MessagesAreaTA);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Disconnect");
        jButton1.setEnabled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Disconnect All");
        jButton2.setEnabled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout ChatPLayout = new javax.swing.GroupLayout(ChatP);
        ChatP.setLayout(ChatPLayout);
        ChatPLayout.setHorizontalGroup(
            ChatPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChatPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(InterfaseComBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ChatPLayout.createSequentialGroup()
                        .addGroup(ChatPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UploadB, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SendB, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(MessageConfigrations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        ChatPLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SendB, UploadB, jButton1, jButton2});

        ChatPLayout.setVerticalGroup(
            ChatPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatPLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InterfaseComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ChatPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChatPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MessageConfigrations, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChatPLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(SendB)
                        .addGap(10, 10, 10)
                        .addComponent(UploadB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ChatPLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SendB, UploadB, jButton1, jButton2});

        ServerConfigreations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server Configurations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        TCPServerIPL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TCPServerIPL.setText("TCP Server IP :");

        TCPServerPortL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TCPServerPortL.setText("TCP Server Port # :");

        TCPServerIPT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TCPServerIPT.setText("localhost");

        TCPServerPortT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TCPServerPortT.setText("1010");
        TCPServerPortT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCPServerPortTActionPerformed(evt);
            }
        });

        OnlineUsersL.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        OnlineUsersL.setText("Online Users");

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 0, 0));
        OnlineUsersList.setViewportView(jList1);

        ConnectToServerB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ConnectToServerB.setText("Connect To Server");
        ConnectToServerB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConnectToServerBMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ServerConfigreationsLayout = new javax.swing.GroupLayout(ServerConfigreations);
        ServerConfigreations.setLayout(ServerConfigreationsLayout);
        ServerConfigreationsLayout.setHorizontalGroup(
            ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerConfigreationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ServerConfigreationsLayout.createSequentialGroup()
                        .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TCPServerPortL)
                            .addComponent(TCPServerIPL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TCPServerIPT)
                            .addComponent(TCPServerPortT)))
                    .addComponent(OnlineUsersList, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ServerConfigreationsLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OnlineUsersL)
                    .addComponent(ConnectToServerB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ServerConfigreationsLayout.setVerticalGroup(
            ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerConfigreationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TCPServerIPL)
                    .addComponent(TCPServerIPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ServerConfigreationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TCPServerPortL)
                    .addComponent(TCPServerPortT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(ConnectToServerB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OnlineUsersL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OnlineUsersList, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("<");
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout ManiPLayout = new javax.swing.GroupLayout(ManiP);
        ManiP.setLayout(ManiPLayout);
        ManiPLayout.setHorizontalGroup(
            ManiPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManiPLayout.createSequentialGroup()
                .addGroup(ManiPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoginP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ManiPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ChatP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(4, 4, 4)
                .addComponent(jButton3)
                .addGap(5, 5, 5)
                .addComponent(ServerConfigreations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ManiPLayout.setVerticalGroup(
            ManiPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManiPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ManiPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ServerConfigreations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ManiPLayout.createSequentialGroup()
                        .addComponent(LoginP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManiPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChatP, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManiPLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(46, 46, 46))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ManiP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ManiP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameTActionPerformed
                if (UserNameT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Plese Enter Youer User Name");
        } else {
            LogIn();
        }
    }//GEN-LAST:event_UserNameTActionPerformed

    private void NewUserLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewUserLMousePressed
        SIGNIN SI = new SIGNIN(GUIC,TCPServerIPT.getText(),Integer.parseInt(TCPServerPortT.getText()));
        SI.setVisible(true);
        SI.setLocationRelativeTo(this);
    }//GEN-LAST:event_NewUserLMousePressed

    private void SendBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendBMousePressed
        if (!(jTextArea2.getText().equals("") || GUIC.getTargetUsers().isEmpty())) {
            Message M = new Message(LocalIPT.getText(), Integer.parseInt(LocalPortT.getText()));
            M.setData(jTextArea2.getText());
            jTextArea2.setText("");
            try {
                GUIC.setCurruntUser(GUIC.getTCPS().getCurrentUser());
                System.out.print(GUIC.getTargetUsers().get(0).getUserName()+"<-"+GUIC.getCurruntUser().getUserName());
                GUIC.getCT().SendData(GUIC.getTargetUsers(), GUIC.getCurruntUser(), M, MessagesAreaTA);
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_SendBMousePressed

    private void LoginBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBMousePressed
        if (UserNameT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Plese Enter Youer User Name");
        } else {
            LogIn();
        }
    }//GEN-LAST:event_LoginBMousePressed

    private void InterfaseComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterfaseComBoxActionPerformed
        String S = (String) InterfaseComBox.getSelectedItem();
        S = S.split("/")[1];
        LocalIPT.setText(S);
    }//GEN-LAST:event_InterfaseComBoxActionPerformed

    private void LogoutBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBActionPerformed
        LogOut();
    }//GEN-LAST:event_LogoutBActionPerformed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        if (GUIC.isLOGEDIN()) {
            jList2.setModel(GUIC.getDlm());
            jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            jList1.getSelectedValuesList().forEach(sel -> {
                if (!GUIC.getDlm().contains(sel)) {
                    GUIC.getDlm().addElement(sel);
                    String SelctedI[] = sel.split(",");
                    USER S = new USER(SelctedI[0], SelctedI[1], Integer.parseInt(SelctedI[2]));
                    GUIC.getTargetUsers().add(S);
                }
            });
        }
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        GUIC.getDlm().clear();
        jList2.setModel(GUIC.getDlm());
        GUIC.getTargetUsers().clear();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
       
        if (GUIC.isLOGEDIN()) {
            //jList2.setModel(GUIC.getDlm());
            jList2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            jList2.getSelectedValuesList().forEach(sel -> {
                    GUIC.getDlm().removeElement(sel);
                    String SelctedI[] = sel.split(",");
                    GUIC.getTargetUsers().remove(USER.findUser(GUIC.getTargetUsers(), SelctedI[0]));
            });
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void TCPServerPortTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCPServerPortTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCPServerPortTActionPerformed

    private void ConnectToServerBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectToServerBMousePressed
        // TODO add your handling code here:
        
        
        
        
        
        
    }//GEN-LAST:event_ConnectToServerBMousePressed

    private void UploadBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadBMousePressed
        // TODO add your handling code here:
        //////////////**************************
        File fileToSend;
        JFileChooser FC=new JFileChooser();
        int State=FC.showOpenDialog(LoginB);
        if (State==JFileChooser.APPROVE_OPTION){
            fileToSend=FC.getSelectedFile();
            try {
                GUIC.setCurruntUser(GUIC.getTCPS().getCurrentUser());
                System.out.print(GUIC.getTargetUsers().get(0).getUserName()+"<-"+GUIC.getCurruntUser().getUserName());
                GUIC.getCT().SendFile(GUIC.getTargetUsers(), GUIC.getCurruntUser(), fileToSend, MessagesAreaTA);
            } catch (Exception ex) {

            }
        
        }
        
        
        
        
    }//GEN-LAST:event_UploadBMousePressed
    private void LogIn() {
            
            GUIC.getTCPS().setSPortNum(Integer.parseInt(LocalPortT.getText()));
            GUIC.getTCPS().start();

            USER NewUser = new USER(UserNameT.getText(),"",0);
            NewUser.setLogedIn(true);
            NewUser.setNewUser(false);
            try {
                GUIC.getTCPC().SendData(NewUser, TCPServerIPT.getText(), Integer.parseInt(TCPServerPortT.getText()));
            } catch (Exception ex) {
                Logger.getLogger(SIGNIN.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
            ChangEnable(true);

            GUIC.getST().setTA(MessagesAreaTA);
            GUIC.getST().setSPortNum(Integer.parseInt(LocalPortT.getText()));
            
            if (!GUIC.isSTStarted()) {
                GUIC.setFlag(true);
                GUIC.getST().start();
            } else {
                GUIC.getST().resume();
            }
    }

    private void ChangEnable(boolean X) {
        jButton1.setEnabled(X);
        jButton2.setEnabled(X);
        jButton3.setEnabled(X);
        LogoutB.setEnabled(X);
        InterfaseComBox.setEnabled(X);
        SendB.setEnabled(X);
        LocalIPT.setEnabled(X);
        jTextArea2.setEnabled(X);
        GUIC.setLOGEDIN(X);
        LoginB.setEnabled(!X);
        UploadB.setEnabled(X);
    }

    private void LogOut() {
        USER NewUser = new USER(UserNameT.getText(),"",0);
            NewUser.setLogedIn(false);
            NewUser.setNewUser(false);
            try {
                GUIC.getTCPC().SendData(NewUser, TCPServerIPT.getText(), Integer.parseInt(TCPServerPortT.getText()));
            } catch (Exception ex) {
                Logger.getLogger(SIGNIN.class.getName()).log(Level.SEVERE, null, ex);
            } 
        GUIC.getDlm().clear();
        jList2.setModel(GUIC.getDlm());
        GUIC.getTargetUsers().clear();
        GUIC.setCurruntUser(null);
        LocalIPT.setText("");
        LocalPortT.setText("");
        GUIC.getST().suspend();
        GUIC.getST().setTA(null);
        GUIC.getST().setSPortNum(0);
        MessagesAreaTA.setText("");
        ChangEnable(false);
        GUIC.getDlm().clear();
        jList1.setModel(GUIC.getDlm());
    }
        private void InterfaceNetowrk() {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (!inetAddress.equals("")) {
                        String S = netint.getDisplayName() + inetAddress;
                        InterfaseComBox.addItem(S);
                    }
                }
            }
        } catch (SocketException E) {
        }
    }

    private void UnderLineLable() {
        NewUserL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = NewUserL.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        NewUserL.setFont(font.deriveFont(attributes));
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        GUIFRAME Frame = new GUIFRAME();
        Frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChatP;
    private javax.swing.JButton ConnectToServerB;
    private javax.swing.JComboBox<String> InterfaseComBox;
    private javax.swing.JLabel LocalIPL;
    private javax.swing.JTextField LocalIPT;
    private javax.swing.JLabel LocalPortL;
    private javax.swing.JTextField LocalPortT;
    private javax.swing.JButton LoginB;
    private javax.swing.JPanel LoginP;
    private javax.swing.JButton LogoutB;
    private javax.swing.JPanel ManiP;
    private javax.swing.JPanel MessageConfigrations;
    private javax.swing.JTextPane MessagesAreaTA;
    private javax.swing.JLabel NewUserL;
    private javax.swing.JLabel OnlineUsersL;
    private javax.swing.JScrollPane OnlineUsersList;
    private javax.swing.JButton SendB;
    private javax.swing.JPanel ServerConfigreations;
    private javax.swing.JLabel TCPServerIPL;
    private javax.swing.JTextField TCPServerIPT;
    private javax.swing.JLabel TCPServerPortL;
    private javax.swing.JTextField TCPServerPortT;
    private javax.swing.JButton UploadB;
    private javax.swing.JLabel UserNameL;
    private javax.swing.JTextField UserNameT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
