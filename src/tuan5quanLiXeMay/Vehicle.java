package tuan5quanLiXeMay;

public class Vehicle {
    private float value; // Trị giá xe
    private float cylinderCapacity; // Dung tích xy-lanh
    private String ownerName; // Tên chủ xe
    private String vehicleType; // Loại xe

    // Constructor mặc định
    public Vehicle() {
        this.value = 0.0f;
        this.cylinderCapacity = 0.0f;
        this.ownerName = "";
        this.vehicleType = "";
    }

    // Constructor với đầy đủ thông tin
    public Vehicle(String ownerName, String vehicleType, float value, float cylinderCapacity) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.value = value;
        this.cylinderCapacity = cylinderCapacity;
    }

    // Getter và Setter cho ownerName
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Getter và Setter cho vehicleType
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Getter và Setter cho value
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    // Getter và Setter cho cylinderCapacity
    public float getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(float cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    // Phương thức tính thuế trước bạ
    public float calculateTax() {
        if (cylinderCapacity < 100) {
            return value * 0.01f;
        } else if (cylinderCapacity <= 200) {
            return value * 0.03f;
        } else {
            return value * 0.05f;
        }
    }

    // Phương thức toString để xuất thông tin xe
    @Override
    public String toString() {
        return String.format("%s\t\t%s\t\t%.2f\t\t%.2f\t\t%.2f", ownerName, vehicleType, value, cylinderCapacity, calculateTax());
    }
}
