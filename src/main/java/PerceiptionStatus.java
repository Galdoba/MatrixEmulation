import java.util.ArrayList;
import java.util.List;

public class PerceiptionStatus extends MatrixAction {
	
	private int sourceID;
	private int targetID;
	
	static boolean addPerceiptionStatus = false;
	
	private boolean spotSt;
	private boolean typeSt;
	private boolean dRatingSt;
	private boolean attackSt;
	private boolean sleazeSt;
	private boolean dProcesSt;
	private boolean firewallSt;
	private boolean data1St;
	private boolean data2St;
	private boolean data3St;
	
	static PerceiptionStatus prePerceiptionStatus = new PerceiptionStatus (0,0,false,false,false,false,false,false,false,false,false,false);
	
/*	public void statusArray(boolean spotSt, boolean typeSt, boolean dRatingSt, boolean attackSt, boolean sleazeSt, boolean dProcesSt,
			boolean firewallSt, boolean data1St, boolean data2St, boolean data3St) {
		//super();
		this.spotSt = spotSt;
		this.typeSt = typeSt;
		this.dRatingSt = dRatingSt;
		this.attackSt = attackSt;
		this.sleazeSt = sleazeSt;
		this.dProcesSt = dProcesSt;
		this.firewallSt = firewallSt;
		this.data1St = data1St;
		this.data2St = data2St;
		this.data3St = data3St;
	}*/

	//public statusArray newStatus = new statusArray (false, false, false, false, false, false, false, false, false, false);
	
	
	
	//PerceiptionStatus prePStatus = new PerceiptionStatus (0,0,0);
	
	public PerceiptionStatus(int sourceID, int targetID, boolean spotSt, boolean typeSt, boolean dRatingSt, boolean attackSt, boolean sleazeSt, boolean dProcesSt,
			boolean firewallSt, boolean data1St, boolean data2St, boolean data3St) {
		//super;
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.spotSt = spotSt;
		this.typeSt = typeSt;
		this.dRatingSt = dRatingSt;
		this.attackSt = attackSt;
		this.sleazeSt = sleazeSt;
		this.dProcesSt = dProcesSt;
		this.firewallSt = firewallSt;
		this.data1St = data1St;
		this.data2St = data2St;
		this.data3St = data3St;
	}

	
	public static void initiatePerceiptionSt() {
		int percStatusCounter = 0;
		if (percStatusList.size() == 0) {
			System.out.println("percStatusList.size()=" + percStatusList.size());
			percStatusList.add(pStatus0);
		}
		for (int i=0; i<iconList.size();i++) {
			int psS=iconList.get(i).getIconID();
			for (int j=0; j<iconList.size(); j++){
				int psT=iconList.get(j).getIconID();
				prePerceiptionStatus = new PerceiptionStatus(psS,psT,false,false,false,false,false,false,false,false,false,false);
				percStatusCounter = percStatusCounter + 1;
				comparePerceiptionStatus ();
				if (addPerceiptionStatus == true) {
					percStatusList.add(prePerceiptionStatus);
					addPerceiptionStatus = false;
				}
				setDefaultRelations();
			}
		}
	}
	
	
	
	private static boolean comparePerceiptionStatus () {
		addPerceiptionStatus = false;
		for (int j=0; j < percStatusList.size(); j++) { //ÏÅÐÅÁÈÐÀÅÌ ÓÒÂÅÐÆÄÅÍÍÛÅ ÌÀÐÊÈ
				if (prePerceiptionStatus.getSourceID()==percStatusList.get(j).getSourceID() && prePerceiptionStatus.getTargetID()==percStatusList.get(j).getTargetID()) { //ÑÐÀÂÍÈÂÀÅÌ ÏÎÒÅÍÖÈÀËÜÍÛÅ È ÓÒÂÅÐÆÄÅÍÍÛÅ (ÅÑËÈ ÅÑÒÜ ÏÎËÍÎÅ ÑÎÂÏÀÄÅÍÈÅ ÍÈ×ÅÃÎ ÍÅ ÄÅËÀÅÌÁ ÅÑËÈ ÏÎËÍÎÃÎ ÑÎÂÏÀÄÅÍÈß ÍÅÒ - ÄÎÁÀÂËßÅÌ
					addPerceiptionStatus = false;
					return addPerceiptionStatus;
				}
			}
		addPerceiptionStatus = true;
		return addPerceiptionStatus;
	}
	
	private static void setDefaultRelations() {
		for (int i=0; i < percStatusList.size(); i++) { //ÏÅÐÅÁÈÐÀÅÌ ÓÒÂÅÐÆÄÅÍÍÛÅ ÌÀÐÊÈ
			if (percStatusList.get(i).getSourceID() == percStatusList.get(i).getTargetID()) {
				percStatusList.get(i).setSpotSt(true);
				percStatusList.get(i).setTypeSt(true);
				percStatusList.get(i).setAttackSt(true);
				percStatusList.get(i).setSleazeSt(true);
				percStatusList.get(i).setdProcesSt(true);
				percStatusList.get(i).setFirewallSt(true);
				percStatusList.get(i).setData1St(true);
				percStatusList.get(i).setData2St(true);
				percStatusList.get(i).setData3St(true);
			}
			
		}
		
	}
	
	public static boolean searchPeceiptionStatus () {
		boolean spotST = false;
		boolean typeST = false;
		boolean attackST = false;
		boolean slezeST = false;
		boolean dataProcST = false;
		boolean firewallST = false;
		boolean data1ST = false;
		boolean data2ST = false;
		boolean data3ST = false;
		
		int mS = iconAttack.getIconID();
		int mT = iconDefence.getIconID ();
		for (int i = 0; i < percStatusList.size(); i++) {
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				spotST = percStatusList.get(i).isSpotSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				typeST = percStatusList.get(i).isTypeSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				attackST = percStatusList.get(i).isAttackSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				dataProcST = percStatusList.get(i).isSleazeSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				firewallST = percStatusList.get(i).isdProcesSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				data1ST = percStatusList.get(i).isFirewallSt();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				data2ST = percStatusList.get(i).isData1St();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				data3ST = percStatusList.get(i).isData2St();
			}
			if ((percStatusList.get(i).getSourceID() == mS) && (percStatusList.get(i).getTargetID() == mT)) {
				data3ST = percStatusList.get(i).isData3St();
			}
		}
		
		return true;
	}
	
	public static boolean checkPerceiptionStatus (String matrixActionName) { //Èìååì íàçâàíèå äåéñòâèÿ = íåîáõîäèìûé ìèíèìóì ìàðîê.
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
	
	
	public static void placeChangePS () {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	

	public int getSourceID() {
		return sourceID;
	}



	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}



	public int getTargetID() {
		return targetID;
	}



	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}



	public boolean isSpotSt() {
		return spotSt;
	}



	public void setSpotSt(boolean spotSt) {
		this.spotSt = spotSt;
	}



	public boolean isTypeSt() {
		return typeSt;
	}



	public void setTypeSt(boolean typeSt) {
		this.typeSt = typeSt;
	}



	public boolean isdRatingSt() {
		return dRatingSt;
	}



	public void setdRatingSt(boolean dRatingSt) {
		this.dRatingSt = dRatingSt;
	}



	public boolean isAttackSt() {
		return attackSt;
	}



	public void setAttackSt(boolean attackSt) {
		this.attackSt = attackSt;
	}



	public boolean isSleazeSt() {
		return sleazeSt;
	}



	public void setSleazeSt(boolean sleazeSt) {
		this.sleazeSt = sleazeSt;
	}



	public boolean isdProcesSt() {
		return dProcesSt;
	}



	public void setdProcesSt(boolean dProcesSt) {
		this.dProcesSt = dProcesSt;
	}



	public boolean isFirewallSt() {
		return firewallSt;
	}



	public void setFirewallSt(boolean firewallSt) {
		this.firewallSt = firewallSt;
	}



	public boolean isData1St() {
		return data1St;
	}



	public void setData1St(boolean data1St) {
		this.data1St = data1St;
	}



	public boolean isData2St() {
		return data2St;
	}



	public void setData2St(boolean data2St) {
		this.data2St = data2St;
	}



	public boolean isData3St() {
		return data3St;
	}



	public void setData3St(boolean data3St) {
		this.data3St = data3St;
	}
	
	
	

}