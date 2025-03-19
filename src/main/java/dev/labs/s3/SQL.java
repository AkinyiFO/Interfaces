package dev.labs.s3;

// Contract
public interface SQL {
    void connect(String url, String user, String password);
    void executeQuery(String query);
    void closeConnection();
}
