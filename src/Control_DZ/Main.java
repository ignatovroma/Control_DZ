package Control_DZ;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Notebook notebook1 = new Notebook("dell", "a10", 8, 500, "windows", "black");
        Notebook notebook2 = new Notebook("dell", "a20", 8, 1000, "windows", "gray");
        Notebook notebook3 = new Notebook("hp", "d87", 16, 1000, "windows", "silver");
        Notebook notebook4 = new Notebook("hp", "e117", 8, 1000, "windows", "yellow");
        Notebook notebook5 = new Notebook("apple", "m1", 16, 1000, "macos", "silver");
        Notebook notebook6 = new Notebook("apple", "m2", 16, 3000, "macos", "silver");
        Notebook notebook7 = new Notebook("samsung", "x8", 32, 2000, "windows", "red");
        Notebook notebook8 = new Notebook("samsung", "g10", 16, 1000, "windows", "brown");
        Notebook notebook9 = new Notebook("asus", "r8", 8, 2000, "linux", "white");
        Notebook notebook10 = new Notebook("asus", "yz89", 8, 500, "linux", "pink");

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);
        notebooks.add(notebook8);
        notebooks.add(notebook9);
        notebooks.add(notebook10);

        NotebookFilter notebookFilter = new NotebookFilter(notebooks);

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - Бренд (например, Dell)");
        System.out.println("2 - ОЗУ (ГБ)");
        System.out.println("3 - Объем ЖД (ГБ)");
        System.out.println("4 - Операционная система (например, Windows)");
        System.out.println("5 - Цвет (например, Silver)");

        int option = scanner.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.print("Введите бренд: ");
                    String brand = scanner.next().toLowerCase();
                    filters.put("brand", brand);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ОЗУ (ГБ): ");
                    int ram = scanner.nextInt();
                    filters.put("ram", ram);
                    break;
                case 3:
                    System.out.print("Введите минимальный объем ЖД (ГБ): ");
                    int storageCapacity = scanner.nextInt();
                    filters.put("storageCapacity", storageCapacity);
                    break;
                case 4:
                    System.out.print("Введите операционную систему: ");
                    String operatingSystem = scanner.next().toLowerCase();
                    filters.put("operatingSystem", operatingSystem);
                    break;
                case 5:
                    System.out.print("Введите цвет: ");
                    String color = scanner.next().toLowerCase();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Некорректный вариант");
                    break;
            }

            System.out.println("Выберите следующий критерий фильтрации (или 0 для завершения поиска): ");
            option = scanner.nextInt();
        }

        List<Notebook> filteredNotebooks = notebookFilter.filterNotebooks(filters);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие условиям фильтра, не найдены.");
        } else {
            System.out.println("Найденные ноутбуки, удовлетворяющие условиям фильтра:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(" Бренд: " + notebook.getBrand() + "\n Модель: " + notebook.getModel() + "\n ОЗУ: " + notebook.getRam() + "\n Объем ЖД: " +
                        notebook.getStorageCapacity() + "\n Операционная система: " + notebook.getOperatingSystem() + "\n" +
                        " Цвет: " + notebook.getColor()+ "\n");
            }
        }
    }
}
