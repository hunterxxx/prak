import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VView extends JFrame{
	private JLabel lbl1 = new JLabel("x1");
	private JLabel lbl2 = new JLabel("x2");
	private JLabel lbl3 = new JLabel("x3");
	private JLabel lbl4 = new JLabel("x4");
	private JLabel lbl5 = new JLabel("y1");
	private JLabel lbl6 = new JLabel("y2");
	private JLabel lbl7 = new JLabel("y3");
	private JLabel lbl8 = new JLabel("y4");
	private JTextField x1 = new JTextField(3);
	private JTextField x2 = new JTextField(3);
	private JTextField x3 = new JTextField(3);
	private JTextField x4 = new JTextField(3);
	private JTextField y1 = new JTextField(3);
	private JTextField y2 = new JTextField(3);
	private JTextField y3 = new JTextField(3);
	private JTextField y4 = new JTextField(3);
	
	private JButton calc = new JButton("Berechnen");
		
	public VView(){
		super("Pflanzen");
        initForm();
	}

	private void initForm() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(200, 200, 500, 500);
        
        this.add(calc);
        this.add(lbl1);
        this.add(x1);
        this.add(lbl2);
        this.add(x2);
        this.add(lbl3);
        this.add(x3);
        this.add(lbl4);
        this.add(x4);
        this.add(lbl5);
        this.add(y1);
        this.add(lbl6);
        this.add(y2);
        this.add(lbl7);
        this.add(y3);
        this.add(lbl8);
        this.add(y4);
	}
	
    public void setPointsListener(ActionListener l){
        this.calc.addActionListener(l);
    }
	
	public int[] getEingabe() {
	    int[] intArray = new int[8];
	    
	    intArray[0] = Integer.parseInt(x1.getText());
	    intArray[1] = Integer.parseInt(x2.getText());
	    intArray[2] = Integer.parseInt(x3.getText());
	    intArray[3] = Integer.parseInt(x4.getText());
	    intArray[4] = Integer.parseInt(y1.getText());
	    intArray[5] = Integer.parseInt(y2.getText());
	    intArray[6] = Integer.parseInt(y3.getText());
	    intArray[7] = Integer.parseInt(y4.getText());
	    
	    System.out.println(intArray[0]);
	    
	    return intArray;
	}
		
	public void drawaline(Punkt a,Punkt b){
		Graphics g = this.getGraphics(); 
		g.setColor(Color.green);
		g.drawLine(a.x, a.y, b.x, b.y);
	}		
}
