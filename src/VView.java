import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
        this.setBounds(200, 200, 500, 500);
        
        this.add(calc);
        this.add(x1);
        this.add(x2);
        this.add(y1);
        this.add(y2);

        JPanel panel=new JPanel();
        panel.setBackground( Color.BLUE);
        getContentPane().add(panel);
        panel.setSize(450,450);
        this.add(panel, BorderLayout.CENTER);
        
        
	}
	
    public void setPointsListener(ActionListener l){
        this.calc.addActionListener(l);
    }
	
	public int[] getEingabe() {
	    int[] intArray = new int[4];
	    
	    intArray[0] = Integer.parseInt(x1.getText());
	    intArray[1] = Integer.parseInt(x2.getText());
	    intArray[2] = Integer.parseInt(y1.getText());
	    intArray[3] = Integer.parseInt(y2.getText());
	    
	    System.out.println(intArray[0]);

	    
	    
	    return intArray;
	}
	
	public void drawaline(Punkt a, Punkt b){
		
	}
	
}
