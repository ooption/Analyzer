public class TestAnalyzer {

	public static int[] arr = {0, 1, 7, 8, 9, 15, 17, 20, 55, 56};

	public static void main(String[] args) {				
		Analyzer test = new Analyzer();
		System.out.println(test.searchClusters(arr));
		
		for(Cluster aa : test.clusters) {	
			System.out.println("Minimum found " + aa.minimum + ", cluster from " 
								+ aa.clusterstart + " to " + aa.clusterend);
		}
	}
}