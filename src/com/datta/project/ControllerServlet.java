package com.datta.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget()");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in dopost()");
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in process()");
		String uri=request.getRequestURI();
		System.out.println("the uri is "+uri);
		RequestDispatcher rd=null;
		Model m=new Model();
		
		// preprocessing register...
		if(uri.contains("/OpenRegisterView.do"))
			
		{
			System.out.println("olag banta");
			rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
			
		}
		
		//post proceesing register...
		if(uri.contains("/Register.do"))
		{
			RegBean rb=(RegBean) request.getAttribute("reg");
			String res=m.register(rb);
			if(res.equals(Constants.SUCCESS))
			{
				rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				request.setAttribute("ErrorMsg", res);
				rd=request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
				
			
			
		}
		// pre processing login..
		if(uri.contains("/OpenLoginView.do"))
		{
			rd=request.getRequestDispatcher("/Login.jsp");
					rd.forward(request, response);
			
		}
		
		
		// post processing log in...
		if(uri.contains("/Login.do"))
		{
			
			LoginBean lb=(LoginBean) request.getAttribute("log");
		  String res=m.authenticate(lb);
		 if(res.equals(Constants.SUCCESS))
		 {
			 HttpSession hs=request.getSession(true);
			 hs.setAttribute("loggedin", lb);
			 hs.setAttribute("email", lb.getEmail());    // in session ..
			 request.setAttribute("id", lb.getEmail());
			 System.out.println(lb.getEmail());
			 rd=request.getRequestDispatcher("Menu.jsp");
			 rd.forward(request, response);
			
			 
		 }
		 else
		 {
			 request.setAttribute("errormsg", res);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
		 System.out.println("inside ");
		 }
			 
		 
		}
		
		
// Editing purpose...(pre processing...)
		
		if(uri.contains("/OpenEditView.do"))
		{
			HttpSession hs=request.getSession(false);
			String email="";
			if(hs!=null)
			{
				LoginBean lb=(LoginBean) hs.getAttribute("loggedin");
				email=(String)lb.getEmail();
				System.out.println(email);
			}
			RegBean rb=m.getAccDetail(email);
			request.setAttribute("prefilled", rb);
			rd=request.getRequestDispatcher("EditAcc.jsp");
			rd.forward(request, response);
		
		}
		
		
// post processing (editing)
		
		if(uri.contains("/EditAcc.do"))
		{
			RegBean rb=(RegBean) request.getAttribute("tumbu");
		  String res= m.update(rb);
		  if(res.equals(Constants.SUCCESS))
		  {
			  request.setAttribute("msg", "Modified Your Account SuccessFully");
		  rd=request.getRequestDispatcher("Login.jsp");
		  rd.forward(request, response);
			
		   }
		}
		
	// logout purpose...
		if(uri.contains("/Logout.do"))
		{
			HttpSession hs=request.getSession(false);
			hs.removeAttribute("loggedin");
			hs.invalidate();	
			/*request.setAttribute("logoutuu", "U logged Out SuccessFully");*/   //if home page is jsp it would be usefull
			response.sendRedirect("HomePage.html");
		}
		
		
		
	// additioin of contact pre processing...
		
		if(uri.contains("/openAddContactView.do"))
		{
			rd=request.getRequestDispatcher("AddContact.jsp");
			rd.forward(request, response);
		}
		
   // addition of contact ...post processing
		if(uri.contains("/AddContact.do"))
		{
			HttpSession hs=request.getSession(false);
			
			String email=(String) hs.getAttribute("email");
			System.out.println(email);
			AddContactBean acb=(AddContactBean) request.getAttribute("addcontactu");
			String result=m.contactAddMadu(acb,email);
			if(result.equals(Constants.SUCCESS))
			{
				
				request.setAttribute("addaytu","Your Contact is Added successfully");
				 rd=request.getRequestDispatcher("ContactSuccess.jsp");
				 rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", result);
			   rd=request.getRequestDispatcher("AddContact.jsp");
			   rd.forward(request, response);
			}
			
		}
		
	// listing of contact..
		
		if(uri.contains("/openContactListView.do"))
		{
			rd=request.getRequestDispatcher("ContactList.jsp");
			rd.forward(request, response);
		
		}
		
		
//   listing of conatact part-2
		if(uri.contains("/ContactList.do"))
		{
             HttpSession hs=request.getSession(false);
			
			String email=(String) hs.getAttribute("email");
			System.out.println(email);
			String opt=request.getParameter("option");
			List<AddContactBean> res=m.listMadu(opt,email);
			request.setAttribute("showlist", res);
			rd=request.getRequestDispatcher("ListResults.jsp");
					rd.forward(request, response);
		}
		
		//contact search..
		if(uri.contains("/openSearchView.do"))
		{
			rd=request.getRequestDispatcher("SearchContact.jsp");
			rd.forward(request, response);
		}
		
		// post processing of search contact..
		if(uri.contains("/Search.do"))
		{
			 HttpSession hs=request.getSession(false);
				
				String email=(String) hs.getAttribute("email");
				System.out.println(email);
			String k=request.getParameter("searchitem");
			System.out.println("Entrd search item is "+k);
			List<AddContactBean> ls=m.searchedList(k,email);
			System.out.println(ls);
			if(ls.size()!=0)
			{
				request.setAttribute("searchdlist",ls);
				rd=request.getRequestDispatcher("SearchResults.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				request.setAttribute("error", "Ninu Hudkta Ero Contact Ellapa");
				rd=request.getRequestDispatcher("SearchContact.jsp");
				rd.forward(request, response);
				
			}
		}
		
		
		// Edit contact  
		if(uri.contains("/openEditContactView.do"))
		{
			 HttpSession hs=request.getSession(false);
			String email=(String) hs.getAttribute("email");
			System.out.println(email);
			List<AddContactBean> res=m.editMadu(email);
			request.setAttribute("editablelist", res);
			rd=request.getRequestDispatcher("EditContact.jsp");
			rd.forward(request, response);
		}
		
		// in editing update of contact...
		
		if(uri.contains("/updateContactView.do"))
		{
			   HttpSession hs=request.getSession(false);
				String email=(String) hs.getAttribute("email");
				String ph=request.getParameter("phonenum");
				System.out.println("phnum is"+ph);
				System.out.println(email);
				AddContactBean res=m.editMadu2(email,ph);
				System.out.println(res);
				request.setAttribute("temp", res);
			rd=request.getRequestDispatcher("UpdateContact.jsp");
			rd.forward(request, response);
		}
		
		// from edit intermediatry contact jsp..
		if(uri.contains("/editContact.do"))
		{
			AddContactBean acb=(AddContactBean) request.getAttribute("conedit");
			System.out.println("acb in con"+acb);
			String res=m.fillContactUpdate(acb);
			if(res.equals(Constants.SUCCESS))
			{
				rd=request.getRequestDispatcher("updateSuccess.jsp");
						rd.forward(request, response);
			}
			else
			{
				request.setAttribute("updation", "Your Editing of contact is failed");
				rd=request.getRequestDispatcher("UpdateContact.jsp");
				rd.forward(request, response);
			}
		}
		
		// for show edited listuu...
		if(uri.contains("/EditCon.do"))
		{
			
			rd=request.getRequestDispatcher("EditContact.jsp");
			rd.forward(request, response);
			
		}
		
		// deleting of contact..
		if(uri.contains("/deleteContactView.do"))
		{
			String ph=request.getParameter("phonenum");
			System.out.println("phnum is"+ph);
			String res=m.deleteMadu(ph);
			if(res.equals(Constants.SUCCESS))
			{
				rd=request.getRequestDispatcher("DeletedSuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msguu", "Not deleting try 1c..");
				rd=request.getRequestDispatcher("EditContact.jsp");
				rd.forward(request, response);
				
			}
			
		}
		
		
}   

}
