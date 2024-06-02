package hus.oop.finalexam.de3.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();
        /*
        TODO

        - Viết code để test cho tất cả các hàm bên dưới.
        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
        System.out.println("Testing original data:");
        testOriginalData();

        System.out.println("\nTesting sorting by year of birth in increasing order:");
        testSortYearOfBirthIncreasing();

        System.out.println("\nTesting sorting by year of birth in decreasing order:");
        testSortYearOfBirthDecreasing();

        System.out.println("\nTesting sorting by average grade in increasing order:");
        testSortAverageGradeIncreasing();

        System.out.println("\nTesting sorting by average grade in decreasing order:");
        testSortAverageGradeDecreasing();

        System.out.println("\nTesting filtering students with the highest maths grades:");
        testFilterStudentsHighestMathsGrade();

        System.out.println("\nTesting filtering students with the lowest maths grades:");
        testFilterStudentsLowestMathsGrade();

        System.out.println("\nTesting filtering students with the highest average grades:");
        testFilterStudentsHighestAverageGrade();

        System.out.println("\nTesting filtering students with the lowest average grades:");
        testFilterStudentsLowestAverageGrade();

        System.out.println("\nTesting filtering students with average grades higher than 7:");
        testFilterStudentsHigherThanAverageGrade();

        System.out.println("\nTesting filtering students with average grades lower than 9:");
        testFilterStudentsLowerThanAverageGrade();
    }

    public static void init() {
        String filePath = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2\\src\\hus\\oop\\" +
                "finalexam\\de3\\data\\students.csv";
        readListData(filePath);
    }

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
                StudentManager.getInstance().append(student);
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

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        List<Student> sortedList = StudentManager.getInstance().sortYearOfBirthIncreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortYearOfBirthDecreasing() {
        List<Student> sortedList = StudentManager.getInstance().sortYearOfBirthDecreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        List<Student> sortedList = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        List<Student> sortedList = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(sortedList);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        List<Student> filteredList = StudentManager.getInstance().filterStudentsHighestMathsGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        List<Student> filteredList = StudentManager.getInstance().filterStudentsLowestMathsGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        List<Student> filteredList = StudentManager.getInstance().filterStudentsHighestAverageGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        List<Student> filteredList = StudentManager.getInstance().filterStudentsLowestAverageGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsHigherThanAverageGrade() {
        /* TODO */
        List<Student> filteredList = StudentManager.getInstance().filterStudentsHigherThanAverageGrade(7);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsLowerThanAverageGrade() {
        /* TODO */
        List<Student> filteredList = StudentManager.getInstance().filterStudentsLowerThanAverageGrade(9);
        StudentManager.print(filteredList);
    }
}
