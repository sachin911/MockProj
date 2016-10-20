
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
    
<title>PM Home</title>
</head>
<body>

     <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav" style="float:right;">
				
				<%	
					String userType = (String) session.getAttribute("UserType");
					String PMToTraderSwitch ="<li><a href=\"selectTrader\"><span class=\"glyphicon glyphicon-user\"></span> Trader Portal</a></li>";				

					if( userType.equalsIgnoreCase("PMTRADER")){
						out.print(PMToTraderSwitch);
					}
				%>	
				
				 <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>				 
			</ul>
		</div>
    </nav>

	<div class="container">
        <div id="menu-item-row" class="row">
                
            <!-- thumb -->
            <a href="./CreateTrade.jsp"> 
                <div id="thumb-create-order" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </div>
                        <div class="thumb-text"> Create Order </div>
                    </center>
                </div>
                </div> 
            </a>
            
            
            
                  
            <!-- thumb -->
            <a href="ViewOrderBlotter"> 
                <div id="thumb-order-blotter" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-shopping-cart"></span>
                        </div>
                        <div class="thumb-text"> Order Blotter </div>
                    </center>
                </div>
                </div> 
            </a>
            
            <!-- thumb -->
            
            <a href="ViewPendingOrder"> 
                <div id="thumb-pending-order" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-list-alt"></span>
                        </div>
                        <div class="thumb-text"> Pending Orders </div>
                    </center>
                </div>
                </div> 
            </a>
            
            <!-- thumb -->
            <a href="GeneralView"> 
                <div id="thumb-history" class="thumb-pm-home col col-sm-3">
                <div class="thumb-pm-home-container">
                    <center>
                        <div class="glyph-thumb-item">
                            <span class="glyphicon glyphicon-th-list"></span>
                        </div>
                        <div class="thumb-text"> History </div>
                    </center>
                </div>
                </div> 
            </a>
            
        </div>        		
    </div>
    
        <!-- Portfolio Listing -->
    <div class="container">
        <center><h2 id="portfolio-list-title"> PORTFOLIOS </h2></center>
        <div id="portfolio-list-row" class="row">
            <center>
                <a href="GeneralView"> <div id="portfolio-list-All" class="portfolio-list-thumb col col-sm-3"> All Portfolios </div></a>
                <a href="Mining"> <div id="portfolio-list-mining" class="portfolio-list-thumb col col-sm-3"> Mining </div></a>
                <a href="Banking"> <div id="portfolio-list-Banking" class="portfolio-list-thumb col col-sm-3"> Banking </div></a>
                <a href="Automobile"> <div id="portfolio-list-Automobile" class="portfolio-list-thumb col col-sm-3"> Automobile </div></a>
                <a href="Energy"> <div id="portfolio-list-Energy" class="portfolio-list-thumb col col-sm-3"> Energy </div></a>
                <a href="Textile"> <div id="portfolio-list-Textile" value="Textile" class="portfolio-list-thumb col col-sm-3"> Textile </div></a>
                <a href="Pharma"> <div id="portfolio-list-Pharma" class="portfolio-list-thumb col col-sm-3"> Pharma </div></a>
                <a href="FMCG"> <div id="portfolio-list-FMCG" class="portfolio-list-thumb col col-sm-3"> FMCG </div></a>
                <a href="Cement"> <div id="portfolio-list-Cement" class="portfolio-list-thumb col col-sm-3"> Cement </div></a>
                <a href="Aluminium"> <div id="portfolio-list-Aluminium" class="portfolio-list-thumb col col-sm-3"> Aluminium </div></a>
                <a href="Transport"> <div id="portfolio-list-Transport" class="portfolio-list-thumb col col-sm-3"> Transportation </div></a>
                <a href="Other"> <div id="portfolio-list-Transport" class="portfolio-list-thumb col col-sm-3"> Other </div></a>
            </center>
        </div>
    </div>
		
</body>
</html>