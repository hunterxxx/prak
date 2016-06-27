import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class View extends JFrame{
	
	private JTextField txtEingabe = new JTextField(3);
	private JButton calc = new JButton("Berechnen");
	
	public View(){
		super("Pflanzen");
        initForm();
	}

	private void initForm() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(200, 200, 500, 100);
		
	}
	
	public int[] getEingabe(){
		
		
		return this.txtEingabe.getText();;
	}
	
	private void drawaline(Punkt a, Punkt b){
		
	}
	
	private void startButton(ActionListener l){
		this.calc.addActionListener(l);
	}
}
