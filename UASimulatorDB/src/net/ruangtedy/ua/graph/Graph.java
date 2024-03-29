package net.ruangtedy.ua.graph;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class Graph extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;
	
	public Graph(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
	}
	
	private static JFreeChart createChart(CategoryDataset dataset) 
	{
		JFreeChart chart = ChartFactory.createLineChart
		(
				"Java Standard Class Library", // chart title
				"Release", // domain axis label
				"Class Count", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				true, // tooltips
				false // urls
		);
		
		chart.addSubtitle(new TextTitle("Number of Classes By Release"));
		
		TextTitle source = new TextTitle("Source: Java In A Nutshell (4th Edition) "
		+ "by David Flanagan (O�Reilly)");
				
		source.setFont(new Font("SansSerif", Font.PLAIN, 10));
		source.setPosition(RectangleEdge.BOTTOM);
		source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(source);
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);
		
		// customise the range axis...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		// customise the renderer...
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		
		renderer.setShapesVisible(true);
		renderer.setDrawOutlines(true);
	    renderer.setUseFillPaint(true);
	    renderer.setFillPaint(Color.white);
	    return chart;
	}
	/**
	 * 
	 */
	
	private static CategoryDataset createDataset() 
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(212, "Classes", "JDK 1.0");
		dataset.addValue(504, "Classes", "JDK 1.1");
		dataset.addValue(1520, "Classes", "SDK 1.2");
		dataset.addValue(1842, "Classes", "SDK 1.3");
		dataset.addValue(2991, "Classes", "SDK 1.4");
		return dataset;
	 }
	
	public static JPanel createDemoPanel() 
	{
		JFreeChart chart = createChart(createDataset());return new ChartPanel(chart);
	}
	/**
	* Starting point for the demonstration application.
	*
	* @param args ignored.
	*/
	
	public static void main(String[] args)
	{
		Graph demo = new Graph("Line Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}
