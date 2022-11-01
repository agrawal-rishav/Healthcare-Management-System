package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Tblcontactus;
import com.HMS.HealthCare.Repository.TblcontactusRepository;

@Service
public class TblcontactusService {
    
    @Autowired
    private TblcontactusRepository tblcontactusRepository;

    public List<Tblcontactus> getUnreadQueries() {
        Iterable<Tblcontactus> it = tblcontactusRepository.findAll();
        List<Tblcontactus> li = new ArrayList<>();
        Long count = 1l;
        for(Tblcontactus query : it) {
            if(query.getIsread() == null) {
                Tblcontactus con = new Tblcontactus(count++, query.getFullname(), query.getEmail(), 
                                                        query.getContactno(), query.getMessage());
                li.add(con);
            }
        }
        return li;
    }

    public List<Tblcontactus> getReadQueries() {
        Iterable<Tblcontactus> it = tblcontactusRepository.findAll();
        List<Tblcontactus> li = new ArrayList<>();
        Long count = 1l;
        for(Tblcontactus query : it) {
            if(query.getIsread() != null) {
                Tblcontactus con = new Tblcontactus(count++, query.getFullname(), query.getEmail(), 
                                                    query.getContactno(), query.getMessage());
                li.add(con);
            }
        }
        return li;
    }

    public Tblcontactus getQuery(String email) {
        Iterable<Tblcontactus> it = tblcontactusRepository.findAll();
        for(Tblcontactus q : it) {
            if(q.getEmail().equalsIgnoreCase(email))
                return q;
        }
        return null;
    }

    public Tblcontactus getById(Long id) {
        return tblcontactusRepository.findById(id).get();
    }

    public void saveQuery(Tblcontactus tbl) {
        tblcontactusRepository.save(tbl);
    }

}
