
import java.sql.DriverManager;

public class Example5 {

    public static void main(String[] args) {
        try {
            var url = "jdbc:mysql://localhost:3306/testDB";
            Class.forName("com.mysql.cj.jdbc.Driver");
            var conn = DriverManager.getConnection(url, "root", "1234");

            if (conn != null) {
                var st = conn.createStatement();
                var query = "SELECT * FROM students";
                var res = st.executeQuery(query);

                while (res.next()) {
                    System.out.println(res.getString("studentFirstName"));
                    System.out.println(res.getString("studentLastName"));
                    System.out.println(res.getString("studentNo"));
                }
            }

        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
}
