# servlet-demo
Its just a project for learning servlet jsp

### The exploded war can be found at 
 - /eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/servlet-demo
 
## Java servlet

### Implements javax.servlet.Servlet
 - Has five method signatures

 - Lifecycle methods as follows

 - void init(ServletConfig)
 - void service(ServletRequest, ServletResponse)
 - void destroy()

 - And the getters and setters

 - getServletInfo()
 - getServletConfig()
 

### javax.servlet.GenericServlet 
It implements the Servlet for us hence implements all the methods except service

Therefore by extending it now we only implement service method

### javax.servlet.http.HttpServlet extends from GenericServlet
- This class implements the contract void service(ServletRequest, ServletResponse) method and its different variants
- void service(HttpServletRequest, HttpServletResponse)
- void doGet(HttpServletRequest, HttpServletResponse)
- void doPost(HttpServletRequest, HttpServletResponse)
- void doPut(HttpServletRequest, HttpServletResponse)
- void doDelete(HttpServletRequest, HttpServletResponse)
- void doHead(HttpServletRequest, HttpServletResponse)
- void doTrace(HttpServletRequest, HttpServletResponse)
- void doOptions(HttpServletRequest, HttpServletResponse)

Therefore best method is to extend the HttpServlet class and overide the do methods

## MIME - Multipurpose Internet Mail Extension
- Before sending or writing content to the client this must be set
- MIME type describes whta kind of data we are giving it could be html, csv, binary data like pdf etc
- response.setContentType("text/html")

It can be both character and binary streams are available
- Text content ==> Character stream
- response.getWriter() -> PrintWriter
- PrintWriter -> print(), println(), printf()
- out.close() -> important!