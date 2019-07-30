package tss;

public class Theatre {
	/**
	 * How many performances are scheduled.
	 */
	private int _numPerformance;
	/**
	 * Array that contains Performance type of performance.
	 */
	private Performance[] _performance;
	/**
	 * Array that contains Artist type of artist.
	 */
	private Artist[] _artists;
	/**
	 * How many artists are registered.
	 */
	private int _numArtist;


	public Theatre(){
		_numPerformance = 0;
		_numArtist = 0;
		_performance = new Performance [1000];
		_artists = new Artist [1000];

	}


	public void addArtist (Artist artist) {
		/**
		 * Firstly check whether the artist have already registered, cannot register the same artist for twice. 
		 */
		for (int i=0; i<_numArtist; i++){
			if (_artists[i].equals(artist.toString())) {
				return;
			}
		}
		/**
		 * If the artist haven't been registered, register as a new artist and add to array.
		 */
		_artists[_numArtist]=artist;
		_numArtist++;

	}


	public void addPerformance(Performance performance, Artist artist) {
		boolean registed = false;
		boolean overlaps = false;
		boolean overnight = false;
		
		/**
		 * Firstly check whether the artist have been registered, if not then print out warning message
		 */
		for (int i=0; i<_numArtist; i++){
			if (_artists[i].equals(artist.toString())) {	
				registed=true;
			}
		}
		if (registed== false) {	
			System.out.println("%%ERROR%%: Artist " + artist + " not registered");
			return;
		}
		
		/**
		 * Secondly check whether the new added performance have overlaopped with existing performance, if does print warning message
		 */
		for (int i=0; i<_numPerformance; i++) {
			if (_performance[i].overlaps(performance)) {
				overlaps=true;				
				System.out.println("%%ERROR%%: Performance " + _performance[i] + " overlaps with existing performance " +  performance);
				return;

			}
		}
		/**
		 * Lastly check whether the performance schedule time is going to end after the midnight. if does print warning message.
		 */
		if (performance.overnight() == true) {
			System.out.println("%ERROR%%: Performance ends after midnight");
			return;
		}
		/**
		 * If all conditions are suit then add the performance into the array.
		 */
		if (overlaps == false && overnight == false) {
			_performance[_numPerformance] = performance;	
			_numPerformance++;
		}
	}



	/**
	 * Display all the message required.
	 */
	public void display() {
		System.out.println("THEATRE: The Powerstation");
		System.out.println("REGISTERED ARTISTS");
		if(_numArtist == 0) {
			System.out.println("No artists registered");
		}
		for(int i=0; i< _numArtist; i++){
			System.out.println((i+1) + ". " +_artists[i]);
		}

		System.out.println("SCHEDULED PERFORMANCES");
		if (_numPerformance == 0) {
			System.out.println("No performances scheduled");
			return;
		}
		for(int i=0; i<_numPerformance; i++) {
			System.out.println(_performance[i]);
		}
	}









}



