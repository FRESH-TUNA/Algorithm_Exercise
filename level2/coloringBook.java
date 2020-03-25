import java.util.Stack;
import java.util.Iterator;

class ColoringBook {
  private int[] world;
  private int maxWideOfArea;
  private int countOfArea;
  
  public ColoringBook(int[] world) {
    this.world = world;
    this.maxWideOfArea = 0;
    this.countOfArea = 0;
  }

  public void service() {
    if(this.world.length == 0)
        return;
    
    int lastBlock = this.world[0] + 1;
    int wideOfArea = 0;
    for (int i : this.world) { 
      if(i != lastBlock) {
        if(wideOfArea > this.maxWideOfArea) 
          this.maxWideOfArea = wideOfArea;
        ++this.countOfArea; 
        wideOfArea = 1;
      }
      else
        ++wideOfArea;
    } 
  }

  public static void main(String[] args) {
    
  }
}