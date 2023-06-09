import java.util.ArrayList;
import java.util.PriorityQueue;

public class OxfordPathFinding {
	public static ArrayList<Locations> networkDelayTime(int start, int end, int time, boolean[] weather) { 
		double[][] map = {{0, 1, 0.34}, {1, 0, 0.34}, {0, 8, 0.19}, {8, 0, 0.19}, {1, 2, 0.3}, {2, 1, 0.3}, {8, 1, 0.12}, {1, 8, 0.12}, 
				{2, 3, 0.11}, {3, 2, 0.11}, {5, 3, 0.06}, {3, 5, 0.06}, {3, 4, 0.01}, {4, 3, 0.01}, {3, 6, 0.07}, {6, 3, 0.07}, {3, 9, 0.01}, {9, 3, 0.01}, 
				{4, 2, 0.13}, {2, 4, 0.13}, {5, 6, 0.06}, {6, 5, 0.06}, {5, 7, 0.06}, {7, 5, 0.06}, {6, 7, 0.06}, {7, 6, 0.06}, {6, 9, 0.06}, {9, 6, 0.06}, 
				{6, 16, 0.08}, {16, 6, 0.08}, {7, 10, 0.09}, {10, 7, 0.09}, {7, 14, 0.1}, {14, 7, 0.1}, {9, 12, 0.25}, {12, 9, 0.25}, {10, 11, 0.06}, {10, 13, 0.1}, 
				{10, 14, 0.12}, {11, 13, 0.06}, {13, 11, 0.06}, {11, 14, 0.13}, {14, 11, 0.13}, {11, 22, 0.18}, {22, 11, 0.18}, {12, 13, 0.2}, {13, 12, 0.2}, {12, 15, 0.16}, 
				{15, 12, 0.16}, {12, 16, 0.14}, {16, 12, 0.14}, {12, 17, 0.17}, {17, 12, 0.17}, {13, 16, 0.06}, {13, 17, 0.14}, {15, 16, 0.09}, {16, 15, 0.09}, 
				{15, 18, 0.21}, {18, 15, 0.21}, {15, 19, 0.09}, {19, 15, 0.09}, {16, 17, 0.05}, {17, 16, 0.05}, {16, 18, 0.06}, {18, 16, 0.06}, {17, 18, 0.08}, 
				{18, 17, 0.08}, {17, 23, 0.17}, {23, 17, 0.17}, {18, 19, 0.14}, {19, 18, 0.14}, {18, 23, 0.16}, {23, 18, 0.16}, {18, 26, 0.13}, {26, 18, 0.13}, 
				{18, 36, 0.24}, {36, 18, 0.24}, {19, 20, 0.07}, {20, 19, 0.07}, {20, 21, 0.03}, {21, 20, 0.03}, {20, 34, 0.15}, {34, 20, 0.15}, {21, 22, 0.05}, 
				{22, 21, 0.05}, {21, 33, 0.06}, {33, 21, 0.06}, {22, 27, 0.12}, {27, 22, 0.12}, {22, 28, 0.17}, {28, 22, 0.17}, {22, 31, 0.15}, {31, 22, 0.15}, 
				{22, 32, 0.12}, {32, 22, 0.12}, {22, 33, 0.1}, {33, 22, 0.1}, {23, 24, 0.07}, {24, 23, 0.07}, {23, 25, 0.1}, {25, 23, 0.1}, {23, 26, 0.14}, {26, 23, 0.14}, 
				{24, 25, 0.07}, {25, 24, 0.07}, {25, 26, 0.1}, {26, 25, 0.1}, {25, 37, 0.15}, {37, 25, 0.15}, {26, 36, 0.26}, {36, 26, 0.26}, {27, 28, 0.9}, 
				{28, 27, 0.9}, {27, 29, 0.1}, {29, 27, 0.1}, {27, 31, 0.11}, {31, 27, 0.11}, {28, 29, 0.14}, {29, 28, 0.14}, {29, 30, 0.07}, {30, 29, 0.07}, {30, 31, 0.16}, 
				{31, 30, 0.16}, {30, 47, 0.18}, {47, 30, 0.18}, {31, 32, 0.09}, {32, 31, 0.09}, {31, 41, 0.08}, {41, 31, 0.08}, {31, 45, 0.07}, {45, 31, 0.07}, 
				{32, 33, 0.08}, {33, 32, 0.08}, {32, 35, 0.08}, {35, 32, 0.08}, {32, 41, 0.06}, {32, 41, 0.06}, {33, 34, 0.04}, {34, 33, 0.04}, {33, 35, 0.08}, {35, 33, 0.08}, 
				{34, 36, 0.16}, {36, 34, 0.16}, {34, 38, 0.2}, {38, 34, 0.2}, {35, 39, 0.12}, {39, 35, 0.12}, {35, 40, 0.09}, {40, 35, 0.09}, {35, 41, 0.09}, {41, 35, 0.09}, 
				{35, 42, 0.09}, {42, 35, 0.09}, {36, 37, 0.26}, {37, 36, 0.26}, {36, 38, 0.22}, {38, 36, 0.22}, {36, 61, 0.26}, {61, 36, 0.26}, {38, 39, 0.12}, {39, 38, 0.12}, 
				{38, 60, 0.13}, {60, 38, 0.13}, {38, 61, 0.13}, {61, 38, 0.13}, {39, 40, 0.09}, {40, 39, 0.09}, {39, 42, 0.13}, {42, 39, 0.13}, {39, 58, 0.08}, {58, 39, 0.08}, 
				{39, 59, 0.05}, {59, 39, 0.05}, {39, 60, 0.1}, {60, 39, 0.1}, {40, 43, 0.09}, {43, 40, 0.09}, {40, 44, 0.07}, {44, 40, 0.07},    {40, 43, 0.08}, {43, 40, 0.08},
				{40, 59, 0.08}, {59, 40, 0.08}, {40, 60, 0.08}, {60, 40, 0.08}, {40, 61, 0.16}, {61, 40, 0.16}, {41, 42, 0.04}, {42, 41, 0.02}, {41, 43, 0.06}, {43, 41, 0.06}, 
				{41, 45, 0.06}, {45, 41, 0.06}, {42, 43, 0.03}, {43, 42, 0.03}, {42, 44, 0.07}, {44, 42, 0.07}, {42, 45, 0.07}, {45, 42, 0.07}, {43, 44, 0.05}, {44, 43, 0.05}, 
				{43, 45, 0.08}, {45, 43, 0.08}, {43, 56, 0.1}, {56, 43, 0.1}, {43, 57, 0.13}, {57, 43, 0.13}, {44, 45, 0.13}, {45, 44, 0.13}, {44, 48, 0.04}, {48, 44, 0.04}, 
				{44, 54, 0.1}, {54, 44, 0.1}, {45, 47, 0.09}, {47, 45, 0.09}, {46, 47, 0.12}, {47, 46, 0.12}, {47, 50, 0.08}, {50, 47, 0.08}, {47, 51, 0.11}, {51, 47, 0.11}, 
				{48, 49, 0.1}, {49, 48, 0.1}, {48, 52, 0.11}, {52, 48, 0.11}, {48, 53, 0.11}, {53, 48, 0.11}, {49, 50, 0.09}, {50, 49, 0.09}, {49, 57, 0.08}, {57, 49, 0.08}, 
				{50, 51, 0.09}, {51, 50, 0.09}, {50, 52, 0.07}, {52, 50, 0.07}, {51, 82, 0.2}, {82, 51, 0.2}, {52, 53, 0.04}, {53, 52, 0.04}, {52, 55, 0.06}, {55, 52, 0.06}, 
				{52, 82, 0.09}, {82, 52, 0.09}, {53, 54, 0.11}, {54, 53, 0.11}, {53, 55, 0.07}, {55, 53, 0.07}, {54, 49, 0.07}, {49, 54, 0.07}, {54, 55, 0.07}, {55, 54, 0.07}, 
				{55, 82, 0.09}, {82, 55, 0.09}, {55, 83, 0.15}, {83, 55, 0.15}, {56, 57, 0.08}, {57, 56, 0.08}, {56, 83, 0.19}, {83, 56, 0.19}, {57, 58, 0.1}, {58, 57, 0.1}, 
				{57, 83, 0.1}, {83, 57, 0.1}, {57, 84, 0.15}, {84, 57, 0.15}, {58, 61, 0.06}, {61, 58, 0.06}, {58, 86, 0.12}, {86, 58, 0.12}, {59, 60, 0.11}, {60, 59, 0.11}, 
				{59, 84, 0.11}, {84, 59, 0.11}, {59, 88, 0.13}, {88, 59, 0.13}, {60, 63, 0.14}, {63, 60, 0.14}, {60, 64, 0.14}, {64, 60, 0.14},   {60, 90, 0.1}, {90, 60, 0.1}, 
				{60, 93, 0.09}, {93, 60, 0.09}, {61, 62, 0.07}, {62, 61, 0.07}, {61, 63, 0.19}, {63, 61, 0.19}, {62, 65, 0.15}, {65, 62, 0.15}, {62, 68, 0.15}, {68, 62, 0.15},
				{62, 93, 0.1}, {93, 62, 0.1}, {62, 94, 0.13}, {94, 62, 0.13}, {63, 64, 0.08}, {64, 63, 0.08}, {63, 66, 0.18}, {66, 63, 0.18}, {64, 65, 0.09}, {65, 64, 0.09}, 
				{64, 66, 0.25}, {66, 64, 0.25}, {65, 67, 0.12}, {67, 65, 0.12}, {65, 69, 0.15}, {69, 65, 0.15}, {66, 71, 0.08}, {71, 66, 0.08}, {66, 73, 0.08}, {73, 66, 0.08},
				{66, 94, 0.23}, {94, 66, 0.23}, {67, 70, 0.13}, {70, 67, 0.13}, {67, 71, 0.12}, {71, 67, 0.12}, {68, 72, 0.13}, {72, 68, 0.13}, {68, 74, 0.21}, {74, 68, 0.21},
				{69, 68, 0.24}, {68, 69, 0.24}, {69, 70, 0.12}, {70, 69, 0.12}, {69, 71, 0.07}, {71, 69, 0.07}, {70, 71, 0.13}, {71, 70, 0.13}, {70, 72, 0.09}, {72, 70, 0.09}, 
				{70, 74, 0.1}, {74, 70, 0.1}, {70, 75, 0.14}, {75, 70, 0.14}, {71, 75, 0.11}, {75, 71, 0.11}, {71, 92, 0.19}, {92, 71, 0.19}, {71, 93, 0.22}, {93, 71, 0.22}, 
				{72, 73, 0.11}, {73, 72, 0.11}, {72, 74, 0.07}, {74, 72, 0.07}, {73, 76, 0.11}, {76, 73, 0.11}, {73, 80, 0.16}, {80, 73, 0.16}, {73, 76, 0.13}, {76, 73, 0.13}, 
				{74, 75, 0.13}, {75, 74, 0.13}, {74, 76, 0.08}, {76, 74, 0.08}, {75, 94, 0.13}, {94, 75, 0.13}, {76, 77, 0.11}, {77, 76, 0.11}, {77, 78, 0.07}, {78, 77, 0.07}, 
				{77, 79, 0.13}, {79, 77, 0.13}, {77, 80, 0.1}, {80, 77, 0.1}, {77, 81, 0.09}, {81, 77, 0.09}, {78, 79, 0.05}, {79, 78, 0.05}, {78, 80, 0.08}, {80, 78, 0.08}, 
				{78, 81, 0.16}, {81, 78, 0.16}, {79, 80, 0.08}, {80, 79, 0.08}, {79, 81, 0.08}, {81, 79, 0.08}, {81, 116, 0.35}, {116, 81, 0.35}, {82, 83, 0.09}, {83, 82, 0.09}, 
				{82, 104, 0.13}, {104, 82, 0.13}, {83, 84, 0.11}, {84, 83, 0.11}, {83, 85, 0.04}, {85, 83, 0.04}, {84, 87, 0.09}, {87, 84, 0.09}, {84, 88, 0.13}, {88, 84, 0.13}, 
				{85, 86, 0.12}, {86, 85, 0.12}, {85, 103, 0.12}, {103, 85, 0.12}, {85, 104, 0.16}, {86, 87, 0.07}, {87, 86, 0.07}, {86, 99, 0.06}, {99, 86, 0.06}, {86, 103, 0.15}, 
				{103, 86, 0.15}, {87, 89, 0.13}, {89, 87, 0.13}, {87, 99, 0.12}, {99, 87, 0.12}, {88, 89, 0.11}, {89, 88, 0.11}, {88, 90, 0.07}, {88, 91, 0.09}, {91, 88, 0.09}, 
				{89, 90, 0.05}, {90, 89, 0.05}, {89, 95, 0.04}, {95, 89, 0.04}, {89, 99, 0.11}, {99, 89, 0.11}, {90, 91, 0.09}, {91, 90, 0.09}, {90, 93, 0.17}, {93, 90, 0.17}, 
				{91, 92, 0.16}, {92, 91, 0.16}, {92, 95, 0.13}, {95, 92, 0.13}, {93, 94, 0.07}, {94, 93, 0.07}, {94, 95, 0.13}, {95, 94, 0.13}, {94, 97, 0.16}, {97, 94, 0.16}, 
				{95, 96, 0.12}, {96, 95, 0.12}, {95, 97, 0.09}, {97, 95, 0.09}, {96, 97, 0.05}, {97, 96, 0.05}, {96, 98, 0.06}, {96, 99, 0.08}, {96, 100, 0.07}, {97, 98, 0.09}, 
				{98, 97, 0.09}, {98, 100, 0.12}, {100, 98, 0.12}, {98, 115, 0.25}, {115, 98, 0.25}, {99, 100, 0.02}, {100, 99, 0.02}, {99, 101, 0.08}, {101, 99, 0.08}, {99, 103, 0.16}, 
				{103, 99, 0.16}, {100, 101, 0.08}, {101, 100, 0.08}, {101, 102, 0.08}, {102, 101, 0.08}, {101, 103, 0.1}, {103, 101, 0.1}, {101, 114, 0.14}, {114, 101, 0.14}, 
				{102, 103, 0.08}, {103, 102, 0.08}, {102, 106, 0.14}, {106, 102, 0.14}, {102, 113, 0.13}, {113, 102, 0.13}, {103, 104, 0.06}, {104, 103, 0.06}, {103, 106, 0.13}, 
				{106, 103, 0.13}, {104, 105, 0.13}, {105, 104, 0.13}, {104, 106, 0.12}, {106, 104, 0.12}, {105, 106, 0.03}, {106, 105, 0.03}, {106, 107, 0.09}, {107, 106, 0.09}, 
				{106, 108, 0.1}, {108, 106, 0.1}, {107, 108, 0.03}, {108, 107, 0.03}, {107, 110, 0.06}, {110, 107, 0.06}, {107, 111, 0.06}, {111, 107, 0.06}, {107, 109, 0.07}, 
				{109, 107, 0.07}, {108, 111, 0.06}, {111, 108, 0.06}, {108, 112, 0.07}, {112, 108, 0.07}, {109, 110, 0.03}, {110, 109, 0.03}, {110, 111, 0.04}, {111, 110, 0.04}, 
				{111, 112, 0.09}, {112, 111, 0.09}, {112, 113, 0.05}, {113, 112, 0.05}, {113, 114, 0.16}, {114, 113, 0.16}, {114, 115, 0.43}, {115, 114, 0.43}, {115, 116, 0.25}, 
				{116, 115, 0.25}, {115, 117, 0.16}, {117, 115, 0.16}, {115, 118, 0.2}, {118, 115, 0.2}, {117, 118, 0.1}, {118, 117, 0.1}, {119, 117, 0.34}, {117, 119, 0.34}};
		int N = 120;
    	double[][] adjacencyMatrix = new double[N][N];
    	// Initialize the entire matrix of edges to a value of -1 to start, that way we dont have issues when edges have a weight of 0.
        for(int i = 0; i < adjacencyMatrix[0].length; i++) {
            for(int j = 0; j < adjacencyMatrix[1].length; j++) {
                adjacencyMatrix[i][j] = -1;
            }   
        }
        
    	for(double[] location : map) {
    		// Adds the necessary weight modifier based on congestion or weather
    		if(Locations.valueOf((int) location[0]).isTimeSensitive() && isCongestedTime(time)) {
    			location[2] += (location[2] * 0.20);
    		}
    		
    		if(weather[1] == true || weather[2] == true) {
    			location[2] += (location[2] * 0.20);
    		}
    		
			// Makes a matrix where the weight of each neighbor of x and y is defined
			adjacencyMatrix[(int) location[0]][(int) location[1]] = location[2];
		}
    	
    	// Define our distance and parent arrays
    	double[] dist = new double[N];
    	int[] parent = new int[N];
    	// Setup our distances with max value
    	for(int v = 0; v < N; v++) {
    		dist[v] = Integer.MAX_VALUE;
    	}
    	// Set starting node distance to 0
    	dist[start] = 0;
    	// Setup a priority queue weighted by the weight of the node
    	PriorityQueue<double[]> Q = new PriorityQueue<double[]>((vertex1,vertex2) -> (int) vertex1[1] - (int) vertex2[1]);
		// Add starting node to priority queue
    	Q.add(new double[] {start, 0});
    	// Go through each edge and see if theres a shorter path from the starting node.
    	while(!Q.isEmpty()) {
    		double[] nodeData = Q.poll();
    		double node = nodeData[0];
    		double distance = nodeData[1];
    		for(int v = 0; v < N; v++) {
    			if(adjacencyMatrix[(int) node][v] >= 0) {
    				if(dist[v] > distance + adjacencyMatrix[(int) node][v]) {
    					Q.add(new double[] {v, distance + adjacencyMatrix[(int) node][v]});
    					dist[v] = distance + adjacencyMatrix[(int)node][v];
    					parent[v] = (int) node;
    				}
    			}
    		}
    	}
    	
    	// Find the path that was taken from start to end nodes
    	if(dist[end] != -1) {
    		ArrayList<Integer> reversedPath = new ArrayList<Integer>();
    		int currentNode = end;
    		reversedPath.add(end);
    		while(currentNode != start) {
    			reversedPath.add(parent[currentNode]);
    			currentNode = parent[currentNode];
    		}
    		
    		ArrayList<Locations> path = new ArrayList<Locations>();

    		for(int i = reversedPath.size() - 1; i >= 0; i--) {
    			path.add(Locations.valueOf(reversedPath.get(i)));
    		}
    		
    		return path;
    	}
    	
    	return new ArrayList<Locations>();
    }
	
	public static boolean isCongestedTime(int time) {
		if(time > 745 && time < 815 || time > 815 && time < 845 || time > 955 && time < 1015 || time > 1125 && time < 1155 || time > 1300 && time < 1330 || time > 1435 && time < 1505) {
			return true;
		}
		
		return false;
	}
	
}
