/**
 * Created by michaelssss on 16-1-14.
 */
public class DogImlp implements IDog {
    @Override
    public String bark() {
        return "WoWaing";
    }

    @Override
    public String eat(String food) {
        return "Eating " + food;
    }
}
