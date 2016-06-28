import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VView extends JFrame{
	
	private JTextField x1 = new JTextField(3);
	private JTextField x2 = new JTextField(3);
	private JTextField y1 = new JTextField(3);
	private JTextField y2 = new JTextField(3);
	
	private JButton calc = new JButton("Berechnen");
	
	public VView(){
		super("Hello");
        initForm();
	}

	private void initForm() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(200, 200, 500, 100);
        
        this.add(calc);
        this.add(x1);
        this.add(x2);
        this.add(y1);
        this.add(y2);

		
	}
	
	public int[] getEingabe(){
		
		
		return this.x1.getText();
	}
	
	private void drawaline(Punkt a, Punkt b){
		
	}
	
	private void startButton(ActionListener l){
		this.calc.addActionListener(l);
	}
}
