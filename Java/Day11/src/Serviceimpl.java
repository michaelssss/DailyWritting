/**
 * Created by michaelssss on 16-1-14.
 */
public class Serviceimpl implements IService {
    private IDog dog;

    public IDog getDog() {
        return dog;
    }

    public void setDog(IDog dog) {
        this.dog = dog;
    }

    @Override
    public void service(String food) {
        System.out.println(dog.bark());
        System.out.println(dog.eat(food));
    }
}
