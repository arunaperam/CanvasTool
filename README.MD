# **`#####CanvasTool#####`**


#### **`Description`:**

This Tool works as follows:
 1. Creates a  canvas of specified width and height
 2. Draws Rectangle, horizontal and vertical lines using text based commands
 3. Quit the program on instruction.
 
#### `Instructions to Build and Run the code`:

To Run:

java version: 1.8

Already a prebuilt jar is available in the target folder.

Download the zip or clone the code from below repository: 

###### **https://github.com/arunaperam/CanvasTool.git**

Simply run: 
###### **java -jar target/CanvasTool-1.0-SNAPSHOT-jar-with-dependencies.jar**

Then follow below commands:

### `Commands`

|Command 		|Description|
|-----|----|
|C w h          | Create a new canvas of width w and height h.
|               |
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2).
|               | Horizontal or vertical lines are supported.
|               | Horizontal and vertical lines will be drawn using the 'x' character.
|               |
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
|               | Horizontal and vertical lines will be drawn using the 'x' character.
|               |
|Q              | Quit|

Make sure canvas is created first before applying L or R commands.

Make sure the the points x1,x2,y1,y2 are within the range of canvas width and height.
 
##### **To build the above jar from scratch:**

install Maven:3.6.3

1)From project root : 

###### **mvn clean package**
this  command creates Jar in target folder.

2)Run the command :  

###### **java -jar target/CanvasTool-1.0-SNAPSHOT-jar-with-dependencies.jar**


### ****`From IDE`****

1) Import the project into any IDE.(I built this on Intellij)

2) set the IDE to run on java 1.8

3) Run the class with main method i.e ArgumentsReader.

4)Follow the commands mentioned above to create canvas and then the lines and Rectangles.




### ****` Project Structure`****
**`package`**

com.deutsche.associate

**`MainClass`**

ArgumentsReader: Reads arguments from interactive command line and sends parsed input to parser.

**`Interface`**

Canvas: Contains method declarations for various drawing requirements.

**`Supporting Classes`**

1. ArgumentProcessor:Verifies arguments received from Reader and redirects to the required methods,else raises exception.

2. CanvasCreator:Contains the functionality to generate  the required output based on the arguments passed by the user.

3. PixelPrinter:Contains the functionality to print the output.


**`Test Classes`**:

Three test classes available in 'src/test' covering most of the functionality.

Once cloned the code ,tests can be run using below command from root directory i.e CanvasTool:

###### **mvn clean test**






