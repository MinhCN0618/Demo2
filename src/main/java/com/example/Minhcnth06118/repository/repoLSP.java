package com.example.Minhcnth06118.repository;

import com.example.Minhcnth06118.entity.LoaiSP;
import com.example.Minhcnth06118.entity.SanPham;
import com.example.Minhcnth06118.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class repoLSP {
    private Session session = null;

    public repoLSP(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<LoaiSP> getAll(){
        return session.createQuery("SELECT lsp FROM LoaiSP lsp").list();
    }

    public LoaiSP getByID(int id){
        return session.find(LoaiSP.class, id);
    }
}
