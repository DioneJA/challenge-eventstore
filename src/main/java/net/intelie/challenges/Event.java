package net.intelie.challenges;

import java.util.Objects;

/**
 * This is just an event stub, feel free to expand it if needed.
 */
public class Event {

    private final String type;
    private final long timestamp;

    public Event(String type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public String type() {
        return type;
    }

    public long timestamp() {
        return timestamp;
    }
    //ToString to print the event
    @Override
    public String toString() {
        return "Event{" + "type=" + type + ", timestamp=" + timestamp + '}';
    }

    //Generating a HashCode and Equals to use in object comparisons
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.timestamp != other.timestamp) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

}
