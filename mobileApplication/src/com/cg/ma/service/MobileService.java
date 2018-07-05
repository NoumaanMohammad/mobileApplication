package com.cg.ma.service;

import java.util.List;

import com.cg.ma.dto.Mobiledto;
import com.cg.ma.exception.MobileException;

public interface MobileService {
	List<Mobiledto> getAllMobiles() throws MobileException;
     Mobiledto SearchMobile(int mid) throws MobileException;
	int insertmobile(Mobiledto mobile) throws MobileException ;

}
