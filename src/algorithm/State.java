package algorithm;

public enum State {
	ADD, FIRST_MOVE, PACKET_SEND, ADJUST_MOVE, WAIT, DONE;

	public String toString() {
		return super.toString().toLowerCase();
	}
}
