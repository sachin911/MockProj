
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
<style>

#portfolio-list-row{
    width:80%;
    height: 450px;
    overflow-y:scroll;
    margin:0 auto;   
    margin-top: 20px;
}

.portfolio-list-thumb:hover{
    background: #F1F1F1;
     text-shadow: 2px 2px 4px #000000;
    -moz-box-shadow:    inset 0 0 10px #000000;
    -webkit-box-shadow: inset 0 0 10px #000000;
    box-shadow:         inset 0 0 10px #000000;
}

#portfolio-list-title{
    margin-top: 30px;
    text-shadow: 2px 2px 2px #000000;
}

.portfolio-list-thumb{
    width: 20%;
    height:120px;
    color:black;
    font-weight: bold;
    
    border: 2px solid black;
    border-radius: 20px;
    
    margin-left: 2.5%;
    margin-right: 2.5%;
    margin-top: 2%;
    margin-bottom: 2%;
    
    text-align: center;
    vertical-align: middle;
    line-height: 120px;
}


#menu-item-row{
    width: 100%;
}

.thumb-pm-home{
    background: #e7e7e7;
    width: 20%;
    height:160px;
    border: 3px solid black;
    margin-left: 2.5%;
    margin-right: 2.5%;
    border-radius: 15px 50px 30px
}

.thumb-pm-home:hover{
    background:#f1f1f1;
    box-shadow: 10px 10px grey;
}

.thumb-pm-home:hover .glyph-thumb-item{
    color: #F50;
}

.thumb-pm-home:hover .thumb-text{
    color: black;
}

.glyph-thumb-item{
    height:60%;
    margin: 5px;
    font-size:50px;
    padding: 18px;
}

.thumb-text{
    color: grey;
    font-weight: bold;
    font-size: 1.2em;
}


#portfolio-list-row::-webkit-scrollbar {
    width: 1em;
}
 
#portfolio-list-row::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
 
#portfolio-list-row::-webkit-scrollbar-thumb {
  background-color: darkgrey;
  outline: 1px solid slategrey;
}

</style>

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
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
    </nav>
    
    <!-- Menu Items -->
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
            <a href="./OrderBlotter.jsp"> 
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
            <a href="./PendingOrder.jsp"> 
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
            <a href="./PMHistory.jsp"> 
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
                <a href="#" target="_blank"> <div id="portfolio-list-mining" class="portfolio-list-thumb col col-sm-3"> Mining </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Banking" class="portfolio-list-thumb col col-sm-3"> Banking </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Automobile" class="portfolio-list-thumb col col-sm-3"> Automobile </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Energy" class="portfolio-list-thumb col col-sm-3"> Energy </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Textile" class="portfolio-list-thumb col col-sm-3"> Textile </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Pharma" class="portfolio-list-thumb col col-sm-3"> Pharma </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-FMCG" class="portfolio-list-thumb col col-sm-3"> FMCG </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Cement" class="portfolio-list-thumb col col-sm-3"> Cement </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Aluminium" class="portfolio-list-thumb col col-sm-3"> Aluminium </div></a>
                <a href="#" target="_blank"> <div id="portfolio-list-Transport" class="portfolio-list-thumb col col-sm-3"> Transport </div></a>
            </center>
        </div>
    </div>
	
</body>
</html>