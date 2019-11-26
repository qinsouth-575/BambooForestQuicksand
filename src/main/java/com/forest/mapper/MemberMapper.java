package com.forest.mapper;

import com.forest.entity.Member;
import com.forest.entity.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    
    List <Member> queryAllByPage(Member m);
    
    int insertMember(Member m);
    
    Member queryById(int MemberId);
    
    int updateById(Member m);
    
    int updatebi(Member m);
    
    int queryCont(int MemberId);
}