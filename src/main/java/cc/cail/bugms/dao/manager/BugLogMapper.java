package cc.cail.bugms.dao.manager;

import cc.cail.bugms.dao.entity.BugLog;
import cc.cail.bugms.dao.entity.BugLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BugLogMapper {
    int countByExample(BugLogExample example);

    int deleteByExample(BugLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BugLog record);

    int insertSelective(BugLog record);

    List<BugLog> selectByExample(BugLogExample example);

    BugLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BugLog record, @Param("example") BugLogExample example);

    int updateByExample(@Param("record") BugLog record, @Param("example") BugLogExample example);

    int updateByPrimaryKeySelective(BugLog record);

    int updateByPrimaryKey(BugLog record);
}