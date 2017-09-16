package cn.ssh.bos.activemq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import cn.alidayu.send.message.SmsSystemTextStaff;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.stereotype.Component;

import com.aliyuncs.exceptions.ClientException;


@Component("smsConsumerStaff")
public class SmsConsumerStaff implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			String telephone = ((MapMessage)message).getString("telephone");
			String staffname = ((MapMessage)message).getString("staffname");
			String username = ((MapMessage)message).getString("username");
			String utel = ((MapMessage)message).getString("utel");
			String addr = ((MapMessage)message).getString("addr");
			SendSmsResponse resp = SmsSystemTextStaff.sendSmsText(telephone,staffname,username,utel,addr);
			System.out.println("短信发送==="+resp.getMessage());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
