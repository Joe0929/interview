import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class WebSeverTest{
    public String add_user(String login,String name,String password){
        String status=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=null;
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","qiao1234");
            PreparedStatement ps =conn.prepareStatement("insert into adduser values('"+login+""+name+"','"+password+"')");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            status="用户已存在";
            e.printStackTrace();
        }
        return status;
    }
}