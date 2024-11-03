async function createStudent() 
{
    const requestData = { 
        name:document.getElementById("NAME").value, 
        score:document.getElementById("SCORE").value
    } 
    let response = await fetch("http://localhost:8080/create", {
        method:'POST', 
        headers: {
            'Content-type':'application/json'
        }, 
        body:JSON.stringify(requestData)
        });
    let responseData= await response.text(); 
    document.getElementById("creationState").innerHTML=responseData;
} 
document.getElementById("createStudent").addEventListener('submit',function(e) { 
    e.preventDefault(); 
    createStudent();
})