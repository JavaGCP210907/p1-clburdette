const url ="http://localhost:8090/";
let getAvengerButton = document.getElementById("getAvengerButton");
let avengerBody = document.getElementById("avengerBody");
let loginButton = document.getElementById("loginButton");
let message = document.getElementById("message");

getAvengerButton.addEventListener('click', assembleFunc);
loginButton.addEventListener('click', loginFunc);

async function assembleFunc(){

    let response = await fetch(url + "avengers", {credentials: "include"});
    console.log(response);
    if(response.status === 200){
        let data = await response.json();

        for(let avenger of data){

            let row = document.createElement("tr");
            avengerBody.appendChild(row);

            let cell = document.createElement("td");
            cell.innerHTML = avenger.av_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = avenger.av_name;
            row.appendChild(cell2);
            
            let cell3 = document.createElement("td");
            cell3.innerHTML = avenger.first_name;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = avenger.last_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = avenger.power_level;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = avenger.home_fk;
            row.appendChild(cell6);

        }
    }

}

async function loginFunc(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let package = {
        username : usern,
        password : userp
    }

    let response = await fetch(url + "login", {

        method: "POST",
        body: JSON.stringify(package),
        credentials: "include"

    } );

    console.log(response.status);
    response.body

    if(response.status === 200){

        //another async function to grab the user with usern and store it in global user variable
        document.getElementById("login-row").innerText = "Welcome";
    }else{
        document.getElementById("login-row").innerText = "Login failed";
    }
}