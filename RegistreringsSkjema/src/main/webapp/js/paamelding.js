"use strict";

function init(){
	function sjekkPassordStyrke(event) { 
    const validity = event.target.validity; 
    if (validity.valid) { 
        if(passord.value.length >= 5 && /\d/.test(passord.value) && /[A-Z]/.test(passord.value)){
		passord.classList.add("valid");
		passord.classList.remove("invalid");
		passord.classList.remove("mediumPassord");
		}else{
			passord.classList.remove("valid");
		passord.classList.remove("invalid");
		passord.classList.add("mediumPassord");
		}
    }else{
		passord.classList.remove("valid");
		passord.classList.add("invalid");
		passord.classList.remove("mediumPassord");
} 
}
function sjekkRepPassord(event){
	event.target.setCustomValidity("Repetert passord er feil!");
	
	if(repetertPassord.value == passord.value){
		event.target.setCustomValidity(""); 
	}
} 

const passord = document.getElementById("passord");
const repetertPassord = document.getElementById("passordRepetert");

passord.addEventListener("input", sjekkPassordStyrke)
repetertPassord.addEventListener("input", sjekkRepPassord)
}
document.addEventListener('DOMContentLoaded', init);