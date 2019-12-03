import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Operations {

	PQueue jobQueue = new PQueue();
	PQueueMainMemory ramQueue = new PQueueMainMemory();
	
	
	public PQueue JobSchedular(String fileName) throws IOException, ClassNotFoundException {
		File nf  = new File(fileName);
		Scanner read = new Scanner(nf);
		int i;
		while(read.hasNextLine()) {
			String line=read.nextLine();
			
			String[] lines=line.split(" ");
		int id =	Integer.parseInt(lines[0]);
		int size = Integer.parseInt(lines[1]);
		double eet = Double.parseDouble(lines[2]);
		double eet1 = Double.parseDouble(lines[3]);
		String state = lines[4];
		jobQueue.enqueue(new Process(id, size, eet, eet1, state), size);
			
		}
		return jobQueue;
}
	public PQueueMainMemory CPUSchedular() throws ClassNotFoundException, IOException {
		PQueueNode tmp;
		int allSize = 0;
		jobQueue = JobSchedular("yazeed");
		while(allSize <= 163840 && jobQueue.length() != 0) {
			tmp = jobQueue.serve();
			tmp.data.setState("Ready");
			allSize += tmp.data.getProgramSize();
			if(allSize <= 163840)
			ramQueue.enqueue(tmp.data, tmp.data.getExpectedExecutionTime());
			
		}
		
			return ramQueue;
		
	}
		

}
