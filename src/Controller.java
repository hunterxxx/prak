import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	private Model _model;
	private View _view;
	
	public Controller(){
		this._model = new Model(null, null, null, null, null, 0, 0);
		this._view = new View();
		
	}
	
	public void start(){
		
	}
	
	public void showView(){
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
}
