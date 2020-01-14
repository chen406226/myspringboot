package com.votes.server.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votes.mapper.CandidateMapper;
import com.votes.schema.Candidates;
import com.votes.schema.Product;
import com.votes.schema.Votes;
import com.votes.server.CandidateServer;


@Service
@Transactional
public class CandidateServerImpl implements CandidateServer{
	@Autowired
	private CandidateMapper candidateMapper;
	
	public List<Candidates> findCandidates(int productId){
		return candidateMapper.findCandidates(productId);
	};
	public Long AddVotes(double money,String code,String name,int candidatesId,int productId){
		return candidateMapper.AddVotes(money,code,name,candidatesId,productId);
	};
	public HashMap findCandidatesByCode(String code,int productId){
		return candidateMapper.findCandidatesByCode(code,productId);
	};
	public List<Object> findProductAll(){
		return candidateMapper.findProductAll();
	};
	public List<Object> findTwitterAll(){
		return candidateMapper.findTwitterAll();
	};
	
	public List<Votes> findVoteDetail(int productId,int candidateId){
		return candidateMapper.findVoteDetail(productId,candidateId);
	};
	public HashMap findObjByProperty(Object isBig,Object symbol){
		return candidateMapper.findObjByProperty(isBig,symbol);
	};
}
