const url ="http://localhost:8090/";
//element variables
let headerDiv = document.getElementById("headerDiv");
let loginDiv = document.getElementById("loginDiv");
let submitDiv = document.getElementById("submitDiv");
let employeeListDiv = document.getElementById("employeeListDiv");
let employeeTicketDiv = document.getElementById("employeeTicketDiv");
let managerDiv = document.getElementById("managerDiv");
let managerTicketDiv = document.getElementById("managerTicketDiv");

let loggedInUserName = document.getElementById("loggedInUserName");
let logoutButton = document.getElementById("logoutButton");

let loginButton = document.getElementById("loginButton");
let usernameF = document.getElementById("usernameField");
let passwordF = document.getElementById("passwordField");
let loginMessage = document.getElementById("loginMessage");

let amountInput = document.getElementById("amountInput");
let descriptionInput = document.getElementById("descriptionInput");
let typeSelectSubmit = document.getElementById("typeSelectSubmit");
let submitReimbursementButton = document.getElementById("submitReimbursementButton");
let viewTicketsButton = document.getElementById("viewTicketsButton");
let subMessage = document.getElementById("subMessage");

let newTicketButton = document.getElementById("newTicketButton");

let returnToEmployeeListButton = document.getElementById("returnToEmployeeListButton");

let selectStatus = document.getElementById("selectStatus");

let approveButton = document.getElementById("approveButton");
let denyButton = document.getElementById("denyButton");
let returnToManagerListButton = document.getElementById("returnToManagerListButton");

console.log("variables assigned");
//globals for continuity between views
let currentTicket = {};

let USER_ID;
let USER_FIRST_NAME;
let USER_LAST_NAME;
let USER_ROLE_ID;

let currentManagerSelect = 1;

init();

function init(){ //initialize handlers and ready the page for first view
    logoutButton.addEventListener('click', logout);
    loginButton.addEventListener('click', login);
    submitReimbursementButton.addEventListener('click', submitReimbursement);
    viewTicketsButton.addEventListener('click', viewTickets);
    newTicketButton.addEventListener('click', createTicket);
    returnToEmployeeListButton.addEventListener('click', viewTickets);
    selectStatus.addEventListener('change', changeStatus);
    approveButton.addEventListener('click', setStatus.bind(this,2));
    denyButton.addEventListener('click', setStatus.bind(this,3));
    returnToManagerListButton.addEventListener('click', viewManagerTickets.bind(this,currentManagerSelect));
    console.log("listeners added");

    loginMessage.innerHTML="";
    selectStatus.selectedIndex = 0;
    resetDivs();
    headerDiv.style.display = "none";
    loginDiv.style.display = "block";
    console.log("init complete");
}
//reset all divs for next page view
function resetDivs(){
    loginDiv.style.display = "none";
    submitDiv.style.display = "none";
    employeeListDiv.style.display = "none";
    employeeTicketDiv.style.display = "none";
    managerDiv.style.display = "none";
    managerTicketDiv.style.display = "none";
}
//actions taken when login is successful
function handleSuccessfulLoginReturn(info){
    USER_ID = info.ERS_USERS_ID;
    USER_FIRST_NAME = info.USER_FIRST_NAME;
    USER_LAST_NAME = info.USER_LAST_NAME;
    USER_ROLE_ID = info.USER_ROLE_ID;
    usernameF.value = null;
    passwordF.value = null;
    loginMessage.innerHTML="";
    loggedInUserName.innerHTML = "Welcome, " + USER_FIRST_NAME + " " + USER_LAST_NAME;
    headerDiv.style.display = "block";
    if(USER_ROLE_ID == 1){//separates app access based on user role: manager or employee
        viewManagerTickets(currentManagerSelect);
    }else{
        createTicket();
    }
}
//resets app on logout
function logout(){

    USER_ID = null;
    USER_FIRST_NAME = null;
    USER_LAST_NAME = null;
    USER_ROLE_ID = null;
    document.getElementById("employeeBody").innerHTML="";
    document.getElementById("managerBody").innerHTML="";
    resetDivs();
    headerDiv.style.display = "none";
    loggedInUserName.innerHTML = "";
    loginMessage.innerHTML="You have logged out";
    loginDiv.style.display = "block";

}
//post method to check if user login is valid against the db
async function login(){


    let usern = usernameF.value;
    let userp = passwordF.value;

    let package = {
        username : usern,
        password : userp
    }
    console.log(package);
    let response = await fetch(url + "login", {

        method: "POST",
        body: JSON.stringify(package),
        credentials: "include"

    } );

    if(response.status === 200){

        const userInfo = await response.json();
        handleSuccessfulLoginReturn(userInfo);

    }else{

        loginMessage.innerHTML="username and/or password incorrect";

    }

}
//manager landing view of groups of reimbursements sorted by type
async function viewManagerTickets(index){

    resetDivs();
    managerDiv.style.display = "block";
    currentTicket = {};

    let response;
    if(currentManagerSelect == 1){
            response = await fetch(url + "reimbursements",{
                method: "GET",
                credentials: "include"
            });
    }else{
            response = await fetch(url + "reimbursements/status/" + (currentManagerSelect - 1),{
                method: "GET",
                credentials: "include"
            });
    }

    if(response.status === 200){

        console.log("get REIMBs success");
        const managerViewReimbursements = await response.json();
        console.log(managerViewReimbursements);
        displayReimbursements(managerViewReimbursements, "managerBody");
        
    }else{
        
        console.log("get REIMBs fail");
        resetDivs();
        managerDiv.style.display = "block";
        subMessage.innerText = "error. please try again.";

    }
}
//landing method for employees. new ticket submission view, gateway to view all tickets for logged in employee
function createTicket(){

    document.getElementById("employeeBody").innerHTML="";
    resetDivs();
    submitDiv.style.display = "block";
    amountInput.value = null;
    descriptionInput.value = null;
    subMessage.innerText = "";
}
//sends new reimbursement to db on submitReimbursementButton press
async function submitReimbursement(){

    let submitReInfo = {};
    submitReInfo.REIMB_AMOUNT = amountInput.value; 
    submitReInfo.REIMB_DESCRIPTION = descriptionInput.value;
    submitReInfo.REIMB_AUTHOR = USER_ID;
    submitReInfo.REIMB_TYPE_ID = parseInt(typeSelectSubmit.value);
    console.log(submitReInfo);
    let response = await fetch(url + "reimbursements",{
        method: "POST",
        body: JSON.stringify(submitReInfo),
        credentials: "include"
    });
    
    if(response.ok){
        //resets form on successful submission
        subMessage.innerText = "submission successful";
        amountInput.value = null;
        descriptionInput.value = null;

    }else{
        subMessage.innerText = "error. please try again.";
    }

}
//view of all tickets for logged in employee
async function viewTickets(){

    resetDivs();
    newTicketButton.style.display = "none";
    employeeListDiv.style.display = "block";

    let response = await fetch(url + "reimbursements/user/" + USER_ID.toString(), {credentials: "include"});

    if(response.status === 200){

        console.log("get REIMBs success");
        let employeeViewReimbursements = await response.json();
        console.log(employeeViewReimbursements);
        displayReimbursements(employeeViewReimbursements, "employeeBody");
        newTicketButton.style.display = "block";

    }else{//back to employee submit view on server fail
        
        console.log("get REIMBs fail");
        resetDivs();
        submitDiv.style.display = "block";
        subMessage.innerText = "error. please try again.";
    }
}
//gets sorted info from db by status based on current value of the selectStatus select box
async function changeStatus(){
    
    let statusChange = parseInt(selectStatus.value);
    currentManagerSelect = statusChange;
    selectStatus.disabled = true;
    console.log(statusChange);
    let response;

    if(statusChange == 1){
            response = await fetch(url + "reimbursements",{
                method: "GET",
                credentials: "include"
            });
    }else{
            response = await fetch(url + "reimbursements/status/" + (statusChange - 1),{
                method: "GET",
                credentials: "include"
            });
    } 

    if(response.ok){

        const managerViewReimbursements = await response.json();
        document.getElementById("managerBody").innerHTML = "";
        console.log(managerViewReimbursements);
        displayReimbursements(managerViewReimbursements, "managerBody");

    }else{

        resetDivs();
        managerDiv.style.display = "block";
        subMessage.innerText = "error. please try again.";

    }
    selectStatus.disabled = false;
}
//manager view of a singular ticket with options to approve or deny if
//ticket is pending
async function viewManagerTicket(id){

    document.getElementById("managerBody").innerHTML="";
    resetDivs();
    managerTicketDiv.style.display = "block";
    approveButton.style.display = "none";
    denyButton.style.display = "none";
    approveButton.disabled = false;
    denyButton.disabled = false;

    let response = await fetch(url + "reimbursements/" + id,{
        method: "GET",
        credentials: "include"
    });

    if(response.ok){

        const selectedTicket = await response.json();
        currentTicket = selectedTicket;
        console.log(selectedTicket);
        
        if(currentTicket.REIMB_RESOLVER != undefined){

            await getResolver(selectedTicket.REIMB_RESOLVER);

        }

        populateManagerTicket(currentTicket);

        if(selectedTicket.REIMB_STATUS_ID == "pending"){
        
            approveButton.style.display = "block";
            denyButton.style.display = "block";
        }

    }else{
        
        resetDivs();
        managerDiv.style.display = "block";

    }
}
//employee view of singular ticket with button to return to employee ticket list view
async function viewEmployeeTicket(id){

    console.log(id);
    document.getElementById("employeeBody").innerHTML="";
    resetDivs();
    employeeTicketDiv.style.display = "block";
    approveButton.disabled = false;
    denyButton.disabled = false;

    let response = await fetch(url + "reimbursements/" + id,{

        method: "GET",
        credentials: "include"

    });

    if(response.ok){

        const selectedTicket = await response.json();
        currentTicket = selectedTicket;
        console.log(selectedTicket);
        if(currentTicket.REIMB_RESOLVER != undefined){
            await getResolver(selectedTicket.REIMB_RESOLVER);
        }
        populateEmployeeTicket(currentTicket);

    }else{//return to employee landing view on fail
        
        resetDivs();
        submitDiv.style.display = "block";
        subMessage.innerText = "error. please try again.";

    }
}
//transmits update of status of pending reimbursements to db based on button press 
async function setStatus(id){

    console.log(id);
    resetDivs();
    managerTicketDiv.style.display = "block";
    approveButton.disabled = true;
    denyButton.disabled = true;
    let updatePackage = {
        REIMB_ID : currentTicket.REIMB_ID,
        REIMB_STATUS_ID : id,
        REIMB_RESOLVER : USER_ID
    }

    let response = await fetch(url + "reimbursements/status",{
        method: "POST",
        body: JSON.stringify(updatePackage),
        credentials: "include"
    });

    if(response.ok){

        viewManagerTicket(currentTicket.REIMB_ID);

    }else{

        resetDivs();
        submitDiv.style.display = "block";
        subMessage.innerText = "error. please try again.";
    }
}
//dynamically displays reimbursement list data coming back from the db
function displayReimbursements(reimbursements, idName){

    for(const reimb of reimbursements){
        console.log(reimb);
        let row = document.createElement('tr');
        let elem = document.createElement('td');
        let text = document.createTextNode(reimb["REIMB_ID"]);
        let ticketID = reimb["REIMB_ID"];
        elem.appendChild(text);
        row.appendChild(elem);
        elem = document.createElement('td');
        text = document.createTextNode(reimb["REIMB_TYPE_ID"]);
        elem.appendChild(text);
        row.appendChild(elem);
        elem = document.createElement('td');
        text = document.createTextNode("$ " + reimb["REIMB_AMOUNT"]);
        elem.appendChild(text);
        row.appendChild(elem);
        elem = document.createElement('td');
        text = document.createTextNode(reimb["REIMB_SUBMITTED"]);
        elem.appendChild(text);
        row.appendChild(elem);
        elem = document.createElement('td');
        text = document.createTextNode(reimb["REIMB_AUTHOR"]);
        elem.appendChild(text);
        row.appendChild(elem);
        elem = document.createElement('td');
        text = document.createTextNode(reimb["REIMB_STATUS_ID"]);
        elem.appendChild(text);
        row.appendChild(elem);
        console.log(row.className);
        row.setAttribute("class", "clickable");
        let clickFunc;
        if(idName == "managerBody"){
            clickFunc = "viewManagerTicket(" + ticketID +")";
        }else{
            clickFunc = "viewEmployeeTicket(" + ticketID +")";
        }
        row.setAttribute("onclick", clickFunc);
        document.getElementById(idName).appendChild(row);
        }
}
//populates static reimbursement ticket form for manager single ticket view
function populateManagerTicket(ticket){
    console.log(ticket);
    document.getElementById("mtID").innerHTML = "ID:  " + ticket.REIMB_ID;
    document.getElementById("mtTYPE").innerHTML = "TYPE:  " + ticket.REIMB_TYPE_ID;
    document.getElementById("mtSTAT").innerHTML =  "STATUS:  " + ticket.REIMB_STATUS_ID;
    document.getElementById("mtNAME").innerHTML = "AUTHOR:  " + ticket.REIMB_AUTHOR;
    document.getElementById("mtSDAT").innerHTML = "SUBMITTED:  " + ticket.REIMB_SUBMITTED;
    document.getElementById("mtAMT").innerHTML = "$" + ticket.REIMB_AMOUNT;
    if(ticket.REIMB_DESCRIPTION == undefined){
        document.getElementById("mtDESC").innerHTML = "DESCRIPTION: ";
    }else{
        document.getElementById("mtDESC").innerHTML = "DESCRIPTION:  " + ticket.REIMB_DESCRIPTION;
    }
    if(ticket.REIMB_RESOLVER == undefined){
        document.getElementById("mtRES").innerHTML = "RESOLVED BY:  none";
    }else{
        document.getElementById("mtRES").innerHTML = "RESOLVED BY:  " + ticket.REIMB_RESOLVER;
    }
    if(ticket.REIMB_RESOLVED == undefined){
        document.getElementById("mtRDAT").innerHTML = "RESOLVED:  n/a";
    }else{
    document.getElementById("mtRDAT").innerHTML = "RESOLVED:  " + ticket.REIMB_RESOLVED;
    }
}
//populates static reimbursement ticket form for employee single ticket view
//TODO refactor into single method
function populateEmployeeTicket(ticket){
    console.log(ticket);
    document.getElementById("etID").innerHTML = "ID:  " + ticket.REIMB_ID;
    document.getElementById("etTYPE").innerHTML = "TYPE:  " + ticket.REIMB_TYPE_ID;
    document.getElementById("etSTAT").innerHTML =  "STATUS:  " + ticket.REIMB_STATUS_ID;
    document.getElementById("etNAME").innerHTML = "AUTHOR:  " + ticket.REIMB_AUTHOR;
    document.getElementById("etSDAT").innerHTML = "SUBMITTED:  " + ticket.REIMB_SUBMITTED;
    document.getElementById("etAMT").innerHTML = "$" + ticket.REIMB_AMOUNT;
    if(ticket.REIMB_DESCRIPTION == undefined){
        document.getElementById("etDESC").innerHTML = "DESCRIPTION: ";
    }else{
        document.getElementById("etDESC").innerHTML = "DESCRIPTION:  " + ticket.REIMB_DESCRIPTION;
    }
    if(ticket.REIMB_RESOLVER == undefined){
        document.getElementById("etRES").innerHTML = "RESOLVED BY:  none";
    }else{
        document.getElementById("etRES").innerHTML = "RESOLVED BY:  " + ticket.REIMB_RESOLVER;
    }
    if(ticket.REIMB_RESOLVED == undefined){
        document.getElementById("etRDAT").innerHTML = "RESOLVED:  n/a";
    }else{
    document.getElementById("etRDAT").innerHTML = "RESOLVED:  " + ticket.REIMB_RESOLVED;
    };
}
//gets username of reimbursement resolver based on resolver id for single ticket view
async function getResolver(id){

    console.log(id);
    let response = await fetch(url + "resolver/" + id,{
        method: "GET",
        credentials: "include"
    });
    if(response.ok){

        const user = await response.json();
        console.log(user);
        currentTicket.REIMB_RESOLVER = user.ERS_USERNAME;
        console.log(currentTicket);
    }else{console.log("error getting resolver");}
}