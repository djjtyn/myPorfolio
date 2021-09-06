$( document ).ready(function() {
	
	//Code below will allow typewriter to display for About Me page
	let typed = new Typed(".typedEffect", {
		stringsElement: ".typedData",
		typeSpeed: 90,
		backSpeed:90,
		loop: true,
		shuffle: true,
	});
	
	//Code below allows form to be submitted when a filter option is selected from the drop down on the myskills page 
	$("#filterSkills").on("change", function(){
		$(".skillFilter").submit();
	})
});


//Code below will allow bubble effect to be displayed
/*function createBubbles(){
	const container = document.querySelector(".container");
	const bubble = document.createElement("span");
	bubble.classList.add("bubble");
	let bubbleSize = Math.random() * 60;
	bubble.style.width = bubbleSize + "px";
	bubble.style.height = bubbleSize + "px";
	bubble.style.left = Math.random() * innerWidth + "px";
	container.appendChild(bubble);
	setTimeout( () => {
		bubble.remove();
	}, 4000);
}*/