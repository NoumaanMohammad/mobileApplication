package com.cg.ma.service;

import java.util.List;

import com.cg.ma.dao.MobiledaoImpl;
import com.cg.ma.dto.Mobiledto;
import com.cg.ma.exception.MobileException;

public class MobileServiceImpl implements MobileService{
  
    MobiledaoImpl dao=new MobiledaoImpl();
    
	@Override
	public List<Mobiledto> getAllMobiles() throws MobileException {
		return dao.getAllMobiles();
	}

	@Override
	public Mobiledto SearchMobile(int mid) throws MobileException {
		return dao.searchMobile(mid);
	}

	@Override
	public int insertmobile(Mobiledto mobile) throws MobileException {
		return dao.insertMobile(mobile);
	}

	
}
