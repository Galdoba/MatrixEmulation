
public class Grid {
	private String gridName;
	private int gridRating;
	private int gridOverwatchScore;
	
	public static int currentOS;
	
	
			
		public Grid(String gridName, int gridRating, int gridOverwatchScore) {
		super();
		this.gridName = gridName;
		this.gridRating = gridRating;
		this.gridOverwatchScore = gridOverwatchScore;
	}



		public String getGridName() {
			return gridName;
		}



		public void setGridName(String gridName) {
			this.gridName = gridName;
		}



		public int getGridRating() {
			return gridRating;
		}



		public void setGridRating(int gridRating) {
			this.gridRating = gridRating;
		}



		public int getGridOverwatchScore() {
			return gridOverwatchScore;
		}



		public void setGridOverwatchScore(int gridOverwatchScore) {
			this.gridOverwatchScore = gridOverwatchScore;
		}

		
		

}