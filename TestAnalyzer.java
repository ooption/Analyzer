public class TestAnalyzer {

	public static void main(String[] args) {
		
		int[] arr = {0, 1, 7, 8, 9, 15, 17, 20, 55, 56};
		
		
		Analyzer testA = new Analyzer();
		System.out.println(testA.searchClusters(arr));
		
		for(Cluster aa : testA.clusters) {	
			System.out.println("Minimum found " + aa.minimum + ", cluster from " + aa.clusterstart + " to " + aa.clusterend);
		}

	}
}