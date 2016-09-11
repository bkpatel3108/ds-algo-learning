
public class Passenger {
	static Integer counter = 0;
	Integer id;
	Integer serviceTime;
	Integer waitingTime;
	String type;

	Passenger(Integer serviceTime, String type) {
		this.serviceTime = serviceTime;
		this.type = type;
		this.waitingTime = 0;
		id = ++counter;
	}

	public Integer getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(Integer waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	public void addWaitTime()
	{
		this.waitingTime++;
	}

	public Integer getId() {
		return id;
	}
	
	public String toString()
	{
		return "id: "+id+" type: "+type+" serviceTime: "+serviceTime;
	}
	
	public String passengerServedString()
	{
		return "id: "+id+" type: "+type+" serviceTime: "+serviceTime+" time waited: "+waitingTime;
	}

}
