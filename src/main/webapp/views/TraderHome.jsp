
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mock.project.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href=" https://rawgit.com/Govind-jha/online-resources/master/pm-home.css">



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>TRADER Home</title>
</head>
<body>

     <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./TraderHome.jsp">Trader</a>
			</div>
			<ul class="nav navbar-nav" style="float:right;">
				
				<%-- <%	
					String userType = (String) session.getAttribute("UserType");
					String PMToTraderSwitch ="<li><a href=\"selectTrader\"><span class=\"glyphicon glyphicon-user\"></span> Trader Portal</a></li>";				

					if( userType.equalsIgnoreCase("PMTRADER")){
						out.print(PMToTraderSwitch);
					}
				%>	 --%>
				
				 <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>				 
			</ul>
		</div>
    </nav>

	<div class="container">
        <div id="menu-item-row" class="row">
                
            <!-- thumb -->
            <a href="PopulateBB"> 
                <div id="thumb-create-order" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </div>
                        <div class="thumb-text"> View Blocks </div>
                    </center>
                </div>
                </div> 
            </a>
            
            
            
                  
            <!-- thumb -->
            <a href="updateTable"> 
                <div id="thumb-order-blotter" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-shopping-cart"></span>
                        </div>
                        <div class="thumb-text"> Pending Orders </div>
                    </center>
                </div>
                </div> 
            </a>
            
      
            
            
            <!-- thumb -->
            <a href="PopulateTraderHistory"> 
                <div id="thumb-history" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-th-list"></span>
                        </div>
                        <div class="thumb-text"> Trade History </div>
                    </center>
                </div>
                </div> 
            </a>
            
        </div>        		
    </div>
    

		
</body>
</html>