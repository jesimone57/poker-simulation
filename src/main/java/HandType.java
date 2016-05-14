/**
 * Created by jsimone on 5/13/16.
 */
public enum HandType {

	STRAIGHT_FLUSH("Straight Flush"),
	STRAIGHT("Straight"),
	FLUSH("Flush"),

	FOUR_OF_A_KIND("Four-of-a-Kind"),
	FULL_HOUSE("Full House"),
	THREE_OF_A_KIND("Three-of-a-Kind"),
	TWO_PAIR("Two Pair"),
	ONE_PAIR("One Pair"),
	NOTHING("Nothing");

	private String label;
	private HandType(String label) {
		this.label = label;
	}
	public String getLabel() {
		return this.label;
	}
}
