package top.trial.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���CAPTCHA���ͼƬ��֤��
 * 
 * @author ������
 *
 */
public class CAPTCHAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CAPTCHAServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 250;
		int height = 60;
		// �����ڴ�ͼ��BufferedImage
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ��������Graphics
		Graphics g = bi.getGraphics();
		// ���߿�
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
		// ������ɫ
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width - 2, height - 2);
		// ��������
		int lineNum = 10;
		Random r = new Random();
		g.setColor(Color.RED);
		for (int i = 0; i < lineNum; i++) {
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		// ���������
		int mathNum = 4;
		int fontSize = 40;
		g.setColor(Color.GREEN);
		g.setFont(new Font("����", Font.BOLD | Font.ITALIC, fontSize));
		for (int j = 1; j <= mathNum; j++) {
			g.drawString(r.nextInt(10) + "", width * j / (mathNum + 1) - fontSize / 3, height / 2 + fontSize / 3);
		}
		// ����������ImageIO
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "-1");
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
