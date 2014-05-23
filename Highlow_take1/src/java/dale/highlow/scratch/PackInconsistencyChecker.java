package dale.highlow.scratch;

import dale.highlow.cards.DefaultPack;
import dale.highlow.cards.Pack;
import dale.highlow.cards.PlayingCard;

public class PackInconsistencyChecker {
	
	public static void main(String[] args) {
		PackInconsistencyChecker checker = new PackInconsistencyChecker();
		checker.test2();
	}
	
	private void test() {

		Pack pack = new DefaultPack();
		System.out.println(pack);
		///pack.shufflePack();
		System.out.println(pack);
		PlayingCard c1 = pack.cutPack();
		//try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		///pack.shufflePack();
		PlayingCard c2 = pack.cutPack();
		boolean equal = c1.getName().equals(c2.getName());
		System.out.println(equal + "  " + c1.getName() + " : " + c2.getName());
		//assertFalse(c1.equals(c2));
		//assertFalse(false);
	}
	
	public void test2() {
		int[] spread = new int[52];
		DefaultPack pack = new DefaultPack();
		
		System.out.println(pack);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 500000; i++) {
			PlayingCard pc = pack.cutPack();
			int j;
			for (j = 0; j < 52; j++) {
				if (pc.getName().equals(pack.cardNameArray[j])) break;
			}
			spread[j]++;
		}
		
		System.out.print("[ ");
//		for (int i : spread) {
//			System.out.print(i + ", ");
//		}
		
		for(int i = 0; i < 52; i++) System.out.print(spread[i] + ", ");
		
		System.out.print("} ");
		
		System.out.println("\n\nStd Deviation: " + (int)standardDeviation(spread));
	}
	
	public double standardDeviation(int [] values) {
		
		int mean = 0;
		for (int i : values) mean += i;
		mean /= values.length;
		
		double[] squares = new double[values.length];
		for (int i = 0; i < squares.length; i++) {
			squares[i] = Math.pow((values[i] - mean), 2);
		}
		
		double variance = 0.0;
		for (double d : squares) variance += d;
		variance /= squares.length;
		
		return Math.sqrt(variance);
	}

}
