var score = 0;
var target = Math.floor(Math.random() * 20) + 1;
var guesses = 5;


 function changeColor() {
      nIntervId = setInterval(flashText, 200);
    }
 
    function flashText() {
      var oElem = document.getElementById('guessButton');
      oElem.style.color = oElem.style.color == 'red' ? 'blue' : 'red';
      // 'red' ? 'blue' : 'red' is a ternary operator.
    }


function guesshandler(){
var guess = document.getElementById('guessInput').value;
		if (guess == target) {
			alert("Correct!");
			score++;
			target = Math.floor(Math.random() * 20) + 1;
			guesses = 5;
		} else if (guess < target) {
			alert("Higher");
			guesses--;
		} else if (guess > target) {
			alert("Lower");
			guesses--;
		}
		if (guesses == 0) {
			alert("You lose");
			score--;
			target = Math.floor(Math.random() * 20) + 1;
			guesses = 5;
		}
		var guessSpan = document.getElementById('guesses');
		while (guessSpan.childNodes.length > 0)
			guessSpan.removeChild(guessSpan.firstChild);
		var t = document.createTextNode(guesses);
		guessSpan.appendChild(t);
		var scoreSpan = document.getElementById('score');
		while (scoreSpan.childNodes.length > 0)
			scoreSpan.removeChild(scoreSpan.firstChild);
		var t = document.createTextNode(score);
		scoreSpan.appendChild(t);
		}

document.getElementById('guessButton').addEventListener('click',
	guesshandler);
	
document.getElementById('guessButton').addEventListener('click',
	async function(){
	var response = await fetch('data.txt');
	car text = await reponse.text();
	alert("The server did stuff!");
	
	});
document.getElementById('guessInput').addEventListener('keydown', function(e){
if(e.keyCode == 13){
	guesshandler();
	return true;
}
else return false;
});








