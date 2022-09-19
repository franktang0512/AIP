package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;

import net.sourceforge.chart2d.*;

/**
 * @see https://stackoverflow.com/q/40537278/230513
 * @see https://stackoverflow.com/q/11870416/230513
 * @see https://stackoverflow.com/a/28519356/230513
 */
public class Histogram {

    private static final int BINS = 256;
//    private final BufferedImage image;
    private HistogramDataset dataset;
    private XYBarRenderer renderer;

//    public Histogram(BufferedImage image){
////    	this.image = image;
//    }
    public Histogram() {}


    ChartPanel createChartPanel(BufferedImage image) {
        // dataset
        dataset = new HistogramDataset();
        Raster raster = image.getRaster();
        final int w = image.getWidth();
        final int h = image.getHeight();
        double[] r = new double[w * h];
        r = raster.getSamples(0, 0, w, h, 0, r);
        dataset.addSeries("Red", r, BINS);
        r = raster.getSamples(0, 0, w, h, 1, r);
        dataset.addSeries("Green", r, BINS);
        r = raster.getSamples(0, 0, w, h, 2, r);
        dataset.addSeries("Blue", r, BINS);
//        int x;
        
//        
//        BufferedImage image_temp=new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
////        r =ProcessImage.RGBtoGray(image).getRaster().getSample(0, 0, x);
//        Raster raster_temp  = image_temp.getRaster();
//        double x[] = new double[w * h];
//        x= raster_temp.getSamples(0, 0,w, h, 0, x);
//        dataset.addSeries("Gray",x, BINS);

        // chart
        JFreeChart chart = ChartFactory.createHistogram("", "Intensity Value(RGB)",
            "Frequency", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        // translucent red, green & blue
        Paint[] paintArray = {
            new Color(0x80ff0000, true),
            new Color(0x8000ff00, true),
            new Color(0x800000ff, true),
            new Color(0x80ffffff, true)
        };
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray,
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    public JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.add(new JCheckBox(new VisibleAction(0)));
        panel.add(new JCheckBox(new VisibleAction(1)));
        panel.add(new JCheckBox(new VisibleAction(2)));
//        panel.add(new JCheckBox(new VisibleAction(3)));
        return panel;
    }

    private class VisibleAction extends AbstractAction {

        private final int i;

        public VisibleAction(int i) {
            this.i = i;
            this.putValue(NAME, (String) dataset.getSeriesKey(i));
            this.putValue(SELECTED_KEY, true);
            renderer.setSeriesVisible(i, true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            renderer.setSeriesVisible(i, !renderer.getSeriesVisible(i));
        }
    }
    
    
    public LBChart2D createChart(BufferedImage gray, int buckets) {
        // Chart2D configuration
        Object2DProperties object2DProps = new Object2DProperties();
        object2DProps.setObjectTitleText("Gray Histogram");
        Chart2DProperties chart2DProps = new Chart2DProperties();
        chart2DProps.setChartDataLabelsPrecision(-1);
        LegendProperties legendProps = new LegendProperties();
        String[] legendLabels = {"Gray"};
        legendProps.setLegendLabelsTexts(legendLabels);
        GraphChart2DProperties graphChart2DProps = new GraphChart2DProperties();
        graphChart2DProps.setLabelsAxisTitleText("Intensity Value(Gray)");
        graphChart2DProps.setNumbersAxisTitleText("Frequency");

        // Dataset
        String[] labelsAxisLabels = new String[buckets];
        for (int i = 0; i < labelsAxisLabels.length; i++) {
            labelsAxisLabels[i] = String.valueOf(i * 256 / buckets);
        }
        graphChart2DProps.setLabelsAxisLabelsTexts(labelsAxisLabels);
        int[] counts = new int[buckets];
        for (int r = 0; r < gray.getHeight(); r++) {
            for (int c = 0; c < gray.getWidth(); c++) {
                int v = (gray.getRGB(c, r) & 0xff) * buckets / 256;
                counts[v]++;
            }
        }
        Dataset dataset = new Dataset(1, counts.length, 1);
        for (int i = 0; i < counts.length; i++) {
            dataset.set(0, i, 0, counts[i]);
        }

        GraphProperties graphProps = new GraphProperties();
        MultiColorsProperties multiColorsProps = new MultiColorsProperties();
        LBChart2D chart2D = new LBChart2D();
        chart2D.setObject2DProperties(object2DProps);
        chart2D.setChart2DProperties(chart2DProps);
        chart2D.setLegendProperties(legendProps);
        chart2D.setGraphChart2DProperties(graphChart2DProps);
        chart2D.addGraphProperties(graphProps);
        chart2D.addDataset(dataset);
        chart2D.addMultiColorsProperties(multiColorsProps);

        //Optional validation:  Prints debug messages if invalid only.
        if (!chart2D.validate(false)) {
            chart2D.validate(true);
        }
        return chart2D;
    }

}