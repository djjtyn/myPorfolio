$( document ).ready(function() {
	
	//Code below will allow typewriter to display for About Me page
	let typed = new Typed(".typedEffect", {
		stringsElement: ".typedData",
		typeSpeed: 90,
		backSpeed:90,
		loop: true,
		shuffle: true,
	});
	
	//Code below will allow skill cards to be flipped on small screen sizes

	
	//Call the function to display bubbles
	//setInterval(createBubbles, 50);
});


//Code below will allow bubble effect to be displayed
function createBubbles(){
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
}