package com.senpiper.liv2train.SERVICE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senpiper.liv2train.BEAN.Address;
import com.senpiper.liv2train.BEAN.EnrollmentBean;
import com.senpiper.liv2train.DAO.AddressDAO;
import com.senpiper.liv2train.DAO.EnrollmentDAO;
import com.senpiper.liv2train.ENTITY.AddressEntity;
import com.senpiper.liv2train.ENTITY.EnrollmentEntity;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService{
	
	@Autowired
	EnrollmentDAO dao;
	@Autowired
	AddressDAO adao;
	
	public void saveall(EnrollmentBean bean) {
		Address address = bean.getAddress();
		AddressEntity aentity = new AddressEntity();
		BeanUtils.copyProperties(address, aentity);
		EnrollmentEntity entity = new EnrollmentEntity();
		BeanUtils.copyProperties(bean, entity);
		entity.setAddress(aentity);
		dao.save(entity);
	}
	
	public List<EnrollmentBean> findall(){
		List<EnrollmentEntity> records = dao.findAll();
		List<EnrollmentBean> beanrecords = new ArrayList<EnrollmentBean>();
		for(EnrollmentEntity e: records) {
			EnrollmentBean bean = new EnrollmentBean();
			BeanUtils.copyProperties(e, bean);
			AddressEntity ar = adao.getById(e.getId());
			Address a = new Address();
			BeanUtils.copyProperties(ar, a);
			bean.setAddress(a);
			beanrecords.add(bean);
		}
		return beanrecords;
	}

}
