FormID.addEventListener('submit',(Event)=>
{
       Event.preventDefault();
}
);
window.onload=function()
{
    document.getElementById("buttonId").addEventListener("click",idFunction);
    document.getElementById("buttonId2").addEventListener("click",makeFunction);
}

function idFunction()
{ 


    var customerID= document.getElementById("customID").value;
    document.getElementById("customID").value=null;
    searchByID(customerID);
    
}
function makeFunction()
{ 
    
    var customerMake= document.getElementById("customMake").value;
    document.getElementById("customMake").value=null;
    searchByMake(customerMake);
    
}
var car = 
{
    id:"",
    vin:"",
    model:"",
    make:"",
    mileage:""
};

function searchByID(customerID)

{
    
    let xml= new XMLHttpRequest();
    
    xml.onreadystatechange = function()
    {
        if(xml.readyState === 4 && xml.status==200)
        {

            //console.log(xml.readyState);
            //console.log("Lets see response text" +xml.responseText);
            var car = JSON.parse(xml.responseText)

            var display= 
            '<table class="table table-dark">'+
            '<pre>'+ 
            '<tr>'+
            '<th>'+'ID&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Vin&nbsp;&nbsp;&nbsp;'+'</th>'+      // Creating table
            '<th>'+'Model&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Make&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Mileage&nbsp;'+'</th>'+
            '</tr>'+
            '<tr>'+
            '<td>'+car.id+'</td>'+
            '<td>'+car.vin+'</td>'+
            '<td>'+car.model+'</td>'+
            '<td>'+car.make+'</td>'+
            '<td>'+car.mileage+'</td>'+
          '</tr>'+
          '</pre>'+
            '</table>';
            document.getElementById("test").innerHTML=display; 
       
        }
    }
    var parameter=customerID;
    var path='/CarAPI/api/car?id=';
    var url=path.concat(parameter);
    xml.open('GET', url);
    xml.send();


}

function searchByMake(customerMake)

{
    
    let xml= new XMLHttpRequest();
    
    xml.onreadystatechange = function()
    {
        if(xml.readyState === 4 && xml.status==200)
        {

           
            var car = JSON.parse(xml.responseText);
            var display1='<table class="table table-dark">'+
            '<pre>'+
            '<tr>'+
            '<th>'+'ID&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Vin&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Model&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Make&nbsp;&nbsp;&nbsp;'+'</th>'+
            '<th>'+'Mileage&nbsp;'+'</th>'+
            '</tr>';
            

            var display2="";
            for(var i in car)
            {
                 display2 += 
            '<tr>'+
            '<td>'+car[i].id+'</td>'+
            '<td>'+car[i].vin+'</td>'+
            '<td>'+car[i].model+'</td>'+
            '<td>'+car[i].make+'</td>'+
            '<td>'+car[i].mileage+'</td>'+
          '</tr>';
            
            }
            var display4= '</pre>'+
            '</table>';


            var display3=display1.concat(display2);
            var display=display3.concat(display4);
            
            document.getElementById("test").innerHTML=display; 
       
        }
    }
    var parameter=customerMake;
    var path='/CarAPI/api/car?make=';
    var url=path.concat(parameter);
    xml.open('GET', url);
    xml.send();
    


}


   
 