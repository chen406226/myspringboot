package com.soul.dao;

import com.soul.entity.SysEntity;

public interface SysDao {
	public void saveSys(SysEntity sys);
	public SysEntity findById(int id);
	public int updateSys(SysEntity sys);
}
