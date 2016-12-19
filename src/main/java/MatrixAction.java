import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextField;

public class MatrixAction extends MatrixEmulation {
	static boolean attSide;
	boolean defSide;
	static List <String> targetList = new ArrayList<String>();
	static String targetIcon;
	static int attackerHuman = 0;
	static int attMod = 0;
	static int defMod = 0;
	private static int nethits;
	//private static int damage;
	private static String matrixActionName = null;
	static String command = null;
	static String comm0 = null;
	static String comm1 = null;
	static String comm2 = null;
	private static String [] mtrxActML = {"Data Spike", "Hold", "Brute Force", "Brute Force2", "Brute Force3", "Matrix Perceiption", "Matrix Search"};
	private static String [] attmtrxAct = {"Data Spike", "Brute Force", "Brute Force2", "Brute Force3"};
	private static String [] slzmtrxAct = {};
	private static String [] dPmtrxAct = {"Matrix Perceiption", "Matrix Search"};
	private static String [] frwmtrxAct = {};
	//public static List <Marks> markList = new ArrayList<Marks>(); dfghоаывп
	//markList.add(mARK);
	
	
	
	
	
	//static ArrayList <Icon> targetList = new ArrayList<Icon>();
	
	public static void action () {
		//формируем Список марок
		//Marks.initiateMARKs();
		
		seekTargets ();
		iconAttack.setInitiative(iconAttack.getInitiative() - 10);
		//switch (attackerHuman) {
			if (targetList.size() > 0) {
				//preapareTest();//(iconAttack, iconDefence);	
				choosetarget (targetList);
				//targetList.clear();
				chooseaction ();
				preapareTest();//(iconAttack, iconDefence);
				targetList.clear();
				
				getModificators();
				executetest();
				applyEffect(); //(iconAttack, iconDefence, nethits, matrixActionName);
				renewDefIcon();
				renewAttIcon();
				iconDefence = iconNull;
				destroyIcon();
			}
		}			
		
	private static void getModificators() {
		attMod = 0;
		if (matrixActionName.equals("Brute Force2")) {
			attMod = attMod -4;
		}
		if (matrixActionName.equals("Brute Force3")) {
			attMod = attMod -10;
		}
		
	}
	
	
	
	private static void preapareTest() {
		switch (attackerHuman) {
		case 0: 
			for (int i = 0; i < iconList.size(); i++) { 
				if (iconList.get(i).getName() == comm2) {
					iconDefence = iconList.get(i);
				}
			}
			comm0 = iconAttack.getName();
			comm1 = matrixActionName;
			if (comm0.equals("Patrol IC")) {
				matrixActionName = "Matrix Perceiption";
				comm1 = matrixActionName;
			}
			command = comm0 + ">" + comm1 + ">" + comm2;
			System.out.println("Програмная сборка команды:");
			System.out.println(command);
			//Frame.addLog("Action:" + command);
			break;
		case 1:
			//String userIn = " ";
			//command = Frame.userInput();
			System.out.println(Frame.userInput());
			System.out.println(command);
			Scanner cons = new Scanner(System.in);
			//command = Frame.getInputConsole().getText();
			boolean act = false;
			boolean subj = false;
			while (act == false || subj == false) {
				System.out.print("Action:" + "Persona0>");
				//Frame.userInput();
				command = Frame.userInput();
				//command = cons.nextLine(); //String[] ss=s.split("/");
				String[] s = command.split(">");
				comm0 = "Persona0>";
				comm1 = s[0];
				comm2 = s[1];
				for (int index=0; index < targetList.size(); index++) {
					if (targetList.get(index).equals(comm2)) {
						for (int i = 0; i < iconList.size(); i++) {
							if (iconList.get(i).getName().equals(comm2)) {
								iconDefence = iconList.get(i);
								subj = true;
								
							}
						}
					}
				}
				if (Arrays.asList(mtrxActML).contains(comm1)) {
					matrixActionName = comm1;
					if (Marks.checkMarks(matrixActionName) == true) {
						attackerHuman = 0;
						System.out.println("Action Correct");
						act = true;
					}
					//
					
					
					//attackerHuman = 0;
					//System.out.println("Action Correct");
					//act = true;
				} else {
					System.out.println("WARNING!! Command is impossible to resolve. PLEASE CHECK SPELLING...");
				}
				System.out.println("----------------------------------------------------------------------");
				Frame.clearInput();
			}
		}
	}
		
	

	private static void renewDefIcon() {
		for (int i = 0; i < iconList.size(); i++) {
			if (iconDefence.getName() == iconList.get(i).getName()) {
				int index=iconList.indexOf(iconList.get(i));
				   iconList.set( index, iconDefence );
			}
		}
		
	}

	private static void renewAttIcon() {
		for (int i = 0; i < iconList.size(); i++) {
			if (iconAttack.getName() == iconList.get(i).getName()) {
				int index=iconList.indexOf(iconList.get(i));
				   iconList.set( index, iconAttack );
			}
		}
	}
		
	

	private static void applyEffect() {
		switch (matrixActionName) { //происходит если тест успешен.
        case "Data Spike":  dataSpike();
        if (nethits > 0 && Host.yellowAlert == false) {
        	Host.yellowAlert = true;
        	System.out.println("YELLOW ALERT!!!");
        }
        int OScore = Dice.hit2;
        break;
        case "Brute Force":  bruteForce();
        System.out.println("Using Brute Force Action...");
        break;
        case "Brute Force2":  bruteForce2();
        System.out.println("Using Brute Force Action...");
        break;
        case "Brute Force3":  bruteForce3();
        System.out.println("Using Brute Force Action...");
        break;
        case "Hold":		hold();
        break;
        case "Matrix Perceiption":  matrixPerceiption ();
        if (iconAttack.getName().equals("Patrol IC") && Host.redAlert == false && nethits > 0) {
        	Host.redAlert = true;
        	System.out.println("RED ALERT!!!");
        }
        break;
		}
		
		
		
	}

	


	private static int executetest() {
		if (iconAttack.getName().equals("Patrol IC") && Host.patrolScanCounter > 1 && Host.yellowAlert == false && Host.redAlert == false) {
			targetIcon = "-1";
			System.out.println("patrolScanCounter = " + Host.patrolScanCounter);
			//Host.patrolScanCounter = Host.patrolScanCounter -1;
			
		}
		
		switch (targetIcon) {
		case "-1": matrixActionName="Hold";
				return 0;
		default:
		int dicePool1 = iconAttack.getDeviceRating() * 2 + attMod; ///Через Switch строить дайспул 1
		if (dicePool1 < 0) {
			dicePool1 = 0;
		}
		int dicePool2 = iconDefence.getDeviceRating() + iconDefence.getFirewall() + defMod; //Через Switch строить дайспул 2
		int limit = 0; //нужен механизм выбора лимита от типа действия
		for (int i = 0; i < attmtrxAct.length; i++) {
			if (matrixActionName.equals(attmtrxAct[i])) {
				limit = iconAttack.getAttack();
				
			}
		}
		for (int i = 0; i < dPmtrxAct.length; i++) {
			if (matrixActionName.equals(dPmtrxAct[i])) {
				limit = iconAttack.getDataProcessing();
				
			}
		}
		
		
		System.out.println("Executing Test:  (" + dicePool1 + "[" + limit + "] vs " + dicePool2 + ")");
		nethits = Dice.oppTest(dicePool1, dicePool2, limit, true, true, true);
		int OScore = Dice.hit2; 
		attMod = 0;
		defMod = 0;
		return nethits;
		}
	}

	private static String choosetarget(List<String> targetList) {
		if (targetList.size() > 0) {
			int index = new Random().nextInt(targetList.size());
			targetIcon = targetList.get(index);
			//targetList.clear();
			for (int i = 0; i < iconList.size(); i++) { //в этом цикле мы берем иниативу из списка всех икон и сравниваем с order[0], если совпадает то эта наша атакующая икона.
				if (iconList.get(i).getName() == targetIcon) {
					comm2 = iconList.get(i).getName();
					iconDefence = iconList.get(i);
				}
			}
			return targetIcon;
		}
		return "-1";
	}

	private static List <String> seekTargets() {//ВЫБИРАЕМ ИКОНЫ КОТОРЫЕ МОГУТ ОКАЗАТЬСЯ НАШИМИ ВРАГАМИ
		targetList.clear();
		attSide = iconAttack.getPlayer();
		if (attSide == true) {//ЕСЛИ attSide = ИСТИНА, ТО ОТПРАВЛЯЕМ НА СКАНЕР, ПОСЛЕ НЕГО СРАЗУ СОБИРАЕМ И ДЕЛАЕМ ТЕСТ.
			attackerHuman = 1;
			System.out.println("attackerHuman = " + 1);
		}
		for (int i = 0; i < iconList.size(); i++) {
			if ((iconList.get(i).getPlayer() != attSide) && (iconList.get(i).getMcm()>0)) {
				System.out.println ("--Potential target:----" + iconList.get(i).getName());
				targetList.add(iconList.get(i).getName());
			}
		}
		return targetList;
	}

	public static String chooseaction() {
		//targetIcon = 1; //через много ифов написать методику выбора действий 
		//Brute Force - не задан для ИИ икон
		switch (targetIcon) {
        case "-1":  matrixActionName = "Hold";
            break;
        default: matrixActionName = "Data Spike";
        	break;
		}
		return matrixActionName;
	}
	
	
		
	
	
//-------------------MATRIX ACTIONS MECHANICS-----------------------
	
	private static void bruteForce() {
		System.out.println("nethits=" + nethits);
		if (nethits > 0) {
			int damageSoak = Dice.tresholdTest((iconDefence.getDeviceRating() + iconDefence.getFirewall()), 0, 999, true, true, false);
			System.out.println("DamageSoak= " + damageSoak);
			int damage = (nethits/2) - damageSoak;
			if (damage < 0) { 
				damage  = 0;
			}
			
			
			iconDefence.setMcm(iconDefence.getMcm() - damage); //наносим повреждения равные нетхитам/2
			System.out.println("наносим повреждения равные нетхитам/2:" + damage);
			
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1Mark();
			System.out.println("марoк стало:" + Marks.searchMarks());
			Frame.addLog("Action:" + comm0 + ">" + comm1 + ">" + comm2);
			Frame.addLog("...ok");
		}
		if (nethits < 1) { //происходит если нетхиты меньше нуля (защита получает марку на атаку и атака огребает урон)
			int damage = nethits;
			iconAttack.setMcm(iconAttack.getMcm() + damage); //наносим повреждения равные нетхитам
			System.out.println("наносим повреждения равные нетхитам:" + damage);
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1MarkR();
			System.out.println("марoк стало:" + Marks.searchMarks());
			Frame.addLog("Action:" + comm0 + ">" + comm1 + ">" + comm2);
			Frame.addLog("...rejected");
		}
		
	}
	
	private static void bruteForce2() {
		System.out.println("nethits=" + nethits);
		if (nethits > 0) {
			int damageSoak = Dice.tresholdTest((iconDefence.getDeviceRating() + iconDefence.getFirewall()), 0, 999, true, true, false);
			System.out.println("DamageSoak= " + damageSoak);
			int damage = (nethits/2) - damageSoak;
			if (damage < 0) { 
				damage  = 0;
			}
			iconDefence.setMcm(iconDefence.getMcm() - damage); //наносим повреждения равные нетхитам/2
			System.out.println("наносим повреждения равные нетхитам/2:" + damage);
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1Mark();
			Marks.place1Mark();
			//place1Mark();
			System.out.println("марoк стало:" + Marks.searchMarks());
		}
		if (nethits < 1) { //происходит если нетхиты меньше нуля (защита получает марку на атаку и атака огребает урон)
			int damage = nethits;
			iconAttack.setMcm(iconAttack.getMcm() + damage); //наносим повреждения равные нетхитам
			System.out.println("наносим повреждения равные нетхитам:" + damage);
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1MarkR();
			System.out.println("марoк стало:" + Marks.searchMarks());
		}
		
	}
	
	
	private static void bruteForce3() {
		System.out.println("nethits=" + nethits);
		if (nethits > 0) {
			int damageSoak = Dice.tresholdTest((iconDefence.getDeviceRating() + iconDefence.getFirewall()), 0, 999, true, true, false);
			System.out.println("DamageSoak= " + damageSoak);
			int damage = (nethits/2) - damageSoak;
			if (damage < 0) { 
				damage  = 0;
			}
			iconDefence.setMcm(iconDefence.getMcm() - damage); //наносим повреждения равные нетхитам/2
			System.out.println("наносим повреждения равные нетхитам/2:" + damage);
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1Mark();
			Marks.place1Mark();
			Marks.place1Mark();
			System.out.println("марoк стало:" + Marks.searchMarks());
		}
		if (nethits < 1) { //происходит если нетхиты меньше нуля (защита получает марку на атаку и атака огребает урон)
			int damage = nethits;
			iconAttack.setMcm(iconAttack.getMcm() + damage); //наносим повреждения равные нетхитам
			System.out.println("наносим повреждения равные нетхитам:" + damage);
			System.out.println("Ставим марку");
			Marks.searchMarks();
			System.out.println("марoк было:" + Marks.searchMarks());
			Marks.place1MarkR();
			System.out.println("марoк стало:" + Marks.searchMarks());
		}
		
	}
	
	private static void dataSpike() {
		System.out.println("Data Spike NetHits=" + nethits);
		if (nethits < 1) {
			System.out.println("MCM атакующей иконы иконы ДО: " + iconAttack.getMcm());
			iconAttack.setMcm(iconAttack.getMcm() + nethits); //(в случае неудачи атакующая икона получает повреждение равное нетхитам без резиста) "+" потому что нетхиты 0 или меньше
			System.out.println("MCM атакующей иконы иконы после: " + iconAttack.getMcm());
			Frame.addLog("Action:" + comm0 + ">" + comm1 + ">" + comm2);
			Frame.addLog("...rejected");
		} else {
			int damageSoak = Dice.tresholdTest((iconDefence.getDeviceRating() + iconDefence.getFirewall()), 0, 999, true, true, false);
			System.out.println("DamageSoak= " + damageSoak);
			System.out.println("Damage:ATTDR=" + iconAttack.getAttack() + " NetHits=" + nethits + " Marks=" + Marks.searchMarks() + " dSoak=" + damageSoak);
			int damage = iconAttack.getAttack() + nethits + (Marks.searchMarks()*2) - damageSoak;
				if (damage < 0) {
					damage = 0; 
				}
				System.out.println("Damage= " + damage);
				System.out.println("MCM защищающейся иконы ДО: " + iconDefence.getMcm());	
			iconDefence.setMcm(iconDefence.getMcm() - damage);
			System.out.println("MCM защищающейся иконы ПОСЛЕ: " + iconDefence.getMcm());
			Frame.addLog("Action:" + comm0 + ">" + comm1 + ">" + comm2);
			Frame.addLog("...ok");
		}
		//info=info + iconAttack.getName() + ">" + matrixActionName + ">" + iconDefence.getName();
		
	}
	
	private static void matrixPerceiption() {
		// TODO Auto-generated method stub
		System.out.println("Do MPerceipt");
		System.out.println("MPerceipt NetHits=" + nethits);
		if (nethits > 0) {
			System.out.println("Reveal " + nethits + " bytes if information about " + iconDefence.getName());
		}
		
		
	}
	
	private static void hold() {
		System.out.println(iconAttack.getName() + " holding......");
		
	}
	
	public static String getCommand() {
		return command;
	}
	
//-------------------MARK MANIPULATION MECHANICS-----------------------	
	
/*	private static int searchMarks () {
		int x = 0;
		int mS = iconAttack.getIconID();
		int mT = iconDefence.getIconID ();
		for (int i = 0; i < markList.size(); i++) {
			if ((markList.get(i).getSourceID() == mS) && (markList.get(i).getTargetID() == mT)) {
				x = markList.get(i).getMarkqty();
			}
		}
		return x;
	}*/
	
/*	private static boolean checkMarks (String matrixActionName) { //Имеем название действия = необходимый минимум марок.
		boolean validity = false;
		int validMarks = 0;
		switch (matrixActionName) {
		case "Data Spike" : validMarks = 0; //для примера
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
	}*/
	
	
	
	
	
	
	
	
	
	
/*	private static void place1Mark () {
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
	
	private static void place1MarkR () {
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
	
	*/
	
	
}	
	
	
