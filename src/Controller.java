import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller{
	private Model _model;
	private VView _view;
	
	public int breite = 500;
	public int hoehe = 500;
	
	public Controller(){
		this._view = new VView ();
		
		addListener();
	}
	
	public void showView(){
		this._view.setVisible(true);
	}
	
	
	private void addListener(){
		this._view.setPointsListener(new PointsListener());
	 }
	  
	  class PointsListener implements ActionListener{
	        public void actionPerformed(ActionEvent e) {
	        	int [] wert = _view.getEingabe();
	            _model= new Model(_view,new Punkt(wert[0],wert[1]),new Punkt(wert[2],wert[3]),new Punkt(wert[4],wert[5]), new Punkt(wert[6],wert[7]),hoehe,breite);
	        }
	    }

}
