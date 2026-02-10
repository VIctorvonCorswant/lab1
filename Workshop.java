import java.util.ArrayList;
import java.util.List;

//public class Workshop2 {
//
//    List<String> supportedModels = new ArrayList<>();
//    List<Car> facility = new ArrayList<>();
//    protected int facilitySize = 5;
//
//
//    public Workshop2(int facilitySize) {
//        this.facilitySize = facilitySize;
//    }
//
//    public boolean addCarToWorkshop(Car car) {
//        // Prevent adding unsupported car models
//        if (!supportedModels.contains(car.getModelName())) return false;
//
//        if (facility.size() < facilitySize) {
//            facility.add(car);
//            return true;
//        }
//        return false;
//    }
//
//    public Car removeCarFromWorkshop(Car specifiedCar) {
//        if (facility.contains(specifiedCar)) {
//            facility.remove(specifiedCar);
//            return specifiedCar;
//        }
//        if (!facility.isEmpty()) return facility.removeFirst();
//        return null;
//    }
//}

public class Workshop<M extends Car<M>> {

    List<Class<? extends M>> supportedModels = new ArrayList<>();
    List<Car<M>> facility = new ArrayList<>();
    protected int facilitySize = 5;

    public Workshop(int facilitySize, List<Class<? extends M>> supportedModels) {
        this.facilitySize = facilitySize;
        if (supportedModels != null) this.supportedModels.addAll(supportedModels);
    }

    public boolean addCarToWorkshop(Car<M> car) {
        // Compile-time safety: only cars typed with the workshop's model type M can be passed
        if (facility.size() < facilitySize) {
            facility.add(car);
            return true;
        }
        return false;
    }
}
