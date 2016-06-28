import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.View;

public class Controller implements ActionListener{
	private Model _model;
	private VView _view;
	
	public Controller(){
		//this._model = new Model (null, null, null, null, null, 0, 0);
		this._view = new VView ();
		
		//addListener();
		
	}
	
	public void start(){
		//
	}
	
	public void showView(){
		this._view.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int [] wert = int.(_view.getEingabe());
		_model.Model(wert);
		_view.drawaline(String.valueOf(_model.get));
		
	}
	
}
