package com.votes.server;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votes.schema.Candidates;


public interface CandidateServer {
	public List<Candidates> findCandidates();
	Long AddVotes(double money,String code,int candidatesId);
	HashMap findCandidatesByCode(String code);
}
