module com.orion.domotica {
	requires javafx.controls;
	requires javafx.fxml;
	
	
	opens com.orion.domotica to javafx.fxml;
	exports com.orion.domotica;
}