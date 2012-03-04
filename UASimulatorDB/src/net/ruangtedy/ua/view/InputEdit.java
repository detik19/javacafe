package net.ruangtedy.ua.view;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.ruangtedy.ua.controller.ActionUI;
import net.ruangtedy.ua.controller.ODBConnectionmySQL;
import net.ruangtedy.ua.model.Constants;
import net.ruangtedy.ua.model.OConnection;

import org.jdesktop.application.SingleFrameApplication;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * 
 */
public class InputEdit extends SingleFrameApplication {
    private JPanel topPanel;
    private JLabel jLabel1;
    private JComboBox jComboBoxBulan;
    private JComboBox jComboBoxTahun;
    private JButton jButton2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel JLabelNRP;
    private JButton jButtonUpdate;
    private JButton jButtonClear;
    private JTextField jTextFile;
    private JButton jButtonRambah;
    private JLabel jLabel4;
    private JButton jButtonInput;
    private JTextField jTextFieldRiset;
    private JLabel jLabelRiset;
    private JTextField jTextFieldNRP;
    private JTextField jTextFieldFresh;
    private JSeparator jSeparator1;
    private JComboBox jComboBoxSite;
	ODBConnectionmySQL odbmysql=new ODBConnectionmySQL();
    private int id;
    
    ActionUI aUI= new ActionUI();
    @Override
    protected void startup() {
    	{
    		topPanel = new JPanel();
    		getMainFrame().getContentPane().add(topPanel, BorderLayout.NORTH);
    		topPanel.setPreferredSize(new java.awt.Dimension(500, 300));
    		
    		topPanel.setLayout(null);
    		{
    			jButton2 = new JButton();
    			topPanel.add(jButton2);
    			jButton2.setName("jButtonDisplay");
    			jButton2.setBounds(322, 14, 67, 23);
    			jButton2.addMouseListener(new MouseAdapter() {
    				public void mouseClicked(MouseEvent evt) {
    					try {
							jButton2MouseClicked(evt);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    				}
    			});
    		}
    		{
    			ComboBoxModel jComboBox3Model = 
    					new DefaultComboBoxModel(
    							new String[] { "2009", "2010", "2011", "2012", "2013", "2014","2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" });
    			jComboBoxTahun = new JComboBox();
    			topPanel.add(jComboBoxTahun);
    			jComboBoxTahun.setModel(jComboBox3Model);
    			jComboBoxTahun.setBounds(199, 15, 93, 20);
    		}
    		{
    			ComboBoxModel jComboBox4Model = 
    					new DefaultComboBoxModel(
    							new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" });
    			jComboBoxBulan = new JComboBox();
    			topPanel.add(jComboBoxBulan);
    			jComboBoxBulan.setModel(jComboBox4Model);
    			jComboBoxBulan.setBounds(76, 15, 106, 20);
    		}
    		{
    			jLabel1 = new JLabel();
    			topPanel.add(jLabel1);
    			jLabel1.setName("jLabel1");
    			jLabel1.setBounds(20, 18, 26, 14);
    		}
    		{
    			jLabel2 = new JLabel();
    			topPanel.add(jLabel2);
    			jLabel2.setBounds(20, 55, 18, 14);
    			jLabel2.setName("jLabel2");
    		}
    		{
    			ComboBoxModel jComboBoxSiteModel = 
    					new DefaultComboBoxModel(
    							new String[] { "Adaro S60", "Adaro S219","Kideco S179", "Kideco S211","KPC S079", "BAYA S214", "INDO S313", "TCMM S314", "CILE S142" });
    			jComboBoxSite = new JComboBox();
    			topPanel.add(jComboBoxSite);
    			jComboBoxSite.setModel(jComboBoxSiteModel);
    			jComboBoxSite.setBounds(76, 52, 139, 20);
    		}
    		{
    			jSeparator1 = new JSeparator();
    			topPanel.add(jSeparator1);
    			jSeparator1.setBounds(11, 80, 475, 65);
    			jSeparator1.setName("jSeparator1");
    			{
    				jLabel3 = new JLabel();
    				jSeparator1.add(jLabel3);
    				jLabel3.setBounds(10, 11, 44, 16);
    				jLabel3.setName("jLabel3");
    			}
    		}
    		{
    			jTextFieldFresh = new JTextField();
    			topPanel.add(jTextFieldFresh);
    			jTextFieldFresh.setBounds(74, 92, 77, 20);
    		}
    		{
    			JLabelNRP = new JLabel();
    			topPanel.add(JLabelNRP);
    			JLabelNRP.setBounds(172, 95, 27, 14);
    			JLabelNRP.setName("JLabelNRP");
    		}
    		{
    			jTextFieldNRP = new JTextField();
    			topPanel.add(jTextFieldNRP);
    			jTextFieldNRP.setBounds(219, 91, 73, 20);
    		}
    		{
    			jLabelRiset = new JLabel();
    			topPanel.add(jLabelRiset);
    			jLabelRiset.setBounds(310, 91, 55, 23);
    			jLabelRiset.setName("jLabelRiset");
    		}
    		{
    			jTextFieldRiset = new JTextField();
    			topPanel.add(jTextFieldRiset);
    			jTextFieldRiset.setBounds(351, 92, 72, 20);
    		}
    		{
    			jButtonInput = new JButton();
    			topPanel.add(jButtonInput);
    			jButtonInput.setBounds(219, 167, 67, 23);
    			jButtonInput.setName("jButtonInput");
    			jButtonInput.addMouseListener(new MouseAdapter() {
    				public void mouseClicked(MouseEvent evt) {
    						
    					try {
							jButtonInputMouseClicked(evt);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    					
    				}
    			});
    		}
    		{
    			jLabel4 = new JLabel();
    			topPanel.add(jLabel4);
    			jLabel4.setBounds(21, 131, 23, 14);
    			jLabel4.setName("jLabel4");
    		}
    		{
    			jTextFile = new JTextField();
    			topPanel.add(jTextFile);
    			jTextFile.setBounds(76, 125, 216, 20);
    		}
    		{
    			jButtonRambah = new JButton();
    			topPanel.add(jButtonRambah);
    			jButtonRambah.setBounds(301, 122, 71, 23);
    			jButtonRambah.setName("jButtonRambah");
    			jButtonRambah.addMouseListener(new MouseAdapter() {
    				public void mouseClicked(MouseEvent evt) {
    					jButtonRambahMouseClicked(evt);
    				}
    			});
    		}
    		{
    			jButtonClear = new JButton();
    			topPanel.add(jButtonClear);
    			jButtonClear.setBounds(156, 167, 57, 23);
    			jButtonClear.setName("jButtonClear");
    			jButtonClear.addMouseListener(new MouseAdapter() {
    				public void mouseClicked(MouseEvent evt) {
    					jButtonClearMouseClicked(evt);
    				}
    			});
    		}
    		{
    			jButtonUpdate = new JButton();
    			topPanel.add(jButtonUpdate);
    			jButtonUpdate.setBounds(302, 167, 67, 23);
    			jButtonUpdate.setName("jButtonUpdate");
    		}
    	}
        show(topPanel);
    }

    public static void main(String[] args) {
        launch(InputEdit.class, args);
		//System.out.println("Connection Success ");

    }
    
    private void jButton2MouseClicked(MouseEvent evt) throws SQLException 
    {
    	
    	boolean flag=aUI.DisplayPressed(getJComboBoxBulan(), getJComboBoxTahun(), getComboBoxSite());
    	System.out.println(flag);
    	if (flag==true)
    	{
    		jTextFieldFresh.setText(aUI.getFresh());
    		jTextFieldNRP.setText(aUI.getNrp());
    		jTextFieldRiset.setText(aUI.getRiset());
    	}
    	else
    		JOptionPane.showMessageDialog( topPanel ,  Constants.DATA_NOT_EXIST, "Database Result", JOptionPane.INFORMATION_MESSAGE);
      	
    }
    
    public String getJComboBoxBulan()
    {
		return (String) jComboBoxBulan.getSelectedItem();    	
    }
    
    public String getJComboBoxTahun()
    {
    	return (String) jComboBoxTahun.getSelectedItem();
    }
    
    public String getComboBoxSite()
    {
    	return (String) jComboBoxSite.getSelectedItem();
    }
    
    public String getjTextFieldNRP()
    {
		return jTextFieldNRP.getText();
    	
    }
    
    public String getjTextFieldFresh()
    {
    
		return jTextFieldFresh.getText();
    	
    }
    
    public String getjTextFieldRiset()
    {
		return jTextFieldRiset.getText();
    	
    }
    
    private void jButtonInputMouseClicked(MouseEvent evt) throws SQLException 
    {
    	if(!jButtonInput.isEnabled())
    	{
    		
    	}
    	else
    	aUI.inputPressed();
    }
    
    private void jButtonRambahMouseClicked(MouseEvent evt) {
    	System.out.println("jButtonRambah.mouseClicked, event="+evt);
    	//TODO add your code for jButtonRambah.mouseClicked
    }
    
    private void jButtonClearMouseClicked(MouseEvent evt) {
    	System.out.println("jButtonClear.mouseClicked, event="+evt);
    	//TODO add your code for jButtonClear.mouseClicked
    }
}
