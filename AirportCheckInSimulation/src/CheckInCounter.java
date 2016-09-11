
public class CheckInCounter {

	private Passenger passenger;
	private Integer passengerRemainingServiceTime;
	private Integer busyCounter;
	private ConsoleLogger consoleLogger;

	CheckInCounter() {
		passenger = null;
		passengerRemainingServiceTime = 0;
		busyCounter = 0;
		consoleLogger = new ConsoleLogger();
	}

	public boolean isFree() {
		if (this.passenger == null) {
			return true;
		}
		return false;
	}

	public void assignPassenger(Passenger passenger) {
		this.passenger = passenger;
		this.passengerRemainingServiceTime = passenger.getServiceTime();
	}

	// update checkInCounter at each time interval
	public void updateCounter() {
		if (passenger != null) {
			busyCounter++;
		}

		if (passengerRemainingServiceTime == 1) {
			if (passenger != null) {
				// System.out.print(" /Passenger Served/ " +
				// passenger.passengerServedString());
				consoleLogger.log(" /Passenger Served/ " + passenger.passengerServedString());
				passenger = null;
			}
			passengerRemainingServiceTime--;
		} else {
			passengerRemainingServiceTime--;
		}
	}

	public Integer getBusyCounter() {
		return busyCounter;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public Integer getPassengerRemainingServiceTime() {
		return passengerRemainingServiceTime;
	}

}
