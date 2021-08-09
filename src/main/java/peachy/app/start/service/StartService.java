package peachy.app.start.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import peachy.app.start.mapper.StartMapper;
import peachy.app.start.vo.AppInfoVo.AppData;
import peachy.app.start.vo.AppInfoVo.AppInfoRequest;
import peachy.app.start.vo.AppInfoVo.AppInfoResponse;
import peachy.app.start.vo.ResultCode;

@Service
public class StartService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private StartMapper mapper;
	
	public AppInfoResponse updateAppInfo(AppInfoRequest requestVo) {
		if (StringUtils.isNotEmpty(requestVo.getUserSeq())) mapper.updateUserAppInfo(requestVo);
		
		AppData appData = new AppData();
		appData.setAppVersion(mapper.getAppInfo(requestVo));
		appData.setActionData(mapper.getActionData(requestVo));
		
		return new AppInfoResponse(appData, 
				ResultCode.success, 
				messageSource.getMessage(ResultCode.success, null, LocaleContextHolder.getLocale()));
	}

}
