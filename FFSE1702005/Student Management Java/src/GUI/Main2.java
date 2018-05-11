/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.ThiSinhDLL;
import DLL.TinhThanhDLL;
import Entity.ThiSinh;
import Entity.TinhThanh;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Little Princess
 */
public class Main2 extends javax.swing.JFrame {

    
    
    ThiSinhDLL empDLL = new ThiSinhDLL() ;  
    ArrayList<ThiSinh> listEMP = new ArrayList<>() ;
     ArrayList<ThiSinh> listEMP2 = new ArrayList<>() ;
    
    
    TinhThanhDLL depDLL = new TinhThanhDLL() ;
    ArrayList<TinhThanh> listDep = new ArrayList<>() ;
    
   
    
    public Main2() {
        
        initComponents();
        String laf = "" ;
        laf = "com.sum.java.swing.plaf.windowsLookAndFeel" ;
        try {
            UIManager.setLookAndFeel(laf);
            SwingUtilities.updateComponentTreeUI(this);
            
        } catch (Exception e) {
        }
        this.setLocation(450, 50);
       
        Biding() ;
        BidingDep() ;
      
    }
    
    
     public void BidingDep() {
        listDep = depDLL.getAll();
        for (TinhThanh d : listDep) {
            cbxDep.addItem(d.getTenTinh());
        }
    }
    
    public void Biding()
    {
        listEMP = empDLL.getAll() ;
        Vector clums = new Vector() ;
        clums.add("MaTS") ;
        clums.add("Name") ;
        clums.add("MaTinh") ;
        clums.add("NgaySinh") ;
        clums.add("GioiTinh") ;
        clums.add("DiemToan") ;
        clums.add("DiemHoa") ;
        clums.add("DiemLi") ;
        clums.add("TenTinh") ;
        
        Vector data = new Vector() ;
        
        for( ThiSinh emp : listEMP)
        {
            Vector row = new Vector() ;
            row.add(emp.getMaTS()) ;
            row.add(emp.getName()) ;
            row.add(emp.getMaTinh()) ;
            row.add(emp.getNgaySinh()) ;
            row.add(emp.getGioiTinh()) ;
            row.add(emp.getDiemToan()) ;
            row.add(emp.getDiemHoa()) ;
            row.add(emp.getDiemLi()) ;
            
            listDep  = depDLL.getByID(emp.getMaTinh()) ;
            if( listDep.size() > 0)
            {
                row.add(listDep.get(0).getTenTinh()) ;
            }
            else
            {
                row.add(" Empty ") ;
            
            }
            
            
            data.add(row) ;
        
        }
        
    
       DefaultTableModel dtm = new DefaultTableModel(data,clums) ;
       tblThiSinh.setModel(dtm) ;
        
    
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThiSinh = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        cbxDep = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        JTxtAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("STUDENT MANAGEMENT");

        tblThiSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblThiSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThiSinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThiSinh);

        jLabel2.setText("MaTS");

        jLabel3.setText("Name");

        jLabel4.setText("NS");

        jLabel5.setText("GioiTinh");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Diem Toan");

        jLabel7.setText("Diem Hoa");

        jLabel9.setText("Diem Li");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Address");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Total Points");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("F");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("M");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 102));
        jLabel12.setText("St Information ");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Address");

        jLabel14.setText("StudentID");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(39, 39, 39)
                .addComponent(JTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(36, 36, 36)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\it.png")); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\filter.png")); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 153));
        jLabel17.setText("List Student");

        jMenu1.setText("File");

        jMenuItem1.setText("New ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Save");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem3.setText("About Me");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jTextField3))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton2)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(19, 19, 19)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxDep, 0, 85, Short.MAX_VALUE)
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel10)
                            .addComponent(jRadioButton2))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.listDep = this.depDLL.getAll();
        int MaTS = Integer.parseInt(this.jTextField1.getText());
        String Name = this.jTextField2.getText();
        String NgaySinh = this.jTextField3.getText();
     //   int GioiTinh = Integer.parseInt(this.jTextField4.getText());
        int GioiTinh ;
        if(jRadioButton1.isSelected())
        {
            GioiTinh = 1 ;
        }
        else
        {
            GioiTinh = 0 ;
        
        }
        float DiemToan = Float.parseFloat(this.jTextField5.getText());
        float DiemHoa = Float.parseFloat(this.jTextField6.getText());
        float DiemLi = Float.parseFloat(this.jTextField7.getText());
        int rowDep = this.cbxDep.getSelectedIndex();
        int MaTinh = this.listDep.get(rowDep).getMaTinh();
        ThiSinh emp = new ThiSinh();
        emp.setMaTS(MaTS);
        emp.setName(Name);
        emp.setMaTinh(MaTinh);
        emp.setNgaySinh(NgaySinh);
        emp.setGioiTinh(GioiTinh);
        emp.setDiemToan(DiemToan);
        emp.setDiemHoa(DiemHoa);
        emp.setDiemLi(DiemLi);
        if (this.empDLL.AddData(emp)) {
            JOptionPane.showMessageDialog(this, "Add New EMP SUCCESS ! ");
            this.Biding();
        } else {
            JOptionPane.showMessageDialog(this, "Add New EMP FAIL ! ");
        }
    }                                        

    private void tblThiSinhMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        if (this.tblThiSinh.getSelectedRow() != -1) {
            int row = this.tblThiSinh.getSelectedRow();
            this.listEMP = this.empDLL.getAll();
            this.jTextField1.setText(String.valueOf(this.listEMP.get(row).getMaTS()));
            this.jTextField2.setText(this.listEMP.get(row).getName());
            this.jTextField3.setText(this.listEMP.get(row).getNgaySinh());
            
            if(listEMP.get(row).getGioiTinh() == 1 )
            {
                jRadioButton1.setSelected(true);
           
            }
            else
            {
                jRadioButton2.setSelected(true);
            }
            this.jTextField5.setText(String.valueOf(this.listEMP.get(row).getDiemToan()));
            this.jTextField6.setText(String.valueOf(this.listEMP.get(row).getDiemHoa()));
            this.jTextField7.setText(String.valueOf(this.listEMP.get(row).getDiemLi()));
            this.jTextField8.setText(String.valueOf(listEMP.get(row).getDiemToan() + listEMP.get(row).getDiemHoa()+ listEMP.get(row).getDiemLi()));
            
            this.listDep = this.depDLL.getByID(this.listEMP.get(row).getMaTinh());
            if (this.listDep.size() > 0) {
                this.cbxDep.setSelectedItem(this.listDep.get(0).getTenTinh());
            } else {
                this.cbxDep.setSelectedIndex(0);
            }
        }
    }                                       

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
         if (this.tblThiSinh.getSelectedRow() != -1) {
            int row = this.tblThiSinh.getSelectedRow();
            this.listEMP = this.empDLL.getAll();
            if (this.empDLL.DeleteData(this.listEMP.get(row).getMaTS())) {
                JOptionPane.showMessageDialog(this, " Deleted ! ");
                this.Biding();
            } else {
                JOptionPane.showMessageDialog(this, " Delete Fail ! ");
            }
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.listDep = this.depDLL.getAll();
        this.listEMP = this.empDLL.getAll();
        int MaTS = Integer.parseInt(this.jTextField1.getText());
        String Name = this.jTextField2.getText();
        String NgaySinh = this.jTextField3.getText();
    
        int GioiTinh ;
        if(jRadioButton1.isSelected())
        {
            GioiTinh = 1 ;
        
        }
        else
        {
            GioiTinh = 0 ;
        }
        float DiemToan = Float.parseFloat(this.jTextField5.getText());
        float DiemHoa = Float.parseFloat(this.jTextField6.getText());
        float DiemLi = Float.parseFloat(this.jTextField7.getText());
        int rowDep = this.cbxDep.getSelectedIndex();
        int row = this.tblThiSinh.getSelectedRow();
        int MaTinh = this.listDep.get(rowDep).getMaTinh();
        ThiSinh emp = new ThiSinh();
        emp.setMaTS(this.listEMP.get(row).getMaTS());
        emp.setName(Name);
        emp.setMaTinh(MaTinh);
        emp.setNgaySinh(NgaySinh);
        emp.setGioiTinh(GioiTinh);
        emp.setDiemToan(DiemToan);
        emp.setDiemHoa(DiemHoa);
        emp.setDiemLi(DiemLi);
        if (this.empDLL.UpdateData(emp)) {
            JOptionPane.showMessageDialog(this, " Update Success ! ");
            this.Biding();
        } else {
            JOptionPane.showMessageDialog(this, " Update Fail ! ");
        }
    }                                        

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        String ad = JTxtAddress.getText() ;
        listDep = depDLL.getByName(ad) ;
       
        int MT = listDep.get(0).getMaTinh() ;
        
        int ID = Integer.parseInt(jTextField9.getText() ) ;
        
        listEMP = empDLL.getAll() ;
        Vector clums = new Vector() ;
        clums.add("MaTS") ;
        clums.add("Name") ;
        clums.add("MaTinh") ;
        clums.add("NgaySinh") ;
        clums.add("GioiTinh") ;
        clums.add("DiemToan") ;
        clums.add("DiemHoa") ;
        clums.add("DiemLi") ;
        clums.add("TenTinh") ;
        
        Vector data = new Vector() ;
        
        for( ThiSinh emp : listEMP)
        {
            Vector row = new Vector() ;

                if( emp.getMaTinh() == MT || emp.getMaTS() == ID )
                {
                    row.add(emp.getMaTS()) ;
                    row.add(emp.getName()) ;
                    row.add(emp.getMaTinh()) ;
                    row.add(emp.getNgaySinh()) ;
                    row.add(emp.getGioiTinh()) ;
                    row.add(emp.getDiemToan()) ;
                    row.add(emp.getDiemHoa()) ;
                    row.add(emp.getDiemLi()) ;        
                    listDep  = depDLL.getByID(emp.getMaTinh()) ;
                    if( listDep.size() > 0)
                    {

                        row.add(listDep.get(0).getTenTinh()) ;
                    }
                    else
                    {

                         row.add(" Empty ") ;


                    }
                       
                 data.add(row) ;
                 
                }
                         
                
        }
         
       DefaultTableModel dtm = new DefaultTableModel(data,clums) ;
       tblThiSinh.setModel(dtm) ;
              
     
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        buttonGroup1.clearSelection();
        this.jTextField5.setText("");
        this.jTextField6.setText("");
        this.jTextField7.setText("");
        this.jTextField8.setText("");
    }                                        

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
       
        Sub2 s = new Sub2() ;
        s.setVisible(true);
        
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        System.exit(0);
    }                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        File file= null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
             file = fileChooser.getSelectedFile();

        }

        try {
  //          File file = new File("D:\\Hoc Tap\\CN Java\\Output.txt") ;
            if( ! file.exists())
            {
                file.createNewFile() ;
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile()) ;
            BufferedWriter bw = new BufferedWriter(fw) ;
            bw.write("\n\n ===========       DANH SACH THI SINH       =========== \n\n ");
            bw.write("\n ID ||  Name  || MT || GT ||  NS || Math | Chems | Phys || Address \n\n ");
            for(int i = 0 ; i < tblThiSinh.getRowCount() ; i++)
            {
                for( int j = 0 ; j < tblThiSinh.getColumnCount() ; j++)
                {
                    bw.write(tblThiSinh.getModel().getValueAt(i, j) + "  " );
                
                }
                bw.write("\n\n ------------------------------------ \n\n ");
             
            }
            bw.close() ;
            fw.close(); 
            JOptionPane.showMessageDialog(null, " Exported Data to File Text Success . ");
        } catch (Exception e) {
            e.printStackTrace(); 
            
        }
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JFileChooser fileChooser=new JFileChooser();  
  
  
        int a=fileChooser.showOpenDialog(null);  
        if(a==JFileChooser.APPROVE_OPTION)  
        {  
    //Get file that want to open  
        File fileToOpen=fileChooser.getSelectedFile();  

        try  
        {  

         Desktop.getDesktop().open(fileToOpen);  
        }  
        catch(Exception exception)  
        {  
         System.out.println("Problem occour when to open the file");  
        }  
    }  
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
           
    }                                          
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField JTxtAddress;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxDep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable tblThiSinh;
    // End of variables declaration                   
}
