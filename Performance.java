package tss;

/**
 * Template for tss.Performance. You must implement the constructor and methods
 * shown. You may add fields, constructors, and methods, but do not change
 * the signatures of those provided.
 */
public class Performance {
	/**
	 * Set fields for variables I need to use
	 */
	private Artist _artist;
	private String _startTime;
	private int _duration;
	private Time time;



	public Performance(Artist artist, String startTime, int duration) {
		System.out.println("@Performance object created with artist " + artist + " at " + startTime + " with duration " + duration);
		_artist = artist;
		_startTime = startTime;
		_duration = duration;
		//Time time = new Time (artist, startTime, duration);
		time = new Time(artist, startTime, duration);
	

	}



	/**
	 * Return the artist for this performance.
	 * @return The {@link Artist} for this performance.
	 */

	public Artist getArtist() {
		return _artist;
	}
	/**
	 * Return the duration for this performance.
	 * @return The {@link durationh} for this performance.
	 */

	public int getDuration(){
		return _duration;
	}
	/**
	 * Return the starttime for this performance.
	 * @return The {@link starttime} for this performance.
	 */
	public String getstartTime(){
		return _startTime;
	}
	


	//I suggest that you convert your strings startTime and endTime to Date objects, and use date1.compareTo(date2), which returns 1 if date2 occurs after, -1 if before, 0 same time. So you would have something like that:

	/**
	 * Determine whether this performance overlaps with the performance provided.
	 * Performance A overlaps with performance B if A's start time is before B's, but it
	 * finishes after B starts, or vice versa.
	 * @param existingPerformance The {@link Performance} to compare against.
	 * @return true if the two performances overlap otherwise false.
	 */
	public boolean overlaps(Performance existingPerformance) {
		return time.determinetime(existingPerformance);

	}
	
	/**
	 * Determine whether this performance will end after mid night
	 */
	public boolean overnight() {
		return time.getendTime();
	}



	@Override
	public String toString() {
		return (_startTime + " (" + _duration + "): " + _artist);
	}
}
