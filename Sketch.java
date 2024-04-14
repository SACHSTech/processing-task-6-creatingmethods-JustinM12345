import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    boolean boolBgChange = backgroundChange(5);
    if (boolBgChange) {
      background(210, 255, 173);
    }
    else {
      background(110, 255, 173);
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // Constantly draws stickmen over screen using for loops
    for (int intPositionX = 50; intPositionX < width; intPositionX = intPositionX + 100){
      for(int intPositionY = 50; intPositionY < height; intPositionY = intPositionY + 150){
        drawStickman(intPositionX, intPositionY, intPositionX, intPositionY + 50);
      }
    }

    // Constantly draws flowers over screen using for loops
    for (int intPositionX = 100; intPositionX < width; intPositionX = intPositionX + 100){
      for(int intPositionY = 50; intPositionY < height; intPositionY = intPositionY + 150){
        drawFlower(intPositionX, intPositionY, 20, 20);
      }
    }

  }

  // Changes background depending on value of intNum
  public boolean backgroundChange(int intNum){
    if (intNum >= 10) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public void drawStickman(float bodyX1, float bodyY1, float bodyX2, float bodyY2) {
    // scaling variable for X values
    float widthScaling = width / 800;

    //scaling variable for Y values
    float heightScaling = height / 800;

    // Drawing Body of stickman
    line(bodyX1, bodyY1, bodyX2, bodyY2);

    // Drawing Legs of stickman
    line(bodyX2, bodyY2, (bodyX2 - widthScaling * 20), (bodyY2 + heightScaling * 20));
    line(bodyX2, bodyY2, (bodyX2 + widthScaling * 20), (bodyY2 + heightScaling * 20));

    // Drawing Arms of stickman
    line((bodyX1 + bodyX2) / 2, (bodyY2 + bodyY1) / 2, (bodyX1 + bodyX2) / 2 - widthScaling * 20, (bodyY2 + bodyY1) / 2);
    line((bodyX1 + bodyX2) / 2, (bodyY2 + bodyY1) / 2, (bodyX1 + bodyX2) / 2 + widthScaling * 20, (bodyY2 + bodyY1) / 2);

    // Drawing face
    fill(250, 214, 115);
    ellipse(bodyX1, bodyY1 - heightScaling * 20, widthScaling * 40, heightScaling * 40);
    ellipse(bodyX1 - widthScaling * 5, bodyY1 - heightScaling * 20, widthScaling * 5, heightScaling * 5);
    ellipse(bodyX1 + widthScaling * 5, bodyY1 - heightScaling * 20, widthScaling * 5, heightScaling * 5);
    line(bodyX1 - widthScaling * 5, bodyY1 - heightScaling * 10, bodyX1 + widthScaling * 5, bodyY1 - heightScaling * 10);
    noFill();

  }

  public void drawFlower(float centerX, float centerY, float petalWidth, float petalHeight){

    fill(240, 211, 67);

    // Draw Top-Left Petal
    ellipse(centerX - petalWidth / 2, centerY - petalHeight / 2, petalWidth, petalHeight);

    // Draw Top-Right petal
    ellipse(centerX + petalWidth / 2, centerY - petalHeight / 2, petalWidth, petalHeight);

    // Draw Bottom-Right petal
    ellipse(centerX + petalWidth / 2, centerY + petalHeight / 2, petalWidth, petalHeight);

    // Draw Bottom-Left petal
    ellipse(centerX - petalWidth / 2, centerY + petalHeight / 2, petalWidth, petalHeight);

    fill(0);

    // Draw middle petal
    ellipse(centerX, centerY, petalWidth, petalHeight);

    noFill();
  }
}