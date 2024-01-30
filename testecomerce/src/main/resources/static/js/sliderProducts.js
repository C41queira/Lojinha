/* -------------- Eletronico -------------- */

var nextBtn = document.querySelectorAll('.avancar'); 
var previousBtn = document.querySelectorAll('.voltar'); 

var listCardEletro = document.querySelectorAll('.card-eletronico'); 
const maxCardEletro = listCardEletro.length; 

var listCardMoveis = document.querySelectorAll('.card-moveis'); 
const maxCardMoveis= listCardMoveis.length; 

var listCardInformatica = document.querySelectorAll('.card-informatica'); 
const maxCardInformatica = listCardInformatica.length; 

var listCardGamer = document.querySelectorAll('.card-gamer'); 
const maxCardGamer = listCardGamer.length; 


var countEletro = 0;
var countMoveis = 0;
var countInformatica = 0;
var countGamer = 0;  

listCardEletro[countEletro].classList.add('card-view');
listCardMoveis[countMoveis].classList.add('card-view');
listCardInformatica[countInformatica].classList.add('card-view');
listCardGamer[countGamer].classList.add('card-view');


nextBtn.forEach((btn)=>{
	btn.addEventListener("click", ()=>{
		
		switch(btn.id){
			case "avancarEletro": 
				if(countEletro >= maxCardEletro - 1){
				countEletro = -1; 
				}
		
				countEletro += 1;
				console.log(countEletro);
		
				listCardEletro[countEletro].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardEletro.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardEletro[countEletro].classList.add('card-view');
			break; 
			case "avancarMoveis": 
				if(countMoveis >= maxCardMoveis - 1){
				countMoveis = -1; 
				}
		
				countMoveis += 1;
				console.log(countMoveis);
		
				listCardMoveis[countMoveis].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardMoveis.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardMoveis[countMoveis].classList.add('card-view');
			break; 
			case "avancarInformatica": 
				if(countInformatica >= maxCardInformatica - 1){
				countInformatica = -1; 
				}
		
				countInformatica += 1;
				console.log(countInformatica);
		
				listCardInformatica[countInformatica].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardInformatica.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardInformatica[countInformatica].classList.add('card-view');
			break; 
			case "avancarGamer": 
				if(countGamer >= maxCardGamer - 1){
				countGamer = -1; 
				}
		
				countGamer += 1;;
		
				listCardGamer[countGamer].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardGamer.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardGamer[countGamer].classList.add('card-view');
			break; 
		}
	})
})



previousBtn.forEach((btn)=>{
	btn.addEventListener("click", ()=>{
		
		switch(btn.id){
			case "voltarEletro": 
				if(countEletro <= 0){
				countEletro = 5; 
				}
		
				countEletro -= 1;
				console.log(countEletro);
		
				listCardEletro[countEletro].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardEletro.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardEletro[countEletro].classList.add('card-view');
			break; 
			case "voltarMoveis": 
				if(countMoveis <= 0){
				countMoveis = 5; 
				}
		
				countMoveis -= 1;
				console.log(countMoveis);
		
				listCardMoveis[countMoveis].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardMoveis.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardMoveis[countMoveis].classList.add('card-view');
			break; 
			case "voltarInformatica": 
				if(countInformatica <= 0){
				countInformatica = 5; 
				}
		
				countInformatica -= 1;
				console.log(countInformatica);
		
				listCardInformatica[countInformatica].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardInformatica.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardInformatica[countInformatica].classList.add('card-view');
			break; 
			case "voltarGamer": 
				if(countGamer <= 0){
				countGamer = 5; 
				}
		
				countGamer -= 1;;
		
				listCardGamer[countGamer].scrollIntoView({
					inline:"center", behavior:"smooth", block: "nearest"
				})
				
				listCardGamer.forEach((card) => {
					card.classList.remove('card-view')
				});
				
				listCardGamer[countGamer].classList.add('card-view');
			break; 
		}
	})
})