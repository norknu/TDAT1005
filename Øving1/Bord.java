
class Bord {
	private int antBord;
	private String[] navnTab;

	public Bord (int antBord){
		this.navnTab = new String[antBord];
		this.antBord = antBord;
	}

	public int getAntLedigBord(){
		int antLedigBord = 0;
		for(int i=0; i< navnTab.length; i++){
			if(navnTab[i] == null){
				antLedigBord++;
			}
		}
		return antLedigBord;
	}

	public int getAntOpptattBord(){
		int antOpptattBord = 0;
		for(int i=0; i<navnTab.length; i++){
			if(navnTab[i] !=null){
				antOpptattBord++;
			}
		}
		return antOpptattBord;
	}

	public boolean reservereBord(String navn, int stkBord){
		for(int i=0; i<antBord; i++){
			if(navnTab[i] == null && stkBord !=0){
				navnTab[i] = navn;
				stkBord -=1;
			}
		}
		return true;
	}

	public boolean frigiBord(int[] friBord){
		if(friBord == null) return false;
		for(int i=0; i<friBord.length; i++){
			navnTab[friBord[i]] = null;
		}
		return true;
	}

	public int[] antBordRes(String navn){
		int[] res = new int[0];
		int teller = 0;
		for(int i=0; i<navnTab.length; i++){
			if(navnTab[i] == null){continue;}
			if(navnTab[i].equals(navn)){
				if(teller == res.length){
					res = utvidTabell(res);
				}
				res[teller] = i;
				teller++;
			}
		}
		return res;
	}

	private int[] utvidTabell(int[] nyTab){
		int[] tmp = new int[nyTab.length +1];
		for(int i=0; i<nyTab.length; i++){
			tmp[i] = nyTab[i];
		}
		return tmp;
	}

	public String toString(){
			String ret = "";
			for (int i = 0; i < navnTab.length; i++) {
				ret = "Bordnummer " + i + ": " + navnTab[i] + "\n";
			}
			return ret;
		}
}




