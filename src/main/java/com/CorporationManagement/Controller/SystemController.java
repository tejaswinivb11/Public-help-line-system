package com.CorporationManagement.Controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.CorporationManagement.Entity.SystemEntity;
import com.CorporationManagement.Service.SystemService;

@Controller
public class SystemController {
	
	@Autowired
	private SystemService SS;
	
	@GetMapping("/Admin/AdminHomePage")
	public String AdminHomePage(Model model) {
		model.addAttribute("Issues" , SS.getAllIssues());
		return "AdminHomePage";
	}
	
	@GetMapping("/LoginPage")
	public String LoginPage() {
		System.out.println("login page");
		return "LoginPage";
	}
	
	@GetMapping("/HomePage")
	public String HomePage(Model model , HttpServletRequest request) {
		model.addAttribute("Issues",SS.getAllIssues());
		
		if (request.isUserInRole("ADMIN")) {
            return "redirect:/Admin/AdminHomePage";
        }
		return "HomePage";
	}
	
	@GetMapping("/HomePage/AddIssue")
	public String AddIssue(Model model) {
		SystemEntity SE = new SystemEntity();
		model.addAttribute("issues",SE);
		return "AddImage";
	}
	
	@PostMapping("/Home")
	public String Adding(@ModelAttribute("SystemEntity") SystemEntity Se) {
		SS.SaveEntity(Se);
		return "redirect:/HomePage ";
	}
	
	@GetMapping("/AdminIssueEdit/{id}")
	public String AdminEdit(@PathVariable int id,Model model) {
		model.addAttribute("Issues",SS.getIssueById(id));
		return "AdminIssueEdit";
	}
	
	@PostMapping("/AdminIssueEdit/edit/{id}")
	public String UpdateStudent(@PathVariable int id , @ModelAttribute("SystemEntity") SystemEntity SE , Model model){
		SystemEntity ex = SS.getIssueById(id);
		ex.setStatus(SE.getStatus());
		ex.setDescription(SE.getDescription());
		
//		model.addAttribute("Issuess", SE);
		SS.UpdateIssue(ex);
		return "redirect:/HomePage";
		
	}
	
	@GetMapping("/AdminIssueDelete/{id}")
	public String deleteIssue(@PathVariable int id ) {
		SS.DeleteIssueById(id);
		return "redirect:/HomePage";
	}
	
	@GetMapping("/")
	public String FrountPage() {
		return "index.html";
	}
	
	@GetMapping("/SortByWard")
	public String SortByWard(Model model) {
		model.addAttribute("Sort" , SS.SortAllAsc() );
		return "SortedHomePage";
	}
	
	@PostMapping("/imgSaves")
	public String ImgSave(
			@RequestParam("IssueName") String name,
			@RequestParam("IssueLocation") String location,
			@RequestParam("Ward") int ward,
			@RequestParam("file") MultipartFile file
			) {
		SS.ImageSave(name, location, ward ,file);	
		return "redirect:/HomePage";
	}
	
	@PostMapping("/imgSave")
	public String saveFile(
			@RequestParam("IssueName") String name,
			@RequestParam("IssueLocation") String location,
			@RequestParam("Ward") int ward,
			@RequestParam("file") MultipartFile file
			) {
		SS.saveFile(name, location, ward, file);
		return "redirect:/HomePage";
	}
	
	@GetMapping("/about")
	public String About() {
		return "about";
	}
	
	@GetMapping("/download/image/{id}")
	public ResponseEntity<?> downloadImage(@PathVariable int id , HttpServletResponse response) throws IOException{
		byte[] imageArray = SS.findById(id);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageArray);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(inputStream, response.getOutputStream());
		return new ResponseEntity<>("success" , HttpStatus.OK);
	}
	
	@GetMapping("/HelpLogin")
	public String HelpLogin() {
		return "HelpLogin";
	}
	
	@GetMapping("/HelpWelcome")
	public String HelpWelcome() {
		return "HelpWelcome";
	}
	
	
	
	
	
	
	
	
	
	//useSSL=false&serverTimeZone=UTC&useLegacyDatetimeCode=false&createDatabaseIfNotExist=true
	//sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false	
}

