package tuan5quanLiXeMay;

import java.util.Scanner;

public class VehicleManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3]; // Mảng lưu trữ 3 đối tượng xe
        boolean running = true;

        while (running) {
            // Gọi hàm hiển thị menu và nhập lựa chọn từ người dùng
            int choice = showMenuAndGetChoice(scanner);

            switch (choice) {
                case 1:
                    // Nhập thông tin và tạo các đối tượng xe
                    inputVehicleData(scanner, vehicles);
                    break;

                case 2:
                    // Xuất bảng kê khai tiền thuế trước bạ của các xe
                    printTaxTable(vehicles);
                    break;

                case 3:
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        scanner.close();
    }

    // Hàm hiển thị menu và nhập lựa chọn từ người dùng
    public static int showMenuAndGetChoice(Scanner scanner) {
        System.out.println("Menu:");
        System.out.println("1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3");
        System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
        System.out.println("3. Thoát");
        System.out.print("Chọn công việc (1-3): ");
        return scanner.nextInt();
    }

    // Hàm nhập thông tin và tạo các đối tượng xe
    public static void inputVehicleData(Scanner scanner, Vehicle[] vehicles) {
        scanner.nextLine(); // Consume newline left-over
        for (int i = 0; i < 3; i++) {
            System.out.println("Nhập thông tin cho xe " + (i + 1) + ":");
            System.out.print("Nhập tên chủ xe: ");
            String ownerName = scanner.nextLine();
            System.out.print("Nhập loại xe: ");
            String vehicleType = scanner.nextLine();
            System.out.print("Nhập trị giá xe: ");
            float value = scanner.nextFloat();
            System.out.print("Nhập dung tích xy-lanh (cc): ");
            float cylinderCapacity = scanner.nextFloat();
            scanner.nextLine(); // Consume newline left-over
            vehicles[i] = new Vehicle(ownerName, vehicleType, value, cylinderCapacity);
        }
    }

    // Hàm xuất bảng kê khai tiền thuế trước bạ của các xe
    public static void printTaxTable(Vehicle[] vehicles) {
        System.out.println("Bảng kê khai tiền thuế trước bạ:");
        System.out.println("Chủ xe\t\tLoại xe\t\tTrị giá xe\tDung tích xy-lanh\tThuế trước bạ");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle);
            }
        }
    }
}
