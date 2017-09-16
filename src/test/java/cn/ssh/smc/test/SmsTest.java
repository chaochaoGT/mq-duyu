package cn.ssh.smc.test;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.alidayu.send.message.SmsSystemCode;


public class SmsTest {
	public static void main(String[] args) {

//		code("15850002095");
//		text("15850002095");
	}

	public static void code(String tel){
		try {
			SendSmsResponse response = SmsSystemCode.sendSms(tel,RandCodeUtils.getCode());

			System.out.println("短信接口返回的数据----------------");

			System.out.println("Message=" + response.getMessage());

		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void text(String tel){
//		try {
//			SendSmsResponse response = SmsSystemText.sendSms(tel,"fasdfasdfasdf");
//
//			System.out.println("短信接口返回的数据----------------");
//
//			System.out.println("Message=" + response.getMessage());
//
//		} catch (ClientException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
