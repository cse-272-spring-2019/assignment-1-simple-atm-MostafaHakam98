public class history {
	
	private String previous[] = new String[5];
	private String next[] = new String[5];
	//History saved as strings in form of arrays (queues)
	
	private int pTop = 0, nTop = 0;
	//Iterators of previous and next arrays
	
	public void add(String s) {
		while(nTop > 0) {
			redo();
		} //To make sure all data are stored in one array
		if(pTop == 5) {
			int i;
			for(i=0 ; i<4 ; i++) {
				previous[i]=previous[i+1];
			} //To make a limit of only 5 strings stored
		}
		previous[pTop++] = s;
	} //To store a new transaction in history
	
	
	public void undo() {
		next[nTop++] = previous[--pTop];
		previous[pTop] = null;
	} //Transfer the top of Previous to the top of Next
	
	public void redo() {
		previous[pTop++] = next[--nTop];
		next[nTop] = null;
	} //Transfer the top of Next to the top of Previous

	public String getPrevious() {
		return previous[pTop-1];
	} //Return the top of Previous

	public String getNext() {
		return next[nTop-1];
	} //Return the top of Next

	public int getpTop() {
		return pTop;
	}

	public int getnTop() {
		return nTop;
	}
}