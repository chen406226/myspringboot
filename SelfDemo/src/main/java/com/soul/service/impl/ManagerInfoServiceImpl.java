package com.soul.service.impl;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soul.domain.ManagerInfo;
import com.soul.mapper.ManagerInfoMapper;
import com.soul.server.ManagerInfoService;


@Service
@Transactional
public class ManagerInfoServiceImpl implements ManagerInfoService{
	
	@Autowired
	public ManagerInfoMapper managerInfomapper;
	
	@Override
	public ManagerInfo findByUsername(String username) {
		System.out.println("--------------------------------------------------------"+username);
		ManagerInfo managerInfo = managerInfomapper.findByUsername(username);
		if (managerInfo == null) {
			System.out.println("-----------------------------------------null");
			throw new UnknownAccountException();
		}
		return managerInfo;
	}
}
