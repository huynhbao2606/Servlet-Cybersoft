package com.example.crm.repository;

import com.example.crm.config.MySQLConfig;
import com.example.crm.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    Connection conn = MySQLConfig.getConnection();

    public List<Role> findAll(){
        List<Role> listRoles = new ArrayList<>();

        String query = "SELECT * FROM roles";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));
                listRoles.add(role);
            }
        }catch (SQLException e){
            System.out.println("Lỗi thực thi câu truy vấn: " + e.getMessage());
        }

        return listRoles;
    }
}
