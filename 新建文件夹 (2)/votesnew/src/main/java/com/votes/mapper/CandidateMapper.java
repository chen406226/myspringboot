package com.votes.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.votes.schema.Candidates;
import com.votes.schema.Product;
import com.votes.schema.Votes;

//@Mapper
public interface CandidateMapper {
	public List<Candidates> findCandidates(@Param("productId") int productId);
	public Long AddVotes(@Param("money") double money,@Param("code") String code,@Param("name") String name,@Param("candidatesId") int candidatesId,@Param("productId") int productId);
	public HashMap findCandidatesByCode(@Param("code") String code,@Param("productId") int productId);
	public List<Product> findProductAll();
	public List<Votes> findVoteDetail(@Param("productId") int productId,@Param("candidateId") int candidateId);
	public HashMap findObjByProperty(@Param("isBig") Object isBig,@Param("symbol") Object symbol);
}
