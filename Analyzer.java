/*
* Analyzer
* @Version 0.1
* @p.karnaukhov
*/

import java.util.ArrayList;

public class Analyzer {

	public ArrayList<Cluster> clusters = new ArrayList<Cluster>();

	public String searchClusters(int[] data) {	

	String result = new String("No clusters found.");	
		if (data == null) {
			return result; //break;
		} else if(data.length == 1) {
			return new String("No enough data."); //break;		
		}
		
		int low = 0;
		int high = data.length - 1;
		int minimum = data[high] - data[low];
		int clusterstart = 0;
		int clusterend = 0;
		
			//find a pair with minimum value between them	
			for(int i = 0; i < high; i++) {				
				if (minimum > (data[i+1] - data[i]) ) {
					minimum = (data[i+1] - data[i]);
					clusterstart = i;
					clusterend = i + 1;										
				}			
			}

			//find other members of the cluster if they exist
			if(clusterstart != clusterend) {
			
				while (clusterstart > 0) {
					int temp = data[clusterstart] - data[clusterstart - 1];
						if (temp < minimum*2) {
							clusterstart = clusterstart - 1;
						} else { 
							break;
						}
				}
				 
				while (clusterend < high) {
					int temp = data[clusterend + 1] - data[clusterend];
						if (temp < minimum*2) {
							clusterend = clusterend + 1;
						} else { 
							break;
						}
				}
				
				// the cluster is ready
				clusters.add(new Cluster(minimum, data[clusterstart], data[clusterend]));							
				System.out.print("* ");
				
				//find another cluster - recursion
				if (clusterstart > 0) {
					int size = clusterstart; 
					int[] left = new int[size];
					java.lang.System.arraycopy(data, 0, left, 0, size);
					result = searchClusters(left); 					
				}			
				if (clusterend < high) {
					int size = high - clusterend;				
					int[] right = new int[size];			 		
					java.lang.System.arraycopy(data, clusterend + 1, right, 0, size);
					result = searchClusters(right);
				}					
				result = new String(clusters.size() + " cluster/s was found.");			
			}		
	return result; 
	}	
}

