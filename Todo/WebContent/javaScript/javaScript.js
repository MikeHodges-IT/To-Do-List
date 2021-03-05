/**
 * 
 */

function validateForm() {
var  x = document.forms["todoItemForm"]["itemTitle"].value;
  if (x == "") {
    document.getElementById("itemTitleError").innerHTML ="To do Item Title Must be filed out";  
    document.getElementById("title").style.color = "red";
    return false;
  }
}


function clearErrorMsg(){
	 document.getElementById("itemTitleError").innerHTML ="&nbsp;"; 
     document.getElementById("title").style.color = "black";
}


