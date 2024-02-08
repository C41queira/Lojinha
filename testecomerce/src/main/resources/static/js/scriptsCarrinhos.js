
/* ------------------------------------- Quantidade btn -------------------------------------   */
var plus = document.querySelectorAll('.plus'); 
var minus = document.querySelectorAll('.minus')
var quantidade = document.querySelectorAll('.valorQuantidade')

var count = 1;

let intervalId = 0; 
 


function updareValueAll(){
	quantidade.forEach(async function(valor){
		valor.innerHTML = count;
	
	})
}

updareValueAll();

function updareValue(int){
	quantidade[int].innerHTML = count; 
}


 
plus.forEach(async function(mais){
	mais.addEventListener('mousedown', (event)=>{
		var div = event.target.parentNode; // Obtém o elemento a div
		var valorQuantidade = div.querySelector('p.valorQuantidade'); // Obtém o elemento p com a classe quantidade
		valorQuantidade.textContent = parseInt(valorQuantidade.textContent) + 1; // Incrementa o valor da quantidade em 1  
	});
})


minus.forEach(async function(menos){
	menos.addEventListener('mousedown', (event)=>{
		var div = event.target.parentNode; // Obtém o elemento a div
		var valorQuantidade = div.querySelector('p.valorQuantidade'); // Obtém o elemento p com a classe quantidade
		if(parseInt(valorQuantidade.textContent) <= 1){
			valorQuantidade.textContent = 1;
		}else{
			valorQuantidade.textContent = parseInt(valorQuantidade.textContent) - 1; // Decrementa o valor da quantidade em 1 
		}
		 
	});
})

/* ------------------------------------- Valor total produto  -------------------------------------   */


var valorTotalProduto = document.querySelectorAll('.produto-valorTotal');

valorTotalProduto.forEach(async function(vtp){
	var tr = vtp.parentNode; 
	
	var price = tr.querySelector('td.produtoPrice'); 
	
	var quantidade = tr.querySelector('p.valorQuantidade');
	
	setInterval(()=>{
		vtp.textContent = (parseFloat(price.textContent) * parseInt(quantidade.textContent)); 
	}, 200);
	
	
})




/* ------------------------------------- subtotal  -------------------------------------   */

const listTotais = document.querySelectorAll('.produto-valorTotal');
const totalHtml = document.getElementById('valorTotalProdutos');

function updateTotal() {
  let valorTotal = 0;
  Array.from(listTotais).forEach(function(valor) {
    valorTotal += parseFloat(valor.textContent.replace('R$', ''));
  });
  totalHtml.textContent = valorTotal.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
}

updateTotal(); // Call the function initially to update the total
setInterval(updateTotal, 200); // Update the total every 200ms