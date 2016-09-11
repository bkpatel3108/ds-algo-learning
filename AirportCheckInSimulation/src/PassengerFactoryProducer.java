
public class PassengerFactoryProducer {
	public static PassengerAbstractFactory getPassengerFactory(String passengerType, Integer avgArrivalRate,
			Integer avgServiceTime) {
		if (passengerType == null) {
			return null;
		}

		if (passengerType.equals("FIRST_CLASS")) {
			return new FirstClassPassengerFactory(avgArrivalRate,avgServiceTime);
		} else if (passengerType.equals("COACH")) {
			return new CoachPassengerFactory(avgArrivalRate,avgServiceTime);
		}

		return null;
	}
}
