package POJO;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by michaelssss on 16-1-12.
 */
public class MealEntity {
    private int code;
    private Timestamp timestamp;
    private int category;
    private double volume;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealEntity that = (MealEntity) o;
        return code == that.code &&
                category == that.category &&
                Double.compare(that.volume, volume) == 0 &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, timestamp, category, volume);
    }
}
