/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Control.Gestor_Reservas;
import Entidad.*;
import Utilidades.Triple;
import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javafx.util.Pair;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mateo Chamorro
 */
public class CU01_SelectorAulas extends javax.swing.JFrame {

    private boolean C1;
    private boolean C2;
    private int cantAlumnos;
    private String tipoAula;
    private Docente docente;
    private Bedel bedel;
    private Curso curso;
    
    private ArrayList<
                       Pair<
                            ArrayList<
                                        Triple<Date,Time,Time>>,
                            ArrayList<
                                        Triple<Integer,DiaReserva,Aula>>>
                    > 
    listaDiasHorariosConSolapamiento=new ArrayList(); 
    
    private ArrayList<
                       Triple<
                            ArrayList<
                                        Triple<Date,Time,Time>>,
                            ArrayList<
                                        Triple<Integer,DiaReserva,Aula>>
                            ,Aula>
                    > 
    listaDiasHorariosConSolapamientoYAula=new ArrayList(); 
    

    //Esta lista contiene una lista de pares: El primer elemento es una lista con "dias", donde en periodica son multiples (por dia de la semana) y en esporadica
    //es uno solo. El segundo elemento contiene, para ese conjunto de días, las aulas disponibles o las aulas con solapamiento.
    
    
    /**
     * Creates new form AulasDisponibles_CU1_CU5_P2
     */
    public CU01_SelectorAulas(boolean C1, boolean C2, ArrayList<Triple<Date,Time,Time>> listaDiasHorarios, int cantAlumnos, String tipoAula, Docente docente, Bedel bedel, Curso curso) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.C1=C1;
        this.C2=C2;
        this.cantAlumnos=cantAlumnos;
        this.tipoAula=tipoAula;
        this.docente=docente;
        this.bedel=bedel;
        this.curso=curso;
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        int ancho=jTable1.getWidth();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(ancho/6);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(ancho/6);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(ancho/6);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(ancho/2);
        
        //DefaultTableModel model = new DefaultTableModel();
        //jTable1.setModel(model);
        
        ArrayList diasPorSemana[] = new ArrayList[5];
        for(int i=0;i<5;i++) diasPorSemana[i]=new ArrayList();
        Pair<Time,Time> horaPorDia[]=new Pair[5];
        
        if(!C1 && !C2){ //Esporadica
            
            for (int i=0;i<listaDiasHorarios.size();i++){
                ArrayList diaEsporadico=new ArrayList();
                diaEsporadico.add(listaDiasHorarios.get(i).first);
                ArrayList<Triple<Integer,DiaReserva,Aula>> aulas = Gestor_Reservas.getInstance().obtenerAulasDisponibles(C1, C2, cantAlumnos, tipoAula, diaEsporadico, listaDiasHorarios.get(i).second, listaDiasHorarios.get(i).third);
                ArrayList<Triple<Date,Time,Time>> dias = new ArrayList();dias.add(listaDiasHorarios.get(i));
                Pair p = new Pair(dias,aulas);
                listaDiasHorariosConSolapamiento.add(p);
            }
            
        }else{ //Periodica
            
     
            for(int i=0;i<listaDiasHorarios.size();i++){
                diasPorSemana[listaDiasHorarios.get(i).first.getDay()-1].add(listaDiasHorarios.get(i).first);
                horaPorDia[listaDiasHorarios.get(i).first.getDay()-1]=new Pair(listaDiasHorarios.get(i).second,listaDiasHorarios.get(i).third);
            }
            
            for(int i=0;i<5;i++){
                if(!diasPorSemana[i].isEmpty()){
                    ArrayList<Triple<Integer,DiaReserva,Aula>> aulas=(ArrayList<Triple<Integer,DiaReserva,Aula>>) Gestor_Reservas.getInstance().obtenerAulasDisponibles(C1, C2, cantAlumnos, tipoAula, diasPorSemana[i], horaPorDia[i].getKey(), horaPorDia[i].getValue());
                    ArrayList<Triple<Date,Time,Time>> dias = new ArrayList();
                    for(int j=0;j<diasPorSemana[i].size();j++){
                        dias.add(new Triple(diasPorSemana[i].get(j),horaPorDia[i].getKey(),horaPorDia[i].getValue()));
                    }
                    Pair p = new Pair(dias,aulas);
                    listaDiasHorariosConSolapamiento.add(p);
                }
            }
            
        }
        
        if (!C1 && !C2){ //Esporadica

            DefaultListModel lm;
            lm=new DefaultListModel();
            for(int i=0;i<listaDiasHorariosConSolapamiento.size();i++){
                lm.addElement(listaDiasHorariosConSolapamiento.get(i).getKey().get(0).toStringEsporadica());
                //lm.addElement(listaDiasHorarios.get(i).toStringEsporadica());
            }
            sinAsignar.setModel(lm);
            
        } else {
            
            //Periodica
            DefaultListModel lm;
            lm=new DefaultListModel();

            for (int i=0;i<listaDiasHorariosConSolapamiento.size();i++){
                lm.addElement(listaDiasHorariosConSolapamiento.get(i).getKey().get(0).toStringPeriodica());
            }
            sinAsignar.setModel(lm);
        }
             
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        todos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        conAsignar = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sinAsignar = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BDLbedel");

        menos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menos.setForeground(new java.awt.Color(255, 0, 51));
        menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/minus.png"))); // NOI18N
        menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosActionPerformed(evt);
            }
        });

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+2f));
        jLabel1.setText("Asigne las aulas para cada día:");

        jLabel4.setText("Días asignados");

        jLabel2.setText("Aulas disponibles:");

        todos.setText("Asignar aula para todos");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aula", "Ubicacion", "Capacidad", "Características"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(jButton5.getFont().deriveFont(jButton5.getFont().getStyle() | java.awt.Font.BOLD));
        jButton5.setText("Confirmar reserva");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Información solapamiento");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mas.setForeground(new java.awt.Color(0, 204, 0));
        mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/plus.png"))); // NOI18N
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });

        conAsignar.setToolTipText("");
        jScrollPane2.setViewportView(conAsignar);

        jLabel3.setText("Días que faltan asignar");

        sinAsignar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sinAsignarValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(sinAsignar);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/bdlbedel.png"))); // NOI18N
        jLabel5.setToolTipText("");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/help.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(40, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(40, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 182, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(todos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(209, 209, 209))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(todos)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        
        if(sinAsignar.getSelectedIndex()>=0 && jTable1.getSelectedRow()>=0 && listaDiasHorariosConSolapamiento.get(sinAsignar.getSelectedIndex()).getValue().get(jTable1.getSelectedRow()).first==0){
            
            int l=sinAsignar.getSelectedIndex();
            int t=jTable1.getSelectedRow();
            ArrayList borrador=new ArrayList();
            
            Triple<Integer,DiaReserva,Aula> pa=listaDiasHorariosConSolapamiento.get(l).getValue().get(t);
            pa=new Triple(0,null,pa.third);
            
            for(int i=0;i<listaDiasHorariosConSolapamiento.size();i++){
                
                //Si tiene el aula en su lista y la tiene sin solapamiento
                //Si esto ocurre, en la lista el elemento va a responder al formato <0,null,Aula>
                //por lo que generando de forma manual eso en "pa" deberia andar
                
                if(listaDiasHorariosConSolapamiento.get(i).getValue().contains(pa) ){
                    
                    Pair<ArrayList<Triple<Date,Time,Time>>,ArrayList<Triple<Integer,DiaReserva,Aula>>>ld=listaDiasHorariosConSolapamiento.get(i);
                    Triple ldya=new Triple(ld.getKey(),ld.getValue(),pa.third);
                    listaDiasHorariosConSolapamientoYAula.add(ldya);
                    borrador.add(ld);
                    
                }
                
            }
            for(int i=0;i<borrador.size();i++){
                listaDiasHorariosConSolapamiento.remove(borrador.get(i));
            }
            
            this.relistar();
            
            
        }
        
    }//GEN-LAST:event_todosActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        
        if(sinAsignar.getSelectedIndex()>=0 && jTable1.getSelectedRow()>=0 && listaDiasHorariosConSolapamiento.get(sinAsignar.getSelectedIndex()).getValue().get(jTable1.getSelectedRow()).first==0){
            
            int l=sinAsignar.getSelectedIndex();
            int t=jTable1.getSelectedRow();
            
            Pair<ArrayList<Triple<Date,Time,Time>>,ArrayList<Triple<Integer,DiaReserva,Aula>>>ld=listaDiasHorariosConSolapamiento.get(l);
            Triple ldya=new Triple(ld.getKey(),ld.getValue(),ld.getValue().get(t).third);
            listaDiasHorariosConSolapamientoYAula.add(ldya);
            listaDiasHorariosConSolapamiento.remove(ld);
            
            //listaDiasHorariosConSolapamiento.get(l).third=listaDiasHorariosConSolapamiento.get(l).second.get(t).getValue();
            
            this.relistar();
            
        }
        
    }//GEN-LAST:event_masActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PopUp(TipoPopUp.INFORMACION,"Para asignar un aula\n  1. Seleccione el dia a reservar\n  2. Seleccione el aula\n  3. Presione el '+'\n\nPara desasignar un aula\n  1. Seleccione la reserva a desasignar         \n  2. Presione el '-' ");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrameController.pop();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sinAsignarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sinAsignarValueChanged
        //Cuando se selecciona un dia, se muestra las aulas para ese dia en la tabla
        
        if(sinAsignar.getSelectedIndex()>=0){
        int sel=sinAsignar.getSelectedIndex();
        ArrayList<Triple<Integer,DiaReserva,Aula>> aulasParaElDia = listaDiasHorariosConSolapamiento.get(sel).getValue();
        
        DefaultTableModel model=((DefaultTableModel)jTable1.getModel());
        model.setRowCount(0);
        
        if(!listaDiasHorariosConSolapamiento.get(sinAsignar.getSelectedIndex()).getValue().isEmpty()){
            
            if((listaDiasHorariosConSolapamiento.get(sinAsignar.getSelectedIndex()).getValue().get(0).first)>0){
                jTable1.setForeground(Color.RED);
                jButton6.setEnabled(true);
            }else{
                jTable1.setForeground(Color.BLACK);
                jButton6.setEnabled(false);

            }
        
        }
        for(int i=0;i<aulasParaElDia.size();i++){
            
            Aula a = aulasParaElDia.get(i).third;
            
            Object[] fila = {a.getNombreAula(),a.getPiso(),a.getCapacidad(),a.getResumenCaracteristicas()};
            model.addRow(fila);
            
            
            
        }
        }

        
        
    }//GEN-LAST:event_sinAsignarValueChanged

    private void menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosActionPerformed
        
        if(conAsignar.getSelectedIndex()>=0){
            
            int l=conAsignar.getSelectedIndex();
            
            Triple t = listaDiasHorariosConSolapamientoYAula.get(l);
            Pair p = new Pair(t.first,t.second);
            listaDiasHorariosConSolapamiento.add(p);
            listaDiasHorariosConSolapamientoYAula.remove(t);
            
            
            this.relistar();
            
        }
    }//GEN-LAST:event_menosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        ArrayList<Pair<Triple<Date,Time,Time>,Aula>> lista=new ArrayList();
        
        for(int i=0;i<listaDiasHorariosConSolapamientoYAula.size();i++){
            
            for(int j=0;j<listaDiasHorariosConSolapamientoYAula.get(i).first.size();j++){
                
                Triple t=listaDiasHorariosConSolapamientoYAula.get(i).first.get(j);
                Aula a = listaDiasHorariosConSolapamientoYAula.get(i).third;
                
                Pair p = new Pair(t,a);
                lista.add(p);
                
            }   
            
        }
        
        Gestor_Reservas.getInstance().crearReserva(cantAlumnos, C1, C2, docente, curso, bedel, lista);
        
        new PopUp(TipoPopUp.INFORMACION,"Se ha realizado la reserva exitosamente.");
        FrameController.pop();
        FrameController.pop();
        FrameController.pop();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        DiaReserva dr=listaDiasHorariosConSolapamiento.get(sinAsignar.getSelectedIndex()).getValue().get(jTable1.getSelectedRow()).second;
        
        new CU01_InformacionSolapamiento(dr).setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(CU01_SelectorAulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CU01_SelectorAulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CU01_SelectorAulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CU01_SelectorAulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CU01_SelectorAulas(true,true,null,0,null,null,null,null).setVisible(true);
            }
        });
    }
    
    private void relistar(){
        
        DefaultListModel lmSA,lmCA;
        lmSA=new DefaultListModel();
        lmCA=new DefaultListModel();
        
        if (!C1 && !C2){ //Esporadica

            for(int i=0;i<listaDiasHorariosConSolapamiento.size();i++){
                lmSA.addElement(listaDiasHorariosConSolapamiento.get(i).getKey().get(0).toStringEsporadica());
            }
            for(int i=0;i<listaDiasHorariosConSolapamientoYAula.size();i++){
                lmCA.addElement(listaDiasHorariosConSolapamientoYAula.get(i).first.get(0).toStringEsporadica()+" ("+listaDiasHorariosConSolapamientoYAula.get(i).third.getNombreAula()+")");
            }
 
        } else { //Periodica

            for(int i=0;i<listaDiasHorariosConSolapamiento.size();i++){
                lmSA.addElement(listaDiasHorariosConSolapamiento.get(i).getKey().get(0).toStringPeriodica());
            }
            for(int i=0;i<listaDiasHorariosConSolapamientoYAula.size();i++){
                lmCA.addElement(listaDiasHorariosConSolapamientoYAula.get(i).first.get(0).toStringPeriodica()+" ("+listaDiasHorariosConSolapamientoYAula.get(i).third.getNombreAula()+")");
            }

        }
        
            sinAsignar.setModel(lmSA);
            conAsignar.setModel(lmCA);
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            if(sinAsignar.getModel().getSize()==0){
                jButton5.setEnabled(true);
            }else{
                jButton5.setEnabled(false);
            }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> conAsignar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JList<String> sinAsignar;
    private javax.swing.JButton todos;
    // End of variables declaration//GEN-END:variables
}


