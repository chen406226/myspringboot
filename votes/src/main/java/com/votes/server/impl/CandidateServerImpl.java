package com.votes.server.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votes.mapper.CandidateMapper;
import com.votes.schema.Candidates;
import com.votes.server.CandidateServer;


@Service
@Transactional
public class CandidateServerImpl implements CandidateServer{
	@Autowired
	private CandidateMapper candidateMapper;
	
	public List<Candidates> findCandidates(){
		return candidateMapper.findCandidates();
	};
	public Long AddVotes(double money,String code,int candidatesId){
		return candidateMapper.AddVotes(money,code,candidatesId);
	};
	public HashMap findCandidatesByCode(String code){
		return candidateMapper.findCandidatesByCode(code);
	};
}
