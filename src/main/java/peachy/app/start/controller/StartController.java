package peachy.app.start.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import peachy.app.start.service.StartService;
import peachy.app.start.vo.AppInfoVo.AppInfoRequest;
import peachy.app.start.vo.AppInfoVo.AppInfoResponse;

@RestController
@Tag(name = "앱 구동 API", description = "앱 구동 시 받아햘 데이터를 주는 API")
public class StartController {
	
	@Autowired
	private StartService service;
	
	@PostMapping("/getAppInfo")
	@Operation(summary = "앱정보조회", description = "서버에서 필요한 데이터를 받고 App에 필요한 데이터 넘김")
    public AppInfoResponse getAppInfo(@RequestBody @Valid AppInfoRequest requestVo) throws Exception {
    	return service.updateAppInfo(requestVo);
	}
}
