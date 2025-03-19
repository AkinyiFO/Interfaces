package dev.labs.s3;

public class Main {
    public static void main(String[] args) {
        // Objects from blueprint Database
        Database oracle = new Database();

        // Invoke methods
        oracle.printStatus();

        // Access a field
        System.out.println(oracle.getPassword());

        MySQL mysql = new MySQL();
        mysql.connect("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
        mysql.executeQuery("SELECT * FROM users");
        mysql.closeConnection();
    }
}