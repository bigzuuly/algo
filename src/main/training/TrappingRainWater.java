package main.training;

/*
 * Exercise from LeetCode: https://leetcode.com/problems/trapping-rain-water/submissions/
 */
public class TrappingRainWater {

	/* slower */
	public static int trap(int[] height) {
        //find max height from elevation map
        int maxHeight = -1;
        
        for(int i=0; i<height.length; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
            }    
        }
        
        System.out.println("Max Height: " + maxHeight);
        
        //maxHeight = 1;
        int pockets = 0;
        //for each elevation level look for pockets
        //pocket is defined when a subsequent elevation is lower
        //skip level 0 - ground
        for(int currentHeight = 1; currentHeight < maxHeight+1; currentHeight++){
            
            int numPockets = 0;
            boolean pocketFound = false;
            for(int j = 0; j < height.length; j++){
                
               if(height[j] >= currentHeight){
                   if(!pocketFound){
                    pocketFound = true;
                   }else{
                    pockets = pockets + numPockets; 
                      
                    //reset numPockets
                    numPockets = 0;
                    //pocketFound = false;
                   }   
               }else if(height[j] < currentHeight){
                  //pocket found
                   if(pocketFound){
                    numPockets = numPockets + 1;
                   }
               }
               //System.out.println("Current Height: " + currentHeight + " | Num Pockets: " + numPockets + " | Height: " + height[j] + " | Pocket Found: " + pocketFound);
            }
           //System.out.println("####");
        }
        
        //return total pockets
        
    return pockets;
    }
	
	/* much much faster using left and right bounds !!!
	 * 
	 *  Runtime: 1 ms, faster than 98.51% of Java online submissions for Trapping Rain Water.
	 *	Memory Usage: 37.7 MB, less than 95.21% of Java online submissions for Trapping Rain Water.
	 */
	public static int trapV2(int[] height) {
        
        int pockets = 0;
        int leftBound = 0;
        int rightBound = -1;
        
        while(leftBound < height.length){
            
            //look for right bound
            boolean tallerRightHeight = false;
            for(int j = leftBound+1; j<height.length; j++){
                if(height[j] >= height[leftBound]){
                    rightBound = j;
                    tallerRightHeight = true;
                    break;
                }
            }
            
            //if no taller right height, look for max right height
            if(!tallerRightHeight){
                int maxRightHeight = 0;
                for(int j = leftBound+1; j<height.length; j++){
                    if(height[j] >= maxRightHeight){
                        rightBound = j;
                        maxRightHeight = height[j];
                    }
                }
            }
            
            if(rightBound > leftBound){
                //calc water level between leftBound and rightBound
                System.out.println("calc pocket LeftBound: " + leftBound + " | RightBound: " + rightBound );
                int currentHeight = Math.min(height[leftBound], height[rightBound]);
                
                for(int k=leftBound+1; k < rightBound; k++){
                    pockets = pockets + (currentHeight - height[k]);
                    System.out.println(currentHeight - height[k]);
                }
                
                //set rightBound to be the new leftBound
                leftBound = rightBound;
            }else{
                leftBound++;
            }

            System.out.println("LeftBound: " + leftBound + " | RightBound: " + rightBound);
            
        }
            
           
        
        return pockets;
        
    }

	public static void main(String[] args) {
		System.out.println(trapV2(new int[] {5,2,1,2,1,5}));
	}
}
