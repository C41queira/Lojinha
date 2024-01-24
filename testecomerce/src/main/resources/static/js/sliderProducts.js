/* -------------- Eletronico -------------- */

var nextEletro = document.getElementById('avancarEletro'); 
var previousEletro = document.getElementById('voltarEletro'); 

var listCardEletro = document.querySelectorAll('.card-eletronico'); 

const maxCardEletro = listCardEletro.length; 


var countEletro = 0; 

listCardEletro[countEletro].classList.add('card-view');

nextEletro.addEventListener('click', function(event){
	
	event.preventDefault();
	event.stopPropagation();
	
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
})

previousEletro.addEventListener('click', function(event){
	
	event.preventDefault();
	event.stopPropagation();
	
	if(countEletro <= 0){
		countEletro = 5; 
	}
	
	countEletro -= 1;
	console.log(countEletro);
	
	listCardEletro[countEletro].scrollIntoView({
		inline:"center", behavior:"smooth",block: "nearest"
	})
	
	listCardEletro.forEach((card) => {
		card.classList.remove('card-view')
	});
	
	listCardEletro[countEletro].classList.add('card-view');
})