package com.votes.server;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votes.schema.Candidates;
import com.votes.schema.Product;
import com.votes.schema.Votes;


public interface CandidateServer {
	public List<Candidates> findCandidates(int productId);
	Long AddVotes(double money,String code,String name,int candidatesId,int productId);
	HashMap findCandidatesByCode(String code,int productId);
	public List<Object> findProductAll();
	public List<Object> findTwitterAll();
	public List<Votes> findVoteDetail(int productId,int candidateId);
	public HashMap findObjByProperty(Object isBig,Object symbol);
}
