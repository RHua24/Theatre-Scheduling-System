package tss;


public class Time {
	/**
	 * Set field for each elements extracting from the input string. Divide the elements into two parts
	 * for each elements: starting and ending 
	 */
	private int _duration;
	private int _MinuteS;
	private int _HourS;
	private int _DayS;
	private int _MonthS;
	private int _YearS;
	private int _MinuteE;
	private int _HourE;

	public Time (Artist artist, String startTime, int duration) {
		
		/**
		 * Use substring to extract each elements of minutes, hours and days etc and convert them into 
		 * integer for comparison
		 */
		_duration = duration;
		_MinuteS = Integer.parseInt(startTime.substring(14,16));
		_HourS = Integer.parseInt(startTime.substring(11,13));
		_DayS = Integer.parseInt(startTime.substring(8,10));
		_MonthS = Integer.parseInt(startTime.substring(5,7));
		_YearS = Integer.parseInt(startTime.substring(0,4));

	}

	/**
	 * Calculate the ending time of the performance by adding the duration onto the start time in order to 
	 * determine whether it's going to overlap.
	 */
	public boolean getendTime() {
		_MinuteE = _MinuteS + _duration;
		_HourE = _HourS;
		while (_MinuteE >= 60) {
			_HourE = _HourS + 1;
			_MinuteE = _MinuteE - 60;	
		}
		/**
		 * If the hours is greater than 24 that means the performance will end after midnight
		 */
		if (_HourE >= 24){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *Determine whether the time is overlapped.
	 */
	public boolean determinetime (Performance existingPerformance) {
		/**
		 * Use substring to extract the elements out from the existing performance and convert into integer in
		 * order to compare.
		 */
		String existingtime = existingPerformance.getstartTime();
		int existingminute = Integer.parseInt(existingtime.substring(existingtime.length()-2));
		int existinghour = Integer.parseInt(existingtime.substring(12,13));
		int existingmonth = Integer.parseInt(existingtime.substring(5,7));
		int existingyear = Integer.parseInt(existingtime.substring(0,4));
		int existingdays = Integer.parseInt(existingtime.substring(8,10));
		int existingduration = existingPerformance.getDuration();
		
		
		/**
		 * Calculate the end time for existing performance.
		 */
		int existingminuteE = existingminute + existingduration;
		int existinghourE = existinghour;
		while (existingminuteE >= 60) {
			existinghourE = existinghour + 1;
			existingminuteE = existingminuteE - 60;			
		} 

		/**
		 * Set conditions to determine whether the performance is overlapped by firstly comparing year and month,
		 * if the day is the same them use hours of start time, minutes of ending time, hours of start time and 
		 * hours of ending time to check the possibility of not overlapping.
		 */
		if (_YearS > existingyear || _YearS < existingyear) {
			return false;			
		} else if
		(_MonthS > existingmonth || _YearS < existingmonth) {
			return false; //If the year or month is different then there cannot be overlapping

		}else if (_DayS > existingdays || _DayS < existingdays) {
			return false;			
		} else if
		(_HourE < existinghour && _HourS > existinghourE) {
			return false;
		} else if 
		(_HourE == existinghour && _MinuteE < existingminute) {
			return false;
		}else if
		(_HourS == existinghourE && _MinuteS > existingminuteE) {
			return false; 
		}

		//If none of the above situation suits then the performance is overlapped.
		return true;

	}
	}







