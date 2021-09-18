$( document ).ready(function() {	
	//Code below allows form to be submitted when a filter option is selected from the drop down on the myskills page 
	$("select").on("change", function(){
		$("form").submit();
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

function flipSkillCard(element){
	let cardFront = element.querySelector(".card-front");
	let cardBack = element.querySelector(".card-back");
	cardFront.style.transform = "rotateY(-180deg)";
	cardBack.style.transform = "rotateY(0deg)";
	element.addEventListener("mouseleave", function(){
		cardFront.style.transform = "rotateY(0deg)";
		cardBack.style.transform = "rotateY(-180deg)";
	})
}

//Code below allows zoomed in areas to appear for an image
function zoomIn(imageContainer, imageElement, event) {
	let zoomYPosition = (event.pageY - imageElement.offsetTop - imageContainer.offsetTop -27 );
	let zoomXPosition = (event.pageX - imageElement.offsetLeft - imageContainer.offsetLeft -27);
	//If there is already a zoomContainer, remove it
	if(document.getElementById("zoomContainer")){
		document.getElementById("zoomContainer").remove();
	}
	let zoomContainer = document.createElement("div");
	zoomContainer.id = "zoomContainer";
	zoomContainer.style.minHeight = "3em";
	zoomContainer.style.minWidth = "3em";
	zoomContainer.style.background = "url(" + imageElement.src + ")";
	zoomContainer.style.backgroundPosition = (-zoomXPosition) + "px " + (-zoomYPosition) + "px";
	zoomContainer.style.border = "1px solid black";
	zoomContainer.style.position = "absolute";
	zoomContainer.style.top = zoomYPosition + "px";	
	imageContainer.appendChild(zoomContainer);
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
		image.style.padding = "0";
		image.style.display = "block";
		image.style.minHeight = "90%";
		image.style.margin = "1em auto";
		image.onmousemove = function(event) {
			zoomIn(magnifiedImage,image, event);
		}
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

function displayDatabaseSchema(projectId){
	let schemaContainer = document.createElement("div");
	schemaContainer.id = "magnifiedImage";
	schemaContainer.style.width = "100%";
	schemaContainer.style.backgroundColor = "white";
	schemaContainer.style.position = "absolute";
	schemaContainer.style.top = window.scrollY + "px";
	let schema = document.createElement("img");
	schema.style.width = "100%";
	schema.style.display = "block";
	schema.style.minHeight = "100%";
	schema.style.margin = "1em auto";
	schema.style.padding = "1em";
	let minimiseButton = document.createElement("button");
	minimiseButton.innerHTML = '<i class="fas fa-times-circle"></i>';
	minimiseButton.style.float = "right";
	minimiseButton.onclick = function() {
		this.parentElement.remove();
	}
	//Set the schema value depeneding on which button was clicked
	switch(projectId) {
		case 1: 
			schema.src = "image/DatabaseDesigns/IOMusicDatabaseDesign.jpg"; 
			break;
		case 4:
			schema.src = "image/DatabaseDesigns/MusiciansChoiceDatabase.jpg";
	}
	schemaContainer.appendChild(minimiseButton);
	schemaContainer.append(schema);
	document.body.appendChild(schemaContainer);
}

function initialiseMasonryGrid() {
	let grid = document.querySelector(".grid");
	let masonry = new Masonry(grid, {
		itemSelector: ".grid-item",
		});
	masonry.reloadItems();
}

function flipProjectCard(element) {
	let cardContainer = element.parentElement;
	switch(element.className) {
		case "card-front":
			element.style.transform = "rotateY(-180deg)";
			cardContainer.querySelector(".card-back").style.transform = "rotateY(0deg)";
			adjustBackCardSize(cardContainer);
			break;
		case "card-back":
			element.style.transform = "rotateY(-180deg)";
			cardContainer.querySelector(".card-front").style.transform = "rotateY(0deg)";
			adjustFrontCardSize(cardContainer);
			break;
	}
}

//Function below will adjust the project card height based on wheither the front or back of the card is showing
function adjustBackCardSize(element){
	let cardBack = element.querySelector(".card-back");
	let cardFront = element.querySelector(".card-front");
	cardBack.style.position = "relative";
	cardFront.style.position = "absolute";
	initialiseMasonryGrid();
}

function adjustFrontCardSize(element){
	let cardFront = element.querySelector(".card-front");
	let cardBack = element.querySelector(".card-back");
	cardFront.style.position = "relative";
	cardBack.style.position = "absolute";
	initialiseMasonryGrid();
}
