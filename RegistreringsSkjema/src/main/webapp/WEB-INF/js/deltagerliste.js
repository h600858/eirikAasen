"use strict";
function init(){
	
	let table = document.getElementById("MyTable");
	let cells = table.querySelectorAll("td");
	let len = cells.length;
	for(var i = 0;  i<len; i = i+3){
		if (cells[i].innerText=='M'){
		cells[i].innerText=String.fromCodePoint("0x2640");
		} else {
		cells[i].innerText=String.fromCodePoint("0x2642");
	    }
	}
	
	
	let rader = document.querySelectorAll("tr");
	let innloggetMobil = document.getElementById("innloggetBruker").getAttribute("value");
	console.log(innloggetMobil)
	rader.forEach(function(row){
		if(row.getAttribute("id") == innloggetMobil){
			row.style.backgroundColor = "#90EE90";
		
		}
	})
	

}

document.addEventListener('DOMContentLoaded', init);