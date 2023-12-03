public class PostgreConn {
    private final String driver = "org.postgresql.Driver";
    private final String user = "postgres";
    private final String password = "hoangvu@123";
    private final String connUrl = "jdbc:postgresql://localhost/my_db";

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getConnUrl() {
        return connUrl;
    }
}
