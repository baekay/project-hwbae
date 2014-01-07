package kr.ac.hanrw.webapp.common;

import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.User;
import kr.ac.hanrw.webapp.utils.CryptoHelper;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.StringUtils;

public class AccessTokenHandler {
	static public AccessToken generate(User user)
	{
		AccessToken ac = new AccessToken();
		
		long timestamp = System.currentTimeMillis();
		String strTimestamp = DateFormatUtils.format(timestamp, "yyyyMMddHHMMSS");
		String token = user.getUserId() + "|" + user.getRoleId() + "|" + user.getTelNo() + "|" + user.getEmail() + "|" + strTimestamp + "|" + "0";
		
		try {
			ac.setAccessToken(CryptoHelper.encrypt(token));
		} catch (Exception e) {
			return null;
		}
		return ac;
	}
	
	static public User parseAccessToken(AccessToken ac) {
		String token = ac.getAccessToken();
		User user = new User();
		
		try {
			String decToken = CryptoHelper.decrypt(token);
			String[] tokens = StringUtils.delimitedListToStringArray(decToken, "|");
			user.setUserId(tokens[0]);
			user.setRoleId(tokens[1]);
			user.setTelNo(tokens[2]);
			user.setEmail(tokens[3]);
            user.setLoginTime(tokens[4]);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return user;
	}
}
