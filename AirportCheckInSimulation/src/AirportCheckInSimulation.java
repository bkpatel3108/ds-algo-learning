import java.util.ArrayList;
import java.util.List;

public class AirportCheckInSimulation {

	private Integer simulationTime;
	private Integer finalSimulationTime;

	private Integer maxFirstClassCheckInTime;
	private Integer maxCoachCheckInTime;
	private Integer maxCheckInTime;
	private Double avgFirstClassCheckInTime;
	private Double avgCoachCheckInTime;
	private Double avgCheckInTime;

	private Integer maxFirstClassWaitingTime;
	private Integer maxCoachWaitingTime;
	private Integer maxWaitingTime;
	private Double avgFirstClassWaitingTime;
	private Double avgCoachWaitingTime;
	private Double avgWaitingTime;

	// private Integer totalQueueLength;
	private Integer totalFirstClassPaxQLen;
	private Integer totalCoachPaxQLen;
	private Integer maxQueueLength;
	private Integer maxFirstClassPaxQLen;
	private Integer maxCoachPaxQLen;
	private Double avgFirstClassPaxQLen;
	private Double avgCoachPaxQLen;
	private Double avgQueueLength;

	private List<CheckInCounter> firstClassCheckInCounters;
	private List<CheckInCounter> coachCheckInCounters;

	private PassengerAbstractFactory firstClassPassengerFactory;
	private PassengerAbstractFactory coachPassengerFactory;

	private Queue<Passenger> firstClassPassengerQueue;
	private Queue<Passenger> coachPassengerQueue;

	private List<Passenger> firstClassPassengers;
	private List<Passenger> coachPassengers;

	private List<Double> firstClassCountersOccupancy;
	private List<Double> coachCountersOccupancy;

	private ConsoleLogger consoleLogger;

	AirportCheckInSimulation(Integer simulationTime, Integer noOfFirstClassCheckInCounters,
			Integer noOfCoachCheckInCounters, Integer avgFirstClassPassengerArrivalRate,
			Integer avgCoachPassengerArrivalRate, Integer avgFirstClassPassengerServiceTime,
			Integer avgCoachPassengerServiceTime, Integer debugMode) {

		this.simulationTime = simulationTime;

		firstClassCheckInCounters = new ArrayList<CheckInCounter>();
		coachCheckInCounters = new ArrayList<CheckInCounter>();

		firstClassPassengers = new ArrayList<Passenger>();
		coachPassengers = new ArrayList<Passenger>();

		for (int i = 0; i < noOfFirstClassCheckInCounters; i++) {
			CheckInCounter checkInCounter = new CheckInCounter();
			firstClassCheckInCounters.add(checkInCounter);
		}

		for (int i = 0; i < noOfCoachCheckInCounters; i++) {
			CheckInCounter checkInCounter = new CheckInCounter();
			coachCheckInCounters.add(checkInCounter);
		}

		firstClassPassengerFactory = PassengerFactoryProducer.getPassengerFactory("FIRST_CLASS",
				avgFirstClassPassengerArrivalRate, avgFirstClassPassengerServiceTime);
		coachPassengerFactory = PassengerFactoryProducer.getPassengerFactory("COACH", avgCoachPassengerArrivalRate,
				avgCoachPassengerServiceTime);

		firstClassPassengerQueue = new ArrayQueue<Passenger>();
		coachPassengerQueue = new ArrayQueue<Passenger>();

		firstClassCountersOccupancy = new ArrayList<Double>();
		coachCountersOccupancy = new ArrayList<Double>();

		totalFirstClassPaxQLen = 0;
		totalCoachPaxQLen = 0;
		maxQueueLength = 0;
		maxFirstClassPaxQLen = 0;
		maxCoachPaxQLen = 0;
		finalSimulationTime = 0;

		consoleLogger = new ConsoleLogger();
		ConsoleLogger.mode = debugMode;
	}

	public void simulate() {

		for (int timeUnit = 0; (timeUnit < simulationTime) || (!firstClassPassengerQueue.isEmpty())
				|| (!coachPassengerQueue.isEmpty()); timeUnit++, finalSimulationTime++) {

			// System.out.print("\nTime >>" + (timeUnit + 1));
			consoleLogger.log("\nTime >>" + (timeUnit + 1));

			// generate first class passenger
			if (timeUnit < simulationTime) {
				Passenger firstClassPassenger = firstClassPassengerFactory.getFirstClassPassenger();
				if (firstClassPassenger != null) {
					// System.out.print(" /Passenger Created/ " +
					// firstClassPassenger.toString());
					consoleLogger.log(" /Passenger Created/ " + firstClassPassenger.toString());
					firstClassPassengerQueue.enqueue(firstClassPassenger);
					firstClassPassengers.add(firstClassPassenger);
				}

				// generate coach passenger
				Passenger coachPassenger = coachPassengerFactory.getCoachPassenger();
				if (coachPassenger != null) {
					// System.out.print(" /Passenger Created/ " +
					// coachPassenger.toString());
					consoleLogger.log(" /Passenger Created/ " + coachPassenger.toString());
					coachPassengerQueue.enqueue(coachPassenger);
					coachPassengers.add(coachPassenger);
				}
			}

			// work on coach check in counter
			for (CheckInCounter checkInCounter : coachCheckInCounters) {
				checkInCounter.updateCounter();
				if (checkInCounter.isFree()) {
					Passenger coachPassengerFrmQ = coachPassengerQueue.dequeue();
					if (coachPassengerFrmQ != null) {
						checkInCounter.assignPassenger(coachPassengerFrmQ);
					}
				}
			}

			// work on first class checkin counter
			for (CheckInCounter checkInCounter : firstClassCheckInCounters) {
				checkInCounter.updateCounter();
				if (checkInCounter.isFree()) {
					Passenger firstClassPassengerFrmQ = firstClassPassengerQueue.dequeue();
					if (firstClassPassengerFrmQ != null) {
						checkInCounter.assignPassenger(firstClassPassengerFrmQ);
					} else {
						Passenger coachPassengerFrmQ = coachPassengerQueue.dequeue();
						if (coachPassengerFrmQ != null) {
							checkInCounter.assignPassenger(coachPassengerFrmQ);
						}
					}

				}
			}

			// update wait time of passenger in queues
			for (int i = 0; i < firstClassPassengerQueue.size(); i++) {
				Passenger firstClassPassengerFrmQ = firstClassPassengerQueue.dequeue();
				firstClassPassengerFrmQ.addWaitTime();
				firstClassPassengerQueue.enqueue(firstClassPassengerFrmQ);
			}

			for (int i = 0; i < coachPassengerQueue.size(); i++) {
				Passenger coachPassengerFrmQ = coachPassengerQueue.dequeue();
				coachPassengerFrmQ.addWaitTime();
				coachPassengerQueue.enqueue(coachPassengerFrmQ);
			}

			totalFirstClassPaxQLen = totalFirstClassPaxQLen + firstClassPassengerQueue.size();
			maxFirstClassPaxQLen = maxFirstClassPaxQLen > firstClassPassengerQueue.size() ? maxFirstClassPaxQLen
					: firstClassPassengerQueue.size();

			totalCoachPaxQLen = totalCoachPaxQLen + coachPassengerQueue.size();
			maxCoachPaxQLen = maxCoachPaxQLen > coachPassengerQueue.size() ? maxCoachPaxQLen
					: coachPassengerQueue.size();

			// totalQueueLength = totalFirstClassPaxQLen + totalCoachPaxQLen;
			maxQueueLength = maxFirstClassPaxQLen > maxCoachPaxQLen ? maxFirstClassPaxQLen : maxCoachPaxQLen;
		}

		// process passenger of check in counters
		// Search for max remaining time. Run simulation for that much time
		Integer maxRemainingTime = 0;

		for (CheckInCounter checkInCounter : firstClassCheckInCounters) {
			maxRemainingTime = maxRemainingTime > checkInCounter.getPassengerRemainingServiceTime() ? maxRemainingTime
					: checkInCounter.getPassengerRemainingServiceTime();
		}

		for (CheckInCounter checkInCounter : coachCheckInCounters) {
			maxRemainingTime = maxRemainingTime > checkInCounter.getPassengerRemainingServiceTime() ? maxRemainingTime
					: checkInCounter.getPassengerRemainingServiceTime();
		}

		for (int i = 0; i < maxRemainingTime; i++) {
			// System.out.print("\nTime >>" + (++finalSimulationTime));
			consoleLogger.log("\nTime >>" + (++finalSimulationTime));
			for (CheckInCounter checkInCounter : firstClassCheckInCounters) {
				if (checkInCounter.getPassengerRemainingServiceTime() + 1 > 0) {
					checkInCounter.updateCounter();
				}
			}

			for (CheckInCounter checkInCounter : coachCheckInCounters) {
				if (checkInCounter.getPassengerRemainingServiceTime() + 1 > 0) {
					checkInCounter.updateCounter();
				}
			}
		}

	}

	public Integer getMaxFirstClassCheckInTime() {
		return maxFirstClassCheckInTime;
	}

	public Integer getMaxCoachCheckInTime() {
		return maxCoachCheckInTime;
	}

	public Integer getMaxCheckInTime() {
		return maxCheckInTime;
	}

	public Double getAvgFirstClassCheckInTime() {
		return avgFirstClassCheckInTime;
	}

	public Double getAvgCoachCheckInTime() {
		return avgCoachCheckInTime;
	}

	public Double getAvgCheckInTime() {
		return avgCheckInTime;
	}

	public Integer getMaxFirstClassWaitingTime() {
		return maxFirstClassWaitingTime;
	}

	public Integer getMaxCoachWaitingTime() {
		return maxCoachWaitingTime;
	}

	public Integer getMaxWaitingTime() {
		return maxWaitingTime;
	}

	public Double getAvgFirstClassWaitingTime() {
		return avgFirstClassWaitingTime;
	}

	public Double getAvgCoachWaitingTime() {
		return avgCoachWaitingTime;
	}

	public Double getAvgWaitingTime() {
		return avgWaitingTime;
	}

	public Integer getMaxQueueLength() {
		return maxQueueLength;
	}

	public Double getAvgQueueLength() {
		return avgQueueLength;
	}

	public Integer totalfirstClassPassengers() {
		return firstClassPassengers.size();
	}

	public Integer totalCoachPassengers() {
		return coachPassengers.size();
	}

	public Integer totalPassengers() {
		return firstClassPassengers.size() + coachPassengers.size();
	}

	public List<Double> getFirstClassCountersOccupancy() {
		return firstClassCountersOccupancy;
	}

	public List<Double> getCoachCountersOccupancy() {
		return coachCountersOccupancy;
	}

	public Integer getMaxFirstClassPaxQLen() {
		return maxFirstClassPaxQLen;
	}

	public Integer getMaxCoachPaxQLen() {
		return maxCoachPaxQLen;
	}

	public Double getAvgFirstClassPaxQLen() {
		return avgFirstClassPaxQLen;
	}

	public Double getAvgCoachPaxQLen() {
		return avgCoachPaxQLen;
	}

	public Integer getFinalSimulationTime() {
		return finalSimulationTime;
	}

	public void generateSimulationReport() {
		Integer totalFirstClassCheckInTime = 0;
		Integer totalCoachCheckInTime = 0;
		Integer totalCheckInTime = 0;
		Integer totalFirstClassWaitingTime = 0;
		Integer totalCoachWaitingTime = 0;
		Integer totalWaitingTime = 0;

		Integer maxFirstClassWaitingTime = 0;
		Integer maxCoachWaitingTime = 0;
		// Integer maxWaitingTime = 0;
		Integer maxFirstClassCheckInTime = 0;
		Integer maxCoachCheckInTime = 0;
		// Integer maxCheckInTime = 0;

		// firstClassPassengers
		for (Passenger passenger : firstClassPassengers) {
			Integer firstClassPassengerWaitingTime = passenger.getWaitingTime();
			totalFirstClassWaitingTime = totalFirstClassWaitingTime + firstClassPassengerWaitingTime;
			maxFirstClassWaitingTime = firstClassPassengerWaitingTime > maxFirstClassWaitingTime
					? firstClassPassengerWaitingTime : maxFirstClassWaitingTime;

			Integer firstClassPassengerCheckInTime = firstClassPassengerWaitingTime + passenger.getServiceTime();
			totalFirstClassCheckInTime = totalFirstClassCheckInTime + firstClassPassengerCheckInTime;
			maxFirstClassCheckInTime = firstClassPassengerCheckInTime > maxFirstClassCheckInTime
					? firstClassPassengerCheckInTime : maxFirstClassCheckInTime;
		}

		if (firstClassPassengers.size() > 0) {
			this.avgFirstClassWaitingTime = totalFirstClassWaitingTime / (double) firstClassPassengers.size();
			this.avgFirstClassCheckInTime = totalFirstClassCheckInTime / (double) firstClassPassengers.size();
		}

		this.maxFirstClassWaitingTime = maxFirstClassWaitingTime;
		this.maxFirstClassCheckInTime = maxFirstClassCheckInTime;

		// coachPassengers
		for (Passenger passenger : coachPassengers) {
			Integer coachPassengerWaitingTime = passenger.getWaitingTime();
			totalCoachWaitingTime = totalCoachWaitingTime + coachPassengerWaitingTime;
			maxCoachWaitingTime = coachPassengerWaitingTime > maxCoachWaitingTime ? coachPassengerWaitingTime
					: maxCoachWaitingTime;

			Integer coachPassengerCheckInTime = coachPassengerWaitingTime + passenger.getServiceTime();
			totalCoachCheckInTime = totalCoachCheckInTime + coachPassengerCheckInTime;
			maxCoachCheckInTime = coachPassengerCheckInTime > maxCoachCheckInTime ? coachPassengerCheckInTime
					: maxCoachCheckInTime;

		}

		if (coachPassengers.size() > 0) {
			this.avgCoachWaitingTime = totalCoachWaitingTime / (double) coachPassengers.size();
			this.avgCoachCheckInTime = totalCoachCheckInTime / (double) coachPassengers.size();
		}

		this.maxCoachWaitingTime = maxCoachWaitingTime;
		this.maxCoachCheckInTime = maxCoachCheckInTime;

		// all passengers
		totalWaitingTime = totalFirstClassWaitingTime + totalCoachWaitingTime;
		totalCheckInTime = totalFirstClassCheckInTime + totalCoachCheckInTime;

		this.avgWaitingTime = ((double) totalWaitingTime / (firstClassPassengers.size() + coachPassengers.size()));
		this.avgCheckInTime = ((double) totalCheckInTime / (firstClassPassengers.size() + coachPassengers.size()));

		this.maxCheckInTime = maxFirstClassCheckInTime > maxCoachCheckInTime ? maxFirstClassCheckInTime
				: maxCoachCheckInTime;
		this.maxWaitingTime = maxFirstClassWaitingTime > maxCoachWaitingTime ? maxFirstClassWaitingTime
				: maxCoachWaitingTime;

		// find occupancy
		for (CheckInCounter checkInCounter : firstClassCheckInCounters) {
			Integer busyCounter = checkInCounter.getBusyCounter();
			Double occupancy = ((double) busyCounter / finalSimulationTime) * 100.0;
			firstClassCountersOccupancy.add(occupancy);
		}

		for (CheckInCounter checkInCounter : coachCheckInCounters) {
			Integer busyCounter = checkInCounter.getBusyCounter();
			Double occupancy = ((double) busyCounter / finalSimulationTime) * 100.0;
			coachCountersOccupancy.add(occupancy);
		}

		// Queue statistics
		avgFirstClassPaxQLen = ((double) totalFirstClassPaxQLen / finalSimulationTime);
		avgCoachPaxQLen = ((double) totalCoachPaxQLen / finalSimulationTime);
		avgQueueLength = ((double) (totalFirstClassPaxQLen + totalCoachPaxQLen)) / (finalSimulationTime * 2);

	}

}
