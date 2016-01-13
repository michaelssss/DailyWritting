package POJO;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by michaelssss on 16-1-13.
 */
public class MealEntity {
    private Integer code;
    private Timestamp timestamp;
    private Integer category;
    private Double volume;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealEntity that = (MealEntity) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(category, that.category) &&
                Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, timestamp, category, volume);
    }
}
