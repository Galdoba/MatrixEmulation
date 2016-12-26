

public class Dice {
	
	private static int dp1;
	private static int dp2;
	private static boolean gli;
	private static boolean cgl;
	private static boolean suc;
	
	public static int hit1;
	public static int hit2;
	
	private static int lim;
	private static int tre;
	//private int limit;
	
	public Dice (int dicePool1, int dicePool2, int limit, int treshold, boolean glitch, boolean critGlitch, boolean success) {
		dp1 = dicePool1;
		dp2 = dicePool2;
		lim = limit;
		tre = treshold;
		
		gli = glitch;
		cgl = critGlitch;
		suc = success;
		
		//System.out.println(dicePool1);
	}
	
	
	
	public static boolean getGli () { //accesesor method (getter)
		return gli;
	}
	
	public static void setGli (boolean glitch) { //mutator (setter)
		gli = glitch;
	}
	public static boolean getCritGli () { //accesesor method (getter)
		return cgl;
	}
	
	public static void setCritGli (boolean critGlitch) { //mutator (setter)
		cgl = critGlitch;
	}
	public static boolean getSuc () { //accesesor method (getter)
		return suc;
	}
	
	public static void setSuc (boolean success) { //mutator (setter)
		suc = success;
	}
	
	public static int getThreshold () { //accesesor method (getter)
		return tre;
	}
	
	public static void setThreshold (int treshold) { //mutator (setter)
		tre = treshold;
	}
	
			
	public int getDicePool1() {
		return dp1;
	}
	
	public static void setDicePool1(int dicePool1) {
		dicePool1 = dp1;
	}
	
	public int getDicePool2() {
		return dp2;
	}
	
	public static void setDicePool2(int dicePool2) {
		dicePool2 = dp2;
	}
	
	public int getLimit() {
		return lim;
	}
	
	public static void setLimit(int limit) {
		limit = lim;
	}
	
	
	
	
	public static int oppTest ( int dicePool1, int dicePool2, int limit, boolean glitch, boolean critGlitch, boolean success) {
		int glitchCounter1 = 0;
		//int glitchCounter2 = 0;
		hit1 = 0;
		hit2 = 0;
		int netHits = 0;
		int diceResult1 = 0;
		int diceResult2 = 0;
		int counter = 0;
		//System.out.println("Begin: Dice #  " + counter + " = " + diceResult1 + dicePool1);
		while (counter <= dicePool1) { //Attack rolling cycle
			diceResult1 = 1 + (int)(Math.random() * 6);
				if (diceResult1 == 1) {
					glitchCounter1++;
				} else if (diceResult1 == 5) {
					hit1++;
				} else if (diceResult1 == 6) {
					hit1++;
				}
		
			//System.out.println("Dice # " + counter + " = " + diceResult1);
			counter++;
		}
		counter = 1;
		while (counter <= dicePool2) { //Defence rolling cycle
			diceResult2 = 1 + (int)(Math.random() * 6);
				if (diceResult2 == 1) {
//					glitchCounter2++;
				} else if (diceResult2 == 5) {
					hit2++;
				} else if (diceResult2 == 6) {
					hit2++;
				}
		
			//System.out.println("Dice # " + counter + " = " + diceResult1);
			counter++;
		}
		if (hit1 > limit) {
			hit1 = limit;
		}
		if ((glitchCounter1 +1 ) >=  (dicePool1/2) && hit1 > 0) {
			gli=true;
			cgl=false;
		} else {
			gli=false;
		}
		
		if ((glitchCounter1 +1 ) >=  (dicePool1/2) && hit1 == 0) {
			cgl=true;
			suc = false;
			gli=false;
		} else {
			cgl=false;
		}
		netHits = hit1 - hit2;
		if (netHits > 0) {
			suc=true;
			cgl=false;
		} else {
			suc=false;
		}
		success = suc;
		glitch = gli;
		critGlitch = cgl;
		
		
		
		//System.out.println("Attack got " + hit1 + " successes of " + dicePool1 + " dice");
		//System.out.println("Defence got " + hit2 + " successes of " + dicePool2 + " dice");
		//System.out.println("Test result (attacker side) is " + netHits + " NetHits");
		return netHits;
	}
	
	
	
	public static int tresholdTest ( int dicePool1, int treshold, int limit, boolean glitch, boolean critGlitch, boolean success) {
		
		
		int glitchCounter1 = 0;
		//int glitchCounter2 = 0;
		int hit1 = 0;
		//int hit2 = 0;
		//int netHits = 0;
		int diceResult1 = 0;
		//int diceResult2 = 0;
		int counter = 0;
		//System.out.println("Begin: Dice# ¹ " + counter + " = " + diceResult1 + dicePool1);
		//boolean glitch = false;
		//boolean critGlitch = false;
		//boolean success = false;
		
		//for(int x = 10; x < 20; x = x+1)
		//for (counter = 1; counter == dicePool1; counter++) { //Attack roll cycle
		while (counter < dicePool1) {
			diceResult1 = 1 + (int)(Math.random() * 6);
			counter++;
				if (diceResult1 == 1) {
					glitchCounter1++;
				} else if (diceResult1 == 5) {
					hit1++;
				} else if (diceResult1 == 6) {
					hit1++;
				}
		
			//System.out.println("Dice # " + counter + " = " + diceResult1);
			//counter++;
		}
		
		if (hit1 > limit) {
			hit1 = limit;
		}
		
		if ((glitchCounter1 + 1) > (dicePool1/2) && hit1 > 0 && hit1 < treshold) {
			gli = true;
			cgl = false;
			//glitch = gli;
			//critGlitch = cgl;
			//System.out.println("You got GLITCH!"); 
			//Test unpassed. Glitch
		} else if ((glitchCounter1 + 1) > (dicePool1/2) && hit1 == 0) {
			cgl = true;
			gli = false;
			suc = false;
			critGlitch = cgl;
			//System.out.println("You got CRITICAL GLITCH! OMG!!111");
			//Test unpassed. Critical Glitch
		} else if ((glitchCounter1 + 1) <= (dicePool1/2) && hit1 >= treshold) {
			suc = true;
			cgl = false;
			success = suc;
			//System.out.println("Hunt was successful. Good job!");
			//Test passed. No Glitch
		} else if ((glitchCounter1 + 1) <= (dicePool1/2) && hit1 < treshold) {
			//System.out.println("You failed hunting.");
			suc = false;
			gli = false;
			cgl = false;
			//Test passed. Glitch
		} else {
			gli = true;
			suc = true;
			cgl = false;
			success = suc;
			glitch = gli;
			critGlitch = cgl;
			//System.out.println("Hunt was successful. Sorta. You got glitch.");
			//Test passed. Glitch
		}
		
		
		//System.out.println("Att Dicepool: " + dicePool1 + ", " + "successes: " + hit1 + ", threshold " + treshold + ", Glitch = " + glitch + ", CRITGlitch = " + critGlitch);
		
		
		
		if (hit1 < treshold) {
			//System.out.println("Akell missed =(");
		}
		
		
		//netHits = hit1 - hit2;
		
		//System.out.println("Att got " + hit1 + " sucesses");
		//System.out.println("Def got " + hit2 + " sucesses");
		return hit1;
	}

	public static int dotsqty ( int dicePool1) {
		
		int diceResult1 = 0;
		int counter = 0;
		int total = 0;
		while (counter < dicePool1) {
			diceResult1 = 1 + (int)(Math.random() * 6);
			total = total + diceResult1;
			counter++;
		}
		
		//System.out.println("Were dice: " + dicePool1 + ", made " + initiative + " Initiative");
		return total;
	
		
		
	}
	
	
}