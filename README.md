# Knight's Tour Solver
A Java implementation of the Knight's Tour algorithm. The knight's tour problem is the mathematical problem of finding a knight's tour. Creating a program to find a knight's tour is a challenge given to computer science students.

<p align="center">
  <img src="https://bellmcp.github.io/img/Projects_KnightsTour.jpg" />
</p>

# Resources

* [Download Project (.rar | 471 KB)](https://bellmcp.github.io/work/TicTacToe.rar)
* [Download .NET Framework 4.7.2 (Direct Link)](https://dotnet.microsoft.com/download/dotnet-framework/net472)

# What I Learned

* Developed a user interface within the Windows Forms App (.NET Framework) using ToolStrip, TextBox, Label & Button.
* Implemented functinality to the UI: `buttonClick`, `disableButtons`, `newGame`, & `resetCount`.
* Integrated Tic Tac Toe logic strategy to the `winnerCheck` function. (based on [Wikipedia's strategy](https://en.wikipedia.org/wiki/Tic-tac-toe#Strategy))

# winnerCheck()

```         
            //horrizontal check
            if ((A1.Text == A2.Text) && (A2.Text == A3.Text) && (!A1.Enabled))
                winner_exist = true;
            else if ((B1.Text == B2.Text) && (B2.Text == B3.Text) && (!B1.Enabled))
                winner_exist = true;
            else if ((C1.Text == C2.Text) && (C2.Text == C3.Text) && (!C1.Enabled))
                winner_exist = true;

            //vertical check
            if ((A1.Text == B1.Text) && (B1.Text == C1.Text) && (!A1.Enabled))
                winner_exist = true;
            else if ((A2.Text == B2.Text) && (B2.Text == C2.Text) && (!A2.Enabled))
                winner_exist = true;
            else if ((A3.Text == B3.Text) && (B3.Text == C3.Text) && (!A3.Enabled))
                winner_exist = true;

            //diagonal check
            if ((A1.Text == B2.Text) && (B2.Text == C3.Text) && (!A1.Enabled))
                winner_exist = true;
            else if ((A3.Text == B2.Text) && (B2.Text == C1.Text) && (!C1.Enabled))
                winner_exist = true;
```

# Future Ideas Include

* Add an ability to have the X and O on the board be different colors.
* Implement an unbeatable AI in single player mode.
* Welcome screen to let player switch between single player and multiplayer mode.

# License

* Except where otherwise noted, this project is licensed under a [Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International](http://creativecommons.org/licenses/by-nc-nd/4.0/).

> Copyright © 2018 Wutipat Khamnuansin, All rights reserved.
