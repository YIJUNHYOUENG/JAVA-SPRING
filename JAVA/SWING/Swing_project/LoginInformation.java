package s1019;

public class LoginInformation {
	
	// 회원 정보 저장 창
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getIdArr() {
		return idArr;
	}

	public void setIdArr(String[] idArr) {
		this.idArr = idArr;
	}

	public String[] getPwArr() {
		return pwArr;
	}

	public void setPwArr(String[] pwArr) {
		this.pwArr = pwArr;
	}

	public String[] getNameArr() {
		return nameArr;
	}

	public void setNameArr(String[] nameArr) {
		this.nameArr = nameArr;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		LoginInformation.n = n;
	}

	public String id, pw, name;
	public static String[] idArr = new String[0];
	public static String[] pwArr = new String[0];
	public static String[] nameArr = new String[0];
	public static int n = 0;
	
	LoginInformation() {
	}
	
	LoginInformation(String id, String pw, String name) { // 값을 Login으로 보냄
		this.id = id;
		this.pw = pw;
		this.name = name;
		newArr(idArr,pwArr,nameArr);
		new Login(idArr, pwArr, nameArr);
	}
	
	public void newArr(String[] idArr, String[] pwArr, String[] nameArr) { // 회원가입 성공 시 배열을 추가
		n++;
		idArr = new String[n];
		pwArr = new String[n];
		nameArr = new String[n];
		for(int i=0;i<n;i++) {
			if(i<n-1) {
				idArr[i] = LoginInformation.idArr[i];
				pwArr[i] = LoginInformation.pwArr[i];
				nameArr[i] = LoginInformation.nameArr[i];
				System.out.println(idArr[i]);
			}
			else if(i==n-1) {
				idArr[i] = this.id;
				pwArr[i] = this.pw;
				nameArr[i] = this.name;
			}
		}
		LoginInformation.idArr = idArr;
		LoginInformation.pwArr = pwArr;
		LoginInformation.nameArr = nameArr;
	}

}
