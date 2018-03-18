package axela.app.service.service;

import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.service.model.AxelaServiceJcImg;
import axela.service.repository.JobcardImgRepository;

@Service
public class AppJobcardImgService extends Connect {
	HashMap output = new HashMap();
	public int imgId = 0;
	public String imgPic = "";
	public int imgRank = 0;
	public String imgValue = "";
	public String imgEntryId = "0";
	public String imgEntryDate = "";
	public String imgModifiedId = "0";
	public String imgModifiedDate = "";

	@Autowired
	public JobcardImgRepository jobcardImgrepository;
	// img_id = ExecuteQuery("SELECT COALESCE(MAX(img_id), 0) + 1 AS img_id FROM " + compdb(comp_id) + "axela_service_jc_img");
	public HashMap UploadJobCardImage(byte[] file, HttpServletResponse response, String empId, String jcId, String imgTitle, String compId, HttpSession session) throws JSONException, ParseException {
		imgId = 0;
		AxelaServiceJcImg axelaservicejcimg = new AxelaServiceJcImg();
		axelaservicejcimg.setImgId(imgId);
		axelaservicejcimg.setImgJcId(Integer.parseInt(jcId));
		axelaservicejcimg.setImgPic(file);
		axelaservicejcimg.setImgRank(imgRank);
		axelaservicejcimg.setImgTitle(imgTitle);
		axelaservicejcimg.setImgValue(imgValue + "jcimg_" + imgId + ".jpg");
		axelaservicejcimg.setImgEntryId(Integer.parseInt(empId));
		axelaservicejcimg.setImgModifiedId(Integer.parseInt(imgModifiedId));
		axelaservicejcimg.setImgEntryDate(kknow());
		imgId = jobcardImgrepository.save(axelaservicejcimg).getImgId();
		if (imgId != 0) { // if id = 0 -> add mode else update mode
			output.put("successmsg", "Image Added Successfully!");
			output.put("imgId", imgId + "");

		}
		return output;
	}

}
