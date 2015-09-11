package cc.cail.bugms.dao.manager;

import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BugMapper {
	int countByExample(BugExample example);

	int deleteByExample(BugExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Bug record);

	int insertSelective(Bug record);

	List<Bug> selectByExample(BugExample example);

	Bug selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Bug record, @Param("example") BugExample example);

	int updateByExample(@Param("record") Bug record, @Param("example") BugExample example);

	int updateByPrimaryKeySelective(Bug record);

	int updateByPrimaryKey(Bug record);

	List<Map<String, Object>> listTestersBug(Integer testId);

	List<Map<String, Object>> listDevBug(Integer devId);
}