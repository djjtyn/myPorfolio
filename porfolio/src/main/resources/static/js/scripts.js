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
	
	setInterval(createBubbles, 3000);
});


//Code below will allow bubble effect to be displayed
function createBubbles(){
	//Get the cut off point for the bubbles 
	const container = document.querySelector(".container");
	const bubble = document.createElement("span");
	bubble.classList.add("bubble");
	let bubbleSize = Math.random() * 60;
	bubble.style.width = bubbleSize + "px";
	bubble.style.height = bubbleSize + "px";
	bubble.style.left = Math.random() * innerWidth + "px";
	bubble.style.position = "fixed";
	bubble.style.bottom = "0";
	container.appendChild(bubble);

}