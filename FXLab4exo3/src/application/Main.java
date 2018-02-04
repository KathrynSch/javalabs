package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;


public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
	 	
		//initialize pie chart data
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("SI", 150),
				new PieChart.Data("SE", 160),
				new PieChart.Data("OCRES", 45),
				new PieChart.Data("Finance", 38),
				new PieChart.Data("EE", 89),
				new PieChart.Data("Santé", 78));
		
		//create piechart
		PieChart pieChart = new PieChart(pieChartData);
		
		//set title of pie chart
		pieChart.setTitle("Number of students per master option at ECE");
		
		//set direction to arrange data
		pieChart.setLabelLineLength(50);
		
		//set labels visible
		pieChart.setLabelsVisible(true);
		
		//set start angle of the pie chart
		pieChart.setStartAngle(0);
	 
        Group root = new Group(pieChart);
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Pie chart app");
        
        stage.setScene(scene);
        stage.show();
    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        launch(args);
	    }
}
