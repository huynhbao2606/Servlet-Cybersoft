package com.example.crm.repository;

import com.example.crm.config.MySQLConfig;
import com.example.crm.entity.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    Connection conn = MySQLConfig.getConnection();

    public List<Job> findAll(){
        List<Job> listJobs = new ArrayList<>();

        String query = "SELECT * FROM jobs";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setName(rs.getString("name"));
                job.setStart_date(rs.getDate("start_date"));
                job.setEnd_date(rs.getDate("end_date"));
                listJobs.add(job);
            }
        }catch (SQLException e){
            System.out.println("Lỗi thực thi câu truy vấn: " + e.getMessage());
        }

        return listJobs;
    }
}
