async function getAllStudent() 
{
    let response= await fetch("http://localhost:8080/students", 
        { 
            method:'GET', 
            headers: {
                'Content-type':'application/json'
            }
        }
    );
    let responseData = await response.json(); 
    for(const student of responseData) 
    {
        const newRow =document.createElement('tr');  
        const newRowId = document.createElement('th'); 
        newRowId.innerHTML=student.id;
        const newRowName = document.createElement('th');
        newRowName.innerHTML=student.name;  
        const newRowScore = document.createElement('th'); 
        newRowScore.innerHTML=student.score; 
        const newRowState = document.createElement('th'); 
        if(student.enable) newRowState.innerHTML="Đang học"; 
        else newRowState.innerHTML="Đã nghỉ học";
        newRow.appendChild(newRowId); 
        newRow.appendChild(newRowName); 
        newRow.appendChild(newRowScore); 
        newRow.appendChild(newRowState); 
        document.getElementById("table").appendChild(newRow);


    }
} 
async function searchById(id) 
{ 
    let url = "http://localhost:8080/student/"+id; 
    let response =  await fetch(url, 
        {
            method:'GET', 
            headers:{
                'Content-type':'application/json'
            }
        }
    ) ; 
    console.log(response);
    let responseData = await response.json();
    if(responseData.id==-1) 
    {
         document.getElementById("searchFail").innerHTML="Không tìm thấy sinh viên"; 
         console.log("Not found");
         return; 
    } 
    document.getElementById("Id").innerHTML= "Mã số sinh viên: "+responseData.id;
    document.getElementById("Name").innerHTML= "Họ và tên: "+responseData.name; 
    document.getElementById("Score").innerHTML="Điểm số: "+responseData.score;
    if(responseData.enable) 
        document.getElementById("State").innerHTML="Tình trạng: Đang học"; 
    else  
    document.getElementById("State").innerHTML="Tình trạng: Đã thôi học";
    

}  
async function deleteById(id) 
{ 
    let url="http://localhost:8080/delete/"+id;
    let response = await fetch(url, { 
        method:'DELETE', 
        headers: {
            'Content-type':'application/json'
        }
    }); 
    let responseData = await response.text(); 
    document.getElementById("deletionState").innerHTML=responseData;
}
getAllStudent(); 
document.getElementById("searchById").addEventListener('submit', 
    function(e) 
    {
        e.preventDefault(); 
        let id = document.getElementById("studentId").value;
        searchById(id);
    }
) 
document.getElementById("deleteStudentById").addEventListener('submit', 
    function(e) {
        e.preventDefault();
        let id = document.getElementById("STUDENTID").value;
        deleteById(id);
    }
)