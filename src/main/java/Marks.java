import java.util.ArrayList;
import java.util.List;

public class Marks extends MatrixAction {
	
	private int sourceID;
	private int targetID;
	private int markqty;
	static boolean addMark = false;
	public Marks[] preMarkLists;
	static Marks preMark = new Marks (0,0,0);
	public static List <Marks> preMarkList = new ArrayList<Marks>();
	
	public Marks(int sourceID, int targetID, int markqty) {
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.markqty = markqty;
	}

		
	public static void initiateMARKs() {
		int markIniCounter = 0;
		if (markList.size() == 0) {
			System.out.println("markList.size()=" + markList.size());
			markList.add(mARK);
		}
		for (int i=0; i<iconList.size();i++) {
			int mS=iconList.get(i).getIconID();
			for (int j=0; j<iconList.size(); j++){
				int mT=iconList.get(j).getIconID();
				preMark = new Marks(mS,mT,0);
				markIniCounter = markIniCounter + 1;
				compareMark ();
				if (addMark == true) {
					markList.add(preMark);
					addMark = false;
				}
				setOwnership ();
			}
		}
	}
		
	private static void setOwnership() {
		for (int i=0; i < markList.size(); i++) { //ÏÅÐÅÁÈÐÀÅÌ ÓÒÂÅÐÆÄÅÍÍÛÅ ÌÀÐÊÈ
			if (markList.get(i).getSourceID() == markList.get(i).getTargetID()) {
				markList.get(i).setMarkqty(4);
			}
			
		}
		
	}

	private static boolean compareMark () {
		addMark = false;
		for (int j=0; j < markList.size(); j++) { //ÏÅÐÅÁÈÐÀÅÌ ÓÒÂÅÐÆÄÅÍÍÛÅ ÌÀÐÊÈ
				if (preMark.getSourceID()==markList.get(j).getSourceID() && preMark.getTargetID()==markList.get(j).getTargetID()) { //ÑÐÀÂÍÈÂÀÅÌ ÏÎÒÅÍÖÈÀËÜÍÛÅ È ÓÒÂÅÐÆÄÅÍÍÛÅ (ÅÑËÈ ÅÑÒÜ ÏÎËÍÎÅ ÑÎÂÏÀÄÅÍÈÅ ÍÈ×ÅÃÎ ÍÅ ÄÅËÀÅÌÁ ÅÑËÈ ÏÎËÍÎÃÎ ÑÎÂÏÀÄÅÍÈß ÍÅÒ - ÄÎÁÀÂËßÅÌ
					addMark = false;
					return addMark;
				}
			}
		addMark = true;
		return addMark;
	}
	
	public static int searchMarks () {
		int x = 0;
		int mS = iconAttack.getIconID();
		int mT = iconDefence.getIconID ();
		for (int i = 0; i < markList.size(); i++) {
			if ((markList.get(i).getSourceID() == mS) && (markList.get(i).getTargetID() == mT)) {
				x = markList.get(i).getMarkqty();
			}
		}
		return x;
	}
	
	public static boolean checkMarks (String matrixActionName) { //Èìååì íàçâàíèå äåéñòâèÿ = íåîáõîäèìûé ìèíèìóì ìàðîê.
		boolean validity = false;
		int validMarks = 0;
		switch (matrixActionName) {
		case "Data Spike" : validMarks = 0; //äëÿ ïðèìåðà
			break;
		case "Brute Force" : validMarks = 0;	
			break;
		default: validMarks = 0;	
			break;
		}
		if (Marks.searchMarks() >= validMarks) {; 
			System.out.println("Action validated...");
			validity = true;
		}
		return validity;
	}
	
	public static void place1Mark () {
		int x;
		int mS = iconAttack.getIconID();
		int mT = iconDefence.getIconID ();
		for (int i = 0; i < markList.size(); i++) {
			if ((markList.get(i).getSourceID() == mS) && (markList.get(i).getTargetID() == mT)) {
				x = markList.get(i).getMarkqty(); 
				markList.get(i).setMarkqty(x+1);
			}
			if (markList.get(i).getMarkqty() > 3) {
				markList.get(i).setMarkqty(3);
			}
		}
		
	}
	
	public static void place1MarkR () {
		int x;
		int mS = iconDefence.getIconID();
		int mT = iconAttack.getIconID ();
		for (int i = 0; i < markList.size(); i++) {
			if ((markList.get(i).getSourceID() == mS) && (markList.get(i).getTargetID() == mT)) {
				x = markList.get(i).getMarkqty(); 
				markList.get(i).setMarkqty(x+1);
			}
			if (markList.get(i).getMarkqty() > 3) {
				markList.get(i).setMarkqty(3);
			}
		}
		
	}
	
	//---------------------------------------------------------------------------
	

	public  int getSourceID() {
		return sourceID;
	}

	public  void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}

	public  int getTargetID() {
		return targetID;
	}

	public  void setTargetID(int targetID) {
		this.targetID = targetID;
	}

	public  int getMarkqty() {
		return markqty;
	}

	public  void setMarkqty(int markqty) {
		this.markqty = markqty;
	}

	public  List<Marks> getMarkList() {
		return markList;
	}

	public  void setMarkList(List<Marks> markList) {
		Marks.markList = markList;
	}
	
	public void markToString (){
		String pMARK = new String ();
		pMARK = "Source ID=" + sourceID + " Target ID=" + targetID + " markqty=" + markqty;
		System.out.println(pMARK);
		
	}

	
	
	

}