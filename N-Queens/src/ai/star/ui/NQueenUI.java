package ai.star.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import ai.star.enums.Algorithm;
import net.miginfocom.swing.MigLayout;
import ai.star.enums.N;

public class NQueenUI {

	private JFrame frame;
	private int n;
	private BufferedImage queenImage;

	private JPanel mainPanel;
	private JLabel lblTitle;
	private JPanel controlsPanel;
	private JPanel choicePanel;
private JLabel lblChoice;
private JPanel nPanel;
private JLabel lblN;
private JPanel buttonsPanel;
private JButton btnSolve;
private JPanel solutionPanel;
private JLabel lblSolutions;

/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NQueenUI window = new NQueenUI();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
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
		try {
			queenImage = ImageIO.read(new File("queen.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 829, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_536163107279850");
		mainPanel.setLayout(new BorderLayout(0, 0));

		lblTitle = new JLabel("NQueens Experimental Comparison");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		mainPanel.add(lblTitle, BorderLayout.NORTH);

		controlsPanel = new JPanel();
		controlsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, null, null, null));
		mainPanel.add(controlsPanel, BorderLayout.WEST);
		controlsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		choicePanel = new JPanel();
		choicePanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(choicePanel);
		choicePanel.setLayout(new MigLayout("", "[1px][117px][179px]", "[26px][][]"));

		lblChoice = new JLabel("Algorithm Choice");
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

		nPanel = new JPanel();
		nPanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(nPanel);

		nPanel.setLayout(new MigLayout("", "[1px][117px][179px]", "[26px][][]"));

		lblN = new JLabel("Choice of N");
		nPanel.add(lblN, "cell 1 1 2 1,alignx center,aligny center");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setForeground(Color.BLUE);
		lblN.setFont(new Font("Segoe UI", Font.BOLD, 24));

		JComboBox<N> comboBoxN = new JComboBox<>();
		comboBoxN.setModel(new DefaultComboBoxModel<N>(N.values()));
		comboBoxN.setSelectedIndex(0);
		nPanel.add(comboBoxN, "cell 1 2 2 1,alignx center,aligny center");
		comboBoxN.setForeground(new Color(0, 128, 0));
		comboBoxN.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBoxN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				n = ((N) comboBoxN.getSelectedItem()).getN();
			}
		});

		buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new LineBorder(Color.RED, 1, true));
		controlsPanel.add(buttonsPanel);
		buttonsPanel.setLayout(new MigLayout("", "[93px][][][]", "[41px][]"));

		btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch ((Algorithm) comboBoxChoice.getSelectedItem()) {
				case BACKTRACKING:
					backtrack(n);
					break;
				case FORWARD_CHECKING:
					forwardCheck(n);
					break;
				case MINIMUM_CONFLICTS:
					solveWithMinimumConflicts(n);
					break;
				case MRV:
					mrv(n);
					break;
				case COMPARE:
					compare(n);
					break;
				default:
					break;

				}
			}
		});
		buttonsPanel.add(btnSolve, "cell 1 1 2 1,alignx left,aligny top");
		btnSolve.setToolTipText("Click to get the solutions");
		btnSolve.setForeground(new Color(128, 0, 0));
		btnSolve.setFont(new Font("Segoe UI", Font.BOLD, 24));

		solutionPanel = new JPanel();
		solutionPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, Color.YELLOW));
		mainPanel.add(solutionPanel, BorderLayout.CENTER);

		String[] solutions = { "0,1,2,3", "2,0,1,3" };
		DefaultComboBoxModel<String> solutionModel = new DefaultComboBoxModel<String>(solutions);
		solutionPanel.setLayout(new MigLayout("", "[450px]", "[33px][33px][23px]"));

		lblSolutions = new JLabel("Solutions");
		lblSolutions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolutions.setForeground(Color.ORANGE);
		lblSolutions.setFont(new Font("Segoe UI", Font.BOLD, 24));
		solutionPanel.add(lblSolutions, "cell 0 0,alignx center,aligny center");

		JComboBox<String> solutionComboBox = new JComboBox<String>(solutionModel);
		solutionComboBox.setToolTipText("Solutions");
		solutionComboBox.setForeground(new Color(128, 0, 128));
		solutionComboBox.setFont(new Font("Segoe UI", Font.BOLD, 20));
		solutionPanel.add(solutionComboBox, "cell 0 1,growx,aligny top");

		solutionComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] solutions = solutionComboBox.getSelectedItem().toString().split(",");
				JPanel gridPanel = new JPanel();

				gridPanel.setLayout(new GridLayout(n, n));

				for (int outerIndex = 0; outerIndex < n; outerIndex++) {
					for (int innerIndex = 0; innerIndex < n; innerIndex++) {
						JLabel imageLabel = new JLabel();
						imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
						if (solutions[outerIndex].equals("" + innerIndex)) {
							imageLabel = new JLabel(new ImageIcon(queenImage));
						}
						gridPanel.add(imageLabel);
					}
				}

				if (solutionPanel.getComponentCount() > 2)
					solutionPanel.remove(2);
				solutionPanel.add(gridPanel, "cell 0 2,alignx center,growy");
				gridPanel.revalidate();
				gridPanel.repaint();

			}
		});

	}

	protected void backtrack(int n) {

	}

	protected void forwardCheck(int n) {

	}

	protected void solveWithMinimumConflicts(int n) {

	}

	protected void mrv(int n) {

	}

	protected void compare(int n) {
		lblSolutions.setText("Comparison Results");
		if(solutionPanel.getComponentCount() > 2) {
			solutionPanel.remove(1);
			solutionPanel.remove(2);
		} else if(solutionPanel.getComponentCount() == 2) {
			solutionPanel.remove(1);
		}
		
		solutionPanel.revalidate();
		solutionPanel.repaint();
	}
}
