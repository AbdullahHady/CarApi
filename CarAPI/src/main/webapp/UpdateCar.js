//console.log("hello Update");
FormID.addEventListener('submit',(Event)=>
{
       Event.preventDefault();
}
);


window.onload=function()
{
    document.getElementById("buttonID").addEventListener("click",updateCar);
}
function updateCar()
{
    
    let customerID=document.getElementById("idInput").value;
    let customerVin=document.getElementById("vinInput").value;
    let customerModel=document.getElementById("modelInput").value;
    let customerMake=document.getElementById("makeInput").value;
    let customerMileage=document.getElementById("mileageInput").value;
    
    document.getElementById("idInput").value=null;
    document.getElementById("vinInput").value=null;
    document.getElementById("modelInput").value=null;
    document.getElementById("makeInput").value=null;
    document.getElementById("mileageInput").value=null;
    let updatedCar=
    {
        id: customerID,
        vin:customerVin,
        model:customerModel,
        make:customerMake,
        mileage:customerMileage
    }
    let xml= new XMLHttpRequest();
    xml.onreadystatechange=function()
    {
        if(xml.readyState==4 && xml.status==200)
        {
            window.alert("Car Information updated");
        }

    }
    let url='/CarAPI/api/car';
    xml.open('PUT',url);
    xml.send(JSON.stringify(updatedCar));


}
