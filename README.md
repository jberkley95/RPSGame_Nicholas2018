# Reaction Game

##Part 1: Creating a New Project

- Create a new Android Project `File -> New -> New Project`
- Name it `RPSGame`
- Set API Level to 21
- Add an Empty Activity
- Leave default `MainActivity` name
- Find 3 images online, one rock, one paper, and one scissors, save all of these as .png files, and copy them into the `drawable` folder inside the `res` folder.
- NAME THESE `rock.png`, `paper.png`, `scissors.png`. DO NOT HAVE CAPITALS, SYMBOLS, OR SPACES IN THE NAMES

##Part 2: Create Layout

- Add 3 buttons at the bottom in a horizontal line that say Rock, Paper, Scissors respectively
- Add 2 image views stacked on top of each other in the center of the screen

##Part 3: Make It Work

- Declare 3 Button vairables and 2 ImageView variables
- Declare 3 String variables userChoice, cpuChoice, and result
- Initialize those variables
- Create a `Random` object `Random r = new Random()`
- Create listeners for all 3 rock, paper, scissors buttons
- Inside each listener, set `userChoice` to whatever button you pressed, for example, if rock is clicked, set userChoice to "rock"
- Set the user's imageView to the image associated with the button clicked, for example `userImage.setImageResource(R.drawable.paper);`
- Create a `GetCPU` method `public void getCpuChoice(){}`

```
public static void getCpuChoice() {
	//randomly select rock (0) paper (1) or scissors (2)
	int cpu = r.nextInt(3);
	
	if (cpu == 0) {
		cpuChoice = "rock";
       cpuImage.setImageResource(R.drawable.rock);
	}
	
	//finish getCpuChoice
	
}
```

- Add getCpuChoice() to each listener after setting the user image
- Create a `showWinner` to calculate who won and display it

```
public void showWinner() {
	if (userChoice.equals(computerChoice)) {
		result = "draw";
	} else if (userChoice.equals("rock") && computerChoice.equals("paper")) {
		result = "win!";
	}
	
	//finish logic
	
	Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
}
```

- Add showWinner() to each listener after calling getCpuChoice()

##Part 4: Challenges

- Keep track of, and display at the top of the screen wins, losses, and ties# RPSGame_Nicholas2018
