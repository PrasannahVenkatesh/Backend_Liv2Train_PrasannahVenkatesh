package com.senpiper.liv2train.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senpiper.liv2train.ENTITY.AddressEntity;
@Repository
public interface AddressDAO extends JpaRepository<AddressEntity,Serializable>{
	


}
