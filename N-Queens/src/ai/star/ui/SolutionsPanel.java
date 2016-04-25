package ai.star.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ai.star.enums.Panels;

public class SolutionsPanel extends MyResultsPanel {
	private JComboBox<String> solutionComboBox;

	public SolutionsPanel(Panels panelType, DefaultComboBoxModel<String> solutionModel) {
		super(panelType);
		
		solutionComboBox = new JComboBox<String>(solutionModel);
		solutionComboBox.setToolTipText("Solutions");
		solutionComboBox.setForeground(new Color(128, 0, 128));
		solutionComboBox.setFont(new Font("Segoe UI", Font.BOLD, 20));
		solutionComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] solutions = getSolution().split(",");
				JPanel gridPanel = new JPanel();
				JScrollPane scroller = new JScrollPane(gridPanel);
				
				gridPanel.setLayout(new GridLayout(NQueenUI.N, NQueenUI.N));

				for (int outerIndex = 0; outerIndex < NQueenUI.N; outerIndex++) {
					for (int innerIndex = 0; innerIndex < NQueenUI.N; innerIndex++) {
						JLabel imageLabel = new JLabel();
						if (solutions[outerIndex].equals("" + innerIndex)) {
							imageLabel = new JLabel(new ImageIcon(QUEEN_IMAGE));
						}
						imageLabel.setSize(500/NQueenUI.N, 500/NQueenUI.N);
						imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
						gridPanel.add(imageLabel);
					}
				}

				addToPanel(scroller);
			}
		});
		
		panel.add(solutionComboBox, "cell 0 1,growx,aligny top");
	}

	private String getSolution() {
		return solutionComboBox.getSelectedItem().toString();
	}

}
