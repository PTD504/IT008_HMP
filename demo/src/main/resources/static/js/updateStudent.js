async function  updateStudent() 
{
    let state = document.getElementById("updateState").checked;
    const request = { 
        id:document.getElementById("updateId").value ,
        name:document.getElementById("updateName").value,
        score:document.getElementById("updateScore").value,
        enable:state
    } 
    let response = await fetch("http://localhost:8080/update", {
        method:'PUT', 
        headers:{
            'Content-type':'application/json'
        },
        body:JSON.stringify(request)
    }); 
    let responseData= await response.text();
    document.getElementById("updationState").innerHTML=responseData;
} 
document.getElementById("updateStudent").addEventListener('submit', 
    function(e) {
        e.preventDefault(); 
        updateStudent();
    }
)