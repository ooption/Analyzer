public class TestAnalyzer {

	public static int[] arr = {0,3,7,8,9,15,17,20,22,55,56,78,99,102,108};

	public static void main(String[] args) {				
		Analyzer test = new Analyzer();
		System.out.println(test.searchClusters(arr));
		
		for(Cluster aa : test.clusters) {	
			System.out.println("Cluster " + aa.clusterstart + "-" + aa.clusterend 
							+ ", fuzziness: " + aa.minimum + ".");
		}
	}
}
