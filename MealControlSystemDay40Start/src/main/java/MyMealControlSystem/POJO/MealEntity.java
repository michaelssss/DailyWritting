package MyMealControlSystem.POJO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelssss on 16-2-24.
 */
@Entity
@Table(name = "Meal", schema = "Meal", catalog = "")
public class MealEntity {
    private int code;
    private Timestamp timestamp;
    private int category;
    private double volume;

    @Id
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "Category")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "Volume")
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

        MealEntity mealEntity = (MealEntity) o;

        if (code != mealEntity.code) return false;
        if (category != mealEntity.category) return false;
        if (Double.compare(mealEntity.volume, volume) != 0) return false;
        if (timestamp != null ? !timestamp.equals(mealEntity.timestamp) : mealEntity.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = code;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + category;
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("当前数据库名字： Meal\n");
        stringBuilder.append("code : " + code + "\n");
        stringBuilder.append("记录时间： " + timestamp.toString() + "\n");
        stringBuilder.append("食物类别：" + category + "\n");
        stringBuilder.append("食用量：" + volume + "%(当前食用量占全天比重) \n");
        return stringBuilder.toString();
    }
}
