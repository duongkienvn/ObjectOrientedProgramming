package hus.oop.finalexam.de3.studentmanager;

import java.util.*;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        studentList = new LinkedList<>();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        this.studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        this.studentList.add(index, student);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        this.studentList.remove(student);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự năm sinh tăng dần.
     * @return
     */
    public List<Student> sortYearOfBirthIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return left.getYearOfBirth() - right.getYearOfBirth();
            }
        });
        return newList;
    }

    /**
     * Sắp xếp sinh viên theo thứ tự năm sinh giảm dần.
     * @return
     */
    public List<Student> sortYearOfBirthDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return right.getYearOfBirth() - left.getYearOfBirth();
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * @return
     */
    public List<Student> sortMathsGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                if (left.getMathsGrade() > right.getMathsGrade()) {
                    return 1;
                } else if (left.getMathsGrade() < right.getMathsGrade()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public List<Student> sortMathsGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                if (right.getMathsGrade() > left.getMathsGrade()) {
                    return 1;
                } else if (right.getMathsGrade() < left.getMathsGrade()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý tăng dần.
     * @return
     */
    public List<Student> sortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getPhysicsGrade));
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý giảm dần.
     * @return
     */
    public List<Student> sortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getPhysicsGrade).reversed());
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa tăng dần.
     * @return
     */
    public List<Student> sortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getChemistryGrade));
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa giảm dần.
     * @return
     */
    public List<Student> sortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getChemistryGrade).reversed());
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public List<Student> sortAverageGradeIncreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getAverageGrade));
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public List<Student> sortAverageGradeDecreasing() {
        /* TODO */
        List<Student> sortedList = new LinkedList<>(this.studentList);
        sortedList.sort(Comparator.comparingDouble(Student::getAverageGrade).reversed());
        return sortedList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm lý cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestPhysicsGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortPhysicsGradeDecreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra những sinh viên có điểm lý cao hơn lowerBoundGrade.
     * @param lowerBoundGrade
     * @return
     */
    public List<Student> filterStudentsHigherThanPhysicsGrade(double lowerBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getPhysicsGrade() > lowerBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm lý thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestPhysicsGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortPhysicsGradeIncreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm lý thấp hơn upperBoundGrade.
     * @param upperBoundGrade
     * @return
     */
    public List<Student> filterStudentsLowerThanPhysicsGrade(double upperBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getPhysicsGrade() < upperBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortMathsGradeDecreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao thấp hơn lowerBoundGrade.
     * @param lowerBoundGrade
     * @return
     */
    public List<Student> filterStudentsHigherThanMathsGrade(int lowerBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getMathsGrade() > lowerBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortMathsGradeIncreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp hơn upperBoundGrade.
     * @param upperBoundGrade
     * @return
     */
    public List<Student> filterStudentsLowerThanMathsGrade(double upperBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getMathsGrade() < upperBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm hóa cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestChemistryGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortChemistryGradeDecreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm hóa cao hơn lowerBoundGrade.
     * @param lowerBoundGrade
     * @return
     */
    public List<Student> filterStudentsHigherThanChemistryGrade(int lowerBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getChemistryGrade() > lowerBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm hóa thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestChemistryGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortChemistryGradeIncreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm hóa thấp hơn upperBoundGrade.
     * @param upperBoundGrade
     * @return
     */
    public List<Student> filterStudentsLowerThanChemistryGrade(int upperBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getChemistryGrade() < upperBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortAverageGradeDecreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));
    }

    /**
     * Lọc ra howMany sinh viên có điểm bình cao hơn lowerBoundGrade.
     * @param lowerBoundGrade
     * @return
     */
    public List<Student> filterStudentsHigherThanAverageGrade(int lowerBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getAverageGrade() > lowerBoundGrade).toList();
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        List<Student> filtered = sortAverageGradeIncreasing();
        return new ArrayList<>(filtered.subList(0, Math.min(howMany, filtered.size())));

    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp hơn upperBoundGrade.
     * @param upperBoundGrade
     * @return
     */
    public List<Student> filterStudentsLowerThanAverageGrade(int upperBoundGrade) {
        /* TODO */
        List<Student> filteredList = new ArrayList<>(studentList);
        return filteredList.stream().filter(student -> student.getAverageGrade() < upperBoundGrade).toList();
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
