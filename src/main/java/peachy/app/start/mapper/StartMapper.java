package peachy.app.start.mapper;

import org.apache.ibatis.annotations.Mapper;

import peachy.app.start.vo.AppInfoVo.AppActionData;
import peachy.app.start.vo.AppInfoVo.AppInfoRequest;

@Mapper
public interface StartMapper {

	void updateUserAppInfo(AppInfoRequest requestVo);

	String getAppInfo(AppInfoRequest requestVo);

	AppActionData getActionData(AppInfoRequest requestVo);

}
