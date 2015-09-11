package hest.co.kr;
interface IMyRemoteService {
	String getMyRemoteMsg();
	String showMyRemoteMsg(String msg);
	void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
	double aDouble, String aString);
}