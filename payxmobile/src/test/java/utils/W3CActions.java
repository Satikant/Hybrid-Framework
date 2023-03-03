package utils;

import initializers.AppPageInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class W3CActions extends AppPageInit {

   /** Identify the slider element using any locator strategy.
   * Find the location of the slider element on the screen.
   * Create a PointerInput object of type TOUCH with a unique id as a finger.
   * Create a Sequence object with a PointerInput object.
   * Add individual actions to the sequence.
   * Pointer move to the slider element location.
   * Pointer down on the slider element.
   * Hold for a few milliseconds.
   * Pointer move the slider to the destination location.
   * Pointer up from the slider element.
   * Perform the sequence by calling the Actions API.
   **/

   static int height, width;
   static int x , y;
   static int startX , startY;
   static int endX , endY;

   public W3CActions(){
       Dimension dim =driver.manage().window().getSize();
       height = dim.getHeight();
       width = dim.getWidth();
       x = width - 10;
       y = 0 ;
       startY = (int) (height * 0.95);
       endY = 0 ;
   }

    public W3CActions(int x , int y , int startX , int startY , int endX, int endY){

        this.x = x;
        this.y = y;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }

   //works without plugins "appium --plugins=gestures"
    public  void slide( WebElement element){
        WebElement slider = element;
        Point source = slider.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x + 400, source.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(singletonList(sequence));
    }

    public void tap(){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(),W3CActions.x, W3CActions.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(100)));
        sequence.addAction(finger.createPointerMove(ofMillis(100),
                PointerInput.Origin.viewport(), W3CActions.x, W3CActions.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(singletonList(sequence));
    }

    public void scrollDown(){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(),W3CActions.x, W3CActions.startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
        PointerInput.Origin.viewport(), W3CActions.x, W3CActions.endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(singletonList(sequence));
    }



}
