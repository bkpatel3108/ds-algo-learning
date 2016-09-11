
public class CoachPassengerFactory extends PassengerAbstractFactory {

	Integer avgArrivalRate;
	Integer avgServiceTime;

	CoachPassengerFactory(Integer avgArrivalRate, Integer avgServiceTime) {
		this.avgArrivalRate = avgArrivalRate;
		this.avgServiceTime = avgServiceTime;
	}

	@Override
	public Passenger getFirstClassPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger getCoachPassenger() {
		// TODO Auto-generated method stub
		// return passenger based on arrival rate
		// calculate service time based on average service time
		boolean isNewPassenger = RandomUtil.randomEvent(avgArrivalRate);
		if (isNewPassenger == true) {
			Integer passengerServiceTime = RandomUtil.randNatAvg(avgServiceTime);
			return new Passenger(passengerServiceTime, "COACH");
		}
		return null;

	}

}
