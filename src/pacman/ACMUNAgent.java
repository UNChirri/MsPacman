package pacman;

import games.math.Vector2d;

public class ACMUNAgent implements Constants{
	Vector2d nearPill;
	//ConnectedSet sed;
	public int move(int fg) {
		// TODO Auto-generated method stub
		if(fg == -65536){
			return 3;
		}else if (fg== -18689){
			return 3;
		}else if(fg == -16711681){
			return 3;
		}else if(fg == -18859){
			return 3;
		}
		return 2;
	}
}
