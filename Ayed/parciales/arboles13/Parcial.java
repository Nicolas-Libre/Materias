package arboles13;
import arbolGeneral.GeneralTree;
public class Parcial {

	
	public Integer resolver (GeneralTree<Integer> ag) {
		if (!ag.isEmpty()) {
			PosYNeg ambasSumas = new PosYNeg();
			int sumaTotal = 0;
			sumaTotal = calcularSumas (ag, ambasSumas);
			if ((sumaTotal % 2) == 0) {
				return ambasSumas.getSumaPos();
			}
			else return ambasSumas.getSumaNeg();
		}
		else return 0;
		
	}
	
	
	private int calcularSumas (GeneralTree<Integer> ag, PosYNeg ambasSumas) {
		int sumaPos = ambasSumas.getSumaPos();
		int sumaNeg = ambasSumas.getSumaNeg();
		int sumaTotal=0;
		for (GeneralTree<Integer> hijo : ag.getChildren()) {
			sumaTotal += calcularSumas (hijo, ambasSumas);
		}
		sumaTotal += ag.getData();
		if (ag.getData() < 0) {
			ambasSumas.setSumaNeg(sumaNeg + ag.getData());
		}
		else ambasSumas.setSumaPos(sumaPos + ag.getData());
		
		return sumaTotal;
	}
}
