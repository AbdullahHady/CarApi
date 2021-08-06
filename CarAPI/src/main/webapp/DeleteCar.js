//console.log("hello delete");
FormID.addEventListener('submit',(Event)=>
{
       Event.preventDefault();
       //console.log("check");
}
);

window.onload=function()
{
    document.getElementById("buttonID").addEventListener("click",deleteCar);
}
function deleteCar()
{
    let customerID=document.getElementById("idInput").value;
    document.getElementById("idInput").value=null;
    let xml=new XMLHttpRequest();
    xml.onreadystatechange=function()
    {
        if(xml.readyState==4 && xml.status==200)
        {
            window.alert("Car Deleted!");
        }


    }
    var parameter=customerID;
    var path='/CarAPI/api/car?id=';
    var url=path.concat(parameter);
    xml.open('DELETE', url);
    xml.send();
}