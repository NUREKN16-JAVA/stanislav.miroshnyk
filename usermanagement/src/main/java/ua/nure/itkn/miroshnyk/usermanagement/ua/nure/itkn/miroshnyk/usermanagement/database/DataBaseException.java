package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement.database;

public class DataBaseException extends Exception {
    private String name;

    DataBaseException (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
