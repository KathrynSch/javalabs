package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import com.daoapi.NurseryDao;
import com.daoimpl.EntityImpl;
 
@Repository("NurseryDao")
@Transactional
public class NurseryImpl extends EntityImpl<NurseryImpl> implements NurseryDao {
 
    @Autowired
    SessionFactory session;
 
   
}