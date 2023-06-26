package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.student.dao.StudentDao;
import com.student.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	//Here we are recieving the base URL in request mapping So wherever we run our 
	//project the front Controller(WebInitilizer)  will come and hit this method 
	
	// we have set a view for "home.jsp" so after the method is implemented  it  will
	//redirect us to the "home.jsp"page
	@RequestMapping("/")
	public ModelAndView homePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}
	
	/** After clicking on "Add Student" on home jsp the request will be comming 
	 * to this (/register ) url  and requestStudent() will be implements
	 * 
	 * VIEW:- in this method we have set a view  for register 
	 * **/

	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	/**when we click on Register button after providing all  the values to the null object in the "register.jsp"
	 * it  will  come in search  of "/save" url  and saveStudent() wil get executed
	 * 
	 * In this method we have received that particular object with help of @ModelAttribute  annotation 
	 * and saved it inside the database  using the [studentDao.saveStudent(student)] method.
	 * 
	 * VIEW-: we have set a view for home.jsp here so after a student object is saved the it will return 
	 * back to Home Page
	 * */
	@RequestMapping("/save")
	public ModelAndView savestudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView();
		studentDao.saveStudent(student);
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}

	/**when we click on the displayStudents on the home.jsp  page the request wil come 
	 * and hit @RequestMapping ("/dispaly")  and displayStudents() will be executed
	 * 
	 * VIEW - Here  we have set a view for display.jsp page so that  particular JSP 
	 * file will be rendered on the browser
	 * 
	 * MODEL/Object - we are also sending an list of student object using the method
	 * (studentDao.findAllStudents) and setting a key for the list (students)
	 * 
 	 * */
	@RequestMapping("/display")
	public ModelAndView displayStudents() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("students", studentDao.findAllStudents());
		return modelAndView;
	}
	
	/** from the display.jsp page when a request is given to update  any student data then it is hitting
	 * this mapping and updateStudent()
	 * implemented
	 * 
	 * as we need and id in order to fetch the data from the database so we are recieving the id  sent from 
	 * the display .jsp page  using an annotation called @Requestparam
	 * 
	 * VIEW :- in this method we have set a view for "update.jsp" page
	 * 
	 *  MODEL/Object we have  also added an  student object that we have found
	 *  from the database using the id we had received (studentDao.findStudentById(id))
	 *  and also set aa key for that (existing Student)
	 * */

	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.addObject("existingStudent", studentDao.findStudentById(id));
		return modelAndView;
	}

	/**After the data is changed / Manipulated from the "update.jsp" file the request 
	 * will come and hit this saveupdateStudent()where we are accepting a @ModelAttribute of the 
	 * of the updateStudent object (same Object)sent from"update.jsp" after manipulation
	 * 
	 *   
	 *   Inside this method we are updating the particular object inide the database
	 *   using studentDao.updateStudent(updatedStudent)
	 *   
	 *   
	 *   VIEW:- here we have set a view for display.jsp file which will be rendered 
	 *   once this method is executed
	 *   
	 *   MODEl/OBJECT:- we have added List of student  and set a key for
	 *   "students",studentDao.findAllStudents(),which will be sent to the (/"display.jsp") file
	 *   
	 *   
	 *   NOTE: The key for list of student which is sent to display.jsp must be same in all the method  where 
	 *   view  is set as display.jsp
	 *    
	 ** */
	@RequestMapping("saveUpdatedStudent")
	public ModelAndView saveUpdatedStudent(@ModelAttribute Student updatedStudent) {
		ModelAndView modelAndView = new ModelAndView();
		studentDao.updateStudent(updatedStudent);

		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("students", studentDao.findAllStudents());
		return modelAndView;
	}
	
	/**After we click on DELETE option in any paticular object the request will come for this deleteStudent()
	 * 
	 * In this method we are accepting an @RequestParam  
	 * */

	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		Student student = studentDao.findStudentById(id);
		studentDao.deleteStudent(student);
		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("students",studentDao.findAllStudents());
		return modelAndView;
	}
	
	
	
	
	
}
