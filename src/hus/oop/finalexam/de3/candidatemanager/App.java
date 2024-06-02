package hus.oop.finalexam.de3.candidatemanager;

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
        là <TenSinhVien_MaSinhVien_CandidateManager>.txt (Ví dụ, NguyenVanA_123456_CandidateManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_CandidateManager>.zip (Ví dụ, NguyenVanA_123456_CandidateManager.zip),
        nộp lên classroom.
         */
        System.out.println("\nTesting the original data:");
        testOriginalData();

        System.out.println("\nTesting sorting students by increasing maths grades:");
        testSortMathsGradeIncreasing();

        System.out.println("\nTesting sorting students by decreasing maths grades:");
        testSortMathsGradeDecreasing();

        System.out.println("\nTesting sorting students by increasing average grades:");
        testSortAverageGradeIncreasing();

        System.out.println("\nTesting sorting students by decreasing average grades:");
        testSortAverageGradeDecreasing();

        System.out.println("\nTesting filtering students with the highest maths grades:");
        testFilterStudentsHighestMathsGrade();

        System.out.println("\nTesting filtering students with the lowest maths grades:");
        testFilterStudentsLowestMathsGrade();

        System.out.println("\nTesting filtering students with the highest average grades:");
        testFilterStudentsHighestAverageGrade();

        System.out.println("\nTesting filtering students with the lowest average grades:");
        testFilterStudentsLowestAverageGrade();
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

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        MyList sortedList = StudentManager.getInstance().sortMathsGradeIncreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        MyList sortedList = StudentManager.getInstance().sortMathsGradeDecreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        MyList sortedList = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        MyList sortedList = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(sortedList);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        /* TODO */
        MyList filteredList = StudentManager.getInstance().filterStudentsHighestMathsGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        /* TODO */
        MyList filteredList = StudentManager.getInstance().filterStudentsLowestMathsGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        MyList filteredList = StudentManager.getInstance().filterStudentsHighestAverageGrade(10);
        StudentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        MyList filteredList = StudentManager.getInstance().filterStudentsLowestAverageGrade(10); 
        StudentManager.print(filteredList);
    }
}
