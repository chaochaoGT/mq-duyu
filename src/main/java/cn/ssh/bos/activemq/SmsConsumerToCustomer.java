package cn.ssh.bos.activemq;

import cn.alidayu.send.message.SmsSystemTextCustomer;
import cn.alidayu.send.message.SmsSystemTextStaff;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;


@Component("smsConsumerCustomer")
public class SmsConsumerToCustomer implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			String telephone = ((MapMessage)message).getString("telephone");
			String staffname = ((MapMessage)message).getString("staffname");
			String username = ((MapMessage)message).getString("username");
			String stel = ((MapMessage)message).getString("stel");
			SendSmsResponse resp = SmsSystemTextCustomer.sendSmsText(telephone,username,staffname,stel);
			System.out.println("短信发送==="+resp.getMessage());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
