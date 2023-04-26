package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	/*trên thị trường hiện nay ngta thường sử dụng 2 loại
	mã hóa là md5 và SHA-1
	*/
	public static String toSHA1(String str) {
		String salt = "jdhfksgn;/@ddg34jk/343.3435djf@";
		String result = null;
		str+=salt;
		
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

