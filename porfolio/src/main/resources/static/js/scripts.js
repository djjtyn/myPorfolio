$( document ).ready(function() {	
	//Code below allows form to be submitted when a filter option is selected from the drop down on the myskills page 
	$("#filterSkills").on("change", function(){
		$(".skillFilter").submit();
	})
	
	//Code below calls method that magnifies education certs when clicked on
	$(".educationCert").on("click", function() {
		magnifyImage($(this).attr("id"));
	})
});

function displayTypeWriterEffect() {
	let typed = new Typed(".typedEffect", {
		stringsElement: ".typedData",
		typeSpeed: 90,
		backSpeed:90,
		loop: true,
		shuffle: true,
	});
}

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



function displayTypeWriterAndBubbleEffect(){
	setInterval(createBubbles, 3000);	
	displayTypeWriterEffect();

}

function magnifyImage(elementId){
	if(document.getElementById("magnifiedImage") == null) {
		//Clone the certificate image and remove it's default classes
		let image = document.getElementById(elementId).cloneNode(true);
		image.removeAttribute("class");
		//Create a Div to store the larger image 
		let imgContainer = document.createElement("div");
		imgContainer.id = "magnifiedImage";
		imgContainer.style.width = "50%";
		imgContainer.style.height = "85%";
		imgContainer.style.margin = "0em 25%";
		imgContainer.style.backgroundColor = "white";
		imgContainer.style.position = "absolute";
		imgContainer.style.top = window.scrollY + + 30 + "px";
		image.style.width = "60%";
		image.style.display = "block";
		image.style.minHeight = "90%";
		image.style.margin = "1em auto";
		image.style.padding = "1em;"
		//Create button to minimise magnifyed image
		let minimiseButton = document.createElement("button");
		minimiseButton.innerHTML = '<i class="fas fa-times-circle"></i>';
		minimiseButton.style.float = "right";
		minimiseButton.onclick = function() {
			this.parentElement.remove();
		}
		imgContainer.appendChild(minimiseButton);
			imgContainer.append(image);
		document.body.appendChild(imgContainer);
	}
}
