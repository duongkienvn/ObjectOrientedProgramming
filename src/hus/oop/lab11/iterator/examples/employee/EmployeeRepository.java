package hus.oop.lab11.iterator.examples.employee;

public class EmployeeRepository implements EmployeeIterable {
    public String[] employess;

    public EmployeeRepository() {
        employess = new String[]{"David", "Scott", "Rhett", "Andrew", "Jessica"};
    }

    @Override
    public Iterator getIterator() {
        return new EmployeeIterator();
    }

    private class EmployeeIterator implements Iterator {
        int position;

        public EmployeeIterator() {
            position = 0;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return employess[position++];
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return position < employess.length;
        }
    }
}
