import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VView extends JFrame{
	
	JPanel center;
    JPanel centerPanel1;
    JPanel centerPanel2;
	
	private JTextField x1 = new JTextField(3);
	private JTextField x2 = new JTextField(3);
	private JTextField y1 = new JTextField(3);
	private JTextField y2 = new JTextField(3);
	private JTextField h = new JTextField(3);
	private JTextField b = new JTextField(3);
	
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
    ArrayList<String> texts = new ArrayList<String>();
    
    int maxFields = 10;
	
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
        this.add(h);
        this.add(b);
        center = new JPanel(new GridLayout(1, 2));
        centerPanel1 = new JPanel(new GridLayout(maxFields, 1, 0, 20));
        centerPanel2 = new JPanel();
        center.add(centerPanel1);
        center.add(centerPanel2);
        
        
		
	}
	
<<<<<<< HEAD
	public int[] getEingabe() {
	    int[] intArray = new int[5];
	    
	    intArray[0] = Integer.parseInt(x1.getText());
	    intArray[1] = Integer.parseInt(x2.getText());
	    intArray[2] = Integer.parseInt(y1.getText());
	    intArray[3] = Integer.parseInt(y2.getText());
	    intArray[4] = Integer.parseInt(h.getText());
	    intArray[5] = Integer.parseInt(b.getText());
	    
	    return intArray;
=======
	public int[] getEingabe(){
		
		
		return this.x1.getText();
>>>>>>> de1c36c1a296ca0198fbdb9dc4bc7620bde43bf7
	}
	
	public void drawaline(Punkt a, Punkt b){
		
	}
	
	private void startButton(ActionListener l){
		this.calc.addActionListener(l);
	}
}
