package net.ruangtedy.ua.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class UserInterface extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWaktu = new JLabel("Bulan :");
		lblWaktu.setBounds(10, 40, 46, 14);
		contentPane.add(lblWaktu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(52, 37, 56, 20);
		contentPane.add(comboBox);
		
		JLabel lblSite = new JLabel("Site :");
		lblSite.setBounds(241, 43, 46, 14);
		contentPane.add(lblSite);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Adaro S60", "Adaro S219", "Kideco S179", "Kideco S211", "KPC S079", "BAYA S214", "INDO S313", "TCMM S314", "CILE S142"}));
		comboBox_1.setBounds(276, 37, 112, 20);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(52, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(52, 136, 416, 141);
		contentPane.add(table);
		
		JLabel lblFresh = new JLabel("Fresh :");
		lblFresh.setBounds(10, 83, 46, 14);
		contentPane.add(lblFresh);
		
		JLabel lblNrp = new JLabel("NRP :");
		lblNrp.setBounds(165, 83, 46, 14);
		contentPane.add(lblNrp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 80, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRiset = new JLabel("Riset :");
		lblRiset.setBounds(304, 83, 46, 14);
		contentPane.add(lblRiset);
		
		textField_2 = new JTextField();
		textField_2.setBounds(353, 80, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBounds(467, 36, 89, 23);
		contentPane.add(btnDisplay);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(137, 37, 75, 20);
		contentPane.add(comboBox_2);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.setBounds(467, 79, 89, 23);
		contentPane.add(btnQuery);
	}
}
