import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller{
	private Model _model;
	private VView _view;
	
	public int breite = 500;
	public int hoehe = 500;
	
	public Controller(){
		//VView vw = null;
		

		//this._model = new Model (vw,anf,mid, li,re,hoehe,breite);
		
		this._view = new VView ();
		
		addListener();
	}
	
	public void start(){
		
	}
	

	public void showView(){
		this._view.setVisible(true);
	}
	
	
	public void passDateToModel(){
		
		
		
		
	}
	
	  private void addListener(){
	        this._view.setPointsListener(new PointsListener());

	 }
	  
	  class PointsListener implements ActionListener{
	        public void actionPerformed(ActionEvent e) {
	            // TODO read and parse values
	        	int [] wert = _view.getEingabe();
	            
	        	
	            
	            _model= new Model(_view,new Punkt(250,400),new Punkt(250,350),new Punkt(200,200), new Punkt(400,200),hoehe,breite);
	        }
	    }

}
