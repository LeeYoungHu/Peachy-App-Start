package peachy.app.start.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class AppInfoVo {
	
	@Data
	@Schema(title = "APP 정보")
	public static class AppData {
		@Schema(title = "APP 버전")
		private String appVersion;
		private AppActionData actionData;
	}
	
	@Data
	@Schema(title = "특이사항이 있을 때 App에서 해줘야 하는 행동 데이터")
	public static class AppActionData {
		@Schema(title = "보여줘야 할 메시지")
		private String msg;
		@Schema(title = "행동해야 할 Action 타입")
		private String actionType;
	}
	
	@Data
	public static class AppInfoRequest {
		@Schema(title = "회원 순번", example = "1")
		private String userSeq;
		@Schema(title = "기기ID", nullable = false)
		@NotNull@NotEmpty
		private String deviceId;	
		@Schema(title = "OS 버전", nullable = false)
		@NotNull@NotEmpty
		private String osVs;	
		@Schema(title = "기기 타입", nullable = false, allowableValues = {"A", "I"}, description = "A:안드로이드, I:IOS")
		@NotNull@NotEmpty
		private String deviceType;	
		@Schema(title = "APP 버전")		
		private String appVs;
		@Schema(title = "FCM 토큰", description = "에러 방지용, app에서 사용할 필요 없음")
		private String fcmToken;
	}
	
	@Getter
	@AllArgsConstructor
	@Schema(title = "초기 App 구동 응답 정보")
	public static class AppInfoResponse {
		private AppData data;
		private String resultCode;
		private String resultMsg;
	}

}
