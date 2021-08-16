package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MaterialManagement materialManagement = new MaterialManagement();
        Scanner scanner = new Scanner(System.in);
        chooseMenu(materialManagement, scanner);
    }

    private static void chooseMenu(MaterialManagement materialManagement, Scanner scanner) {
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    addMaterial(materialManagement, scanner);
                    break;
                }
                case 2: {
                    displayMaterial(materialManagement);
                    break;
                }
                case 3: {
                    updatedMaterial(materialManagement, scanner);
                    break;
                }
                case 4: {
                    removeMaterial(materialManagement, scanner);
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void removeMaterial(MaterialManagement materialManagement, Scanner scanner) {
        System.out.println("Nhập vị trí mà bạn muốn sửa:");
        int index = scanner.nextInt();
        materialManagement.deleteMaterial(index);
    }

    private static void updatedMaterial(MaterialManagement materialManagement, Scanner scanner) {
        System.out.println("Nhập vị trí mà bạn muốn sửa:");
        int index = scanner.nextInt();
        if (index < 0 || index >= materialManagement.getMaterials().length) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            Material material;
            if (materialManagement.getMaterials()[index] instanceof Meat) {
                scanner.nextLine();
                material = inputMeat(scanner);
            } else {
                scanner.nextLine();
                material = inputFloor(scanner);
            }
            materialManagement.updateMaterialInfo(material, index);
        }
    }

    private static void displayMaterial(MaterialManagement materialManagement) {
        System.out.println("Danh sách nguyên liệu");
        showMaterialListInfo(materialManagement.getMaterials());
    }

    private static void addMaterial(MaterialManagement materialManagement, Scanner scanner) {
        subMenuForAddMaterial();
        System.out.println("Chọn nguyên liệu muốn thêm:");
        int choiceMaterial = scanner.nextInt();
        chooseMaterialToAdd(materialManagement, scanner, choiceMaterial);
    }

    private static void showMaterialListInfo(Material[] materials) {
        for (Material material : materials) {
            System.out.print(material);
            int realMoney = material.getRealMoney();
            System.out.print(" tiền phải trả: " + realMoney);
            System.out.println();
        }
    }

    private static void chooseMaterialToAdd(MaterialManagement materialManagement, Scanner scanner, int choiceMaterial) {
        switch (choiceMaterial) {
            case 1: {
                scanner.nextLine();
                Material meat = inputMeat(scanner);
                materialManagement.addNewMaterialToList(meat);
                break;
            }
            case 2: {
                scanner.nextLine();
                Material flour = inputFloor(scanner);
                materialManagement.addNewMaterialToList(flour);
                break;
            }
            case 0: {
                break;
            }
        }
    }

    private static void subMenuForAddMaterial() {
        System.out.println("Thêm nguyên liệu");
        System.out.println("1. Thêm thịt");
        System.out.println("2. Thêm bột");
        System.out.println("0. Quay lại");
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Thêm nguyên liệu vào trong mảng");
        System.out.println("2. Hiện thị danh sách nguyên liệu có trong mảng");
        System.out.println("3. Cập nhật thông itn nguyên liệu có trong mảng");
        System.out.println("4. Xóa nguyên liệu có trong mảng");
        System.out.println("0. Thoát");
    }


    private static Material inputMeat(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày:");
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("Nhập đơn giá:");
        int cost = scanner.nextInt();
        System.out.println("Nhập khối lượng");
        double weight = scanner.nextDouble();
        return new Meat(id, name, localDate, cost, weight);
    }

    private static Material inputFloor(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày:");
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("Nhập đơn giá:");
        int cost = scanner.nextInt();
        System.out.println("Nhập số lượng");
        int amount = scanner.nextInt();
        return new CrispyFlour(id, name, localDate, cost, amount);
    }
}
