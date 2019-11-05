package com.votes.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.votes.schema.Candidates;

//@Mapper
public interface CandidateMapper {
	public List<Candidates> findCandidates();
	public Long AddVotes(@Param("money") double money,@Param("code") String code,@Param("candidatesId") int candidatesId);
	public HashMap findCandidatesByCode(@Param("code") String code);
}
