import java.util.List;
import java.util.Scanner;

public class AirportCheckInSimulationTest {

	public static void main(String[] args) {
		AirportCheckInSimulation airportCheckInSimulation = null;
		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter a number: \n1 - For quick test \n2 - For manual test ");
		int testType = reader.nextInt();
		System.out.println("Do you want to see output for each time unit? (Debug Mode) ");
		System.out.println("Enter a number: \n1 - For yes \n2 - For no ");
		int mode = reader.nextInt();

		if (testType == 1) {

			airportCheckInSimulation = new AirportCheckInSimulation(100, 2, 3, 6, 3, 10, 8, mode);

		} else if (testType == 2) {

			System.out.println("Please enter simulation time");
			Integer simulationTime = reader.nextInt();

			System.out.println("Please enter no of first class checkin counters");
			Integer noOfFirstClassCheckInCounters = reader.nextInt();

			System.out.println("Please enter no of coach checkin counters");
			Integer noOfCoachCheckInCounters = reader.nextInt();

			System.out.println("Please enter avg first class passenger arrival rate");
			Integer avgFirstClassPassengerArrivalRate = reader.nextInt();

			System.out.println("Please enter avg coach passenger arrival rate");
			Integer avgCoachPassengerArrivalRate = reader.nextInt();

			System.out.println("Please enter avg first class passenger service time");
			Integer avgFirstClassPassengerServiceTime = reader.nextInt();

			System.out.println("Please enter avg coach passenger service time");
			Integer avgCoachPassengerServiceTime = reader.nextInt();

			airportCheckInSimulation = new AirportCheckInSimulation(simulationTime, noOfFirstClassCheckInCounters,
					noOfCoachCheckInCounters, avgFirstClassPassengerArrivalRate, avgCoachPassengerArrivalRate,
					avgFirstClassPassengerServiceTime, avgCoachPassengerServiceTime, mode);
		}

		airportCheckInSimulation.simulate();
		airportCheckInSimulation.generateSimulationReport();

		System.out.println("\n\nTotal Passengers >> " + airportCheckInSimulation.totalPassengers());

		System.out.println("Total First Class Passengers >> " + airportCheckInSimulation.totalfirstClassPassengers());

		System.out.println("Total Coach Passengers >> " + airportCheckInSimulation.totalCoachPassengers());

		System.out.println("Avg Waiting Time >> " + airportCheckInSimulation.getAvgWaitingTime());

		System.out.println(
				"Avg CheckIn Time (Waiting Time + Service Time) >> " + airportCheckInSimulation.getAvgCheckInTime());

		System.out.println("Max Waiting Time >> " + airportCheckInSimulation.getMaxWaitingTime());

		System.out.println(
				"Max CheckIn Time (Waiting Time + Service Time) >> " + airportCheckInSimulation.getMaxCheckInTime());

		System.out.println("Avg Coach Waiting Time >> " + airportCheckInSimulation.getAvgCoachWaitingTime());

		System.out.println("Avg Coach CheckIn Time (Waiting Time + Service Time) >> "
				+ airportCheckInSimulation.getAvgCoachCheckInTime());

		System.out.println("Max Coach Waiting Time >> " + airportCheckInSimulation.getMaxCoachWaitingTime());

		System.out.println("Max Coach CheckIn Time (Waiting Time + Service Time) >> "
				+ airportCheckInSimulation.getMaxCoachCheckInTime());

		System.out.println("Avg First Class Waiting Time >> " + airportCheckInSimulation.getAvgFirstClassWaitingTime());

		System.out.println("Avg First Class CheckIn Time (Waiting Time + Service Time) >> "
				+ airportCheckInSimulation.getAvgFirstClassCheckInTime());

		System.out.println("Max First Class Waiting Time >> " + airportCheckInSimulation.getMaxFirstClassWaitingTime());

		System.out.println("Max First Class CheckIn Time (Waiting Time + Service Time) >> "
				+ airportCheckInSimulation.getMaxFirstClassCheckInTime());

		List<Double> firstClassCountersOccupancy = airportCheckInSimulation.getFirstClassCountersOccupancy();
		int counter = 1;
		for (Double occupancy : firstClassCountersOccupancy) {
			System.out.println(
					"First Class CheckIn Counters - CheckIn Counter -" + counter + " Occupancy >> " + occupancy);
			counter++;
		}

		List<Double> coachCountersOccupancy = airportCheckInSimulation.getCoachCountersOccupancy();
		counter = 1;
		for (Double occupancy : coachCountersOccupancy) {
			System.out.println("Coach CheckIn Counters - CheckIn Counter -" + counter + " Occupancy >> " + occupancy);
			counter++;
		}

		System.out.println("Avg Queue Length >> " + airportCheckInSimulation.getAvgQueueLength());

		System.out.println("Max Queue Length >> " + airportCheckInSimulation.getMaxQueueLength());

		System.out.println(
				"Avg First Class Passenger Queue Length >> " + airportCheckInSimulation.getAvgFirstClassPaxQLen());

		System.out.println(
				"Max First Class Passenger Queue Length >> " + airportCheckInSimulation.getMaxFirstClassPaxQLen());

		System.out.println("Avg Coach Passenger Queue Length >> " + airportCheckInSimulation.getAvgCoachPaxQLen());

		System.out.println("Max Coach Passenger Queue Length >> " + airportCheckInSimulation.getMaxCoachPaxQLen());

		System.out.println("Final Simulation Time >> " + airportCheckInSimulation.getFinalSimulationTime());
	}
}
