package hus.oop.finalexam.de3.candidatemanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.append(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insert(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return (Student) studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * @return
     */
    public MyList sortMathsGradeIncreasing() {
        /* TODO */
        MyList sortedList = copyList();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Student left = (Student) sortedList.get(j);
                Student right = (Student) sortedList.get(j + 1);
                if (left.getMathsGrade() > right.getMathsGrade()) {
                    Object temp = sortedList.get(j);
                    sortedList.set(sortedList.get(j + 1), j);
                    sortedList.set(temp, j + 1);
                }
            }
        }
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public MyList sortMathsGradeDecreasing() {
        /* TODO */
        MyList sortedList = copyList();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Student left = (Student) sortedList.get(j);
                Student right = (Student) sortedList.get(j + 1);
                if (left.getMathsGrade() < right.getMathsGrade()) {
                    Object temp = sortedList.get(j);
                    sortedList.set(sortedList.get(j + 1), j);
                    sortedList.set(temp, j + 1);
                }
            }
        }
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public MyList sortAverageGradeIncreasing() {
        /* TODO */
        MyList sortedList = copyList();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Student left = (Student) sortedList.get(j);
                Student right = (Student) sortedList.get(j + 1);
                if (left.getAverageGrade() > right.getAverageGrade()) {
                    Object temp = sortedList.get(j);
                    sortedList.set(sortedList.get(j + 1), j);
                    sortedList.set(temp, j + 1);
                }
            }
        }
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public MyList sortAverageGradeDecreasing() {
        /* TODO */
        MyList sortedList = copyList();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Student left = (Student) sortedList.get(j);
                Student right = (Student) sortedList.get(j + 1);
                if (left.getAverageGrade() < right.getAverageGrade()) {
                    Object temp = sortedList.get(j);
                    sortedList.set(sortedList.get(j + 1), j);
                    sortedList.set(temp, j + 1);
                }
            }
        }
        return sortedList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        MyList filteredList = sortMathsGradeDecreasing();
        int min = Math.min(howMany, filteredList.size());
        MyList result = new MyArrayList();
        for (int i = 0; i < min; i++) {
            result.append(filteredList.get(i));
        }

        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        MyList filteredList = sortMathsGradeIncreasing();
        int min = Math.min(howMany, filteredList.size());
        MyList result = new MyArrayList();
        for (int i = 0; i < min; i++) {
            result.append(filteredList.get(i));
        }

        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        MyList filteredList = sortAverageGradeDecreasing();
        int min = Math.min(howMany, filteredList.size());
        MyList result = new MyArrayList();
        for (int i = 0; i < min; i++) {
            result.append(filteredList.get(i));
        }

        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        MyList filteredList = sortAverageGradeIncreasing();
        int min = Math.min(howMany, filteredList.size());
        MyList result = new MyArrayList();
        for (int i = 0; i < min; i++) {
            result.append(filteredList.get(i));
        }

        return result;
    }

    public MyList copyList() {
        MyList myList = new MyArrayList();
        for (int i = 0; i < studentList.size(); i++) {
            myList.append(studentList.get(i));
        }
        return myList;
    }

    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
