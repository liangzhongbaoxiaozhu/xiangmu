package com.lzb.service;




/**
 * ��֤��֪ͨ���Žӿ�
 * 
 * @ClassName: IndustrySMS
 * @Description: ��֤��֪ͨ���Žӿ�
 *
 */
public class IndustrySMS{
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = Config.ACCOUNT_SID;
	/*private static String smsContent = "��Ϧ�����װ�꡿������֤��Ϊ{"+num+"}������{2}��������ȷ���룬��Ǳ��˲���������Դ˶��š�";*/
	/**
	 * ��֤��֪ͨ����
	 */
	
	
	//   �û�������ֻ��ź�������ɵ���֤�봫����
	public static String execute(String to,Integer code)
	{
		String url = Config.BASE_URL + operation;
		 String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + 
				 "�������г��������ġ�������֤��Ϊ{"+code+"}������{2}��������ȷ���룬��Ǳ��˲���������Դ˶��š�"+ HttpUtil.createCommonParam();
		// �ύ����
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.getProperty("line.sepatator") + result);
		
		return result;
	}

}
