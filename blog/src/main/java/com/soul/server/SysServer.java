package com.soul.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soul.dao.SysDao;
import com.soul.entity.SysEntity;

@Service
public class SysServer {
	@Autowired
	private SysDao sysDao;
	
	public SysEntity findById(int id){
		SysEntity sys = sysDao.findById(id);
		if (sys==null) {
			SysEntity sy = new SysEntity(1,"");
			saveSys(sy);
			return sy;
		}
		return sys;
	}
	
	public void saveSys(SysEntity sys){
		sysDao.saveSys(sys);
	}
	
	public int updateSys(SysEntity sys){
		sysDao.updateSys(sys);
		return 1;
	}
}
