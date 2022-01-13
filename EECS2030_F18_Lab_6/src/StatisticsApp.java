
/**
 * A weather statistics app calculates the 
 * minimum, maximum, and average temperature 
 * read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer.
	 * Update the current temperature and the 
	 * maximum, minimum, and average accordingly.
	 */
	double maxt = Double.NaN;
	double mint = Double.NaN;
	double ctemp = Double.NaN;
	double atemp;
	double numMeasurments = 0;
	double sumTemp;
	WeatherStation ws;
	
	public void update() {
		/* Your Task */
		if (ws != null) {
			if (Double.isNaN(ctemp)) {
				this.numMeasurments ++;
				this.ctemp = ws.getTemperature();
				this.maxt = this.ctemp;
				this.mint = this.ctemp;
				this.atemp = this.ctemp;
				this.sumTemp = this.ctemp;
			}else { 
				this.ctemp = ws.getTemperature();
				this.numMeasurments ++;
				this.sumTemp += this.ctemp;
				this.atemp = this.sumTemp / this.numMeasurments;
				if (this.ctemp > this.maxt) {
					this.maxt = this.ctemp;
					
				}else if (this.ctemp < this.mint) {
					this.mint = this.ctemp;
				
			}
			}
		}
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return this.ws;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */ 
		this.ws = ws;

	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		return this.mint;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		return this.maxt;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		return this.atemp;
	}
}

