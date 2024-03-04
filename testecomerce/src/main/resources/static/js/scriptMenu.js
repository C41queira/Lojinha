var btnMenu = document.getElementById('navMenu'); 

var sideBar = document.querySelector('.sideBar');

var btnCloseSideBar = document.getElementById('closeSideBar');

btnMenu.addEventListener('click', function(){
	if(sideBar.classList.contains('noneSideBar')){
		
		sideBar.classList.add('visible'); 
		
		if(sideBar.classList.contains('hidden')){
			sideBar.classList.remove('hidden');
		}
		
		sideBar.classList.remove('noneSideBar');
		
		const intervalUpdateSideBar = setInterval(updateSidebarPosition, 10);
		
	}else{
		sideBar.classList.add('hidden');
		
		if(sideBar.classList.contains('visible')){
			sideBar.classList.remove('visible');
		}
		
		sideBar.classList.add('noneSideBar');
		
		clearInterval(intervalUpdateSideBar);
	}
})

btnCloseSideBar.addEventListener('click', function(){
	sideBar.classList.remove('visible');
	sideBar.classList.add('hidden');
	sideBar.classList.add('noneSideBar');
	clearInterval(intervalUpdateSideBar);
})



/* Mudança top dinamica */

var valueTop = 95; 

const updateSidebarPosition = async function() {
	if(scrollY == 0){
		sideBar.style.top = valueTop + "px"; 
		
	}else{
		if(scrollY > 0 && scrollY < 95){
			sideBar.style.top = (valueTop - scrollY) + "px"; 
		}else{
			sideBar.style.top = "0px"; 
		}
	}
	
};


	