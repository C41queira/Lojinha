var listPrice = document.querySelectorAll(".priceProduct"); 

var formsPrice = document.getElementById('submitForms'); 

var priceMin = document.getElementById('precoMinimo');
var priceMax = document.getElementById('precoMaximo');


formsPrice.addEventListener('click', (event)=>{
	event.preventDefault();  
	
	let min = 0;
	let max = 1000000;
	
	if (priceMin.value !== '' && priceMin.value !== null) {
	  min = Number(priceMin.value);
	}
	
	if (priceMax.value !== '' && priceMax.value !== null) {
	  max = Number(priceMax.value);
	}
		
	listPrice.forEach((price)=>{
		let card = price.parentNode.parentNode; 
		card.classList.remove('none'); 
		
		var number = Number(price.innerHTML.replace(/R\$: /g, ''));
		
		if(number < min || number > max){
			card.classList.add('none'); 
		} 
	})
})
 