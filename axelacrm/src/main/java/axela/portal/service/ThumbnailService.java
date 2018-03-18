package axela.portal.service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import axela.config.Connect;
import axela.sales.repository.SalesOpprStatusRepository;
@Component
public class ThumbnailService extends Connect {

	private String ImgWidth = "";
	@Autowired
	SalesOpprStatusRepository salesOpprStatusRepository;

	// @Autowired
	// ByteArrayOutputStream bao;

	private JSONObject inputObj;
	private HashMap output = null;
	private String compId = "0";
	private String width = "0";
	private String imgId = "0";
	private String jcId = "0";
	private String type = "";
	@PersistenceContext
	EntityManager em;

	// @Autowired
	// private BufferedOutputStream bfImage;
	private byte[] data;
	private String empId = "0";

	TypedQuery<byte[]> query = null;
	private String ImgHeight;
	private String targetWidth;
	private String targetHeight;

	// Start Populate Oppr_status
	public byte[] imagedata(WebRequest webrequest, HttpServletResponse response, HttpSession session) throws Exception {
		empId = getSession("empId", session);
		compId = getSession("compId", session);
		SOP("empId======================asasasas===========================" + empId);
		if (!empId.equals("0")) {
			type = PadQuotes(webrequest.getParameter("type"));
			imgId = CNumeric(PadQuotes(webrequest.getParameter("imgId")));
			ImgWidth = PadQuotes(webrequest.getParameter("width"));
			ImgHeight = PadQuotes(webrequest.getParameter("height"));

			if (type.equals("empimg")) {
				query = (TypedQuery<byte[]>) em.createQuery("SELECT"
						+ " a.empPhoto FROM AxelaEmp a"
						+ " WHERE a.empId=" + empId);
				SOP("inasasqasasa");
				data = query.getSingleResult();
			}
			if (type.equals("compimg")) {
				query = (TypedQuery<byte[]>) em.createQuery("SELECT"
						+ " a.compPic FROM AxelaComp a"
						+ " WHERE a.compId=" + compId);
				data = query.getSingleResult();
			}
			if (type.equals("jcimg")) {
				query = (TypedQuery<byte[]>) em.createQuery("SELECT"
						+ " a.imgPic FROM AxelaServiceJcImg a"
						+ " WHERE a.imgId=" + imgId);
				data = query.getSingleResult();
			}
			// Set the mime type of the image
			if (data != null) {
				BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
				// Calculate the target width and height
				float scale = 1;
				int targetWidth = 0;
				int targetHeight = 0;
				targetWidth = (int) (bufferedImage.getWidth(null) * scale);
				targetHeight = (int) (bufferedImage.getHeight(null) * scale);
				if (ImgWidth == null || ImgWidth.equals("")) {
					ImgWidth = targetWidth + "";
				}
				if (ImgHeight.equals("")) {
					targetHeight = Integer.parseInt(ImgWidth) * targetHeight / targetWidth;
				} else {
					targetHeight = Integer.parseInt(ImgHeight);
				}
				targetWidth = Integer.parseInt(ImgWidth);

				ImageIO.write(createResizedCopy(bufferedImage, targetWidth, targetHeight), "png", response.getOutputStream());
			}
			// return bao.toByteArray();
		}
		return data;
	}
	BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
		BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = scaledBI.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return scaledBI;
	}
}
