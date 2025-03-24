package dev.labs.s3;

// Define the SQLAllParts interface
interface SQLAllParts {

    // Constants
    // All constant values defined in an interface are implicitly public, static, and final, so those modifiers are unnecessary.
    String DEFAULT_URL = "jdbc:mysql://localhost:3306/default_db";
    String DEFAULT_USER = "root";
    String DEFAULT_PASSWORD = "";

    // Abstract methods - Declared without an implementation.
    // Terminated by a semicolon.
    void connect(String url, String user, String password);
    void executeQuery(String query);
    void closeConnection();

    // Default method (provides a standard way to connect with default credentials)
    default void connectWithDefaults() {
        connect(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
    }

    // Static method (utility function to validate SQL queries)
    static boolean isValidQuery(String query) {
        return query != null && query.trim().length() > 0;
    }

    // abstract, default, and static methods in an interface are implicitly public, so the public modifier is not required.

    // Nested Type: Enum representing different SQL operation types
    enum SQLOperation {
        SELECT, INSERT, UPDATE, DELETE
    }

    // Nested interface for transaction management
    interface TransactionHandler {
        void beginTransaction();
        void commitTransaction();
        void rollbackTransaction();
    }

    // Nested static class providing default configurations
    class DefaultConfig {
        static String getDefaultSchema() {
            return "public";
        }
    }
}
