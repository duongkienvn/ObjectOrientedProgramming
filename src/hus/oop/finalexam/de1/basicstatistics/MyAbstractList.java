package hus.oop.finalexam.de1.basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append("[").append(get(i)).append("]");
            if (i != size() - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
