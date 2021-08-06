var carArray = 
{
    id:"",
    vin:"",
    model:"",
    make:"",
    mileage:""
};
window.onload=function()
{
    let xml= new XMLHttpRequest();
    xml.onreadystatechange=function()
    {
        if(xml.readyState===4 && xml.status==200)
        {
            var carArray=JSON.parse(xml.responseText);

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
            for(var i in carArray)
            {
                 display2 += 
            '<tr>'+
            '<td>'+carArray[i].id+'</td>'+
            '<td>'+carArray[i].vin+'</td>'+
            '<td>'+carArray[i].model+'</td>'+
            '<td>'+carArray[i].make+'</td>'+
            '<td>'+carArray[i].mileage+'</td>'+
          '</tr>';
            
            }
            var display4= '</pre>'+
            '</table>';


            var display3=display1.concat(display2);
            var display=display3.concat(display4);
            document.getElementById("test").innerHTML=display;
        }

    }
    var url='/CarAPI/api/car';
    xml.open('GET', url);
    xml.send();

}