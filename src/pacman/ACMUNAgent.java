package pacman;

public class ACMUNAgent implements Constants{
	//ConnectedSet sed;
	public int move(ConnectedSet sed) {
		// TODO Auto-generated method stub
		if(sed.ghostLike()){
			return 2;
		}else{
			return 3;
		}
	}
}
