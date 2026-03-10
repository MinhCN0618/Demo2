package com.example.Minhcnth06118.repository;

import com.example.Minhcnth06118.entity.SanPham;
import com.example.Minhcnth06118.util.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class repoSP {
    private Session session = null;

    public repoSP(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SanPham> getAll(){
        return session.createQuery("SELECT sp FROM SanPham sp").list();
    }

    public SanPham getByID(int id){
        return session.find(SanPham.class, id);
    }

    public void them(SanPham sanPham){
        try {
            session.getTransaction().begin();
            session.save(sanPham);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void sua(SanPham sanPham){
        try {
            session.getTransaction().begin();
            session.merge(sanPham);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public List<SanPham> timKiem(String ten){
//        return session.createQuery("SELECT sp FROM SanPham sp").list();
        Query query = session.createQuery("SELECT sp FROM SanPham sp WHERE sp.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        return query.getResultList();
    }

    public List<SanPham> phanTrang(int page, int size){
        Query query = session.createQuery("SELECT sp FROM SanPham sp");
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return query.getResultList();
    }
}
