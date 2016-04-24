package ai.star.ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ai.star.enums.Algorithm;

public class ComparisonBarChart {
	private DefaultCategoryDataset dataset;

	public ComparisonBarChart() {
		dataset = new DefaultCategoryDataset();
	}

	public DefaultCategoryDataset getDataset() {
		return dataset;
	}

	public void addToDataSet(Algorithm algorithm, int n, int nodes) {
		dataset.addValue(nodes, algorithm.getType(), "" + n);
	}
	
	public ChartPanel getChartPanel() {
		JFreeChart barChart = ChartFactory.createBarChart("Comparisons", "# of Queens", "# of Nodes Expanded",
				getDataset(), PlotOrientation.VERTICAL, true, true, false);
		return new ChartPanel(barChart);
	}

}
