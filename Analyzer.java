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
	
		if(data == null) {
			return result; //break;
		}
		
		else if(data.length == 1) {
			return new String("No enough data."); //break;		
		}
		
		int low = 0;
		int high = data.length - 1;
		int minimum = high;
		int clusterstart = 0;
		int clusterend = 0;
		
			//find a pair with minimum value between them	
			for(int i = 0; i < high - 1; i++) {
				
				if(minimum > (data[i+1] - data[i]) ) {
					minimum = (data[i+1] - data[i]);
					clusterstart = i;
					clusterend = i + 1;										
				}			
			}

			//find other members of the cluster if they exist
			if(clusterstart != clusterend) {
			
				while(clusterstart > 0) {
					int temp = data[clusterstart] - data[clusterstart - 1];
						if( temp < minimum*2) {
							clusterstart = clusterstart - 1;
						}
						else { break;}
				}
				 
				while(clusterend < high) {
					int temp = data[clusterend + 1] - data[clusterend];
						if( temp < minimum*2) {
							clusterend = clusterend + 1;
						}
						else { break;}
				}
						
				// a cluster is ready
				clusters.add(new Cluster(minimum, data[clusterstart], data[clusterend]));							
				
				//find another clusters
				if(clusterstart > 0) {
					int[] left = new int[clusterstart - 1];
					java.lang.System.arraycopy(data, 0, left, 0, clusterstart - 1);
					result = "After left side search: " + searchClusters(left); 
					System.out.println(result);
					}			
				if(clusterend < high) {
					int[] right = new int[high - clusterend];					
					java.lang.System.arraycopy(data, clusterend + 1 , right, 0, high - clusterend);
					result = "After right side search: " + searchClusters(right);
					System.out.println(result);
					}
					
				result = new String(clusters.size() + " cluster/s was found.");			
			}	
	return result; 
	}
}

