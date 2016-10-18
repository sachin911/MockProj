     
function changetextbox(obj)
{  
      var limit = document.getElementById("limit");
     var stop = document.getElementById("stop");
    	
        stop.disabled =(obj.value == "limit" || obj.value == "market");
        limit.disabled =(obj.value == "stop" || obj.value == "market");
    
}
