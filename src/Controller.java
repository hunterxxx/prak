import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.View;

public class Controller implements ActionListener{
	private Model _model;
	private VView _view;
	
	public Controller(){
		VView vw = null;
		Punkt anf = null;
		Punkt mid = null;
		Punkt li = null;
		Punkt re = null;
		int breite = 0;
		int hoehe = 0;
		this._model = new Model (vw,anf,mid, li,re,hoehe,breite);
		this._view = new VView ();		
		//addListener();		

		//this._model = new Model (null, null, null, null, null, 0, 0);
		this._view = new VView ();
		
		//addListener();
		
	}
	

	public void showView(){
		this._view.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int [] wert = int.(_view.getEingabe());
		_model(wert);
		_view.drawaline(String.valueOf(_model.get));		
	}
	
}
