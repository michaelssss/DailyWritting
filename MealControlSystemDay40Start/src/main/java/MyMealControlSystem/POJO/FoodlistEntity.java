package MyMealControlSystem.POJO;

import javax.persistence.*;

/**
 * Created by michaelssss on 16-2-24.
 */
@Entity
@Table(name = "Foodlist", schema = "Meal", catalog = "")
public class FoodlistEntity {
    private int uid;
    private String foodName;
    private Double calories;
    private String type;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "foodName")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "Calories")
    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodlistEntity that = (FoodlistEntity) o;

        if (uid != that.uid) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (calories != null ? !calories.equals(that.calories) : that.calories != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (calories != null ? calories.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 食物名字：" + foodName + "\n");
        stringBuffer.append(" 食物种类：" + type + "\n");
        stringBuffer.append(" 卡路里：" + calories + " 大卡\n");
        return stringBuffer.toString();
    }
}
