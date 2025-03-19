package ra.bussiness;

import ra.entity.Employee;
import java.util.Scanner;

public class EmployeeBusiness {
    private Employee[] employees = new Employee[100];
    private int count = 0;

    public void addEmployee(Scanner sc) {
        if (count >= employees.length) {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm mới!");
            return;
        }

        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int num;
        while (true) {
            num = sc.nextInt();
            if (num <= 0 || num > (employees.length - count)) {
                System.out.print("Số lượng không hợp lệ. Nhập lại: ");
            } else {
                break;
            }
        }
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            Employee emp = new Employee();
            emp.inputData(sc);
            employees[count++] = emp;
        }
        System.out.println("Thêm nhân viên thành công!");
    }

    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            for (int i = 0; i < count; i++) {
                employees[i].displayData();
            }
        }
    }

    public void editEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String id = sc.next();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                System.out.println("Thông tin hiện tại:");
                employees[i].displayData();
                employees[i].inputData(sc);
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    public void deleteEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = sc.next();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                char confirm = sc.next().charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    for (int j = i; j < count - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--count] = null;
                    System.out.println("Xóa nhân viên thành công!");
                } else {
                    System.out.println("Hủy thao tác xóa.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }
    public void sortEmployees(Scanner sc) {

    }
    public void searchEmployee (Scanner sc){

    }
}
