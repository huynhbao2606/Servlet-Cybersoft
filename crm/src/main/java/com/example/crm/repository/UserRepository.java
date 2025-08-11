package com.example.crm.repository;

import com.example.crm.config.MySQLConfig;
import com.example.crm.entity.Role;
import com.example.crm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    Connection conn = MySQLConfig.getConnection();

    public List<User> findAll(){
        List<User> listUsers = new ArrayList<>();

        String query = "SELECT * FROM users u JOIN roles r ON u.role_id = r.id";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setAvatar(rs.getString("avatar"));

                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));

                user.setRole(role);


                listUsers.add(user);
            }
        }catch (SQLException e) {
            System.out.println("Lỗi thực thi câu truy vấn: " + e.getMessage());
        }

        return listUsers;
    }
}
