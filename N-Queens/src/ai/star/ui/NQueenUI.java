package ai.star.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import ai.star.enums.Algorithm;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class NQueenUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NQueenUI window = new NQueenUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NQueenUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 829, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_536163107279850");
		mainPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("NQueens Experimental Comparison");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		mainPanel.add(lblTitle, BorderLayout.NORTH);

		JPanel controlsPanel = new JPanel();
		controlsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, null, null, null));
		mainPanel.add(controlsPanel, BorderLayout.WEST);
		controlsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel choicePanel = new JPanel();
		choicePanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(choicePanel);
		choicePanel.setLayout(new MigLayout("", "[1px][117px][179px]", "[26px][][]"));
		
				JLabel lblChoice = new JLabel("Algorithm Choice");
				lblChoice.setHorizontalAlignment(SwingConstants.CENTER);
				lblChoice.setFont(new Font("Segoe UI", Font.BOLD, 24));
				lblChoice.setForeground(Color.BLUE);
				choicePanel.add(lblChoice, "cell 1 1 2 1,alignx center,aligny center");
		
				JComboBox<Algorithm> comboBoxChoice = new JComboBox<Algorithm>();
				comboBoxChoice.setModel(new DefaultComboBoxModel<Algorithm>(Algorithm.values()));
				comboBoxChoice.setSelectedIndex(0);
				comboBoxChoice.setToolTipText("Algorithm Choice");
				comboBoxChoice.setForeground(new Color(0, 128, 0));
				comboBoxChoice.setFont(new Font("Segoe UI", Font.BOLD, 14));
				choicePanel.add(comboBoxChoice, "cell 1 2 2 1,alignx center,aligny center");

		JPanel nPanel = new JPanel();
		nPanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(nPanel);

		Integer[] nValues = new Integer[17];
		for (int i = 0; i < 17; i++) {
			nValues[i] = i + 4;
		}
		DefaultComboBoxModel<Integer> nModel = new DefaultComboBoxModel<Integer>(nValues);
										nPanel.setLayout(new MigLayout("", "[1px][117px][179px]", "[26px][][]"));
										
												JLabel lblN = new JLabel("Choice of N");
												nPanel.add(lblN, "cell 1 1 2 1,alignx center,aligny center");
												lblN.setHorizontalAlignment(SwingConstants.CENTER);
												lblN.setForeground(Color.BLUE);
												lblN.setFont(new Font("Segoe UI", Font.BOLD, 24));
										JComboBox<Integer> comboBoxN = new JComboBox<>(nModel);
										comboBoxN.setSelectedIndex(0);
										nPanel.add(comboBoxN, "cell 1 2 2 1,alignx center,aligny center");
										comboBoxN.setForeground(new Color(0, 128, 0));
										comboBoxN.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(buttonsPanel);
		buttonsPanel.setLayout(new MigLayout("", "[93px][][][]", "[41px][]"));
						
								JButton btnSolve = new JButton("Solve");
								btnSolve.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
									}
								});
								buttonsPanel.add(btnSolve, "cell 1 1 2 1,alignx left,aligny top");
								btnSolve.setToolTipText("Click to get the solutions");
								btnSolve.setForeground(new Color(128, 0, 0));
								btnSolve.setFont(new Font("Segoe UI", Font.BOLD, 24));

		JPanel solutionPanel = new JPanel();
		solutionPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, Color.YELLOW));
		mainPanel.add(solutionPanel, BorderLayout.CENTER);
		solutionPanel.setLayout(null);

		JComboBox<List<int[]>> comboBox = new JComboBox<>();
		comboBox.setBounds(10, 5, 477, 33);
		comboBox.setToolTipText("Solutions");
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 20));
		solutionPanel.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 20, 2, 2);
		solutionPanel.add(scrollPane);
	}
}
