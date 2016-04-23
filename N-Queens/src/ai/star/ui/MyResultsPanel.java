package ai.star.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import ai.star.enums.Panels;
import net.miginfocom.swing.MigLayout;

public class MyResultsPanel {

	protected JPanel panel;
	protected JLabel label;
	public static BufferedImage QUEEN_IMAGE;
	
	public MyResultsPanel(Panels panelType) {
		try {
			QUEEN_IMAGE = ImageIO.read(new File("queen.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, Color.YELLOW));
		panel.setLayout(new MigLayout("", "[450px]", "[33px][33px][23px]"));

		label = new JLabel(panelType.getPanelType());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		panel.add(label, "cell 0 0,alignx center,aligny center");
	}

	public JPanel getPanel() {
		return panel;
	}
	
	public void addToPanel(JPanel gridPanel) {
		if (panel.getComponentCount() > 2)
			panel.remove(2);
		panel.add(gridPanel, "cell 0 2,alignx center,growy");

		redraw();
	}

	public void show(boolean show) {
		panel.setVisible(show);
		redraw();
	}

	private void redraw() {
		panel.revalidate();
		panel.repaint();
	}
}
