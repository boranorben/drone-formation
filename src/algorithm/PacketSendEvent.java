package algorithm;

public class PacketSendEvent extends Event {
	
	public PacketSendEvent(double eventTime, Drone drone) {
		this.eventTime = eventTime;
		this.drone = drone;
		this.state = State.PACKET_SEND;
	}

}
