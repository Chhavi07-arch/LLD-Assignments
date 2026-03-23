# Snake and Ladders LLD

## Features
- N x N board
- Multiple players
- Snakes & ladders (random)
- Easy & Difficult mode (Strategy Pattern)
- Clean OOP design

## Design Patterns Used
- Strategy Pattern (GameRule)
- SRP (Single Responsibility Principle)

## How to Run
Run Main.java

+----------------------+
|        Game          |
+----------------------+
| - board: Board       |
| - players: List<Player> |
| - dice: Dice         |
| - currentPlayerIndex:int |
| - rule: GameRule     |
| - extraTurn:boolean  |
| - skipTurn:boolean   |
| - sixCount:int       |
| - gameOver:boolean   |
+----------------------+
| + makeMove()         |
| + isGameOver()       |
| + setExtraTurn()     |
| + setSkipTurn()      |
| + incrementSixCount()|
| + resetSixCount()    |
+----------+-----------+
           |
           | ◆ Composition
           v
+----------------------+
|        Board         |
+----------------------+
| - size:int           |
| - snakes: Map<int,int> |
| - ladders: Map<int,int> |
+----------------------+
| + initializeBoard()  |
| + getFinalPosition() |
+----------+-----------+
           |
     (logical ownership)
           |
     -----------------
     |               |
     v               v
+-----------+   +-----------+
|   Snake   |   |  Ladder   |
+-----------+   +-----------+
| head:int  |   | start:int |
| tail:int  |   | end:int   |
+-----------+   +-----------+

+----------------------+
|       Player         |
+----------------------+
| - id:int             |
| - name:String        |
| - position:int       |
+----------------------+
| + move()             |
| + setPosition()      |
+----------------------+

+----------------------+
|        Dice          |
+----------------------+
| + roll(): int        |
+----------------------+

<<interface>>
+----------------------+
|      GameRule        |
+----------------------+
| + applyRule(Game,int)|
+----------+-----------+
           |
     -------------------
     |                 |
     v                 v
+----------------+  +--------------------+
|   EasyRule     |  |   DifficultRule    |
+----------------+  +--------------------+
| applyRule()    |  | applyRule()        |
+----------------+  +--------------------+


## Design Patterns

1. Strategy Pattern
   - Used for handling different game rules (Easy, Difficult)

2. Single Responsibility Principle
   - Each class has one responsibility:
     - Game → flow control
     - Board → environment logic
     - Player → state
     - Dice → randomness