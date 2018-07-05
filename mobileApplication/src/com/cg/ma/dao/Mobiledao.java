package com.cg.ma.dao;
import java.util.List;

import com.cg.ma.dto.Mobiledto;
import com.cg.ma.exception.MobileException;


public interface Mobiledao {
int insertMobile(Mobiledto mobile) throws MobileException;
List<Mobiledto> getAllMobiles()  throws MobileException;
Mobiledto searchMobile(int mid) throws MobileException;
}
