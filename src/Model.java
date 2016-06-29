import static java.lang.Math.*;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingUtilities;

public class Model {
	public final VView view;
	private double anglel;
	private double angler;
	private double llength;
	private double rlength;
	private int height;
	private int width;
	
	public Model(VView vw,Punkt anf,Punkt mid,Punkt li,Punkt re,int hoehe,int breite){
		System.out.println("in model constructor");
		this.height=hoehe;
		this.width=breite;
		this.view=vw;
		if(anf.getx()>mid.getx()){
			if(li.getx()<mid.getx()){
				this.anglel=90+Math.toDegrees(Math.asin((anf.getx()-mid.getx())/abstand(mid,anf))+Math.asin((mid.gety()-li.gety())/abstand(mid,li)));
			}
			else{
				this.anglel=180+Math.toDegrees(Math.asin((anf.getx()-mid.getx())/abstand(mid,anf))+Math.asin((li.getx()-mid.getx())/abstand(mid,li)));
			}
			if(re.getx()>mid.getx()){
				this.angler=Math.toDegrees(Math.acos((anf.getx()-mid.getx())/abstand(anf,mid))+Math.asin((re.gety()-mid.gety())/abstand(mid,re)));
			}
			else{
				this.angler=90+Math.toDegrees(Math.acos((anf.getx()-mid.getx())/abstand(anf,mid))+Math.acos((re.gety()-mid.gety())/abstand(mid,re)));
			}
		}
		else{
			if(li.getx()<mid.getx()){
				this.anglel=Math.toDegrees(Math.acos((mid.getx()-anf.getx())/abstand(mid,anf))+Math.asin((li.gety()-mid.gety())/abstand(mid,li)));
			}
			else{
				this.anglel=90+Math.toDegrees(Math.acos((mid.getx()-anf.getx())/abstand(mid,anf))+Math.asin((li.getx()-mid.getx())/abstand(mid,li)));
			}
			if(re.getx()>mid.getx()){
				this.angler=90+Math.toDegrees(Math.asin((mid.getx()-anf.getx())/abstand(mid,anf))+Math.asin((re.gety()-mid.gety())/abstand(mid,re)));
			}
			else{
				this.anglel=180+Math.toDegrees(Math.asin((mid.getx()-anf.getx())/abstand(mid,anf))+Math.asin((mid.getx()-re.getx())/abstand(mid,re)));
			}
		}
		this.angler=Math.atan(abstand(mid,re)/abstand(anf,mid));
		this.llength=abstand(mid,li)/abstand(mid,anf);
		this.rlength=abstand(mid,re)/abstand(mid,anf);
		
		if(view == null){
			
			System.out.println("ERRROR null view");
		}
		view.drawaline(anf,mid);
		paint(anf,mid,li,re);
	}
	
	public void paint(Punkt a, Punkt m,Punkt l,Punkt r){
		view.drawaline(m,l);
		view.drawaline(m,r);
		Punkt p1=newPunkt(m,l,true);
		Punkt p2=newPunkt(m,l,false);
		Punkt p3=newPunkt(m,r,true);
		Punkt p4=newPunkt(m,r,false);
		if(possible(l,p1) && possible(l,p2)){
			paint(m,l,p1,p2);
		}
		if(possible(r,p3) && possible(r,p2)){
			paint(m,r,p3,p4);
		}
		
	}
	
	public double abstand(Punkt a,Punkt b){
		return sqrt(((Math.abs(a.getx()-b.getx())*(Math.abs(a.getx()-b.getx()))+Math.abs(a.gety()-b.gety())*(Math.abs(a.gety()-b.gety())))));
	}
	
	public boolean possible(Punkt x,Punkt y){
		if(abstand(x,y)<1){
			return false;
		}
		if(y.getx()>width){
			return false;
		}
		if(y.getx()<0){
			return false;
		}
		if(y.gety()>height){
			return false;
		}
		if(y.gety()<0){
			return false;
		}
		return true;
	}
	
	public Punkt newPunkt(Punkt mid,Punkt aus,boolean lor){ // true=links false=rechts
		double winkel;
		double newlength;
		if(lor){
			newlength=abstand(mid,aus)*llength;
			if(aus.getx()<mid.getx()){
				if(aus.gety()<mid.gety()){
					winkel=anglel+270-Math.toDegrees(Math.asin((mid.gety()-aus.gety())/abstand(aus,mid)));
				}
				else{
					winkel=anglel+180-Math.toDegrees(Math.asin((aus.getx()-mid.getx())/abstand(aus,mid)));
				}
			}
			else{
				if(aus.gety()<mid.gety()){
					winkel=anglel-Math.toDegrees(Math.asin((aus.gety()-mid.gety())/abstand(aus,mid)));
				}
				else{
					winkel=anglel+90-Math.toDegrees(Math.asin((mid.gety()-aus.gety())/abstand(aus,mid)));
				}
			}
		}
		else{
			newlength=abstand(mid,aus)*rlength;
			if(aus.getx()<mid.getx()){
				if(aus.gety()<mid.gety()){
					winkel=90+angler-Math.toDegrees(Math.asin((mid.getx()-aus.getx())/abstand(aus,mid)));
				}
				else{
					winkel=angler-Math.toDegrees(Math.asin((aus.gety()-mid.gety())/abstand(aus,mid)));
				}
			}
			else{
				if(aus.gety()<mid.gety()){
					winkel=angler+180-Math.toDegrees(Math.asin((mid.gety()-aus.gety())/abstand(aus,mid)));
				}
				else{
					winkel=270+angler-Math.toDegrees(Math.asin((aus.getx()-mid.getx())/abstand(aus,mid)));
				}
			}
		}
		Punkt neu = null;
		double abs;
		switch(((int)(winkel)/90)%4){
			case 0:
				abs=sqrt(winkel*winkel+(90-winkel)*(90-winkel));
				abs=newlength/abs;
				neu=new Punkt((int)Math.round(aus.getx()+abs*(90-winkel)),(int)Math.round(aus.gety()+abs*winkel));
				break;
			case 1:
				abs=sqrt(winkel*winkel+(90-winkel)*(90-winkel));
				abs=newlength/abs;
				neu=new Punkt((int)Math.round(aus.getx()-abs*winkel),(int)Math.round(aus.gety()+abs*(90-winkel)));
				break;
			case 2:
				abs=sqrt(winkel*winkel+(90-winkel)*(90-winkel));
				abs=newlength/abs;
				neu=new Punkt((int)Math.round(aus.getx()-abs*(90-winkel)),(int)Math.round(aus.gety()-abs*winkel));
				break;
			case 3:
				abs=sqrt(winkel*winkel+(90-winkel)*(90-winkel));
				abs=newlength/abs;
				neu=new Punkt((int)Math.round(aus.getx()+abs*winkel),(int)Math.round(aus.gety()-abs*(90-winkel)));
				break;
		}
		return neu;
	}
	
}
