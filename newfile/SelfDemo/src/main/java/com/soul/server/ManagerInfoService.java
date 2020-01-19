package com.soul.server;

import com.soul.domain.ManagerInfo;

public interface ManagerInfoService {
	
	public ManagerInfo findByUsername(String username);
	
}
