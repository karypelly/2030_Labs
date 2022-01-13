
/**
 * A weather forecast app determines if the pressure readings from 
 * its subscribed weather station, if any, indicate it is likely to rain
 * due to a reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {
	
	
	double cpres = Double.NaN;
	double lpres = Double.NaN;
	WeatherStation ws;
	/**
	 * Update the reading of this weather observer.
	 * Update the current and last readings of pressure.
	 */
	
	public void update() {
		/* Your Task */
		if (ws != null) {
			if (Double.isNaN(this.cpres)) {
				this.cpres = ws.getPressure();
				this.lpres = this.cpres;
			}else {
				this.lpres = this.cpres;
				this.cpres = ws.getPressure();
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
	 * Get the pressure level read from the last update.
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		/* Your Task */
		return this.cpres;
	}
	
	/**
	 * Get the pressure level read from the second last update.
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		return this.lpres;
	}
	
	/**
	 * Based on the last and second last readings of the pressure level,
	 * it is determined as likely to rain if there is a reduction 
	 * on the pressure level; otherwise it is unlikely to rain.
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		boolean result = false;
		if (this.lpres > this.cpres) {
			result = true;
		}
		return result;
	}
}