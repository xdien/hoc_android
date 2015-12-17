package com.example.extentlib;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GraphViewData[] dulieu = new GraphViewData[]{ 
			    new GraphViewData(2010, 10000), new GraphViewData(2011, 11000), 
			    new GraphViewData(2012, 10500), new GraphViewData(2013, 13000), 
			    new GraphViewData(2014, 12000), new GraphViewData(2015, 12250), 
			    new GraphViewData(2016, 12000)}; 
			GraphViewData[] dulieuduthi = new GraphViewData[]{ 
			    new GraphViewData(2010, 8000), new GraphViewData(2011, 9000), 
			    new GraphViewData(2012, 9500), new GraphViewData(2013, 11000), 
			    new GraphViewData(2014, 10000), new GraphViewData(2015, 11250), 
			    new GraphViewData(2016, 11000)}; 
			GraphViewData[] tyledau = new GraphViewData[]{ 
				    new GraphViewData(2010, 2222), new GraphViewData(2011, 7645), 
				    new GraphViewData(2012, 3333), new GraphViewData(2013, 10442), 
				    new GraphViewData(2014, 9765), new GraphViewData(2015, 10996), 
				    new GraphViewData(2016, 9075)}; 
			// init example series data 
			GraphViewSeries dangky = new GraphViewSeries("Đăng ký", 
			    new GraphViewSeriesStyle(Color.rgb(90, 250, 00), 3), dulieu); 
			GraphViewSeries duthi = new GraphViewSeries("Dự thi", 
			    new GraphViewSeriesStyle(Color.rgb(200, 50, 00), 3), 
			    dulieuduthi); 
			GraphViewSeries dau = new GraphViewSeries("Dau", 
				    new GraphViewSeriesStyle(Color.rgb(200, 66, 11), 3), 
				    tyledau); 
			GraphView graphView = new LineGraphView(this // context 
			    , "Biểu đồ tỉ lệ sinh viên dự thi" // heading 
			); 
			graphView.addSeries(dangky); // data 
			graphView.addSeries(duthi); // data 
			graphView.addSeries(dau);
			graphView.setShowLegend(true); 
			graphView.setLegendAlign(LegendAlign.BOTTOM); 
			graphView.setLegendWidth(200); 
			graphView.getGraphViewStyle().setGridColor(Color.GREEN); 
			graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.YELLOW); 
			graphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED); 
			graphView.getGraphViewStyle().setTextSize(24); 
			graphView.getGraphViewStyle() 
			    .setNumHorizontalLabels(dulieuduthi.length); 
			graphView.getGraphViewStyle().setNumVerticalLabels(5); 
			graphView.getGraphViewStyle().setVerticalLabelsWidth(100); 
			LinearLayout layout = (LinearLayout) findViewById(R.id.layout); 
			layout.addView(graphView); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class GraphViewData implements GraphViewDataInterface { 
		  GraphViewData(double x, double y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
		  double x; 
		  double y; 
		  @Override 
		  public double getX() { 
		    // TODO Auto-generated method stub 
		    return x; 
		  } 
		 
		  @Override 
		  public double getY() { 
		    // TODO Auto-generated method stub 
		    return y; 
		  } 
		} 
}
