package in.srikanth.util;

import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;

public class CaptchaUtil {
	// Create Captcha Object
	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height).addBackground(new GradiatedBackgroundProducer())
				.addText(new DefaultTextProducer()).addNoise(new CurvedLineNoiseProducer()).build();
	}

	// Convert to Binary String
	public static String encodeBase64(Captcha captcha) {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String imageData = null;

		try {
			ImageIO.write(captcha.getImage(), "png", os);
			byte[] bArray = Base64.getEncoder().encode(os.toByteArray());
			imageData = new String(bArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageData;
	}
}
