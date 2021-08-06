console.log("Shaua");
window.onload=function()
{
    document.getElementById("allCar").addEventListener("click",showAllCar);
    document.getElementById("searchCar").addEventListener("click",searchCar);
    document.getElementById("addCar").addEventListener("click",insertCar);
    document.getElementById("updateCar").addEventListener("click",updateCar);
    document.getElementById("deleteCar").addEventListener("click",deleteCar);

}
function showAllCar()
{
    //window.location("AllCar.html");
    window.location="http://localhost:8080/CarAPI/AllCar.html";
}
function searchCar()
{
    window.location="http://localhost:8080/CarAPI/SearchCar.html";
    //var opened = window.open("SearchCar.html");
}
function insertCar()
{
    window.location="http://localhost:8080/CarAPI/CreateCar.html";
    //var opened = window.open("CreateCar.html");
}
function updateCar()
{
    window.location="http://localhost:8080/CarAPI/UpdateCar.html";
    //var opened = window.open("UpdateCar.html");
}
function deleteCar()
{
    window.location="http://localhost:8080/CarAPI/DeleteCar.html";
    //var opened = window.open("DeleteCar.html");
}