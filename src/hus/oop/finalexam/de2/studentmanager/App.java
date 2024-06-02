package hus.oop.finalexam.de2.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final StudentManager studentManager = StudentManager.getInstance();

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                String id = dataList.get(0);
                String lastName = dataList.get(1);
                String firstName = dataList.get(2);
                int yearOfBirth = Integer.parseInt(dataList.get(3));
                double mathsGrade = Double.parseDouble(dataList.get(4));
                double physicsGrade = Double.parseDouble(dataList.get(5));
                double chemistryGrade = Double.parseDouble(dataList.get(6));

                Student student = new Student.StudentBuilder(id)
                        .withLastname(lastName)
                        .withFirstname(firstName)
                        .withYearOfBirth(yearOfBirth)
                        .withMathsGrade(mathsGrade)
                        .withPhysicsGrade(physicsGrade)
                        .withChemistryGrade(chemistryGrade)
                        .build();
                studentManager.append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();

        System.out.println("Testing original data:");
        testOriginalData();

        System.out.println("\nTesting sorting by year of birth increasing:");
        testSortYearOfBirthIncreasing();

        System.out.println("\nTesting sorting by year of birth decreasing:");
        testSortYearOfBirthDecreasing();

        System.out.println("\nTesting sorting by maths grade increasing:");
        testSortMathsGradeIncreasing();

        System.out.println("\nTesting sorting by maths grade decreasing:");
        testSortMathsGradeDecreasing();

        System.out.println("\nTesting sorting by physics grade increasing:");
        testSortPhysicsGradeIncreasing();

        System.out.println("\nTesting sorting by physics grade decreasing:");
        testSortPhysicsGradeDecreasing();

        System.out.println("\nTesting sorting by chemistry grade increasing:");
        testSortChemistryGradeIncreasing();

        System.out.println("\nTesting sorting by chemistry grade decreasing:");
        testSortChemistryGradeDecreasing();

        System.out.println("\nTesting filter students with highest maths grades:");
        testFilterStudentsHighestMathsGrade();

        System.out.println("\nTesting filter students with lowest maths grades:");
        testFilterStudentsLowestMathsGrade();

        System.out.println("\nTesting filter students with highest physics grades:");
        testFilterStudentsHighestPhysicsGrade();

        System.out.println("\nTesting filter students with lowest physics grades:");
        testFilterStudentsLowestPhysicsGrade();

        System.out.println("\nTesting filter students with highest chemistry grades:");
        testFilterStudentsHighestChemistryGrade();

        System.out.println("\nTesting filter students with lowest chemistry grades:");
        testFilterStudentsLowestChemistryGrade();

        System.out.println("\nTesting filter students with highest average grades:");
        testFilterStudentsHighestAverageGrade();

        System.out.println("\nTesting filter students with lowest average grades:");
        testFilterStudentsLowestAverageGrade();
    }

    public static void init() {
        String filePath = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2\\src" +
                "\\hus\\oop\\finalexam\\de2\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String studentIds = studentManager.idOfStudentsToString(studentManager.getStudentList());
        System.out.println(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        List<Student> sortedList = studentManager.sortYearOfBirthIncreasing();
        studentManager.print(sortedList);
    }

    public static void testSortYearOfBirthDecreasing() {
        List<Student> sortedList = studentManager.sortYearOfBirthDecreasing();
        studentManager.print(sortedList);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        List<Student> sortedList = studentManager.sortMathsGradeIncreasing();
        studentManager.print(sortedList);
    }

    public static void testSortMathsGradeDecreasing() {
        List<Student> sortedList = studentManager.sortMathsGradeDecreasing();
        studentManager.print(sortedList);
    }

    public static void testSortPhysicsGradeIncreasing() {
        List<Student> sortedList = studentManager.sortPhysicsGradeIncreasing();
        studentManager.print(sortedList);
    }

    public static void testSortPhysicsGradeDecreasing() {
        List<Student> sortedList = studentManager.sortPhysicsGradeDecreasing();
        studentManager.print(sortedList);
    }

    public static void testSortChemistryGradeIncreasing() {
        List<Student> sortedList = studentManager.sortChemistryGradeIncreasing();
        studentManager.print(sortedList);
    }

    public static void testSortChemistryGradeDecreasing() {
        List<Student> sortedList = studentManager.sortChemistryGradeDecreasing();
        studentManager.print(sortedList);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        List<Student> filteredList = studentManager.filterStudentsHighestMathsGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        List<Student> filteredList = studentManager.filterStudentsLowestMathsGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        List<Student> filteredList = studentManager.filterStudentsHighestPhysicsGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        List<Student> filteredList = studentManager.filterStudentsLowestPhysicsGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        List<Student> filteredList = studentManager.filterStudentsHighestChemistryGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        List<Student> filteredList = studentManager.filterStudentsLowestChemistryGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        List<Student> filteredList = studentManager.filterStudentsHighestAverageGrade(10);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        List<Student> filteredList = studentManager.filterStudentsLowestAverageGrade(10);
        studentManager.print(filteredList);
    }
}
