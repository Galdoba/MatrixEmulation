public class StatusArray {
	
	
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
	
	
	
	public StatusArray(boolean spotSt, boolean typeSt, boolean dRatingSt, boolean attackSt, boolean sleazeSt, boolean dProcesSt,
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
	}

	public StatusArray newStatus = new StatusArray (false, false, false, false, false, false, false, false, false, false);
	
	//private void createStatusArray() {
		
		
		
	



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