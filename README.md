##B/S模式下JSP通过JDBC增删改查   
- dao层为Control层，控制对数据的增删改查;    
- util层为Model层，负责链接数据库；   
- WebContent下的为View层，包括jsp文件及其css样式文件   
###数据传递   
- 增删改查中利用servlet传递数据
- 后来添加的showAllStudent通过将数据保存在session内，    
然后经过请求重定向传递数据，代码如下：    

      //java传送数据
      request.getSession().setAttribute("allStudentInf", list);
      response.sendRedirect("*.jsp");
      //jsp接收数据
      list=(List)session.getAttribute("allStudentInf");
