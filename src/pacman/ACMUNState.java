package pacman;

import java.awt.Graphics;

import games.math.Vector2d;

//pls work :'v
public class ACMUNState implements Drawable {
	private ACMUNAgent agent;
	//Como se encuentra el mundo 
	public ACMUNState() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void draw(Graphics g, int w, int h) {
		// TODO Auto-generated method stub
		
	}


	public void reset() {
		//to do
        //closestPill = null;
    }
	
	public void update(ConnectedSet cs, int[] pix) {
        if (cs.isPacMan()) {
        } else if (cs.ghostLike()) {
            // update the state of the ghost distance


        } else if (cs.pill()) {
            // keep track of the position of the closest pill
//            tmp.set(cs.x, cs.y);
//            if (closestPill == null) {
//                closestPill = new Vector2d(tmp);
//            } else if (tmp.dist(agent.cur) < closestPill.dist(agent.cur)) {
//                closestPill.set(tmp);
//            }
        }

    }

	public ACMUNAgent getAgent(){
		return this.agent;
	}



}
