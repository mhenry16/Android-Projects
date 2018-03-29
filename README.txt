Michael Henry
TA: Tim Walsh

I affirm that I did not give or receive any unauthorized help on this project, and that all work is my own.

Main: This project starts on a main activity where you can set both players name, or leave it as the default. In addition is displays their current score from both games. From here you can go into game 1 (hot/cold) or game 2 (hangman).

Hot/Cold: This game allows users to guess a number between 1 and 10. They're told hot/cold the first time depending on how close they are. Then they're told hotter/colder depending on if their next guess if closer/farther away. Beecause the range is small, it doesn't make sense to have additional feedback, but more detailed responses could be added with additional if statements. The game works better if one player finishes before the other starts, but they can play head to head (see extra credit) although that wouldn't be much fun since it's the same number.

Hangman: For hangman the user can click the buttons that form a keyboard to guess a letter. Once guessed the letter will dissappear. When player 1 is done (either has the word or 8 X's) they must click the change user button. It is a bit awkward, but it allows the first player to see their final screen without it being immedietly cleared. Once both players have gone, the score is calculated by 100 times the difference in guesses, and this is added to their current score and told to the usesr.

Extra Credit:
Checks all edittext's are given valid input.

Go Back buttons only return a new score if the game has finished, otherwise the original score is still displayed on the home page.

Disappears widgits at apropriate times to help the user and give the UI a cleaner look.

Edittext's either remember the players previous choice or clear themelves depending on what's apropriate.

Hot/Cold can be played either like hangman where one person finishes before the other starts, or be played back and forth. This was done by having warmer/colder determined by the previous guess rather than your individual guess. It then only resets after one user gets the number, irrelevent if both players are watching the screen, allowing the next user to start fresh if they wish.

Fully function keyboard in hangman which has the letters dissapear after they're used.