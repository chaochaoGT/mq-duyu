package cn.ssh.bos.activemq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.stereotype.Component;

import com.aliyuncs.exceptions.ClientException;

import cn.alidayu.send.message.SmsSystemCode;

@Component("smsConsumerCode")
public class SmsConsumerCode implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			String tel = ((MapMessage)message).getString("telphone");
			String code = ((MapMessage)message).getString("code");
			SendSmsResponse smsResponse = SmsSystemCode.sendSms(tel, code);
			System.out.println("短信发送==>"+smsResponse.getMessage());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
