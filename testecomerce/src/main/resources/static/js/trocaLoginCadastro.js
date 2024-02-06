var login = document.getElementById('btnLogin');
var cadastro = document.getElementById('btnCadastro'); 

var contCadastro = document.querySelector('.contCadastro'); 
var contLogin = document.getElementById('divLogin'); 

var body = document.querySelector('#body'); 

login.addEventListener('click', async function(){
	contCadastro.classList.add('none'); 
	contLogin.classList.remove('none'); 
	
	body.classList.add('sing-up'); 
	body.classList.remove('sing-in');
})


cadastro.addEventListener('click', async function(){
	contCadastro.classList.remove('none'); 
	contLogin.classList.add('none'); 
	
	body.classList.remove('sing-up'); 
	body.classList.add('sing-in');
})