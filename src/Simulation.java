import java.io.IOException;

public class Simulation {
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Operations o = new Operations();
		
		PQueue pq = o.JobSchedular("yazeed");
		pq.print();
//		PQueueMainMemory pqm = o.CPUSchedular("yazeed");
//		pqm.print();
		
	}
}
