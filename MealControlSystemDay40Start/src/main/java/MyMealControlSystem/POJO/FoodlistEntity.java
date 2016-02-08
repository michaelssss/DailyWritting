package MyMealControlSystem.POJO;

/**
 * Created by michaelssss on 16-2-16.
 */
public class FoodlistEntity {
    private int uid;
    private String foodName;
    private Double calories;
    private String type;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

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
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (calories != null ? calories.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
