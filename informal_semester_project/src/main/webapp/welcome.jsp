<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Kool Form Pack | Coming Soon Page</title>

        <!-- CSS FILES -->                
        <link rel="preconnect" href="https://fonts.googleapis.com">
        
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,700;1,200&family=Unbounded:wght@400;700&display=swap" rel="stylesheet">
        
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/tooplate-kool-form-pack.css" rel="stylesheet">
        
<!--

Tooplate 2136 Kool Form Pack

https://www.tooplate.com/view/2136-kool-form-pack

Bootstrap 5 Form Pack Template

-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script>
	    $(document).ready(function(){
	        $("#refreshButton").click(function(){
	            $.get("ImageServlet", function(data, status){
	                $("#image").attr("src", "data:image/png;base64," + data);
	            });
	        });
	    });
	    </script>
    </head>
    
    <body>

        <main>

            


            


            <section class="hero-section d-flex justify-content-center align-items-center" id="section_1">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-6 col-12 mx-auto">
                          
                          <%String username1 = (String)session.getAttribute("username"); %>
  
							<form id="basicInfo" action="./BasicInfoServlet" method="post" name="autoform1">
							</form>
							
							<script type="text/javascript">
							<%
							boolean flag = true;
							String realTime_map;
							if (request.getAttribute("isEmptyAction") != null) {
								flag = false;
							}
							%>
							console.log("flag="+<%=flag%>);
							if (<%=flag%>) {
								document.autoform1.submit();
							}
							
							</script> 
							
							
			

                  
                                
                                

                       
                                <h2 class="hero-title text-center mb-4 pb-2">Welcome <%= username1 %></h2> </span></a><br/>
							
					
						           
						     
						
						     <a href="update.jsp">Update</a><br/>
						     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						     <a href="AddRobotInfo.jsp">Add Robot!</a><br/>
						     <span class="text-white">Your basic information</span><br/>
						     <%
							if((String[][])session.getAttribute("Array")!=null){
								String[][] information1 = (String[][])session.getAttribute("Array");
								if(information1[0]!=null){ 
									for(int i=0;i<1000;i++){
										if(information1[i][0]!=null){%>
										<table class="table text-white">
										<tr>
										<th>user name</th>
										<th>robot name</th>
										<th>robot image</th>
										</tr>
										<tr>
										<td><%=information1[i][0] %></td>
										<td><%=information1[i][1] %></td>
										<td><img alt="" src="/upload/<%=information1[i][2] %>"/></td>
										</table>
										<% 
										realTime_map = information1[i][3];%>
										
										<% 
										session.setAttribute("realTime_map_now", realTime_map);
										}
										else{
											break;
										}
									}	
								}
							}%>
							
							<br/><span class="text-white">Watch the real-time map!</span><br/>
							
							
							
							<button id="listen">Start listening</button>
						    <button id="refreshButton">watch the real time map!</button>
							<img id="image" src="" />
							
							
							<form method="post" action="./ShowMazeInfo">
						     username : <input type="text" name="username"/><br/>
						      <input type="SUBMIT" name="submit" value="Let's see Maze!">
							</form>
							<%
							if((String[][])session.getAttribute("mazeInfo")!=null){
								String[][] information2 = (String[][])session.getAttribute("mazeInfo");
								if(information2[0]!=null){ 
									for(int i=0;i<1000;i++){
										if(information2[i][0]!=null){%>
										<table>
										<tr>
										<th>user name</th>
										<th>robot name</th>
										<th>path</th>
										<th>time interval</th>
										<th>treasure_picture</th>
										</tr>
										<tr>
										<td><%=information2[i][0] %></td>
										<td><%=information2[i][1] %></td>
										<td><%=information2[i][2] %></td>
										<td><%=information2[i][3] %></td>
										<td><img alt="" src="/upload/<%=information2[i][4] %>"/></td>
										</table>
										<% 
										}
										else{
											break;
										}
									}	
								}
							}%> 
                          
                        </div>
                    </div>
                </div>

                <div class="video-wrap">
                    <video autoplay="" loop="" muted="" class="custom-video" poster="">
                        <source src="videos/video.mp4" type="video/mp4">

                        Your browser does not support the video tag.
                    </video>
                </div>
            </section>
        </main>

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/countdown.js"></script>
        <script src="js/init.js"></script>

	<script>
	document.getElementById('listen').addEventListener('click', function() {
	    var xhr = new XMLHttpRequest();
	    
	    xhr.open("POST", "./listener", true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.onreadystatechange = function() {
	        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
	            console.log(this.responseText);
	        }
	    }
	    xhr.send("realTime_map=<%=session.getAttribute("realTime_map_now")%>");
	});
	</script>
    </body>
    
</html>