package com.base.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.base.model.Res_Data;;

@Repository
public class Res_Dao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(Res_Data rec_data ){
		System.out.println("This is Dao Layer");
		hibernateTemplate.saveOrUpdate(rec_data);
	}
	
	public List<Res_Data> viewAll(){
		
		String sql="from Res_Data";
		
		@SuppressWarnings("unchecked")
		List<Res_Data> list=(List<Res_Data>) hibernateTemplate.execute(s -> {
			Query<?> q=s.createQuery(sql);
			return q;
		}).list();
		
		return list; 
	}
	
}
